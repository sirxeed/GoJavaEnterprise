import org.junit.Test;

public class GenericsTest {
    @Test
    public void test() throws Exception {
        ExecutorNumbers test = new ExecutorNumbers();
        test.addTask(new TaskAddition(5, 8));
        test.addTask(new TaskMultiplication(5.0f, 20.3f));
    }
}