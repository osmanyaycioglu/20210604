package com.training.spring.rest;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@ResponseBody

@RestController
@RequestMapping("/first")
public class FirstRest {

    @GetMapping("/greeting1/{xyz}/devam/{abc}/amount/{miktar}")
    public String greeting1(@PathVariable("xyz") final String name,
                            @PathVariable("abc") final String surname,
                            @PathVariable("miktar") final BigDecimal amount) {
        return "Greetings " + name + " " + surname + " : " + amount.toString();
    }

    @GetMapping("/greeting2")
    public String greeting2(@RequestParam("xyz") final String name,
                            @RequestParam("abc") final String surname,
                            @RequestParam("miktar") final BigDecimal amount) {
        return "Greetings " + name + " " + surname + " : " + amount.toString();
    }

    @GetMapping("/greeting3")
    public String greeting3(@RequestHeader("xyz") final String name,
                            @RequestHeader("abc") final String surname,
                            @RequestHeader("miktar") final BigDecimal amount) {
        return "Greetings " + name + " " + surname + " : " + amount.toString();
    }

    @PostMapping("/greeting4")
    public String greeting3(@RequestBody final Person personParam) {
        return "Greetings " + personParam;
    }

    @PostMapping("/greeting5")
    public Person greeting5(@RequestBody final Person personParam) {
        personParam.setName("ali");
        return personParam;
    }

    @PostMapping(value = "/greeting6",
                 consumes = {
                              MediaType.APPLICATION_JSON_VALUE,
                              MediaType.APPLICATION_XML_VALUE
                 },
                 produces = {
                              MediaType.APPLICATION_JSON_VALUE,
                              MediaType.APPLICATION_XML_VALUE
                 })
    public Person greeting6(@RequestBody final Person personParam) {
        personParam.setName("ali");
        return personParam;
    }

    // Not advised
    @GetMapping("/greeting1a/{operation}")
    public ResponseEntity<?> greeting1(@PathVariable("operation") final Integer op,
                                       @RequestParam("abc") final String abc,
                                       @RequestParam("miktar") final BigDecimal amount) {
        switch (op) {
            case 1:
                return ResponseEntity.ok("abc : " + abc);
            case 2:
                return ResponseEntity.ok("abc : " + abc + " miktar : " + amount);

            default:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                     .body("Error");
        }
    }

    @GetMapping("/greeting1b/{operation}")
    public ResponseEntity<?> greeting1(@PathVariable("operation") final Integer op,
                                       final HttpServletRequest httpServletRequestParam) {
        switch (op) {
            case 1:
                return ResponseEntity.ok("abc : " + httpServletRequestParam.getParameter("abc"));
            case 2:
                return ResponseEntity.ok("abc : "
                                         + httpServletRequestParam.getParameter("abc")
                                         + " miktar : "
                                         + httpServletRequestParam.getParameter("miktar"));

            default:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                     .body("Error");
        }
    }

    @GetMapping("hello")
    // @RequestMapping(value = "/first", method = RequestMethod.GET)
    public String hello() {
        return "First Hello";
    }

    @PostMapping("hello")
    public String hello2() {
        return "First Hello POST";
    }

    @PutMapping("hello")
    public String hello3() {
        return "First Hello PUT";
    }

    @PatchMapping("hello")
    public String hello4() {
        return "First Hello PATCH";
    }

    @DeleteMapping("hello")
    public String hello5() {
        return "First Hello DELETE";
    }

}
