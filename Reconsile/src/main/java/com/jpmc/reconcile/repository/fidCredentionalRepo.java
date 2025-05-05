package com.jpmc.reconcile.repository;

import com.jpmc.reconcile.entity.fidCredentional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface fidCredentionalRepo extends JpaRepository<fidCredentional,Long> {
    Optional<fidCredentional> findByusername(String userName);
}
