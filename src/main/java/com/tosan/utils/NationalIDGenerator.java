package com.tosan.utils;

public class NationalIDGenerator {

    public static String generateNationalId() {
        String nationalId = String.valueOf(Math.round(Math.random() * 1_000_000_000));
        if (nationalId.length() < 9) nationalId += "987654321";

        int sum = 0;
        for (int i = 0; i < 9; i++)
            sum += Integer.parseInt(String.valueOf(nationalId.charAt(i))) * (10 - i);

        int leftover = sum % 11;
        nationalId = leftover > 1 ? nationalId.substring(0, 9) + (11 - leftover) : nationalId.substring(0, 9) + leftover;
        return nationalId;
    }
}