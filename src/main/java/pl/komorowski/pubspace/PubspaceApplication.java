package pl.komorowski.pubspace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "pl.komorowski.pubspace.repository")
public class PubspaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PubspaceApplication.class, args);
    }
}

