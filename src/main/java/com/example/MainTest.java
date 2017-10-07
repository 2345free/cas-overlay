package com.example;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by luoxx on 2017/10/7.
 */
public class MainTest {

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("123"));
    }

}
