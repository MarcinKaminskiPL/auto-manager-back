package net.mkaminski.autoManagerBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class AutoManagerBackendApplication {

    /*
     TODO add readme.md
     TODO add paging in API
     TODO add PATCH methods in API
     TODO add tests
     TODO implements Spring Security
     TODO change database to postgres
     TODO  connect postgres on heroku
     TODO collect stats to the one endpoint
*/
    public static void main(String[] args) {
        SpringApplication.run(AutoManagerBackendApplication.class, args);
    }

}