package org.bedu.api.servidores.controller;

import org.bedu.api.servidores.dto.CredentialDTO;
import org.bedu.api.servidores.service.ICredentialService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/users/{userId}")
public class CredentialController {
    private ICredentialService service;

    public CredentialController(ICredentialService service){
        this.service=service;
    }

    @GetMapping("/users/{userId}/credentials")
    public List<CredentialDTO> findAll(@PathVariable("userId") long userId){
        return service.findByUserId(userId);
    }

    @GetMapping("/users/{userId}/credentials/{id}")
    public CredentialDTO findById(@PathVariable("id") long userId){
        return service.findById(userId);
    }

    @PostMapping("/users/{userId}/applications/{applicationId}/credentials")
    public CredentialDTO save(@PathVariable("userId") long userId,@PathVariable("applicationId") long applicationId,
                              @RequestBody CredentialDTO data){
        return service.save(userId,applicationId,data);
    }

    @PutMapping("/applications/{applicationId}/credentials/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable("userId") long userId,@PathVariable("applicationId") long applicationId,
                       @PathVariable("id") long id, @RequestBody CredentialDTO data){
        service.update(userId,applicationId,id,data);
    }

    @DeleteMapping("/users/{userId}/credentials/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") long id){
        service.delete(id);
    }
}
