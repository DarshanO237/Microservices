package com.calix.deviceManager.repo;

import com.calix.deviceManager.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRepo  extends JpaRepository<Device,Integer> {

    List<Device> findByName(String name);
    List<Device> findById(int id);
}
