package merlin.techtest.config;


import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public")
                .pathsToMatch("/api/**")  // Filtra las rutas que deseas documentar
                .build();
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Prueba técnica Merlin Software")
                        .version("1.0.0")
                        .description("Descripción detallada de la API, con un endpoint que devuelve el precio de un producto de una marca en un momento concreto")
                        .termsOfService("http://swagger.io/terms/")
                        .contact(new Contact()
                                .name("Jesús Cacabelos Montero")
                                .url("https://github.com/jesuscacabelosmontero")
                                .email("jesuscacabelosmontero@gmail.com"))
                        .license(new License()
                                .name("Licencia")
                                .url(""))
                );
    }
            
}
