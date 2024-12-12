package merlin.techtest.prices.domain.models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Price {
    private Long productId;
    private Long brandId;
    private Double price;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double discount;
}
