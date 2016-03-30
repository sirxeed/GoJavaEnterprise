import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class LectureExecutorExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //new LectureExecutorExample().testExecute();
        //new LectureExecutorExample().testSubmit();
        //new LectureExecutorExample().testException();
        //new LectureExecutorExample().testInvokeAny();
        new LectureExecutorExample().testInvokeAll();
    }

    public void testExecute() {
        Executor executor = Executors.newSingleThreadExecutor();
        System.out.println(Thread.currentThread().getName() + " submits task");
        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " async task started!");
            }
        });
    }

    public void testSubmit() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> f = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(1000);
                return "Task executed";
            }
        });
        System.out.println("Waiting for result");
        System.out.println("Result: \"" + f.get() + "\"");


        executorService.shutdown();
    }

    public void testException() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> f = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                throw new RuntimeException("Exception happened!");
            }
        });
        System.out.println("Waiting for result");
        Thread.sleep(1000);
        System.out.println("Result: \"" + f.get() + "\"");

        executorService.shutdown();
    }

    public void testInvokeAny() throws ExecutionException, InterruptedException {
        List<Callable<String>> callables = new ArrayList<>();
        Random random = new Random();
        IntStream.range(0, 3).forEach(i -> callables.add(() -> {
            Thread.sleep(random.nextInt(1000));
            return String.valueOf(i);
        }));

        ExecutorService executor = Executors.newCachedThreadPool();
        String result = executor.invokeAny(callables);

        System.out.println(result);

        executor.shutdown();
    }

    public void testInvokeAll() throws ExecutionException, InterruptedException {
        List<Callable<String>> callables = new ArrayList<>();
        Random random = new Random();
        IntStream.range(0, 3).forEach(i -> callables.add(() -> {
            Thread.sleep(random.nextInt(1000));
            return String.valueOf(i);
        }));

        ExecutorService executor = Executors.newCachedThreadPool();
        List<Future<String>> result = executor.invokeAll(callables);

        System.out.println(result);

        executor.shutdown();
    }
}
