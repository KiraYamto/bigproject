package org.bobo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class TestController {

    @RequestMapping(value = {"/second"}, method = RequestMethod.POST)
   public String testOne(@RequestBody String requestBody, HttpServletRequest request, HttpServletResponse response){
        System.out.println("testRequest");
        return "ok";
    }

}
