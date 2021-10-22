package ua.gudz.hw21;

import org.reflections.Reflections;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class BoxService {
    List<?> classExamples;
    Map<String, Object> myMap = new HashMap<>();
    Reflections reflections = new Reflections(BoxService.class.getPackage().getName());


    void reflectionScan() {
        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(AutoCreate.class);
        classExamples = classes.stream()
                .map(c -> c.getConstructors()[0])
                .filter(Objects::nonNull)
                .map(c -> {
                            try {
                                return c.newInstance();
                            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                                e.printStackTrace();
                            }
                            return null;
                        }
                )
                .filter(Objects::nonNull)
                .toList();
        classExamples
                .forEach(System.out::println);
    }

    //       List<?> changeFields(List<?> in) {
//        in.stream()
//                .map(Object::getClass)
//                .map(Class::getDeclaredFields)
//                .forEach(x -> {
//                    Arrays.stream(x).filter(y -> y.getAnnotation(Multiplier
//                                    .class).value().endsWith("Sum"))
//                            .peek(j -> {
//                                try {
//                                    j.setAccessible(true);
//                                    if (j.get(j).equals(Number.class)) {
//                                        int i = j.getInt(j);
//                                        j.set(j, i + i);
//                                    }
//                                } catch (Exception e) {
//                                    e.printStackTrace();
//                                }
//                            })
//                            .map(Object::getClass)
//                            .toList();
//
//                });
//
//        return in;
//    }    Не понял как правильно сделать через стримы
    void changeFields(List<?> in) {
        for (Object x : in) {
            Field[] array = x.getClass().getDeclaredFields();
            for (Field y : array) {
                try {
                    if (y.isAnnotationPresent(Multiplier.class)) {
                        if (y.getAnnotation(Multiplier.class).value()
                                .equals("Sum")) {
                            y.setAccessible(true);
                            Number number = y.get(x).getClass().getGenericSuperclass()
                                    .equals(Number.class) ? ((Number) y.get(x)) : null;
                            if (number != null && number.getClass().equals(Double.class)) {
                                y.set(x, number.doubleValue() + number.doubleValue());
                            } else if (number != null && number.getClass().equals(Integer.class))
                                y.set(x, number.intValue() + number.intValue());
                        }
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    void createMap(List<?> in) {
        in.forEach(x -> myMap.put(x.getClass().getSimpleName(), x));
    }

    void invokeMethodsFromList(List<?> in) {
        for (Object x : in) {
            Method[] myMet = x.getClass().getDeclaredMethods();
            for (Method y : myMet) {
                if (y.isAnnotationPresent((Init.class))) {
                    y.setAccessible(true);
                    try {
                        y.invoke(x);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    void invokeMethodsFromMap(Map<String, Object> in) {
        ArrayList<Object> values = new ArrayList<>(in.values());
        for (Object x : values) {
            Method[] myMet = x.getClass().getDeclaredMethods();
            for (Method y : myMet) {
                if (y.isAnnotationPresent((Init.class))) {
                    y.setAccessible(true);
                    try {
                        y.invoke(x);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}





