package com.vserdiuk.test.controller;

import com.vserdiuk.test.entity.Person;
import com.vserdiuk.test.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * Created by vserdiuk on 6/21/16.
 */

@RestController
@RequestMapping("persons")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Person> getAll() {
        List<Person> persons = ((List<Person>)personRepository.findAll());
        return  persons;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Person getPersonById(@PathVariable("id") Long id) {
        return personRepository.findOne(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void add(@RequestBody Person person){
        personRepository.save(person);
    }

    @RequestMapping(value = "/upload_image", method = RequestMethod.POST)
    public void uploadImg(HttpServletRequest request, Long id) {
        MultipartHttpServletRequest mRequest;
        try {
            mRequest = (MultipartHttpServletRequest) request;
            mRequest.getParameterMap();

            Iterator<String> itr = mRequest.getFileNames();
            while (itr.hasNext()) {
                MultipartFile multipartFile = mRequest.getFile(itr.next());
                Person person = personRepository.findOne(id);
                byte[] photo = multipartFile.getBytes();
                person.setPhoto(photo);
                personRepository.save(person);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public  void remove(@PathVariable("id") Long id) {
        Person person = personRepository.findOne(id);
        personRepository.delete(person);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void update(@RequestBody Person person) {
        personRepository.save(person);
    }

}
