package merlin.techtest.prices.infrastructure.controller;

import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import merlin.techtest.prices.application.PriceService;
import merlin.techtest.prices.domain.models.Filter;
import merlin.techtest.prices.domain.models.Price;
import merlin.techtest.prices.exception.PriceNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class PriceController {

    private final PriceService service;
    
    public PriceController(PriceService service) {
        this.service = service;
    }

    @Operation(
        summary = "Obtener precio del producto para la fecha indicada",
        description = "Obtiene el precio mas prioritario para el producto de la compañía que se pase y en la fecha indicada"
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200", 
            description = "Precio obtenido correctamente",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Price.class))
        ),
        @ApiResponse(
            responseCode = "400", 
            description = "Petición incorrecta (parámetros inválidos)"
        ),
        @ApiResponse(
            responseCode = "404", 
            description = "No se encontró el precio para ese producto de esa marca para esa fecha."
        )
    })
    @GetMapping("/api/price")
    public Price getPriceByFilter(
        @Parameter(description = "Filtro por el que se buscará el precio. Contiene Id del producto (productID), id de la compañía (brandID) y fecha en la que tiene que estar el precio (data)", required = true)    
        @RequestBody Filter filter
        ) {
        return service.getFilteredPrice(filter);
    }
    
    @ExceptionHandler(PriceNotFoundException.class)
    public ResponseEntity<String> handlePriceNotFoundException(PriceNotFoundException exception) {
        return new ResponseEntity<>("Error: " + exception.getMessage(), HttpStatus.NOT_FOUND);
    }
}
