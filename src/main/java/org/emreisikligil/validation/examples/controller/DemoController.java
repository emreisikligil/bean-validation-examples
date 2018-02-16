package org.emreisikligil.validation.examples.controller;

import org.emreisikligil.validation.examples.message.PersonRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class DemoController {

    @RequestMapping(value = "/demo", method = RequestMethod.POST)
    @ResponseBody
    public String demoEndpoint(@RequestBody @Valid PersonRequest request, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return bindingResult.toString();
        }

        return "No error";
    }

    @RequestMapping(value = "/demo2", method = RequestMethod.POST)
    @ResponseBody
    public String demo2Endpoint(@RequestBody @Valid PersonRequest request) {

        return "No error";
    }
}
