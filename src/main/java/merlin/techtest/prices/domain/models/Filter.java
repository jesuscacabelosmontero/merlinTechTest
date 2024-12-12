package merlin.techtest.prices.domain.models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Filter {
    private Long productId;
    private Long brandId;
    private LocalDate startDate;
    private LocalDate endDate;
}
