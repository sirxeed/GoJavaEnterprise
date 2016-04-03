import org.junit.Assert;
import org.junit.Test;

public class SquareSumImplementationTest {

    @Test
    public void testGetSquareSum() throws Exception {
        SquareSumImplementation test = new SquareSumImplementation();
        Assert.assertEquals(823,
                test.getSquareSum(new int [] {2, 3, 4, 5, 6, 7, 8, 9, 12, 0, 15, 1, 5, 8, 9, 7}, 4));
    }
}