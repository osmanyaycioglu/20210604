package com.training.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.spring.data.IPersonStorage;
import com.training.spring.rest.Person;

@Service
public class PersonManager {

    @Autowired
    private IPersonStorage personStorage;

    public void add(final Person personParam) {
        this.personStorage.insert(personParam);
    }

    public void update(final Person personParam) {
        this.personStorage.update(personParam);

    }

    public Person get(final Long idParam) {
        Person personLoc = this.personStorage.get(idParam);
        if (personLoc == null) {
            throw new IllegalArgumentException("Bu id li person yok : " + idParam);
        }

        return personLoc;
    }


}
