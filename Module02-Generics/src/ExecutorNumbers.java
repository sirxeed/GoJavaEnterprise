import java.util.List;

public class ExecutorNumbers implements Executor<Number> {
    private List<Task> tasks;
    private List<Number> validResults;
    private List<Number> invalidResults;

    @Override
    public void addTask(Task<? extends Number> task) {
        tasks.add(task);
    }

    @Override
    public void addTask(Task<? extends Number> task, Validator<? super Number> validator) {

    }

    @Override
    public void execute() {
        for (Task task : tasks) {
            task.execute();
            if (new ValidatorNumbers().isValid(task.getResult())) {
                validResults.add(task.getResult());
            }
        }
    }

    @Override
    public List<Number> getValidResults() {
        return validResults;
    }

    @Override
    public List<Number> getInvalidResults() {

        return invalidResults;
    }
}