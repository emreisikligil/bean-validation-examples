/*
 * MONITISE CONFIDENTIAL
 * ____________________
 * Copyright 2003 - 2015 Monitise Group Limited
 * All Rights Reserved. www.monitisegroup.com
 * NOTICE: All information contained herein is, and remains
 * the property of Monitise Group Limited or its group
 * companies. The intellectual and technical concepts contained
 * herein are proprietary to Monitise Group Limited and Monitise
 * group companies and may be covered by U.S. and
 * Foreign Patents, patents in process, and are protected by
 * trade secret or copyright law. Dissemination of this information
 * or reproduction of this material is strictly forbidden unless prior
 * written permission is obtained from Monitise Group Limited. Any
 * reproduction of this material must contain this notice
 */

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
