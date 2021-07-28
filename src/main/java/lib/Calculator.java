package lib;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

import static lib.Utils.reverseList;

public class Calculator {

    /**
     * @param input Accept only int elements in range: 0-9
     * @return Adds 1 to each element. If value exceeds max: 9 adds 1 to element on left.
     * @throws CalculatorException in case of invalid input argument (null, out of range)
     */
    public static Integer[] addOneToEach(Integer[] input) {
        if (input == null) throw new CalculatorException("Input should not be null");
        if (input.length == 0) throw new CalculatorException("Input should not be empty");
        if (Stream.of(input).anyMatch(Objects::isNull))
            throw new CalculatorException("Every element should be in range: 0-9. FOUND: null\n", input);
        Optional<Integer> invalidNumber = Stream.of(input).filter(i -> i < 0 || i > 9).findFirst();
        if (invalidNumber.isPresent())
            throw new CalculatorException("Every element should be in range: 0-9. FOUND: " + invalidNumber.get(), input);

        AccumulatorList result = reverseList(Arrays.asList(input)).stream()
                .reduce(new AccumulatorList(), (acc, curr) -> {
                    int addValue = acc.moveNext ? curr + 2 : curr + 1;
                    acc.moveNext = addValue > 9;
                    acc.add(addValue > 9 ? addValue - 10 : addValue);

                    return acc;

                }, (a, b) -> a);

        if (result.moveNext) result.add(1);
        return reverseList(result).toArray(Integer[]::new);
    }
}
