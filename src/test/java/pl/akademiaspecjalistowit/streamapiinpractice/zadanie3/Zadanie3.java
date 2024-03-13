package pl.akademiaspecjalistowit.streamapiinpractice.zadanie3;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

public class Zadanie3 {

    /**
     * ZACZNIJ OD NAPISANIA ASERCJI!
     *
     * Mając listę pracowników (obiekty z polami name i salary), znajdź pierwszych
     * 5 pracowników z najwyższą pensją i zwróć ich imiona w posortowanej liście alfabetycznie.
     */
    @Test
    void zadanie3() {

        List<Employee> employees = List.of(
            new Employee("John Doe", 70000),
            new Employee("Jane Smith", 80000),
            new Employee("Ethan Black", 90000),
            new Employee("Emma White", 85000),
            new Employee("Michael Brown", 50000)
        );

        List<String> topEarners = null;
        System.out.println("Top zarabiający pracownicy: " + topEarners);

    }
}
