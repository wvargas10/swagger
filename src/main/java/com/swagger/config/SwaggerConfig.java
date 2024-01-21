package com.swagger.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static com.swagger.constants.SwaggerAppConstants.API_CONTEXT_ROOT;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
	private static final Logger logger = LoggerFactory.getLogger(SwaggerConfig.class);
	
	   @Bean
	   public Docket elibilityApiDocumentation() {
	      return new Docket(DocumentationType.SWAGGER_2)
	    		  .select()
	    		  .apis(RequestHandlerSelectors.any())
	    		  .paths(PathSelectors.ant(API_CONTEXT_ROOT + "/*"))
	    		  .build()
	    		  .useDefaultResponseMessages(false)
	              .apiInfo(apiInfo());
	   }
	   
	   private ApiInfo apiInfo() {
		      return new ApiInfoBuilder()
		            .title("Swagger specification - Swagger")
		            .description("API that provides general functionality for the purpose of demonstrating OpenApi Swagger.")
		            .termsOfServiceUrl("Terms of Service")
		            .contact(new Contact("Walter Vargas", "https://github.com/wvargas10?tab=repositories", "wvargas10@hotmail.com"))
		            .version("v1.0.0")
		            .license("License MIT Name")
		            .licenseUrl("https://opensource.org/license/mit/")
		            .build();
			   }
}
