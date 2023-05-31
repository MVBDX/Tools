package com.tosan.utils;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static com.tosan.utils.NationalIDGenerator.generateNationalId;
import static org.junit.jupiter.api.Assertions.*;

class NationalIDGeneratorTest {
    @Test
    void generateNationalIdTest() {
//        System.out.println("How many national codes do you want?");
//        Scanner scanner = new Scanner(System.in);
        int loopNo = 10; //Integer.parseInt(scanner.nextLine());
        Set<String> nationalCodes = new HashSet<>(); // for unique national ids
        while (nationalCodes.size() < loopNo)
            nationalCodes.add(generateNationalId());
        System.out.println(nationalCodes);
//        scanner.close();
    }

}