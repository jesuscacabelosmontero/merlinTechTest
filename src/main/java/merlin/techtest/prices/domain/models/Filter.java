package merlin.techtest.prices.domain.models;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Filter {
    private Long productId;
    private Long brandId;
    private LocalDateTime date;
}
