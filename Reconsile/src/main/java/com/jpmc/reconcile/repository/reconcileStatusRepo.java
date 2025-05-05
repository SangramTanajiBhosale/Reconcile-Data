package com.jpmc.reconcile.repository;

import com.jpmc.reconcile.entity.reconcileStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface reconcileStatusRepo extends JpaRepository<reconcileStatus,Long> {
}
