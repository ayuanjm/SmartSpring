package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class VectorAndArrayList {
    public static void main(String[] args) {
        List list = new ArrayList();
        Vector vector = new Vector();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            list.add(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("arrayList插入时间:" + (end - start));
        long starts = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            vector.add(i);
        }
        long ends = System.currentTimeMillis();
        System.out.println("vector插入时间:" + (ends - starts));
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            Integer integer = iterator.next();
            if(integer==2)
                list.remove(integer);
        }    }
}
