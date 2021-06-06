package com.training.spring.rest.design.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.rest.Person;

@RestController
@RequestMapping("/api/v1/person/provision")
public class PersonRest {

    @PutMapping
    public String add(final Person person) {
        return "SUCCESS";
    }

    @PatchMapping
    public String update(final Person person) {
        return "SUCCESS";
    }

    @GetMapping
    public Person get(final String id) {
        return new Person();
    }


}
