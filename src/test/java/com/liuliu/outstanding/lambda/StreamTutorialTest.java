package com.liuliu.outstanding.lambda;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;


class StreamTutorialTest {
    @Test
    public void generatorStream() throws IOException {
        Stream<Object> empty = Stream.empty();
        Stream<String> stringStream = Stream.of("a", "b", "c");
//        Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(20);
//        System.out.println(streamIterated);
        Path path = Paths.get("C:\\Users\\lbt\\Desktop\\学习计划.txt");
        Stream<String> lines = Files.lines(path);
        lines.forEach(System.out::println);
        System.out.println(path.getFileName());
        List<String> strList = Stream.of("a", "b", "c").filter(element -> element.contains("a")).collect(Collectors.toList());
        Optional<String> anyEle = strList.stream().findAny();
        if (anyEle.isPresent()) {
            System.out.println("存在");
        }
        String s = anyEle.get();
        System.out.println(s);
        Optional<String> option2 = Stream.of("a", "b", "c").filter(element -> element.contains("d")).findFirst();
        if (!option2.isPresent()) {
            System.out.println(false);
        }
        System.out.println("==============================");
        List<String> list = Arrays.asList("abc1", "abc2", "abc3");
        Stream<String> sorted = list.stream().sorted(Comparator.reverseOrder());
        sorted.forEach(System.out::println);
        System.out.println("==============================");
        OptionalInt reduce = IntStream.range(1, 4).reduce((a, b) -> a + b);
        System.out.println(reduce.getAsInt());
        System.out.println("==============================");
        List<Product> productList = Arrays.asList(new Product(23, "potatoes"),
                new Product(14, "orange"), new Product(13, "lemon"),
                new Product(23, "bread"), new Product(13, "sugar"));
        String strList2 = productList.stream().map(Product::getName).collect(Collectors.joining(",", "[", "]"));
        System.out.println(strList2);
        Double average = productList.stream().collect(Collectors.averagingInt(Product::getPrice));
        System.out.println(average);
        Map<Boolean, List<Product>> listMap = productList.stream().collect(Collectors.partitioningBy(ele -> ele.getPrice() > 15));
        for (Boolean aBoolean : listMap.keySet()) {
            System.out.println(aBoolean);
            listMap.get(aBoolean).forEach(System.out::println);
            System.out.println();
        }
    }

    @Test
    public void functionTest() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("zhangsan", 4);
        Integer len = hashMap.computeIfAbsent("zhangsan", s -> s.length());
        System.out.println(len);
    }

    @Test
    public void collectionTest() {
        List<String> givenList = Arrays.asList("a", "bb", "ccc", "dd");
        Double average = givenList.stream().collect(averagingDouble(String::length));
        System.out.println(average);
        Optional<String> maxOption = givenList.stream().collect(maxBy(Comparator.naturalOrder()));
        System.out.println(maxOption.get());
        Map<Integer, Set<String>> groupMap = givenList.stream().collect(groupingBy(String::length, toSet()));
        Map<Boolean, List<String>> partitionMap = givenList.stream().collect(partitioningBy(s -> s.length() > 2));


    }
}