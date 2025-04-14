package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FunctionalInterfaceLearning {
    List<String> testing = new ArrayList<>();

    public List<String> getFiltered(String... s){
        Optional<String> tt = Optional.of("testing");

//        Optional<String> mm = tt.map(this::toLower).flatMap(this::splitString).stream().collect(Collectors.toList());
//        Predicate<String> yy

        return Stream.of(s)
                .map(this::toLower)
                .flatMap(this::splitString)
                .collect(Collectors.toList());
    }

    private String toLower(String s){
        return s.toLowerCase();
    }

    private Stream<String> splitString(String s){
        return Stream.of(s.split(""));
    }

    public static void main(String[] args) {
        FunctionalInterfaceLearning functionalInterfaceLearning = new FunctionalInterfaceLearning();
        List<String> result = functionalInterfaceLearning.getFiltered("Eow","APPU");
        for (String s : result){
            System.out.println(s);
        }
    }
}
