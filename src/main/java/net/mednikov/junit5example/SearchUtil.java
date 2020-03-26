package net.mednikov.junit5example;

import java.util.List;
import java.util.Optional;

class SearchUtil {

    private List<Integer> elements;

    SearchUtil(List<Integer> elements){
        this.elements = elements;
    }

    Optional<Integer> getPosition (Integer element){
        if (elements.contains(element)){
            return Optional.of(elements.indexOf(element));
        } else {
            return Optional.empty();
        }
    }
}