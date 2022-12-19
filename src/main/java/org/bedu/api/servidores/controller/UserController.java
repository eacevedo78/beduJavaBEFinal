package org.bedu.api.servidores.controller;

import org.bedu.api.servidores.dto.UserDTO;
import org.bedu.api.servidores.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private IUserService service;

    public UserController(IUserService service){
        this.service=service;
    }

    @GetMapping
    public List<UserDTO> findAll(){
        return service.findAll();
    }

    @GetMapping("{id}")
    public UserDTO findAll(@PathVariable("id") long id){
        return service.findById(id);
    }

    @PostMapping
    public UserDTO save(@RequestBody UserDTO data){
        return service.save(data);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id") long id,@RequestBody UserDTO data){
        service.update(id,data);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") long id){
        service.delete(id);
    }
}
