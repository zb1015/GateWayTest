package kean.nxt;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@SpringCloudApplication
@EnableAutoConfiguration
@RestController
public class APIGatewayApplication {



    public static void main(String[] args) {
        SpringApplication.run(APIGatewayApplication.class, args);
    }

    
    @Bean
    @RefreshScope
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("path_route", r -> r.path("/**")
                        .uri("http://172.18.1.251:2101")).build();
    }

}

