package br.com.lucasfood.payments.dto;

import br.com.lucasfood.payments.model.Status;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class DtoPayment {

    private Long id;
    private BigDecimal value;
    private String name;
    private String number;
    private String expire;
    private String code;
    private Status status;
    private Long requestId;
    private Long formPayment;

}
