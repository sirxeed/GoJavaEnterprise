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
        test.addTask(new TaskAddition(35, 25), new ValidatorNumbers());
        test.execute();
        Assert.assertEquals(60, test.getInvalidResults().get(0));
    }

    @Test (expected = Exception.class)
    public void test4() throws Exception {
        ExecutorNumbers test = new ExecutorNumbers();
        test.addTask(new TaskAddition(35, 25), new ValidatorNumbers());
        Assert.assertEquals(0, test.getValidResults().size());
    }

    @Test (expected = Exception.class)
    public void test5() throws Exception {
        ExecutorNumbers test = new ExecutorNumbers();
        test.execute();
        test.addTask(new TaskAddition(35, 25), new ValidatorNumbers());
    }

}