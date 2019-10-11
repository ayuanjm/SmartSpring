package com.algorithm;

/**
 * 顺序栈，数组实现
 * @param <T>
 */
public class SqlStack<T> {
    private T data[];//用数组表示栈元素
    private int maxSize;//栈空间大小
    private int top;//栈顶指针

    public SqlStack(int maxSize) {
        this.maxSize = maxSize;
        //类型转换异常[Ljava.lang.Object; cannot be cast to [Ljava.lang.Integer
        //Integer array[] = (Integer[]) new Object[maxSize];

        //发生了泛型擦除（T编译为object类型），可以转换
        this.data = (T[]) new Object[maxSize];
        System.out.println(data.getClass());//class [Ljava.lang.Object;
        System.out.println(new Object[maxSize].getClass());//class [Ljava.lang.Object;
        this.top = -1;
    }

    //判断栈是否为空
    public boolean isNull() {
        return top <= -1 ? true : false;
    }

    //判断是否栈满
    public boolean isFull() {
        return top == maxSize - 1 ? true : false;
    }

    //压栈
    public boolean push(T value) {
        if (isFull()) {
            System.out.println("栈满");
            return false;
        }
        ++top;
        data[top] = value;
        return true;
    }

    //弹栈
    public T pop() {
        if (isNull()) {
            System.out.println("栈空");
            return null;
        }
        T value = data[top];
        --top;
        return value;
    }

    public static void main(String[] args) {
        SqlStack<Integer> sqlStack = new SqlStack<Integer>(3);
        sqlStack.push(1);
        sqlStack.push(2);
        sqlStack.push(3);
        Object o = sqlStack.pop();
        System.out.println(o);
        sqlStack.push(4);

    }

}
