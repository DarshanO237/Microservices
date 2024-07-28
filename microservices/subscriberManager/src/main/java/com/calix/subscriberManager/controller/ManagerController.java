package com.calix.subscriberManager.controller;

import com.calix.subscriberManager.Model.Client;
import com.calix.subscriberManager.Model.Subscriber;
import com.calix.subscriberManager.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ManagerController {
    @Autowired
    private SubscriberService service;

    @GetMapping("/hello")
    @ResponseBody
    public String test(){
        return "hello calix";
    }

    @GetMapping("/subscriber")
    @ResponseBody
    public List<Subscriber> getCustomer() {

        return service.getSubscriberData();

    }
    @PostMapping("/subscriber")

    public ResponseEntity<String> addClientData (@RequestBody Client c){

            return  service.addClientData(c.getDeviceName(), c.getSubscriberName(), c.getConnectionStatus(), c.getProperties());


    }


}
