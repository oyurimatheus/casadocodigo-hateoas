package me.yurimatheus.casadocodigo.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.*;
import static springfox.documentation.spi.DocumentationType.*;

@Configuration
@EnableSwagger2
public class SwagerConfig {

    @Bean
    public Docket api() {
        return new Docket(SWAGGER_2)
                   .select()
                   .apis(RequestHandlerSelectors.any())
                   .paths(any())
                   .build();
    }

}
