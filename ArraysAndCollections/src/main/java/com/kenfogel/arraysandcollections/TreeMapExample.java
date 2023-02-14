package com.kenfogel.arraysandcollections;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * A simple example of the LinkedHashMap
 *
 * @author Ken Fogel
 */
public class TreeMapExample {

    /**
     * Some simple LinkedHashMap actions
     */
    public void perform() {
        // Declare a TreeMap using generic notation
        Map<Integer, Integer> treeMap = new TreeMap<>();

        /**
         * Put new pairs in the map. The first value, the key, determines the
         * position in the map. The order is based on the key value. The key
         * must either be an integer or support the comparable interface.
         */
        treeMap.put(6, 6);
        treeMap.put(4, 4);
        treeMap.put(3, 8);
        treeMap.put(2, 10);
        treeMap.put(5, 6);

        // Display value based on the key
        System.out.printf("%s%n", treeMap.get(4));
        /*
         * The result for this get will be null because there is no key with a
         * value of 1
         */
        System.out.printf("%s%n", treeMap.get(1));

        /**
         * The key value must be unique. This allows us to retrieve all the keys
         * using the entrySet method of the collection into a Set object and
         * then iterate through the set and use the return value as the key into
         * the map. 
         */
        Set s = treeMap.entrySet();

        // create an iterator
        Iterator it = s.iterator();

        // iterate and print the mappings
        while (it.hasNext()) {
            System.out.printf("%s%n", it.next());
        }
    }

    /**
     * Where it all begins
     *
     * @param args
     */
    public static void main(String[] args) {
        new TreeMapExample().perform();
    }
}
