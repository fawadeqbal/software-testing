package com.example.tdd;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Book> list= Arrays.asList(
                new Book("1", "Test Driven Development", "Kent Beck"),
                new Book("2", "Clean Code", "Robert C. Martin"),
                new Book("3", "Effective Java", "Joshua Bloch"),
                new Book("4", "Refactoring", "Martin Fowler")
        );

        list=list.stream().filter(e->e.getId().equals("1")||e.getId().equals("2")).collect(Collectors.toList());
        System.out.println(list);
    }
}
