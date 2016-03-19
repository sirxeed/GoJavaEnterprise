import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExecutorNumbers implements Executor<Number> {
    private List<Task<? extends Number>> tasks = new ArrayList();
    private List<Number> validResults = new ArrayList();
    private List<Number> invalidResults = new ArrayList();
    private Map<Task<? extends Number>, Validator<? super Number>> taskValidatorMap = new HashMap();
    private boolean executed = false;

    @Override
    public void addTask(Task<? extends Number> task) throws Exception {
        if (executed) {
            throw new Exception();
        }
        tasks.add(task);
        taskValidatorMap.put(task, null);
    }

    @Override
    public void addTask(Task<? extends Number> task, Validator<? super Number> validator) throws Exception {
        if (executed) {
            throw new Exception();
        }
        tasks.add(task);
        taskValidatorMap.put(task, validator);
    }

    @Override
    public void execute() {
        for (Task<? extends Number> task : tasks) {
            task.execute();
            if (!taskValidatorMap.get(task).equals(null)) {
                if (taskValidatorMap.get(task).isValid(task.getResult())) {
                    validResults.add(task.getResult());
                } else {
                    invalidResults.add(task.getResult());
                }
            }
            else {
                validResults.add(task.getResult());
            }

        }
        executed = true;
    }

    @Override
    public List<Number> getValidResults() throws Exception {
        if (!executed) {
            throw new Exception();
        }
        return validResults;
    }

    @Override
    public List<Number> getInvalidResults() throws Exception{
        if (!executed) {
            throw new Exception();
        }
        return invalidResults;
    }
}