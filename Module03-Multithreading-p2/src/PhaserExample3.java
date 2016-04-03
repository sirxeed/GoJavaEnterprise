/*
import java.util.concurrent.Phaser;

public class PhaserExample3 {

    public static void main(String[] args) {
        final int THREADS = 10;
        for (int i = 0; i < THREADS; i++) {
            new Thread() {
                @Override
            public void run() {

                }
            }.start();
        }
    }

    public static void starter(int threads) {
        phaser.register();
        for (int i = 0; i < threads; i++) {
            new Thread() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " has arrived, phase = " + phaser.getPhase());
                }
            }.start();
            while (true) {
                if (phaser.getRegisteredParties() == 5) {
                    phaser.arriveAndDeregister();
                }
                phaser.arriveAndAwaitAdvance();
            }
        }
    }
}
*/