package com.example;

/**
 * Created by luoxx on 2017/10/7.
 */
public class MainTest {

    public static void main(String[] args) {
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        System.out.println(encoder.encode("123"));
        CustomPasswordEncoder encoder = new CustomPasswordEncoder();
        System.out.println(encoder.encode("123"));
    }

}
