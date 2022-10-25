package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private static final int MIN = 1000;
    private static final int MAX = 2000;
    private static final int ELEMENTS = 100_000;
    private static final int READS = 1_000;
    private static final long AFRICA = 1_110_635_000L;
    private static final long AMERICA = 972_005_000L;
    private static final long ANTARTIDE = 0L;
    private static final long ASIA = 4_298_723_000L;
    private static final long EUROPA = 742_452_000L;
    private static final long OCEANIA = 38_304_000L;
    
    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        final List<Integer> al = new ArrayList<>();
        for (int i = MIN; i < MAX; i++) {
            al.add(i);
        }

        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        final List<Integer> ll = new LinkedList<>(al);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        final int tmp = al.get(MIN-MIN);
        al.set(MIN - MIN, al.get(al.size()-1));
        al.set(al.size()-1, tmp);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (int a : al) {
            System.out.println(a);            
        }
        System.out.println("\n");            
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long time = System.nanoTime();
        for (int i = 0; i < ELEMENTS; i++) {
            al.add(0, i);
        }
        time = System.nanoTime() - time;
        System.out.println("Inserting " + ELEMENTS + " elements as first in an ArrayList took " + time + "ns");
        time = System.nanoTime();
        for (int i = 0; i < ELEMENTS; i++) {
            ll.add(0, i);
        }
        time = System.nanoTime() - time;
        System.out.println("Inserting " + ELEMENTS + " elements as first in a LinkedList took " + time + "ns");
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example PerfTest.java.
         */
        time = System.nanoTime();
        for (int i = 0; i < READS; i++) {
            al.get(al.size() / 2);
        }
        time = System.nanoTime() - time;
        System.out.println("Reading " + READS + " elements in the middle of an ArrayList took " + + time + "ns");
        time = System.nanoTime();
        for (int i = 0; i < READS; i++) {
            ll.get(ll.size() / 2);
        }
        time = System.nanoTime() - time;
        System.out.println("Reading " + READS + " elements in the middle of a LinkedList took " + + time + "ns");

        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        final Map<String,Long> world = new HashMap<>();
        world.put("Africa", AFRICA);
        world.put("Americas", AMERICA);
        world.put("Antarctica", ANTARTIDE);
        world.put("Asia", ASIA);
        world.put("Europe", EUROPA);
        world.put("Oceania", OCEANIA);

        /*
         * 8) Compute the population of the world
         */
        Long tot = 0L;
        for (Map.Entry<String, Long> a : world.entrySet()) {
            tot = tot + a.getValue();
        }
        System.out.println("Total world population: " + tot);
    }
}
