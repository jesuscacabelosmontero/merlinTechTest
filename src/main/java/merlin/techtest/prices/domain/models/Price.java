package merlin.techtest.prices.domain.models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Price {
    private Long id;
    private Double price;
    private Long productId;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double discount;
}
