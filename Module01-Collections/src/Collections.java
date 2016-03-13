import java.util.*;

public class Collections {
    static final int AMOUNT_OF_CALCULATIONS = 100;

    public static void main(String[] args) {
        /*
        //ArrayList
        //add() 10K
        System.out.println("Arraylist " + AMOUNT_OF_CALCULATIONS + " calculations, 10K add() average time is: "
                + addingList(new ArrayList<Integer>(), 10000) + "ms");

        //add() 100K
        System.out.println("Arraylist " + AMOUNT_OF_CALCULATIONS + " calculations, 100K add() average time is: "
                + addingList(new ArrayList<Integer>(), 100000) + "ms");

        //add() 1M
        System.out.println("Arraylist " + AMOUNT_OF_CALCULATIONS + " calculations, 1M add() average time is: "
                + addingList(new ArrayList<Integer>(), 1000000) + "ms");

        System.out.println();
        //
        //get() 10K
        System.out.println("Arraylist " + AMOUNT_OF_CALCULATIONS + " calculations, 10K get() average time is: "
                + gettingList(new ArrayList<Integer>(), 10000) + "ms");

        //get() 100K
        System.out.println("Arraylist " + AMOUNT_OF_CALCULATIONS + " calculations, 100K get() average time is: "
                + gettingList(new ArrayList<Integer>(), 100000) + "ms");

        //get() 1M
        System.out.println("Arraylist " + AMOUNT_OF_CALCULATIONS + " calculations, 1M get() average time is: "
                + gettingList(new ArrayList<Integer>(), 1000000) + "ms");

        System.out.println();
        //
        //remove() 10K
        System.out.println("Arraylist " + AMOUNT_OF_CALCULATIONS + " calculations, 10K remove() average time is: "
                + removingList(new ArrayList<Integer>(), 10000) + "ms");

        //remove() 100K
        System.out.println("Arraylist " + AMOUNT_OF_CALCULATIONS + " calculations, 100K remove() average time is: "
                + removingList(new ArrayList<Integer>(), 100000) + "ms");

        //remove() 1M
        System.out.println("Arraylist " + AMOUNT_OF_CALCULATIONS + " calculations, 1M remove() average time is: "
                + removingList(new ArrayList<Integer>(), 1000000) + "ms");

        System.out.println();
        //
        //contains() 10K
        System.out.println("Arraylist " + AMOUNT_OF_CALCULATIONS + " calculations, 10K contains() average time is: "
                + contains(new ArrayList<Integer>(), 10000) + "ms");

        //contains() 100K
        System.out.println("Arraylist " + AMOUNT_OF_CALCULATIONS + " calculations, 100K contains() average time is: "
                + contains(new ArrayList<Integer>(), 100000) + "ms");

        //contains() 1M
        System.out.println("Arraylist " + AMOUNT_OF_CALCULATIONS + " calculations, 1M contains() average time is: "
                + contains(new ArrayList<Integer>(), 1000000) + "ms");

        System.out.println();
        //
        //populate() 10K
        System.out.println("Arraylist " + AMOUNT_OF_CALCULATIONS + " calculations, 10K populate() average time is: "
                + populating(new ArrayList<Integer>(), 10000) + "ms");

        //populate() 100K
        System.out.println("Arraylist " + AMOUNT_OF_CALCULATIONS + " calculations, 100K populate() average time is: "
                + populating(new ArrayList<Integer>(), 100000) + "ms");

        //populate() 1M
        System.out.println("Arraylist " + AMOUNT_OF_CALCULATIONS + " calculations, 1M populate() average time is: "
                + populating(new ArrayList<Integer>(), 1000000) + "ms");

         */
        System.out.println();
        //
        //iterator.add() 10K
        System.out.println("Arraylist " + AMOUNT_OF_CALCULATIONS + " calculations, 10K iterator.add() average time is: "
                + iteratorAddList(new ArrayList<Integer>(), 10000) + "ms");

        //iterator.add() 100K
        System.out.println("Arraylist " + AMOUNT_OF_CALCULATIONS + " calculations, 100K iterator.add() average time is: "
                + iteratorAddList(new ArrayList<Integer>(), 100000) + "ms");

        //iterator.add() 1M
        System.out.println("Arraylist " + AMOUNT_OF_CALCULATIONS + " calculations, 1M iterator.add() average time is: "
                + iteratorAddList(new ArrayList<Integer>(), 1000000) + "ms");

    }

