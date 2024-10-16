package com.juliano.main;

import com.juliano.dao.SerieDao;
import com.juliano.principal.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;





@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.juliano.dao")
@EntityScan(basePackages = "com.juliano.model")
public class Etapa2Application {
    @Autowired
    private SerieDao repositorio;
    public static void main(String[] args) {
        SpringApplication.run(Etapa2Application.class, args);
    }

}
