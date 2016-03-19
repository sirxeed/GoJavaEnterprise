public class TaskMultiplication implements Task {
    private float a;
    private float b;
    private float result;

    public TaskMultiplication(float a, float b) {
        this.a = a;
        this.b = b;
    }

    public void execute() {
        result = a * b;
    }

    public Float getResult() {
        return result;
    }
}