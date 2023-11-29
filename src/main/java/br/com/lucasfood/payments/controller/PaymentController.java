package br.com.lucasfood.payments.controller;

import br.com.lucasfood.payments.dto.DtoPayment;
import br.com.lucasfood.payments.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URI;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @GetMapping
    public Page<DtoPayment> list(@PageableDefault(size = 10) Pageable page) {
        return service.fetchAll(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DtoPayment> detail(@PathVariable @NotNull Long id) {
        DtoPayment dto = service.fetchById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<DtoPayment> register(@RequestBody @Valid DtoPayment dto, UriComponentsBuilder uriBuilder) {
        DtoPayment payment = service.createPayment(dto);
        URI address = uriBuilder.path("/payments/{id}").buildAndExpand(payment.getId()).toUri();
        return ResponseEntity.created(address).body(payment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DtoPayment> update(@PathVariable @NotNull Long id, @RequestBody @Valid DtoPayment dto) {
        DtoPayment updated = service.updatePayment(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DtoPayment> remove(@PathVariable @NotNull Long id) {
        service.removePayment(id);
        return ResponseEntity.noContent().build();
    }

}