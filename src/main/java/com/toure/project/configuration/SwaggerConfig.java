package com.toure.project.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
//@EnableSwagger2
public class SwaggerConfig {
	
	/**@Bean
	public Docket api() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(
						new ApiInfoBuilder()
						.description("Gestion de stock API")
						.title("REST API")
						.build()
						)
				.groupName("Api v1")
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.toure.project"))
				.paths(PathSelectors.ant( APP_ROOT + "/**"))
				.build();
	}
*/
	@Bean
	public OpenAPI openApi() {
		
		return new OpenAPI()
				.info(new Info()
						.title("REST API")
						.description("Gestion de stock API")
						.version("v1")
						.termsOfService("Terms of service")
                        .contact(new Contact()
                                .name("Base Platform Team")
                                .url("swagger-ui.html")
                                .email("3BasePlatformTeam@matrixcare.com"))
                        .license(new License().name("License").url(""))
						).addSecurityItem(new SecurityRequirement().addList("apikey"))
				.components(new Components()
						.addSecuritySchemes("apikey", new SecurityScheme().type(SecurityScheme.Type.HTTP)
								.scheme("bearer")
								.in(SecurityScheme.In.HEADER)
								.name("Authorization"))
						);
	}
	
}


