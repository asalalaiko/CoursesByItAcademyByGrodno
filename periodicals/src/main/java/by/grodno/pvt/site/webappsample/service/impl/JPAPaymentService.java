package by.grodno.pvt.site.webappsample.service.impl;


import by.grodno.pvt.site.webappsample.domain.Order;
import by.grodno.pvt.site.webappsample.domain.Payment;
import by.grodno.pvt.site.webappsample.repo.PaymentRepo;
import by.grodno.pvt.site.webappsample.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class JPAPaymentService implements PaymentService {

    @Autowired
    PaymentRepo paymentRepo;

    @Override
    public List<Payment> getPayments() {
        return paymentRepo.findAll();
    }

    @Override
    public Payment getPayment(Integer id) {
        return paymentRepo.getOne(id);
    }

    @Override
    public void addPayment(List<Payment> payments) {
        paymentRepo.saveAll(payments);
    }

    @Override
    public void savePayment(Payment payment) {
        paymentRepo.save(payment);
    }

    @Override
    public void deletePayment(Integer id) {
        paymentRepo.deleteById(id);
    }

    @Override
    public List<Payment> getPaymentsByOrder(Order order) {
        return paymentRepo.findByOrder(order);
    }
}
