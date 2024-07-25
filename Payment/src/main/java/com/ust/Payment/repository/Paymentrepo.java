package com.ust.Payment.repository;

import com.ust.Payment.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Paymentrepo extends JpaRepository<Payment,Long> {
    Payment findByPayid(Long payid);
}
