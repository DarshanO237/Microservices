package com.calix.deviceManager.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Entity
@Getter
@Setter

public class Device {



    @GeneratedValue(strategy = GenerationType.TABLE)
    @Id
    private int id;
    private String name;
    private String connectionStatus;
    private String properties;

    public Device(int id, String name, String connectionStatus, String properties) {
        this.id = id;
        this.name = name;
        this.connectionStatus = connectionStatus;
        this.properties = properties;
    }

   public Device(){

   }

    public Device(String name, String connectionStatus, String properties) {
        this.name = name;
        this.connectionStatus = connectionStatus;
        this.properties = properties;
    }
}


