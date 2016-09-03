package com.vserdiuk.test.repository;

import com.vserdiuk.test.entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by vserdiuk on 8/28/16.
 */

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
}
