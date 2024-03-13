package pl.akademiaspecjalistowit.streamapiinpractice.zadanie1;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class Zadanie1 {

    @Test
    void filteringAndSumming(){
        List<Integer> numbers = Arrays.asList(12, 3, 45, 19, 8, 15, 4, 27, 20);

        int sum = 0;

        System.out.println("Suma parzystych liczb większych od 10: " + sum);

    }
}
