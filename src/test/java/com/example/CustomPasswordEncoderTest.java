package com.example;

/**
 * Created by luoxx on 2017/10/7.
 */
public class CustomPasswordEncoderTest {

    public static void main(String[] args) {
        CustomPasswordEncoder encoder = new CustomPasswordEncoder();
        System.out.println(encoder.encode("123"));
    }

}
