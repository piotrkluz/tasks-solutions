package lib;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Utils {
    public static <T> List<T> reverseList(List<T> list) {
        Collections.reverse(list);
        return list;
    }

    public static String arrToString(Integer[] actual) {
        return Stream.of(actual).map(o ->  o == null ? "null" : o.toString()).collect(Collectors.joining(", "));
    }
}