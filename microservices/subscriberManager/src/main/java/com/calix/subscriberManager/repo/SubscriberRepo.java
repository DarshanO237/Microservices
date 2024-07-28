package com.calix.subscriberManager.repo;

import com.calix.subscriberManager.Model.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriberRepo extends JpaRepository<Subscriber,Integer> {
    Subscriber findById(int id);

}
