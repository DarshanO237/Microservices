package com.calix.deviceManager.service;

import com.calix.deviceManager.model.Device;
import com.calix.deviceManager.model.DeviceSubscriber;
import org.springframework.http.ResponseEntity;

import java.util.List;
public interface DeviceServiceInterface {
    public ResponseEntity<String> addData(DeviceSubscriber t);
    public ResponseEntity<?> getCustomerByID(int id);
    public boolean deleteCustomerByID(int id);
    public ResponseEntity<List<Device>> getCustomer();

}
