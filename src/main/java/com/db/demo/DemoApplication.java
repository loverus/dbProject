package com.db.demo;

import com.db.demo.domain.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

    }
    User user = new User("Jeka",30,"jk30","qwer");
    Word word = new Word("QWERtu", 20);
    @Bean
    CommandLineRunner runnerUser(UserRepository repository){
        return args -> {
            repository.save(new User("Vasya", 12, "Vas12", "123"));
            repository.save(new User("Petya", 20, "Pet20", "123"));
            repository.save(user);
        };
    }

    @Bean
    CommandLineRunner runnerWord(WordRepository repository){
        return args -> {
            repository.save(new Word("Hi", 12));
            repository.save(new Word("Hello", 3));
            repository.save(word);


        };
    }

    //ObjectMapper mapper = new ObjectMapper();



    @Bean
    CommandLineRunner runnerStat(StatisticRepository repository){
        return args -> {
            repository.save(new Statistic(user, word, true));
     //       repository.save(new Word("Hello", 3));


        };
    }

}
