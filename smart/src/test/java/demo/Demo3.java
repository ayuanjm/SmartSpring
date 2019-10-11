package demo;


import java.util.Stack;

public class Demo3 {
    public static void main(String[] args) {
        Stack<Integer> strings = new Stack<>();
        strings.push(1);
        strings.push(2);
        System.out.println(strings.peek());
        strings.push(3);
        strings.pop();
        System.out.println(strings.size());
        int a[] = {1, 2, 3, 4, 5};
        int b[] = new int[5];
        //意思是;将a数组里从索引为2的元素开始, 复制到数组b里的索引为5的位置, 复制的元素个数为2个.
        System.arraycopy(a, 2, b, 1, 2);//03400
        System.out.println();
        for (int aa1 : b) {
            System.out.print(aa1);
        }

    }
}
