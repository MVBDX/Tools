package com.tosan.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import static com.tosan.utils.NationalIDGenerator.generateNationalId;

class NationalIDGeneratorTest {
    @Test
    void generateNationalIds() {
//        System.out.println("How many national codes do you want?");
//        Scanner scanner = new Scanner(System.in);
        int loopNo = 10; //Integer.parseInt(scanner.nextLine());
        Set<String> nationalCodes = new HashSet<>(); // for unique national ids
        while (nationalCodes.size() < loopNo)
            nationalCodes.add(generateNationalId());
        System.out.println(nationalCodes);//        scanner.close();
    }

    @Test
    void validateNationalId() {
        String nationalId = generateNationalId();
        AtomicInteger counter = new AtomicInteger(11);
        int sum = Arrays.stream(nationalId.substring(0,9).split(""))
                .map(i -> {
                    counter.decrementAndGet();
                    return Integer.valueOf(i);
                })
                .mapToInt(i -> i * counter.intValue())
                .sum();
        int leftover = sum % 11;
        String correctNationalId = leftover > 1 ? nationalId.substring(0, 9) + (11 - leftover) : nationalId.substring(0, 9) + leftover;

        Assertions.assertEquals(correctNationalId, nationalId);
    }
}