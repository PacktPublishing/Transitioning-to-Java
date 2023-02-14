package com.kenfogel.arraysandcollections;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * A simple example of the LinkedHashMap
 *
 * @author Ken Fogel
 */
public class LinkedHashMapExample {

    /**
     * Some simple LinkedHashMap actions
     */
    public void perform() {

        // Declare a LinkedHashMap using generic notation
        Map<Integer, Integer> linkedHashMap = new LinkedHashMap<>();

        /*
         * Put new pairs in the map. The first value, the key, determines the
         * position in the map. When the key is not an integer then the hashCode
         * value for the object is used. Unlike a HashMap, the order in which
         * key/values are entered into the map is preserved.
         */
        linkedHashMap.put(6, 6);
        linkedHashMap.put(5, 4);
        linkedHashMap.put(4, 8);
        linkedHashMap.put(3, 10);
        linkedHashMap.put(2, 6);

        /**
         * The key value must be unique. This allows us to retrieve all the keys
         * using the entrySet method of the collection into a Set object and
         * then iterate through the set and use the return value as the key into
         * the map. The Set is in the order that values were put into the map.
         */
        Set s = linkedHashMap.entrySet();

        // create an iterator
        Iterator it = s.iterator();

        // iterate and print the mappings
        while (it.hasNext()) {
            System.out.printf("%s%n", it.next());
        }

        // Display value based on the key
        System.out.printf("%s%n", linkedHashMap.get(4));
        /*
         * The result for this get will be null because there is no key with a
         * value of 1
         */
        System.out.printf("%s%n", linkedHashMap.get(1));

    }

    /**
     * Where it all begins
     *
     * @param args
     */
    public static void main(String[] args) {
        new LinkedHashMapExample().perform();
    }
}
