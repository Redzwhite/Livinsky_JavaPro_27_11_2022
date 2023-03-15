package org.example.homework24;
import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

public class TestRunner {
    public static void start(Class<?> clazz) throws Exception {
        Object instance = clazz.getDeclaredConstructor().newInstance();
        Method[] methods = clazz.getDeclaredMethods();
        List<Method> beforeSuiteMethods = new ArrayList<>();
        List<Method> testMethods = new ArrayList<>();
        List<Method> afterSuiteMethods = new ArrayList<>();

        for (Method method : methods) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                beforeSuiteMethods.add(method);
            } else if (method.isAnnotationPresent(Test.class)) {
                testMethods.add(method);
            } else if (method.isAnnotationPresent(AfterSuite.class)) {
                afterSuiteMethods.add(method);
            }
        }

        if (beforeSuiteMethods.size() > 1 || afterSuiteMethods.size() > 1) {
            throw new RuntimeException("BeforeSuite and AfterSuite should be unique!");
        }

        beforeSuiteMethods.sort(Comparator.comparingInt((Method m) -> m.getAnnotation(BeforeSuite.class).hashCode()).reversed());
        afterSuiteMethods.sort(Comparator.comparingInt((Method m) -> m.getAnnotation(AfterSuite.class).hashCode()));

        beforeSuiteMethods.get(0).invoke(instance);

        testMethods.sort(Comparator.comparingInt((Method m) -> m.getAnnotation(Test.class).priority()).thenComparing(Method::hashCode));

        for (Method method : testMethods) {
            method.invoke(instance);
        }

        afterSuiteMethods.get(0).invoke(instance);
    }
}

