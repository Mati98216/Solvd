package com.solvd.laba.task4;

import java.lang.reflect.*;

import static com.solvd.laba.task2.app.Main.logger;

public class Reflection {
    public static void main(String[] args) {
        String className = "com.solvd.laba.task2.itcompany.Customer";

        try {
            // Pobranie klasy na podstawie nazwy
            Class<?> customerClass = Class.forName(className);

            // Wyświetlenie informacji o polach klasy
            logger.info("Fields: ");
            Field[] fields = customerClass.getDeclaredFields();
            for (Field field : fields) {
                logger.info(Modifier.toString(field.getModifiers()) + " " + field.getType() + " " + field.getName());
            }

            // Wyświetlenie informacji o konstruktorach klasy
            logger.info("Constructors: ");
            Constructor<?>[] constructors = customerClass.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                logger.info(Modifier.toString(constructor.getModifiers()) + " " + constructor.getName());
                for (Class<?> parameterType : constructor.getParameterTypes()) {
                    logger.info("  " + parameterType.getName());
                }
            }

            // Wyświetlenie informacji o metodach klasy
            logger.info("\nMethods: ");
            Method[] methods = customerClass.getDeclaredMethods();
            for (Method method : methods) {
                logger.info(Modifier.toString(method.getModifiers()) + " " + method.getReturnType() + " " + method.getName());
                for (Class<?> parameterType : method.getParameterTypes()) {
                    logger.info("  " + parameterType.getName() + "\n");
                }
            }

            // Utworzenie instancji klasy Customer za pomocą refleksji
            Object customerObject = customerClass.getDeclaredConstructor(String.class, String.class, String.class).newInstance("John Doe", "john@example.com", "123456789");

            // Wywołanie metody checkPaymentStatusAndNextDue przy użyciu refleksji
            Method checkPaymentStatusMethod = customerClass.getDeclaredMethod("checkPaymentStatusAndNextDue", boolean.class);
            checkPaymentStatusMethod.invoke(customerObject, true);

        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }
}