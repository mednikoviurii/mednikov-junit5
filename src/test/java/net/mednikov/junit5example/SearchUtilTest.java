package net.mednikov.junit5example;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.google.common.collect.Lists;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SearchUtilTest {

    private static SearchUtil util;

    @BeforeAll
    static void setup() {
        List<Integer> elements = Lists.newArrayList(3,10,17,24,31,38,45,52,59,66,73,80);
        util = new SearchUtil(elements);
    }

    @Test
    void getPositionTest(){
        Optional<Integer> result = util.getPosition(31);
        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(4, result.get());
    }

    @Test
    void noElementTest(){
        Optional<Integer> result = util.getPosition(94);
        Assertions.assertTrue(result.isEmpty());
        Assertions.assertThrows(NoSuchElementException.class, () -> result.get());
    }

    @AfterEach
    void after(){
        System.out.println("Test completed");
    }
}