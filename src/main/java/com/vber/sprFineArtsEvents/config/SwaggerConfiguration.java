package com.vber.sprFineArtsEvents.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Component
@Configuration
@EnableSwagger2
public class SwaggerConfiguration implements WebMvcConfigurer {

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {

      registry
              .addResourceHandler("swagger-ui.html")
              .addResourceLocations("classpath:/META-INF/resources/");

      registry
              .addResourceHandler("/webjars/**")
              .addResourceLocations("classpath:/META-INF/resources/webjars/");
  }
  
  @Bean
  public Docket sprFineArtsEventsApi() {
    return new Docket(DocumentationType.SWAGGER_2)
                     .select()
                     .apis(RequestHandlerSelectors.any())
                     .paths(PathSelectors.any())
                     .build()
                     .apiInfo(getApiInfo());
  }

  private ApiInfo getApiInfo() {
    return new ApiInfoBuilder()
                             .title("sprFineArtsEvents API")
                             .version("1.0")
                             .description("API for sprFineArtsEvents Application")
                             .contact(new Contact("Vladimir.V.Bvn", "", "Vladimir.V.Bvn@gmail.com"))
                             .license("Apache License Version 2.0")
                             .build();
  }
}