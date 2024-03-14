package pl.akademiaspecjalistowit.streamapiinpractice.zadanie3;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Zadanie3 {

    /**
     * ZACZNIJ OD NAPISANIA ASERCJI!
     * <p>
     * Mając listę pracowników (obiekty z polami name i salary), znajdź pierwszych
     * 5 pracowników z najwyższą pensją i zwróć ich imiona w posortowanej liście alfabetycznie.
     */
    @Test
    void zadanie3() {
        //given
        List<Employee> employees = List.of(
                new Employee("John Doe", 70000),
                new Employee("Jane Smith", 80000),
                new Employee("Ethan Black", 90000),
                new Employee("Emma White", 85000),
                new Employee("Michael Brown", 50000)
        );

        //when
        List<String> topEarners = groupEmployee(employees);

        //then
        assertThat(topEarners).containsExactly("Ethan Black", "Emma White", "Jane Smith", "John Doe", "Michael Brown");
    }

    private List<String> groupEmployee(List<Employee> employees) {
        return employees.stream()
                .sorted(Comparator.comparing((Employee e) -> e.getSalary()).reversed().thenComparing(e -> e.getName()))
                .limit(5)
                .map(e -> e.getName())
                .collect(Collectors.toList());
    }
}
