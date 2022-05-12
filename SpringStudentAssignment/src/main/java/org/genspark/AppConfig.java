package org.genspark;


import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {


   @Bean
    public Student getStudent(){
        return new Student(00,"def",getPhones(),getAddress());
    }

    @Bean
    public List<Phone> getPhones(){
       List<Phone> nums = new ArrayList<>();
       nums.add(new Phone("1987654321"));
       nums.add(new Phone("1234567891"));
       return nums;
    }

    @Bean
    public Address getAddress(){
       return new Address("Washington","DC","USA","20001");
    }




}
