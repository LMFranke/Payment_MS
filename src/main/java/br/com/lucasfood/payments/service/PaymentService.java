package br.com.lucasfood.payments.service;

import br.com.lucasfood.payments.dto.DtoPayment;
import br.com.lucasfood.payments.model.Payment;
import br.com.lucasfood.payments.model.Status;
import br.com.lucasfood.payments.repository.PaymentRepositoryInterface;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepositoryInterface repository;

    @Autowired
    private ModelMapper modelMapper;

    public Page<DtoPayment> fetchAll(Pageable page) {
        return repository.findAll(page).map(p -> modelMapper.map(p, DtoPayment.class));
    }

    public DtoPayment fetchById(Long id) {
        Payment payment = repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        return modelMapper.map(payment, DtoPayment.class);
    }

    public DtoPayment createPayment(DtoPayment dto) {
        Payment payment = modelMapper.map(dto, Payment.class);
        payment.setStatus(Status.CREATED);
        repository.save(payment);

        return modelMapper.map(payment, DtoPayment.class);
    }

    public DtoPayment updatePayment(Long id, DtoPayment dto) {
        Payment payment = modelMapper.map(dto, Payment.class);
        payment.setId(id);
        payment = repository.save(payment);

        return modelMapper.map(payment, DtoPayment.class);
    }

    public void removePayment(Long id) {
        repository.deleteById(id );
    }

}
