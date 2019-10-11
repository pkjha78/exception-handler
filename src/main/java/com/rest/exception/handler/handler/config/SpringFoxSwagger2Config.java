package com.rest.exception.handler.handler.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SpringFoxSwagger2Config {
	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(getApiInfo()).select()
				// .apis(RequestHandlerSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("com.rest.exception.handler.handler.controller.rest.v1"))
				.paths(PathSelectors.any()).build();
	}

	private ApiInfo getApiInfo() {
		/*return new ApiInfo("Micro Service REST API Documentation", "A Micro Services API created using Spring Boot",
				"1.0", "http://localhost:8080/policy.html",
				new Contact("P J", "https://www.yourdomain.com/", "test@gmail.com"), 
				"API License",
				"API License URL", Collections.emptyList());*/
		return new ApiInfoBuilder().title("REST API Documentation")
				.description("Services API created using Spring Boot")
				.contact(new Contact("P J", "www.example.com", "example@example.com"))
				.license("API License (Apache 2.0)")
				.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
				.version("1.0.0")
				.build();
	}
}
