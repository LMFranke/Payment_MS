package br.com.lucasfood.payments.repository;

import br.com.lucasfood.payments.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepositoryInterface extends JpaRepository<Payment, Long> {

}
