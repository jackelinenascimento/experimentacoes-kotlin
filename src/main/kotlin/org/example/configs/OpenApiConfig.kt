package org.example.configs

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import org.springframework.context.annotation.Configuration

@Configuration
@OpenAPIDefinition(
    info = Info(
        title = "API de Pessoas",
        version = "v1",
        description = "API para gerenciar pessoas"
    )
)
class OpenApiConfig
