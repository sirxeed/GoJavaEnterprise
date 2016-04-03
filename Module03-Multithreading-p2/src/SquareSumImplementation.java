import java.util.concurrent.Callable;
import java.util.concurrent.Phaser;

public class SquareSumImplementation implements SquareSum {

    public static void main(String[] args) {
        SquareSumImplementation test = new SquareSumImplementation();
        final int NUMBER_OF_VALUES = 1000;
        final int NUMBER_OF_THREADS = 4;
        int[] values = new int[NUMBER_OF_VALUES];

        //Let's fill an array
        for (int i = 0; i < NUMBER_OF_VALUES; i++) {
            values[i] = (int) Math.random()*1000;
        }
        test.getSquareSum(values, NUMBER_OF_THREADS);

        Phaser phaser = new Phaser();
        System.out.println("Phasercount is " + phaser.getPhase());
        //new SquareSumImplementation().getSquareSum(phaser, 2000);//phaser waiting for 2 parties
        //new PhaserExampleModified().testPhaser(phaser, 4000);//phaser waiting for 3 parties
        //new PhaserExampleModified().testPhaser(phaser, 6000);//phaser waiting for 4 parties
        //now that all threads are initiated, we will de-register main thread
        phaser.register();

    }

    @Override
    public long getSquareSum(int[] values, int numberOfThreads) {


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
