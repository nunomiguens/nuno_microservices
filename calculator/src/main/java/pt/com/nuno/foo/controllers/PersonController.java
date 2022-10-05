package pt.com.nuno.foo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pt.com.nuno.foo.model.Person;
import pt.com.nuno.foo.services.personServices;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private personServices services;

    @RequestMapping(method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findAll()  {
        return services.findAll();
    }

    @RequestMapping(value="/{id}", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findById(@PathVariable("id") String id )  {

        return services.findById(id);
    }

    @RequestMapping(method= RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person create(@RequestBody Person person )  {
        return services.create(person);
    }

    @RequestMapping(method= RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person update(@RequestBody Person person )  {
        return services.update(person);
    }

    @RequestMapping(value="/{id}", method= RequestMethod.DELETE)
    public void delete(@PathVariable("id") String id )  {
        services.delete(id);
    }




}
