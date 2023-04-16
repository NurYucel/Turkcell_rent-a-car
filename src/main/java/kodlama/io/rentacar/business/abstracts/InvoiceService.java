package kodlama.io.rentacar.business.abstracts;

import kodlama.io.rentacar.business.dto.reponses.create.CreateInvoiceResponse;
import kodlama.io.rentacar.business.dto.reponses.get.GetAllInvoicesResponse;
import kodlama.io.rentacar.business.dto.reponses.get.GetInvoiceResponse;
import kodlama.io.rentacar.business.dto.reponses.update.UpdateInvoiceResponse;
import kodlama.io.rentacar.business.dto.requests.create.CreateInvoiceRequest;
import kodlama.io.rentacar.business.dto.requests.update.UpdateInvoiceRequest;

import java.util.List;

public interface InvoiceService {
    List<GetAllInvoicesResponse> getAll();

    GetInvoiceResponse getById(int id);

    CreateInvoiceResponse add(CreateInvoiceRequest request);

    UpdateInvoiceResponse update(int id, UpdateInvoiceRequest request);

    void delete(int id);
}
