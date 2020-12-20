package org.exemple.lesson3;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

@Data
public class Student {
    private String name;
    private int age;

//    public Student(String name, int age){
//        this.name = name;
//        this.age = age;
//    }
}
