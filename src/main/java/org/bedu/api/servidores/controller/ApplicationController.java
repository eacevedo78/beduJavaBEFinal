package org.bedu.api.servidores.controller;

import org.bedu.api.servidores.dto.ApplicationDTO;
import org.bedu.api.servidores.service.IApplicationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/servers/{serverId}/applications")
public class ApplicationController {
    private IApplicationService service;

    public ApplicationController(IApplicationService service){
        this.service=service;
    }

    @GetMapping
    public List<ApplicationDTO> findAll(@PathVariable("serverId") long serverId){
        return service.findByServerId(serverId);
    }
    @GetMapping("/{id}")
    public ApplicationDTO findById(@PathVariable("id") long id){
        return service.findById(id);
    }
    @PostMapping
    public ApplicationDTO save(@PathVariable("serverId") long serverId,@RequestBody ApplicationDTO data){
        return service.save(serverId, data);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable("serverId") long serverId,@PathVariable("id") long id,
                       @RequestBody ApplicationDTO data){
        service.update(serverId,id,data);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") long id){
        service.delete(id);
    }
}
