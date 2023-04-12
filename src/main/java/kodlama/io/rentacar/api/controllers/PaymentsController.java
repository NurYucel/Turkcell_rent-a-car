package kodlama.io.rentacar.api.controllers;

import jakarta.validation.Valid;
import kodlama.io.rentacar.business.abstracts.PaymentService;
import kodlama.io.rentacar.business.dto.reponses.create.CreatePaymentResponse;
import kodlama.io.rentacar.business.dto.reponses.get.GetAllPaymentsResponse;
import kodlama.io.rentacar.business.dto.reponses.get.GetPaymentResponse;
import kodlama.io.rentacar.business.dto.reponses.update.UpdatePaymentResponse;
import kodlama.io.rentacar.business.dto.requests.create.CreatePaymentRequest;
import kodlama.io.rentacar.business.dto.requests.update.UpdatePaymentRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/payments")
public class PaymentsController {
    private final PaymentService service;

    @GetMapping
    public List<GetAllPaymentsResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetPaymentResponse getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping
    public CreatePaymentResponse add(@Valid @RequestBody CreatePaymentRequest request) {
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdatePaymentResponse update(@PathVariable int id, @Valid @RequestBody UpdatePaymentRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}