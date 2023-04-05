package kodlama.io.rentacar.business.dto.reponses.get;

import kodlama.io.rentacar.entities.enums.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetAllCarsResponse {
    private int id;
    private int modelId;
    private int modelYear;
    private String plate;
    private State state;
    private double dailyPrice;

}
