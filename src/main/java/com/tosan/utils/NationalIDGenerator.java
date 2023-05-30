package com.tosan.utils;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class NationalIDGenerator {
    public static void main(String[] args) {
        System.out.println("How many national codes do you want?");
        Scanner scanner = new Scanner(System.in);
        int loopNo = Integer.parseInt(scanner.nextLine());
        Set<String> nationalCodes = new HashSet<>(); // for unique national ids
        while (nationalCodes.size() < loopNo)
            nationalCodes.add(generateNationalId());
        System.out.println(nationalCodes);
        scanner.close();
    }

    private static String generateNationalId() {
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