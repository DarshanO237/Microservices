package com.calix.deviceManager.service;

import com.calix.deviceManager.model.DeviceSubscriber;
import com.calix.deviceManager.model.Device;
import com.calix.deviceManager.repo.DeviceRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

@Service
public class DeviceService implements DeviceServiceInterface {
    private static final Logger logger = LoggerFactory.getLogger(DeviceService.class);
    @Autowired
    private DeviceRepo repo;



    @Autowired
    KafkaTemplate<String,DeviceSubscriber> kafkaTemplate;
    public ResponseEntity<String> addData(DeviceSubscriber t){
      try {
         logger.info("message sent to kafka");
           kafkaTemplate.send("Device-1",t);

          return new ResponseEntity<>("Device is added to Database and  updation of subscriber data is in progress",HttpStatus.OK);

         }catch (Exception e){
          e.printStackTrace();
        }


      return new ResponseEntity<>("Error could not update Database",HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<List<Device>> getCustomer() {
        try {


            return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<?> getCustomerByID(int id){
        try {

            return new ResponseEntity<>(repo.findById(id), HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();

            return new ResponseEntity<>("Device not found by this ID",HttpStatus.NOT_FOUND);
        }


    }
    public boolean deleteCustomerByID(int id){
        if(repo.existsById(id)){
            repo.deleteById(id);
            return true;
        }else{
            return false;
        }

    }



}
