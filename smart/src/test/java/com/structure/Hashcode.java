package com.structure;

import java.util.HashMap;

public class Hashcode {
    private int a;

    public Hashcode(int a) {
        this.a = a;
    }

    @Override
    public int hashCode() {
        return a % 10;
    }

    public static void main(String[] args) {
//        System.out.println(1111);
        java.util.Map<Hashcode, Object> map = new HashMap<>(5);
        Hashcode hashcode = new Hashcode(10);
        System.out.println(map.put(hashcode, null));
//        map.put(new Hashcode(20), 1);
//        map.put(new Hashcode(1), 1);
//        map.put(new Hashcode(2), 1);
//        map.put(new Hashcode(3), 1);
//        map.put(new Hashcode(4), 1);
//        map.put(new Hashcode(50), 1);
        System.out.println(map.containsKey(hashcode));
        map.get(1);
    }

    static void hash() {
        Hashcode[] a = {new Hashcode(10), new Hashcode(20)};
        Hashcode[] b = new Hashcode[6];

    }
}
