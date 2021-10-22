package ua.gudz.hw21;

public class Test {
    public static void main(String[] args) {
        BoxService boxService = new BoxService();
        System.out.println("We get after Scan our Classes: ");
        boxService.reflectionScan();
        boxService.changeFields(boxService.classExamples);
        System.out.println("After changes Fields: ");
        boxService.classExamples
                .forEach(System.out::println);
        boxService.createMap(boxService.classExamples);
        System.out.println("Map contains: " + boxService.myMap);
        System.out.print("Methods invoke from List:  ");
        boxService.invokeMethodsFromList(boxService.classExamples);
        System.out.print("Methods invoke from Map:  ");
        boxService.invokeMethodsFromMap(boxService.myMap);
    }
}