    private static float addingList(List<Integer> list, int amount) {
        Date time = new Date();

        long[] duration = new long[AMOUNT_OF_CALCULATIONS];
        //fill
        for (int i = 0; i < amount; i++) {
            list.add((int)(Math.random() * 35465));
        }

        for (int i = 0; i < AMOUNT_OF_CALCULATIONS; i++) {
            list.clear();
            time = new Date();
            for (int j = 0; j < list.size(); j++) {
                list.add((int) (Math.random() * list.size()), (int) (Math.random() * list.size()));
            }
            duration[i] = new Date().getTime() - time.getTime();
        }
        return average(duration);
    }

    private static float iteratorAddList(List<Integer> list, int amount) {
        Date time = new Date();

        long[] duration = new long[AMOUNT_OF_CALCULATIONS];

        for (int i = 0; i < AMOUNT_OF_CALCULATIONS; i++) {
            //fill
            list.clear();
            for (int j = 0; j < amount; j++) {
                list.add((int)(Math.random() * 35465));
            }
            time = new Date();
            for (int j = 0; j < AMOUNT_OF_CALCULATIONS; j++) {
                list.listIterator((int)(Math.random() * list.size())).add((int)(Math.random() * list.size()));
            }
            duration[i] = new Date().getTime() - time.getTime();
        }
        return average(duration);
    }

    private static float gettingList(List<Integer> list, int amount) {
        Date time = new Date();
        long[] duration = new long[AMOUNT_OF_CALCULATIONS];

        //filling
        for (int i = 0; i < amount; i++) {
            list.add(i);
        }

        for (int i = 0; i < AMOUNT_OF_CALCULATIONS; i++) {
            time = new Date();
            for (int j = 0; j < amount; j++) {
                list.get((int) (Math.random() * list.size()));
            }
            duration[i] = new Date().getTime() - time.getTime();

        }
        return average(duration);
    }

    private static float contains(List<Integer> list, int amount) {
        Date time = new Date();
        long[] duration = new long[AMOUNT_OF_CALCULATIONS];

        //filling
        for (int i = 0; i < amount; i++) {
            list.add(i);
        }

        for (int i = 0; i < AMOUNT_OF_CALCULATIONS; i++) {
            time = new Date();
            for (int j = 0; j < AMOUNT_OF_CALCULATIONS; j++) {
                list.contains((int) (Math.random() * list.size()));
            }
            duration[i] = new Date().getTime() - time.getTime();

        }
        return average(duration);
    }

    private static float populating(Collection<Integer> collection, int amount) {
        Date time = new Date();

        long[] duration = new long[AMOUNT_OF_CALCULATIONS];
        for (int i = 0; i < AMOUNT_OF_CALCULATIONS; i++) {
            collection.clear();
            time = new Date();
            for (int j = 0; j < amount; j++) {
                collection.add(i);
            }
            duration[i] = new Date().getTime() - time.getTime();
        }
        return average(duration);
    }

    private static float removingList(List<Integer> list, int amount) {
        Date time = new Date();
        long[] duration = new long[AMOUNT_OF_CALCULATIONS];

        //filling
        for (int i = 0; i < amount; i++) {
            list.add(i);
        }

        for (int i = 0; i < AMOUNT_OF_CALCULATIONS; i++) {
            time = new Date();
            for (int j = 0; j < list.size(); j++) {
                list.remove((int) (Math.random() * list.size()));
            }
            duration[i] = new Date().getTime() - time.getTime();

        }
        return average(duration);
    }

    private static float average(long[] duration) {
        int average = 0;
        for (int i = 0; i < duration.length; i++) {
            average += duration[i];
        }
        //System.out.println(average);
        average /= duration.length;
        return average;
    }
}