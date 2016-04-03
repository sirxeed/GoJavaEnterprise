import java.util.concurrent.Phaser;

public class PhaserExampleModified {
    final static int NUMBER_OF_THREADS = 4;

    public static void main(String[] args) throws InterruptedException {
        final Phaser phaser = new Phaser(NUMBER_OF_THREADS);
        phaser.register();//register self... phaser waiting for 1 party (thread)
        int pass = 1;

        new PhaserExampleModified().testPhaser(phaser);

        while (true) {
            new PhaserExampleModified().testPhaser(phaser);

            if (phaser.getRegisteredParties() % 3 == 0) {
                System.out.println("Registered " + phaser.getRegisteredParties() + " phasers. Starting to execute (pass #" + pass + ")");
                phaser.arriveAndDeregister();
                Thread.sleep(500);
                pass++;
            }
            if (pass == 3) {
                break;
            }
        }
        //phaser.arriveAndDeregister();

        Thread.sleep(10000);
        System.out.println("--- all phasers arrived and deregistered ---");

    }

    private void testPhaser(final Phaser phaser) {
        phaser.register();
        new Thread() {
            @Override
            public void run() {
                try {
                    //System.out.println(Thread.currentThread().getName() + " arrived");
                    Thread.sleep(500);
                    phaser.arrive();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " passed the barrier");
            }
        }.start();
    }
}
