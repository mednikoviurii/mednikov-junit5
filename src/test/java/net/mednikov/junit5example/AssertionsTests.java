package net.mednikov.junit5example;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.google.common.collect.Lists;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AssertionsTests {

    @Test
    void notNullTest(){
        String message = "Hello world!";
        Assertions.assertNotNull(message);
    }

    @Test
    void equalsTest(){
        int number = 25;
        Assertions.assertEquals(25, number);
        Assertions.assertNotEquals(10, number, "Number is 10, but should not be");

        List<Integer> elements = Lists.newArrayList(3,10,17,24,31,38,45,52,59,66,73,80);
        List<Integer> values = Lists.newArrayList(3,10,17,24,31,38,45,52,59,66,73,80);
        Assertions.assertIterableEquals(elements, values);
    }

    @Test
    void throwsTest(){
        Assertions.assertThrows(RuntimeException.class, () -> {
            throw new RuntimeException();
        });
    }

    @Test
    void timeoutTest(){
        Duration duration = Duration.ofSeconds(5);
        Assertions.assertTimeout(duration, () -> TimeUnit.SECONDS.sleep(4));
    }
}