public class TaskAddition implements Task {
    private int a;
    private int b;
    private int result;

    public TaskAddition(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void execute() {
        result = a + b;
    }

    public Integer getResult() {
        return result;
    }
}