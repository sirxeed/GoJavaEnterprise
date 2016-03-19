public class Generics {

    public static void main(String[] args) {
        ExecutorNumbers test = new ExecutorNumbers();

        test.addTask(new TaskAddition(5, 5));
        test.addTask(new TaskAddition(2, 30));
        test.addTask(new TaskAddition(1, 1));
        test.addTask(new TaskMultiplication(1, 5));
        test.addTask(new TaskMultiplication(1.1f, 0.2f));
        test.addTask(new TaskMultiplication(2.0f, 8.3f));


    }
}