package kodlama.io.rentacar.business.dto.reponses.get;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetAllModelsResponse {
    private int id;
    private int brandId;
    private String name;
    private String brandName;
}
