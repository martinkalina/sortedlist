package cz.mkalina.sortedlist;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class SortedLinkedListTest {

    @ParameterizedTest
    @MethodSource("lists")
    public <T extends Comparable<T>> void testGet(List<T> testData) {
        List<T> sortedList = new SortedLinkedList<>(testData);
        List<T> sortedData = sortData(testData);
        for (int i = 0; i < sortedData.size(); i++) {
            assertEquals(sortedData.get(i), sortedList.get(i));
        }
    }

    @ParameterizedTest
    @MethodSource("lists")
//    @SuppressWarnings("all")
    public <T extends Comparable<T>> void testAdd(List<T> testData) {
        List<T> sortedList = new SortedLinkedList<>();
        //noinspection UseBulkOperation
        testData.forEach(sortedList::add);
        assertEquals(sortData(testData), sortedList);
    }

    @ParameterizedTest
    @MethodSource("lists")
    public <T extends Comparable<T>> void testAddAll(List<T> testData) {
        List<T> sortedList = new SortedLinkedList<>();
        sortedList.addAll(testData);
        assertEquals(sortData(testData), sortedList);
    }

    @ParameterizedTest
    @MethodSource("lists")
    public <T extends Comparable<T>> void testCreate(List<T> testData) {
        List<T> sortedList = new SortedLinkedList<>(testData);
        assertEquals(sortData(testData), sortedList);
    }

    @ParameterizedTest
    @MethodSource("lists")
    public <T extends Comparable<T>> void testSize(List<T> testData) {
        List<T> sortedList = new SortedLinkedList<>();
        sortedList.addAll(testData);
        assertEquals(testData.size(), sortedList.size());
    }

    private <T extends Comparable<T>> List<T> sortData(List<T> testData) {
        return testData.stream().sorted().toList();
    }

    public static Stream<Arguments> lists() {
        return Stream.of(
                arguments(List.of()),
                arguments(List.of(1)),
                arguments(List.of(3, 2, 1)),
                arguments(List.of(3, 2, 2, 1)),
                arguments(List.of(3, 3, 2, 2, 1, 1)),
                arguments(List.of("Bob", "Alice", "John", "Clara"))
        );
    }
}
