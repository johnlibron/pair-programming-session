import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example {

    public static void main(String[] args) {
        char[] arrSample = {'R', 'O', 'S', 'E'};
        String strString_1 = new String(arrSample);
        String strString_2 = "ROSE";

        String str1 = "Rock";
        String str2 = "Star";

        String str3 = str1.concat(str2);
        String str4 = str1 + str2;

        System.out.println(str3);
        System.out.println(str4);


        System.out.println(str4.length());

        System.out.println(str3.charAt(2));

        System.out.println(str4.indexOf('S'));


        System.out.println(str4.replace("Star", "Duke"));
        System.out.println(str4.endsWith("q"));
        System.out.println(str4.toLowerCase());
        System.out.println(str4.equals(" rockstar"));


        Gson gson = new Gson();
        try {
            Employee employee = gson.fromJson(new FileReader("src/main/resources/employee.json"), Employee.class);
            System.out.println(employee);
        } catch (IOException e) {
            e.printStackTrace();
        }



        /******/

        List<String> numbers = Arrays.asList("1john", "2jul", "3ponyo", "4haku", "5champ", "6polo");

        System.out.println("original list: " + numbers);

        List<String> even = numbers.stream()
//                                    .map(s -> Integer.valueOf(s))
                .map(String::toUpperCase)
//                                    .filter(number -> number % 2 == 0)
                .filter(name -> name.contains("O"))
                                    .collect(Collectors.toList());

        System.out.println("processed list: " + even);


        List<Staff> staffList = Arrays.asList(
                new Staff("john", 27, new BigDecimal(123)),
                new Staff("julrecha", 26, new BigDecimal(456)),
                new Staff("ponyeta", 24, new BigDecimal(789))
        );


        List<String> collect = staffList.stream()
//                .map(Staff::getName)
//                .filter(name -> name.contains("a"))
                .filter(e -> e.getName().contains("a"))
                .filter(e -> e.getAge() == 24)
//                .map(Staff::getAge)
//                .filter(age -> age == 24)
                .map(Staff::getName)
                .collect(Collectors.toList());

        System.out.println(collect);


        String[][] array = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};

        List<String[]> result = Arrays.stream(array)
                .filter(x -> {
                    for (String s : x) {
                        if (s.equals("a")) {
                            return false;
                        }
                    }
                    return true;
                }).collect(Collectors.toList());

        System.out.println(result.size());

        result.forEach(x -> System.out.println(Arrays.toString(x)));

        List<String> collect1 = Arrays.stream(array)
                .flatMap(Stream::of)
                .filter(x -> !x.equals("a"))
                .collect(Collectors.toList());

        collect1.forEach(System.out::println);

        Developer o1 = new Developer();
        o1.setName("John");
        o1.addBook("Java 8 in Action");
        o1.addBook("Spring Boot in Action");
        o1.addBook("Effective Java (3nd Edition)");

        Developer o2 = new Developer();
        o2.setName("John");
        o2.addBook("Learning Python, 5th Edition");
        o2.addBook("Effective Java (3nd Edition)");

        List<Developer> list = new ArrayList<>();
        list.add(o1);
        list.add(o2);

        Set<String> collect3 = list.stream()
                .map(Developer::getBook)
                .flatMap(Collection::stream)
                .filter(x -> !x.toLowerCase().contains("python"))
                .collect(Collectors.toSet());

        collect3.forEach(System.out::println);



        List<Order> orders = findAll();

        // sum the line items' total amount
        BigDecimal sumOfLineItems = orders.stream()
                .flatMap(order -> order.getLineItems().stream())    //  Stream<LineItem>
                .map(line -> line.getTotal())                       //  Stream<BigDecimal>
                .reduce(BigDecimal.ZERO, BigDecimal::add);          //  reduce to sum all

        // sum the order's total amount
        BigDecimal sumOfOrder = orders.stream()
                .map(order -> order.getTotal())                     //  Stream<BigDecimal>
                .reduce(BigDecimal.ZERO, BigDecimal::add);          //  reduce to sum all

        System.out.println(sumOfLineItems);                         // 3194.20
        System.out.println(sumOfOrder);                             // 3194.20

        if (!sumOfOrder.equals(sumOfLineItems)) {
            System.out.println("The sumOfOrder is not equals to sumOfLineItems!");
        }
    }

    private static List<Order> findAll() {

        LineItem item1 = new LineItem(1, "apple", 1, new BigDecimal("1.20"), new BigDecimal("1.20"));
        LineItem item2 = new LineItem(2, "orange", 2, new BigDecimal(".50"), new BigDecimal("1.00"));
        Order order1 = new Order(1, "A0000001", Arrays.asList(item1, item2), new BigDecimal("2.20"));

        LineItem item3 = new LineItem(3, "monitor BenQ", 5, new BigDecimal("99.00"), new BigDecimal("495.00"));
        LineItem item4 = new LineItem(4, "monitor LG", 10, new BigDecimal("120.00"), new BigDecimal("1200.00"));
        Order order2 = new Order(2, "A0000002", Arrays.asList(item3, item4), new BigDecimal("1695.00"));

        LineItem item5 = new LineItem(5, "One Plus 8T", 3, new BigDecimal("499.00"), new BigDecimal("1497.00"));
        Order order3 = new Order(3, "A0000003", Arrays.asList(item5), new BigDecimal("1497.00"));

        return Arrays.asList(order1, order2, order3);

    }
}
