package com.practice.springboot.controller;

import com.practice.springboot.model.User1;
import com.practice.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//Extending RepresentationalModel in Entity class is not mandatory as EntityModel extends it.
@RestController
public class HateoasDemo {
    @Autowired
    UserRepository repository;

    @GetMapping("/getAll")
    public List<User1> getAllEmployees() {
        return (List<User1>) repository.findAll();
    }

    @GetMapping("/getById/{empNo}")
    public EntityModel<User1> getEmployeeById(@PathVariable Integer empNo) {
        User1 user1 = repository.findById(empNo).get();
        EntityModel<User1> resource = EntityModel.of(user1);
        Link link1 = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllEmployees()).withRel("getAll");
        Link link2 = WebMvcLinkBuilder.linkTo(HateoasDemo.class).slash("getById").slash(user1.getId()).withSelfRel();
        resource.add(link1).add(link2);
        return resource;
    }
}
