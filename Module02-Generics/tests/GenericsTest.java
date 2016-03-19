import org.junit.Test;

public class GenericsTest {
    @Test
    public void test() throws Exception {
        ExecutorImplementation test = new ExecutorImplementation();
        test.addTask(new TaskAddition(5, 8));
        test.addTask(new TaskMultiplication(5.0f, 20.3f));
    }
}