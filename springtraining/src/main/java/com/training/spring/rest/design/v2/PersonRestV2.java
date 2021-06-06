package com.training.spring.rest.design.v2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.rest.Person;
import com.training.spring.services.PersonManager;

@RestController
@RequestMapping("/api/v2/person/provision")
public class PersonRestV2 {

    @Autowired
    private PersonManager pm;

    @PostMapping("/add")
    public String add(@Validated @RequestBody final Person person) {
        //        if ((person.getName() == null)
        //            || person.getName()
        //                     .isEmpty()) {
        //            throw new IllegalArgumentException("name boş olamaz");
        //        }
        this.pm.add(person);
        return "SUCCESS";
    }

    @PostMapping("/update")
    public String update(@RequestBody final Person person) {
        this.pm.update(person);

        return "SUCCESS";
    }

    @GetMapping("/get/{id}")
    public Person get(@PathVariable("id") final Long id) {

        return this.pm.get(id);
    }


    //    @GetMapping("/getbyname")
    //    public Person getbyname(final String name) {
    //        return new Person();
    //    }
    //
    //    @GetMapping("/getbysurname")
    //    public Person getbysurname(final String surname) {
    //        return new Person();
    //    }

}
