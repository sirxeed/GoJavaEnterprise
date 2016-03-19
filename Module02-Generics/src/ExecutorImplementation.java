import java.util.List;

public class ExecutorImplementation implements Executor<Number> {
    List<Task> tasks;

    @Override
    public void addTask(Task task) {
        tasks.add(task);
    }

    @Override
    public void addTask(Task task, Validator validator) {

    }

    @Override
    public void execute() {
        for (Task task : tasks) {
            task.execute();
        }
    }

    @Override
    public List<Number> getValidResults() {
        List<Number> validResults;
        for (Task task : tasks) {
            if (new ValidatorImplementation(task.getResult())) {
                validResults.add(task);
            }
        }

        return validResults;
    }

    @Override
    public List getInvalidResults() {

        return null;
    }
}