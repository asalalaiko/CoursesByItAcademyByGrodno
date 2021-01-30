package by.grodno.pvt.site.webappsample.service;

import by.grodno.pvt.site.webappsample.domain.Order;
import by.grodno.pvt.site.webappsample.domain.Payment;

import java.util.List;

public interface PaymentService {

    List<Payment> getPayments();

    Payment getPayment(Integer id);

    void addPayment(List<Payment> payments);

    void savePayment(Payment payment);

    void deletePayment(Integer id);

    List<Payment> getPaymentsByOrder(Order order);
}
