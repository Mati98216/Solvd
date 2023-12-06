package com.solvd.laba.task1.task1;

public class UserInfoPrinter {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: com.solvd.laba.lacture1.task1.UserInfoPrinter <Name> <Age> <Location>");
        } else {
            String name = args[0];
            int age = Integer.parseInt(args[1]);
            String location = args[2];

            System.out.println("User Information:");
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Location: " + location);
        }
    }
}
