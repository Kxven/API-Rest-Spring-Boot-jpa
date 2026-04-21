package br.com.keven.spring_boot_essentials.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/hello")
public class HelloWorldController{


    //Essa classe é somente um estudo das possiveis formas de eu mapear e os tipos de retorno possiveis de um controller


    /*@GetMapping
    public String HelloWorld(){
        return "Hello Wolrd";
    }*/


    /*@GetMapping
    public ResponseEntity<String> helloWorld(){
        return ResponseEntity.ok("Hello World");
    }*/


    /*@GetMapping
    public ResponseEntity<String> helloWorld(){
        return new ResponseEntity("Hello World", HttpStatus.OK);
    }*/


    /*@PostMapping
    public ResponseEntity<String> helloWorld(){
        return new ResponseEntity("Hello World", HttpStatus.CREATED);
    }*/


    /*@DeleteMapping
    public ResponseEntity<String> helloWorld(){
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }*/

    /*@GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String HelloWorld(){
        return "Hello Wolrd";
    }*/

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String get1(@PathVariable("id") String id){
        return "Hello Wolrd " + id;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String get2(@RequestParam(value="name", required = false) String name){
        return "Hello Wolrd " + name;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String post(@RequestBody String name){
        return "Hello World" + name;
    }

}
