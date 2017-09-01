package demo.rest;

import demo.model.Payment;
import demo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PaymentRestApi {
    private PaymentService paymentService;

    @Autowired
    public PaymentRestApi(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @RequestMapping(value = "/payments", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void pay(@RequestBody Payment payment) {
        paymentService.processPayment(payment);
    }
}
