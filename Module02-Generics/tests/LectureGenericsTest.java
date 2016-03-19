import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class LectureGenericsTest {

    @Test
    public void genericsTypeSafeTest() throws Exception {
        List<Integer> ints = Arrays.asList(10, 20, 30);
        for (Integer anInt : ints) {
            System.out.println(anInt);
        }


    }

    @Test
    public void testGenericSubtypes() throws Exception {
        List<Number> numbers;
        List<Integer> integers = Arrays.asList(10, 20, 30);
        //numbers = integers;


    }

    @Test
    public void testArraysTypes() throws Exception {
        Number[] numbers;
        Integer[] integers = new Integer[]{10, 20, 30};
        numbers = integers;
        numbers[2] = 10.3;

    }
}
