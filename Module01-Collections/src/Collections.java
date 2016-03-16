import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Collections {
    static final int AMOUNT_OF_CALCULATIONS = 100;

    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter("result.csv");

        fileWriter.write(";add();get();remove();contains();populate();iterator.add();iterator.remove()");
        fileWriter.write(System.lineSeparator());

        for (int i = 1; i <= 3; i++) {
            int amount = (int) Math.pow(10, 3 + i);
            //ArrayList<>
            fileWriter.write("ArrayList;");
            fileWriter.write(listAdd(new ArrayList<Integer>(), amount) + ";");
            System.out.println("ArrayList " + amount + " elements add() done!");
            fileWriter.write(listGet(new ArrayList<Integer>(), amount) + ";");
            System.out.println("ArrayList " + amount + " elements get() done!");
            fileWriter.write(listRemove(new ArrayList<Integer>(), amount) + ";");
            System.out.println("ArrayList " + amount + " elements remove() done!");
            fileWriter.write(contains(new ArrayList<Integer>(), amount) + ";");
            System.out.println("ArrayList " + amount + " elements contains() done!");
            fileWriter.write(populate(new ArrayList<Integer>(), amount) + ";");
            System.out.println("ArrayList " + amount + " elements populate() done!");
            fileWriter.write(listIteratorAdd(new ArrayList<Integer>(), amount) + ";");
            System.out.println("ArrayList " + amount + " elements iterator.add() done!");
            fileWriter.write(listIteratorRemove(new ArrayList<Integer>(), amount) + ";");
            System.out.println("ArrayList " + amount + " elements iterator.remove() done!");
            fileWriter.write(System.lineSeparator());

            //LinkedList<>
            fileWriter.write("LinkedList;");
            fileWriter.write(listAdd(new LinkedList<Integer>(), amount) + ";");
            System.out.println("LinkedList " + amount + " elements add() done!");
            fileWriter.write(listGet(new LinkedList<Integer>(), amount) + ";");
            System.out.println("LinkedList " + amount + " elements get() done!");
            fileWriter.write(listRemove(new LinkedList<Integer>(), amount) + ";");
            System.out.println("LinkedList " + amount + " elements remove() done!");
            fileWriter.write(contains(new LinkedList<Integer>(), amount) + ";");
            System.out.println("LinkedList " + amount + " elements contains() done!");
            fileWriter.write(populate(new LinkedList<Integer>(), amount) + ";");
            System.out.println("LinkedList " + amount + " elements populate() done!");
            fileWriter.write(listIteratorAdd(new LinkedList<Integer>(), amount) + ";");
            System.out.println("LinkedList " + amount + " elements iterator.add() done!");
            fileWriter.write(listIteratorRemove(new LinkedList<Integer>(), amount) + ";");
            System.out.println("LinkedList " + amount + " elements iterator.remove() done!");
            fileWriter.write(System.lineSeparator());

            //HashSet<>
            fileWriter.write("HashSet;");
            fileWriter.write(setAdd(new HashSet<Integer>(), amount) + ";");
            System.out.println("HashSet " + amount + " elements add() done!");
            fileWriter.write(setRemove(new HashSet<Integer>(), amount) + ";");
            System.out.println("HashSet " + amount + " elements remove() done!");
            fileWriter.write(contains(new HashSet<Integer>(), amount) + ";");
            System.out.println("HashSet " + amount + " elements contains() done!");
            fileWriter.write(populate(new HashSet<Integer>(), amount) + ";");
            System.out.println("HashSet " + amount + " elements populate() done!");
            fileWriter.write(System.lineSeparator());

            //TreeSet<>
            fileWriter.write("TreeSet;");
            fileWriter.write(setAdd(new TreeSet<Integer>(), amount) + ";");
            System.out.println("TreeSet " + amount + " elements add() done!");
            fileWriter.write(setRemove(new TreeSet<Integer>(), amount) + ";");
            System.out.println("TreeSet " + amount + " elements remove() done!");
            fileWriter.write(contains(new TreeSet<Integer>(), amount) + ";");
            System.out.println("TreeSet " + amount + " elements contains() done!");
            fileWriter.write(populate(new TreeSet<Integer>(), amount) + ";");
            System.out.println("TreeSet " + amount + " elements populate() done!");

            fileWriter.write(System.lineSeparator());
            fileWriter.write(System.lineSeparator());
        }
        fileWriter.close();

    }

    private static float listAdd(List<Integer> list, int amount) {
        Date time = new Date();

        long[] duration = new long[AMOUNT_OF_CALCULATIONS];
        //fill
        for (int i = 0; i < amount; i++) {
            list.add((int) (Math.random() * 35465));
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

    private static float listGet(List<Integer> list, int amount) {
        Date time = new Date();
        long[] duration = new long[AMOUNT_OF_CALCULATIONS / 2];

        //filling
        for (int i = 0; i < amount; i++) {
            list.add(i);
        }

        for (int i = 0; i < AMOUNT_OF_CALCULATIONS / 2; i++) {
            time = new Date();
            for (int j = 0; j < amount; j++) {
                list.get((int) (Math.random() * list.size()));
            }
            duration[i] = new Date().getTime() - time.getTime();

        }
        return average(duration);
    }

    private static float listRemove(List<Integer> list, int amount) {
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

    private static float contains(Collection<Integer> collection, int amount) {
        Date time = new Date();
        long[] duration = new long[AMOUNT_OF_CALCULATIONS];

        //filling
        for (int i = 0; i < amount; i++) {
            collection.add(i);
        }

        for (int i = 0; i < AMOUNT_OF_CALCULATIONS; i++) {
            time = new Date();
            for (int j = 0; j < AMOUNT_OF_CALCULATIONS; j++) {
                collection.contains((int) (Math.random() * collection.size()));
            }
            duration[i] = new Date().getTime() - time.getTime();

        }
        return average(duration);
    }

    private static float populate(Collection<Integer> collection, int amount) {
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

    private static float listIteratorAdd(List<Integer> list, int amount) {
        Date time = new Date();

        long[] duration = new long[AMOUNT_OF_CALCULATIONS];

        for (int i = 0; i < AMOUNT_OF_CALCULATIONS; i++) {
            //fill
            list.clear();
            for (int j = 0; j < amount; j++) {
                list.add((int) (Math.random() * 35465));
            }
            Iterator<Integer> iterator = list.iterator();
            Integer num;

            time = new Date();
            for (int j = 0; j < amount; j++) {
                num = iterator.next();
            }
            duration[i] = new Date().getTime() - time.getTime();
        }
        return average(duration);
    }

    private static float listIteratorRemove(List<Integer> list, int amount) {
        Date time = new Date();
        long[] duration = new long[AMOUNT_OF_CALCULATIONS];

        for (int i = 0; i < AMOUNT_OF_CALCULATIONS; i++) {
            //fill
            list.clear();
            for (int j = 0; j < amount; j++) {
                list.add((int) (Math.random() * 35465));
            }
            Iterator<Integer> iterator = list.iterator();

            time = new Date();
            for (int j = 0; j < AMOUNT_OF_CALCULATIONS; j++) {
                iterator.next();
                iterator.remove();
            }
            duration[i] = new Date().getTime() - time.getTime();
        }
        return average(duration);
    }

    private static float setAdd(Set<Integer> set, int amount) {
        Date time = new Date();
        long[] duration = new long[AMOUNT_OF_CALCULATIONS];

        for (int i = 0; i < AMOUNT_OF_CALCULATIONS; i++) {
            set.clear();
            time = new Date();
            for (int j = 0; j < amount; j++) {
                set.add((int) (Math.random() * amount));
            }
            duration[i] = new Date().getTime() - time.getTime();
        }

        return average(duration);
    }

    private static float setRemove(Set<Integer> set, int amount) {
        Date time = new Date();
        long[] duration = new long[AMOUNT_OF_CALCULATIONS];

        for (int i = 0; i < AMOUNT_OF_CALCULATIONS; i++) {
            //fill
            for (int j = 0; j < amount; j++) {
                set.add((int) (Math.random() * amount));
            }
            //Remove
            time = new Date();
            for (int j = 0; j < amount; j++) {
                set.remove((int) (Math.random() * amount));
            }
            duration[i] = new Date().getTime() - time.getTime();
            set.clear();
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