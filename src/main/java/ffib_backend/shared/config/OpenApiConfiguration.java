package ffib_backend.shared.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {

  @Bean
  public OpenAPI ffibOpenApi() {

    return new OpenAPI()
        .info(
            new Info()
                .title("FFIB API")
                .description("Football Federation Information Backend API")
                .version("v1")
                .contact(
                    new Contact().name("SportsTech Labs").email("engineering@sportstechlabs.com"))
                .license(new License().name("Proprietary")))
        .externalDocs(
            new ExternalDocumentation()
                .description("Project Documentation")
                .url("https://sportstechlabs.atlassian.net/wiki/spaces/FFIB"));
  }
}
