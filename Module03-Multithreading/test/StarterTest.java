import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class StarterTest {

    @Test
    public void testGetElements() throws Exception {
        Starter test = new Starter();
        final int SIZE = 1000;
        List<Integer> elements = new LinkedList<>();
        for (int i = 1; i <= SIZE; i++) {
            elements.add(i);
        }
        test.starter(SIZE);
        Thread.sleep(SIZE / 5);
        Assert.assertArrayEquals(elements.toArray(), test.getElements().toArray());
    }
}