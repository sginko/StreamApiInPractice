package pl.akademiaspecjalistowit.streamapiinpractice.zadanie4;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

public class FlatmapDemo {


    @Test
    void test(){
        List<Order> orders = List.of(
            new Order(List.of(new Product("Książka", 30.0), new Product("Długopis", 5.0)), "NOWE"),
            new Order(List.of(new Product("Laptop", 2000.0), new Product("Myszka", 100.0)), "WYSŁANE"),
            new Order(List.of(new Product("Telefon", 500.0), new Product("Etui", 50.0)), "NOWE"),
            new Order(List.of(new Product("Etui", 1838.33), new Product("Myszka", 774.17)), "WYSŁANE"),
            new Order(List.of(new Product("Telefon", 547.42), new Product("Kurtka", 375.12)), "WYSŁANE"),
            new Order(List.of(new Product("Kurtka", 1321.38)), "NOWE"),
            new Order(List.of(new Product("Buty", 1709.76)), "NOWE"),
            new Order(List.of(new Product("Długopis", 1015.35)), "DOSTARCZONE"),
            new Order(List.of(new Product("Buty", 308.45), new Product("Książka", 1899.55), new Product("Telefon", 1885.82)), "WYSŁANE"),
            new Order(List.of(new Product("Etui", 344.15), new Product("Buty", 961.36)), "DOSTARCZONE")
        );


    }

    public static Map<String, Long> findMaxFrequencyChar(String input) {

        Map<String, Long> frequencyMap = Stream.of(input.split(""))
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

         return frequencyMap.entrySet()
            .stream()
            .max(Map.Entry.comparingByValue())
            .map(entry -> Collections.singletonMap(entry.getKey(), entry.getValue()))
            .orElse(Collections.emptyMap());
    }



}
