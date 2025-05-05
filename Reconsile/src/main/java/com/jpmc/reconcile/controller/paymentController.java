package com.jpmc.reconcile.controller;

import com.jpmc.reconcile.entity.paymentData;
import com.jpmc.reconcile.service.paymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class paymentController {
    @Autowired
    paymentService paymentService;
    @PostMapping("/insert-payment-data")
    public ResponseEntity<String> insertPaymentData(@RequestBody paymentData paymentData){
        paymentService.insertPaymentData(paymentData);
        return new ResponseEntity<>("Payments data is insertion is completed for Id :- "+paymentData.getPaymentId(),HttpStatus.OK);
    }
    @PostMapping("/insert-payments-data")
    public ResponseEntity<String> insertPaymentsData(@RequestBody List<paymentData> paymentData){
        paymentService.insertPaymentsData(paymentData);
        return new ResponseEntity<>("Payments data is insertion is completed",HttpStatus.OK);
    }
    @DeleteMapping("/delete-payment-data")
    public ResponseEntity<String> deletePaymentData(@RequestBody Long Id){
        paymentService.deletePaymentData(Id);
        return new ResponseEntity<>("Deletion of  data is successful for Id :- "+Id,HttpStatus.OK);
    }
    @DeleteMapping("/delete-all-payment-data")
    public ResponseEntity<String> deleteAllPaymentData(){
        paymentService.deleteAllPaymentData();
        return new ResponseEntity<>("Deletion of all data is successful",HttpStatus.OK);
    }
    @GetMapping("/update-recon-status")
    public ResponseEntity<String> updateReconStatus(){
        paymentService.updateReconStatus();
        return new ResponseEntity<>("Status is updated successful",HttpStatus.OK);
    }
}
