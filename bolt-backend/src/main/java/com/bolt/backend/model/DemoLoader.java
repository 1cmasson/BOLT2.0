package com.bolt.backend.model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component //Indicates that an annotated class is a "component"
public class DemoLoader implements CommandLineRunner{
//CommandLineRunner is an interface used to indicate
//that a bean should run when it is contained within a SpringApplication.
        private final BayRepository repository;

        @Autowired //
        public DemoLoader(BayRepository repository){ this.repository = repository; }
    
        @Override
        public void run(String... string) throws Exception{
            this.repository.save(new Bay("01-002","medium",15,"2020-12-06"));
            this.repository.save(new Bay("01-004","medium",20,"2020-12-06"));
            this.repository.save(new Bay("02-002","low",25,"2020-12-05"));
            this.repository.save(new Bay("02-004","low",10,"2020-12-05"));
        }
}

