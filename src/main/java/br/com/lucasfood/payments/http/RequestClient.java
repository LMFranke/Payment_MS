package br.com.lucasfood.payments.http;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("request-ms")
public interface RequestClient {

    @RequestMapping(method = RequestMethod.PUT, value = "/requests/{id}/paid")
    void updatePayment(@PathVariable Long id);

}
