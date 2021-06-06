package com.training.spring.data;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

import com.training.spring.rest.Person;

@Component
public class PersonStorage implements IPersonStorage {

    private final Map<Long, Person> personMap = new ConcurrentHashMap<>();
    // private final List<String>      strs      = Collections.synchronizedList(new ArrayList<>());

    @Override
    public void insert(final Person person) {
        this.personMap.put(person.getUniqueId(),
                           person);
    }

    @Override
    public void update(final Person personParam) {
        this.personMap.put(personParam.getUniqueId(),
                           personParam);

    }

    @Override
    public Person get(final Long idParam) {
        return this.personMap.get(idParam);
    }
}
