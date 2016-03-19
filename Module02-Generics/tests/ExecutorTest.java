import org.junit.Assert;
import org.junit.Test;

public class ExecutorTest {

    @Test
    public void test1() throws Exception {
        ExecutorNumbers test = new ExecutorNumbers();
        test.addTask(new TaskAddition(15, 25), new ValidatorNumbers());
        test.execute();
        Assert.assertEquals(40, test.getValidResults().get(0));
    }

    @Test
    public void test2() throws Exception {
        ExecutorNumbers test = new ExecutorNumbers();
        test.addTask(new TaskAddition(35, 25), new ValidatorNumbers());
        test.execute();
        Assert.assertEquals(0, test.getValidResults().size());
    }

    @Test
    public void test3() throws Exception {
        ExecutorNumbers test = new ExecutorNumbers();
        test.addTask(new TaskMultiplication(2.2f, 10), new ValidatorNumbers());
        test.addTask(new TaskAddition(3, 8), new ValidatorNumbers());
        test.addTask(new TaskMultiplication(15, 10), new ValidatorNumbers());
        test.execute();
        Assert.assertEquals(22f, test.getValidResults().get(0));
        Assert.assertEquals(11, test.getValidResults().get(1));
        Assert.assertEquals(150f, test.getInvalidResults().get(0));
    }

    @Test
    public void test4() throws Exception {
        ExecutorNumbers test = new ExecutorNumbers();
        test.addTask(new TaskAddition(35, 25), new ValidatorNumbers());
        test.execute();
        Assert.assertEquals(60, test.getInvalidResults().get(0));
    }

    @Test (expected = Exception.class)
    public void test5() throws Exception {
        ExecutorNumbers test = new ExecutorNumbers();
        test.addTask(new TaskAddition(35, 25), new ValidatorNumbers());
        Assert.assertEquals(0, test.getValidResults().size());
    }

    @Test (expected = Exception.class)
    public void test6() throws Exception {
        ExecutorNumbers test = new ExecutorNumbers();
        test.execute();
        test.addTask(new TaskAddition(35, 25), new ValidatorNumbers());
    }

}