package org.bedu.api.servidores.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.bedu.api.servidores.dto.CredentialDTO;
import org.bedu.api.servidores.entity.Application;
import org.bedu.api.servidores.entity.Credential;
import org.bedu.api.servidores.entity.User;
import org.bedu.api.servidores.mapper.CredentialMapper;
import org.bedu.api.servidores.repository.IApplicationRepository;
import org.bedu.api.servidores.repository.ICredentialRepository;
import org.bedu.api.servidores.repository.IUserRepository;
import org.bedu.api.servidores.service.ICredentialService;
import org.bedu.jms.model.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Component
public class CredentialServiceImpl implements ICredentialService {
    private CredentialMapper mapper;
    private ICredentialRepository repository;
    private IUserRepository userRepository;
    private IApplicationRepository applicationRepository;

    /*Atributos para la cola de mensajes*/
    @Value("${hsbc.exchange}")
    private String TOPIC_EXCHANGE_NAME;
    @Value("${hsbc.routing}")
    private String ROUTING_KEY;

    private RabbitTemplate template;

    @Autowired
    public CredentialServiceImpl(CredentialMapper mapper, ICredentialRepository repository,
                                 IUserRepository userRepository, IApplicationRepository applicationRepository,
                                 RabbitTemplate template){
        this.mapper=mapper;
        this.repository=repository;
        this.userRepository=userRepository;
        this.applicationRepository=applicationRepository;
        this.template=template;
    }
    @Override
    public List<CredentialDTO> findAll() {
        List<Credential> credentials = repository.findAll();
        return credentials.stream().map(mapper::toDTO).toList();
    }

    @Override
    public List<CredentialDTO> findByUserId(long userId) {
        List<Credential> credentials = repository.findAll();
        return credentials.stream().map(mapper::toDTO).toList();
    }

    @Override
    public CredentialDTO findById(long id) {
        return mapper.toDTO(repository.findById(id).get());
    }

    @Override
    public CredentialDTO save(long userId, long applicationId, CredentialDTO data){
        Credential entity = mapper.toEntity(data);
        User u = userRepository.findById(userId).get();
        Application app= applicationRepository.findById(applicationId).get();
        entity.setApplication(app);
        entity.setUser(u);
        /*Enviar mensaje a RabbitMQ indicando que se creo una credencial*/
        log.info("Se envia mensaje a RabbitMQ para notificar creacion de credenciales");
        //Notification notif = new Notification(entity.getUser().getName(),entity.getApplication().getName());
        template.convertAndSend(TOPIC_EXCHANGE_NAME,ROUTING_KEY, entity.getUser().getName());
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public void update(long userId, long applicationId, long id, CredentialDTO data) {
        Credential entity = repository.findById(id).get();
        if(data.getUserName()!=null)
            entity.setUserName(data.getUserName());
        if(data.getPassword()!=null)
            entity.setPassword(data.getPassword());
        repository.save(entity);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }
}
