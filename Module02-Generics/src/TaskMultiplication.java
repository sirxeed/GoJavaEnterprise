public class TaskMultiplication implements Task<Float> {
    private float a;
    private float b;
    private float result;

    public TaskMultiplication(float a, float b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void execute() {
        result = a * b;
    }

    @Override
    public Float getResult() {
        return result;
    }
}