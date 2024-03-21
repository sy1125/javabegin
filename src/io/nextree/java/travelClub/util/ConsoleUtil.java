package io.nextree.java.travelClub.util;

import java.util.Scanner;

public class ConsoleUtil {

    private Scanner scanner;

    public ConsoleUtil() {
        this.scanner = new Scanner(System.in);
    }

    public String getValueOf(String lable) {
        System.out.print(lable + " : ");
        String inputStr = scanner.nextLine();
        inputStr = inputStr.trim();
        return inputStr;
    }
}
