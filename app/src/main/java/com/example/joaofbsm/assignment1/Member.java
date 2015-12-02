package com.example.joaofbsm.assignment1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Database Simulation
 */
public class Member {

    private String name;
    private String email;
    private String password;

    public static List<Member> members = new ArrayList<>(Arrays.asList(new Member("Test", "test", "1"),
                                                                       new Member("Joao Francisco", "joao", "2")));

    public Member(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
