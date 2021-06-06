package com.training.spring.rest.design.v2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.rest.Person;

@RestController
@RequestMapping("/api/v2/person/search")
public class PersonSearchV2 {

    @GetMapping("/name")
    public Person getbyname(final String name) {
        return new Person();
    }

    @GetMapping("/surname")
    public Person getbysurname(final String surname) {
        return new Person();
    }

}
