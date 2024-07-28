package com.calix.deviceManager.controller;

import com.calix.deviceManager.model.DeviceSubscriber;
import com.calix.deviceManager.model.Device;
import com.calix.deviceManager.service.DeviceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DeviceController {
   Logger logger= LoggerFactory.getLogger(DeviceController.class);
    @Autowired
    private DeviceService service;

    @GetMapping("/device")
    @ResponseBody
    public ResponseEntity<List<Device>> getCustomer() {

        return service.getCustomer();

    }


    @PostMapping("/subscriber")
    public ResponseEntity<String> addCustomer(@RequestBody DeviceSubscriber t){
        logger.info("Microservices are communicating");
        System.out.println(t);
         return service.addData(t);
    }
    @GetMapping("/device/{id}")
    @ResponseBody
    public ResponseEntity<?>  getCustomerByID(@PathVariable(value = "id") int id){
        return service.getCustomerByID(id);
    }
    @DeleteMapping("/device/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") int id){
        try{ boolean isDeleted= service.deleteCustomerByID(id);
            if(isDeleted){
                return new ResponseEntity<>("Device is Deleted",HttpStatus.OK);
            }
        }catch(Exception e){
           e.printStackTrace();
        }
        return new ResponseEntity<>("Error deleting resource",HttpStatus.INTERNAL_SERVER_ERROR);

    }

}
