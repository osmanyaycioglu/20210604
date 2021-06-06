package com.training.spring.data;

import com.training.spring.rest.Person;

public interface IPersonStorage {

    void insert(final Person person);

    void update(Person personParam);

    Person get(Long idParam);
}
