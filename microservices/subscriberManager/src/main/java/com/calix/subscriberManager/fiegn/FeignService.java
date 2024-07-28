package com.calix.subscriberManager.fiegn;

import com.calix.subscriberManager.Model.DeviceSubscriber;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "DeviceManager")
public interface FeignService {
    @PostMapping("/subscriber")
    public ResponseEntity<String> addCustomer(@RequestBody DeviceSubscriber t);


}

