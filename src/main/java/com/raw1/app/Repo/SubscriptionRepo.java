package com.raw1.app.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raw1.app.model.Subscription;
@Repository
public interface SubscriptionRepo extends JpaRepository<Subscription, Long> {

}
