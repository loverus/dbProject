package com.db.demo;

import com.db.demo.domain.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

    }


    public List useraddToList() {
        List<User> users = new ArrayList<>();

        User newUser = new User("Jeka", LocalDate.of(2012, 6, 30), "jk30", "qwer");
        users.add(newUser);
        users.add (new User("Vasya",LocalDate.of(1990, 12, 30), "Vas12", "123"));
        users.add (new User("Petya", LocalDate.of(1980, 8, 31), "Pet20", "123"));
        //User user = users.get(newUser);
        //users.put(newUser);



        //users.add(new User("Vasya",LocalDate.of(1990, 12, 30), "Vas12", "123");
        return users;
    }

    public List wordaddToList() {
        List<Word> words = new ArrayList<>();

        Word newWord = new Word("Hi", 12);
        words.add(newWord);
        words.add (new Word("Привет", 3));
        words.add (new Word("QWERtu", 20));
        //User user = users.get(newUser);
        //users.put(newUser);



        //users.add(new User("Vasya",LocalDate.of(1990, 12, 30), "Vas12", "123");
        return words;
    }

    //Word word = new Word("QWERtu", 20);

    List<User> users = new ArrayList<>();
    List<Word> words = new ArrayList<>();
    @Bean
    CommandLineRunner runnerUser(UserRepository repository){
        return args -> {
           // repository.save(new User("Vasya",LocalDate.of(1990, 12, 30), "Vas12", "123"));
          //  repository.save(new User("Petya", LocalDate.of(1980, 8, 31), "Pet20", "123"));

            users = useraddToList();
            for (User us : users){
            repository.save(us);}
        };
    }

    @Bean
    CommandLineRunner runnerWord(WordRepository repository){
        return args -> {
            words = wordaddToList();
            for (Word ws : words){
                repository.save(ws);}

            //repository.save(new Word("Hi", 12));
           // repository.save(new Word("Привет", 3));
            //repository.save(word);


        };
    }

    //ObjectMapper mapper = new ObjectMapper();

    //User newUser = new User("Jeka", LocalDate.of(2012, 6, 30), "jk30", "qwer");
    //users.add
    @Bean
    CommandLineRunner runnerStat(StatisticRepository repository){
        return args -> {
            //List<User> users = new ArrayList<>();
           // users = addToList();
            System.out.print(users);
            User us = users.get(0);
            Word ws = words.get(1);
            //for (User us : users) {
                System.out.print(us);

                repository.save(new Statistic(us, ws, true));
                //       repository.save(new Word("Hello", 3));

            //}
        };
    }

}
