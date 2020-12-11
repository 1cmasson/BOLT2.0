package com.bolt.backend.model;

import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;
import java.util.Collection;

/**
 * The BaysController is responsible for controlling the flow of the application execution. When you make
 * a request to the application, BaysController is responsible for returning the response to that request.
 * This is the controller for the MVC design pattern.
 */

// The @RestController is a convenience annotation that combines @Controller and @ResponseBody – which eliminates
// the need to annotate every request handling method of the controller class with the @ResponseBody annotation.
// @CrossOrigin is meant for permitting cross-origin requests on specific handler classes and/or handler methods.
@RestController
@RequestMapping("/api")// The @RequestMapping maps HTTP requests to handler methods of MVC and REST controllers.
@CrossOrigin(origins = "http://localhost:3000")
public class BaysController {
    private BayRepository bayRepository; // data model interface

    //constructor
    public BaysController(BayRepository bayRepository){
        this.bayRepository = bayRepository;
    }

    // The bay() method gives the list of bays to the client
    @GetMapping("/bays") //@GetMapping annotation maps HTTP GET requests onto specific handler methods.
    Collection<Bay> bays(){return (Collection<Bay>) bayRepository.findAll();} //returns all the bays

    // The createBay method takes submission from the client and adds it to the list of bays
    @PostMapping("/bays") //@PostMapping annotation maps HTTP POST requests onto specific handler methods.
    ResponseEntity<Bay> createBay(@Valid @RequestBody Bay bay) throws URISyntaxException{
        // URISyntaxException thrown to indicate that a string could not be parsed as a URI reference.
        Bay result = bayRepository.save(bay);
        return ResponseEntity.ok().body(result);
    }
}
