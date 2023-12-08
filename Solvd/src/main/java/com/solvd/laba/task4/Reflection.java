package com.solvd.laba.task4;

import java.lang.reflect.*;

public class Reflection {
    public static void main(String[] args) {
        String className = "com.solvd.laba.task2.itcompany.Customer";
        printClassInfo(className);
    }
    private static void printClassInfo(String className) {
        try {
            Class<?> customerClass = Class.forName(className);

            printInfo("Fields:", customerClass.getDeclaredFields());
            printInfo("Constructors:", customerClass.getDeclaredConstructors());
            printInfo("Methods:", customerClass.getDeclaredMethods());

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        }
    }

    private static void printInfo(String title, Object[] elements) {
        System.out.println(title);
        for (Object element : elements) {
            if (element instanceof Field) {
                printField((Field) element);
            } else if (element instanceof Constructor) {
                printConstructor((Constructor<?>) element);
            } else if (element instanceof Method) {
                printMethod((Method) element);
            }
        }
        System.out.println();
    }

    private static void printField(Field field) {
        System.out.println(Modifier.toString(field.getModifiers()) + " " + field.getType() + " " + field.getName());
    }

    private static void printConstructor(Constructor<?> constructor) {
        System.out.print(Modifier.toString(constructor.getModifiers()) + " " + constructor.getName() + "(");
        Parameter[] parameters = constructor.getParameters();
        for (int i = 0; i < parameters.length; i++) {
            System.out.print(parameters[i].getType().getName());
            if (i < parameters.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(")");
    }

    private static void printMethod(Method method) {
        System.out.print(Modifier.toString(method.getModifiers()) + " " + method.getReturnType() + " " + method.getName() + "(");
        Parameter[] parameters = method.getParameters();
        for (int i = 0; i < parameters.length; i++) {
            System.out.print(parameters[i].getType().getName());
            if (i < parameters.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(")");
    }
}