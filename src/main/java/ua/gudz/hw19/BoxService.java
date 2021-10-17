package ua.gudz.hw19;

import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class BoxService {
//    void allClass (Class <?extends Annotation> annotation) throws Exception{
//        Reflections reflections = new Reflections(new ConfigurationBuilder()
//                .setUrls(ClasspathHelper.forJavaClassPath())
//                .setScanners(new MethodAnnotationsScanner()));


    void reflectionsScan() {
        Reflections reflections = new Reflections(BoxService.class.getPackage().getName());
        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(AutoCreate.class);
        List<?> classExamples = new ArrayList<>();
        classes.stream()
                .map(Class::getClass)
                .forEach(System.out::println);
        classes.stream()
                .map(Class::getClass)
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
    }
}
//        classes.stream()
//                .map(cls -> cls.getAnnotation(AutoCreate.class))
//                .map(AutoCreate::value)
//                .forEach(System.out::println);






