package merlin.techtest.prices.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import merlin.techtest.prices.domain.models.Filter;
import merlin.techtest.prices.domain.models.Price;
import merlin.techtest.prices.exception.PriceNotFoundException;
import merlin.techtest.prices.infrastructure.repository.PriceEntity;
import merlin.techtest.prices.infrastructure.repository.PriceRepository;

@SpringBootTest
class PriceServiceTest {

    @Mock
    private PriceRepository priceRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private PriceService priceService;

    private Filter filter;
    private PriceEntity mockPriceEntity;
    private Price mockPrice;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        
        filter = new Filter(1L, 1L, LocalDateTime.of(2024, 12, 12, 16, 0, 0));

        mockPriceEntity = new PriceEntity();
        mockPriceEntity.setProductId(1L);
        mockPriceEntity.setBrandId(1L);
        mockPriceEntity.setStartDate(LocalDateTime.of(2024, 12, 12, 10, 0, 0));
        mockPriceEntity.setEndDate(LocalDateTime.of(2024, 12, 14, 10, 0, 0));
        mockPriceEntity.setPriority(1L);
        mockPriceEntity.setPrice(30.80);
        mockPriceEntity.setPriceList(1L);

        mockPrice = new Price();
        mockPrice.setProductId(1L);
        mockPrice.setBrandId(1L);
        mockPrice.setStartDate(LocalDateTime.of(2024, 12, 12, 10, 0, 0));
        mockPrice.setEndDate(LocalDateTime.of(2024, 12, 14, 10, 0, 0));
        mockPrice.setPriceList(1L);
        mockPrice.setPrice(30.80);
    }


/*     @Test
    void testGetFilteredPriceWithCorrectData() {
        
        when(priceRepository.findPricesByFilter(filter.getProductId(), filter.getBrandId(), LocalDateTime.of(2024, 12, 12, 16, 0, 0)))
                .thenReturn(mockPriceEntity);
        when(modelMapper.map(mockPriceEntity, Price.class)).thenReturn(mockPrice);

        Price result = priceService.getFilteredPrice(filter);
        assertNotNull(result);
        assertEquals(mockPrice.getProductId(), result.getProductId());
        assertEquals(mockPrice.getBrandId(), result.getBrandId());
        assertEquals(mockPrice.getPrice(), result.getPrice());
        verify(priceRepository, times(1)).findPricesByFilter(filter.getProductId(), filter.getBrandId(), filter.getDate());
        verify(modelMapper, times(1)).map(mockPriceEntity, Price.class);
    } */

    @Test
    void testGetFilteredPriceNotFound() {

        when(priceRepository.findPricesByFilter(filter.getProductId(), filter.getBrandId(), filter.getDate()))
                .thenReturn(null);

        PriceNotFoundException exception = assertThrows(PriceNotFoundException.class, () -> {
            priceService.getFilteredPrice(filter);
        });

        assertEquals("No se encontró el precio para ese producto de esa marca para esa fecha.", exception.getMessage());
    }
}