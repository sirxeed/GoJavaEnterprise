import java.util.concurrent.Callable;
import java.util.concurrent.Phaser;

public class SquareSumImplementation implements SquareSum {

    public static void main(String[] args) {
        SquareSumImplementation test = new SquareSumImplementation();
        final int NUMBER_OF_VALUES = 1000;
        final int NUMBER_OF_THREADS = 20;
        int[] values = new int[NUMBER_OF_VALUES];

        //Let's fill an array
        for (int i = 0; i < NUMBER_OF_VALUES; i++) {
            values[i] = (int) Math.random()*1000;
        }
        test.getSquareSum(values, NUMBER_OF_THREADS);
    }

    @Override
    public long getSquareSum(int[] values, int numberOfThreads) {
        Phaser phaser = new Phaser();
        return 0;
    }

    public class Worker implements Callable {

        @Override
        public Object call() throws Exception {
            for (int i = 0; i < 1; i++) {

            }
            return 0;
        }
    }
}
