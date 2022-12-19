package org.bedu.api.servidores.controller;

import org.bedu.api.servidores.dto.ServerDTO;
import org.bedu.api.servidores.service.IServerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servers")
public class ServerController {
    private IServerService service;

    public ServerController(IServerService service){
        this.service=service;
    }

    @GetMapping
    public List<ServerDTO> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ServerDTO findAll(@PathVariable("id") long id){
        return service.findById(id);
    }

    @PostMapping
    public ServerDTO save(@RequestBody ServerDTO data){
        return service.save(data);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id") long id, @RequestBody ServerDTO data){
        service.update(id,data);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") long id){
        service.delete(id);
    }

}
