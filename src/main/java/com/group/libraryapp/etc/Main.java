package com.group.libraryapp.etc;

import java.util.Scanner;

public class Main {
    private static final int NUM_SIDES = 6;

    private static int[] rollDice(int numRolls) {
        int[] results = new int[NUM_SIDES];
        for (int i = 0; i < numRolls; i++) {
            int roll = (int) (Math.random() * NUM_SIDES);
            results[roll]++;
        }
        return results;
    }

    private static void printResults(int[] results) {
        for (int i = 0; i < NUM_SIDES; i++) {
            System.out.printf("%d은 %d번 나왔습니다.%n", i + 1, results[i]);
        }
    }

    public static void main(String[] args) {
        System.out.println("숫자를 입력하세요 : ");
        Scanner scanner = new Scanner(System.in);
        int numRolls = scanner.nextInt();
        int[] results = rollDice(numRolls);
        printResults(results);
    }
}
