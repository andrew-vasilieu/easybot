package org.easybot.easybottesttask.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(title = "EasyBot Test Task API",
                description = "EasyBot Test Task API",
                version = "v1.0"))
public class SwaggerConfig {
}
