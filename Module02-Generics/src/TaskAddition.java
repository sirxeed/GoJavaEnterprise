public class TaskAddition implements Task<Integer> {
    private int a;
    private int b;
    private Integer result;

    public TaskAddition(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void execute() {
        result = a + b;
    }

    @Override
    public Integer getResult() {
        return result;
    }
}