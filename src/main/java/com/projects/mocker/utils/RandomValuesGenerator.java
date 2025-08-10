package com.projects.mocker.utils;

import java.util.Random;

public class RandomValuesGenerator {

    public static String generateRandomString(int length) {
        String characterSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characterSet.length());
            sb.append(characterSet.charAt(index));
        }
        return sb.toString();
    }

    public static int generateRandomInt(int length){
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be greater than 0");
        }

        Random random = new Random();
        int min = (int) Math.pow(10, length - 1); // smallest number with given length
        int max = (int) Math.pow(10, length) - 1; // largest number with given length

        return random.nextInt(max - min + 1) + min;
    }
}