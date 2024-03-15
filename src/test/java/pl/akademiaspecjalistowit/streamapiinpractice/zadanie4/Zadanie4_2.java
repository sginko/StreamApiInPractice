package pl.akademiaspecjalistowit.streamapiinpractice.zadanie4;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.BIG_DECIMAL;

public class Zadanie4_2 {

    /**
     * ZACZNIJ OD NAPISANIA ASERCJI!
     * <p>
     * Masz listę obiektów Order, gdzie każdy Order zawiera listę produktów oraz status zamówienia
     * (np. "NOWE", "WYSŁANE", "DOSTARCZONE"). Każdy produkt ma nazwę i cenę.
     * <p>
     * Twoim zadaniem jest obliczenie łącznej wartości produktów we wszystkich nowych zamówieniach.
     */
    @Test
    void zadanie4() {
        //given
        List<Order> orders = List.of(
                new Order(List.of(new Product("Książka", 30.0), new Product("Długopis", 5.0)), "NOWE"),
                new Order(List.of(new Product("Laptop", 2000.0), new Product("Myszka", 100.0)), "WYSŁANE"),
                new Order(List.of(new Product("Telefon", 500.0), new Product("Etui", 50.0)), "NOWE"),
                new Order(List.of(new Product("Etui", 1838.33), new Product("Myszka", 774.17)), "WYSŁANE"),
                new Order(List.of(new Product("Telefon", 547.42), new Product("Kurtka", 375.12)), "WYSŁANE"),
                new Order(List.of(new Product("Kurtka", 1321.38)), "NOWE"),
                new Order(List.of(new Product("Buty", 1709.76)), "NOWE"),
                new Order(List.of(new Product("Długopis", 1015.35)), "DOSTARCZONE"), new Order(List.of(new Product("Buty", 308.45),
                        new Product("Książka", 1899.55), new Product("Telefon", 1885.82)), "WYSŁANE"),
                new Order(List.of(new Product("Etui", 344.15), new Product("Buty", 961.36)), "DOSTARCZONE")
        );

        //when
        BigDecimal sumOrders = getSumNewOrders(orders);

        //then
        assertThat(sumOrders).isEqualTo(BigDecimal.valueOf(3616.14));
    }

    private static BigDecimal getSumNewOrders(List<Order> orders) {
        return orders.stream()
                .filter(o -> o.getStatus().equals("NOWE"))
                .flatMap(p -> p.getProducts().stream())
                .map(p -> BigDecimal.valueOf(p.getPrice()))
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
