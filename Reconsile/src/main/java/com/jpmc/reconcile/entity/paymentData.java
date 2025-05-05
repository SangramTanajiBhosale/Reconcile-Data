package com.jpmc.reconcile.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class paymentData {
    @Id
    private Long paymentId;
    private LocalDate nextPaymentDueDate;
    private LocalDate paymentDate;
    private String reconcileStatus;
    private LocalDateTime creTs;
    private LocalDateTime updTs;
}
