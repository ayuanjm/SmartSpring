package com.structure.hashmap;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Hashcode implements Comparator {
    private int a;

    public Hashcode(int a) {
        this.a = a;
    }

    @Override
    public int hashCode() {
        return a % 10;
    }

    public static void main(String[] args) {
        TreeMap treeMap = new TreeMap();
    }

    static void hash() {
    }

    @Override
    public int compare(Object o1, Object o2) {
        return 1;
    }

}
