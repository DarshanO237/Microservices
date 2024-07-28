package com.calix.subscriberManager.service;


import com.calix.subscriberManager.Model.Subscriber;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SubscriberServiceInterface {


    public List<Subscriber> getSubscriberData();
    public ResponseEntity<String> addClientData(String deviceName, String subscriberName, String connectionStatus, String properties);


}
