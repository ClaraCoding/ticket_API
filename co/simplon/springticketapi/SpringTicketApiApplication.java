package co.simplon.springticketapi;

import co.simplon.springticketapi.dao.LearnerDao;
import co.simplon.springticketapi.model.Learner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@SpringBootApplication
@EnableSwagger2
public class SpringTicketApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringTicketApiApplication.class, args);
    }
}
