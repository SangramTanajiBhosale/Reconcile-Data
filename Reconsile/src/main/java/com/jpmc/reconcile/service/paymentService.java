package com.jpmc.reconcile.service;

import com.jpmc.reconcile.entity.paymentData;
import com.jpmc.reconcile.repository.paymentDataRepo;
import com.jpmc.reconcile.repository.reconcileStatusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class paymentService {
    @Autowired
    paymentDataRepo paymentDataRepo;
    @Autowired
    reconcileStatusRepo reconcileStatusRepo;
    public void insertPaymentData(paymentData paymentData){
        paymentData newPaymentData = new paymentData(
                paymentData.getPaymentId(),
                paymentData.getNextPaymentDueDate(),
                paymentData.getPaymentDate(),
                "Pending",
                LocalDateTime.now(),
                LocalDateTime.now()
        );
        paymentDataRepo.save(newPaymentData);
    }
    public void insertPaymentsData(List<paymentData> paymentsData){
        List<paymentData> newPaymentsData = paymentsData.stream().map(paymentData->new paymentData(
                paymentData.getPaymentId(),
                paymentData.getNextPaymentDueDate(),
                paymentData.getPaymentDate(),
                "Pending",
                LocalDateTime.now(),
                LocalDateTime.now())).collect(Collectors.toList());
        paymentDataRepo.saveAll(newPaymentsData);
    }
    public void deletePaymentData(Long Id){
        paymentDataRepo.deleteById(Id);
    }
    public void deleteAllPaymentData(){
        paymentDataRepo.deleteAll();
    }
    public void updateReconStatus(){
        List<Long> paymentIds = reconcileStatusRepo.findAll().stream().filter(payment->payment.getReconcileStatus().equals("COMPLETED")).map(payment->payment.getPaymentId()).collect(Collectors.toList());
        paymentIds.forEach(data->updateReconStatusPaymentData(data));
    }

    private void updateReconStatusPaymentData(Long Id){
        paymentData paymentData = paymentDataRepo.findById(Id).orElseThrow(()-> new RuntimeException("Payment Id not Found"));
        paymentData.setReconcileStatus("Completed");
        paymentDataRepo.save(paymentData);
    }
}