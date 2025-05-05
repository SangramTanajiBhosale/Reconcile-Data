package com.jpmc.reconcile.repository;

import com.jpmc.reconcile.entity.paymentData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface paymentDataRepo extends JpaRepository<paymentData, Long> {
}
