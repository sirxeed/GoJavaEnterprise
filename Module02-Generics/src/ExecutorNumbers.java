import java.util.List;
import java.util.Map;

public class ExecutorNumbers implements Executor<Number> {
    private List<Task<? extends Number>> tasks;
    private List<Number> validResults;
    private List<Number> invalidResults;
    private Map<Task<? extends Number>, Validator<? super Number>> taskValidatorMap;

    @Override
    public void addTask(Task<? extends Number> task) {
        tasks.add(task);
        taskValidatorMap.put(task, null);
    }

    @Override
    public void addTask(Task<? extends Number> task, Validator<? super Number> validator) {
        tasks.add(task);
        taskValidatorMap.put(task, validator);
    }

    @Override
    public void execute() {
        for (Task<? extends Number> task : tasks) {
            task.execute();
            if (!taskValidatorMap.get(task).equals(null)) {
                if (new ValidatorNumbers().isValid(task.getResult())) {
                    validResults.add(task.getResult());
                } else {
                    invalidResults.add(task.getResult());
                }
            }
            else {
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