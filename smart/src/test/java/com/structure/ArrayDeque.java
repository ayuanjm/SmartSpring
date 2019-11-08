package com.structure;

import java.util.Iterator;

/**
 * 基于数组的 双端队列
 * 本文实现的是逆时针数组队列，从左到右，数组的方向和head，tail的出队入队下标变化有关
 * 头指针始终指向队列头元素，而尾指针始终指向队列尾元素的下一个位置
 *
 * @author yuan
 */
public class ArrayDeque<E> implements Deque<E> {
    /**
     * 内部封装的数组
     */
    private Object[] elements;

    /**
     * 队列默认的容量大小
     */
    private static final int DEFAULT_CAPACITY = 16;

    /**
     * 扩容翻倍的基数
     */
    private static final int EXPAND_BASE = 2;

    /**
     * 队列头部下标
     */
    private int head;

    /**
     * 队列尾部下标
     */
    private int tail;

    /**
     * 默认构造方法
     */
    public ArrayDeque() {
        //:::设置数组大小为默认
        this.elements = new Object[DEFAULT_CAPACITY];

        //:::初始化队列 头部,尾部下标
        this.head = 0;
        this.tail = 0;
    }

    /**
     * 由于是循环队列移动指针可能会导致下标越界
     * 获得移动后的指针位置
     *
     * @param logicIndex
     * @return
     */
    private int getMod(int logicIndex) {
        if (logicIndex < 0) {
            //(logicIndex + elements.length) % elements.length;
            return logicIndex + elements.length;
        } else if (logicIndex >= elements.length) {
            //(logicIndex - elements.length) % elements.length;
            return logicIndex - elements.length;
        }
        return logicIndex;
    }

    /**
     * 内部数组扩容
     * 要复制的数组(源数组),复制源数组的起始位置,目标数组,目标数组的下标位置,要复制的长度
     * System.arraycopy(tempArray, 0, elements, 0, tempArray.length);
     */
    private void expand() {
        //内部数组 扩容两倍
        int elementsLength = elements.length;
        Object[] newElements = new Object[elementsLength * EXPAND_BASE];
        //将队列头部到数组末尾的值，拷贝到新数组从0开始的位置
        System.arraycopy(elements, head, newElements, 0, elements.length - head);

    }

    public static void main(String[] args) {
        Object[] old = {1, 2, 3, 4, 5};
        //头部位置为2，old[2]==3;
        int head = 2;
        int tail = 2;
        Object[] newArray = new Object[10];
        System.arraycopy(old, head, newArray, 0, old.length - head);
        System.arraycopy(old,0,newArray,old.length-head,tail);
        for (Object o : newArray) {
            System.out.println(o);
        }
    }

    /**
     * 使用addTail，removeTail时 相当于栈
     * 使用addTail，removeHead时 相当于队列
     *      <----------
     *  |                 |
     *  | 0   1 2 3 4   5 |
     * head ----------> tail
     */
    @Override
    public void addHead(E e) {
        //由于是逆时针数组队列，头部插入元素，head下标左移一位
        this.head = getMod(this.head - 1);
        this.elements[this.head] = e;
        //队列为空时 head == tail,当插入元素后如果head == tail 说明内部数组容量已满，需要扩容。
        if (this.head == this.tail) {

        }
    }

    @Override
    public void addTail(E e) {

    }

    @Override
    public E removeHead() {
        return null;
    }

    @Override
    public E removeTail() {
        return null;
    }

    @Override
    public E peekHead() {
        return null;
    }

    @Override
    public E peekTail() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
