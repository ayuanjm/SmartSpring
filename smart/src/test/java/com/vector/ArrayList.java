package com.vector;


import lombok.Data;

import java.util.List;

/**
 * @author yuan
 * 数据结构向量实现
 */
@Data
public abstract class ArrayList<E> implements List<E> {
    public static void main(String[] args) {
        List list = new java.util.ArrayList();
        list.add(null);
        //list.get(0).equals(null);
        if (null == list.get(0)) {
            System.out.println(1);
        }
    }

    /**
     * 内部封装的数组
     */
    private Object[] elements;

    /**
     * 线性表默认的容量大小
     */
    private static final int DEFAULT_CAPACITY = 16;

    /**
     * 扩容翻倍的基数
     */
    private static final double EXPAND_BASE = 1.5;

    /**
     * 内部数组的实际大小
     */
    private int capacity;

    /**
     * 当前线性表的实际大小
     */
    private int size;

    /**
     * 默认无参构造方法
     */
    public ArrayList() {
        capacity = DEFAULT_CAPACITY;
        elements = new Object[capacity];
    }

    /**
     * 内部数组初始化大小的构造方法
     *
     * @param initialCapacity 内部数组初始大小
     */
    public ArrayList(int initialCapacity) {
        if (initialCapacity < DEFAULT_CAPACITY) {
            capacity = DEFAULT_CAPACITY;
        }
        elements = new Object[capacity];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return (this.size == 0);
    }

    /**
     * list.add(null);
     * list.get(0).equals(null); list可以添加null元素，所以以list元素.equals也会空指针
     *
     * @param object
     * @return
     */
    @Override
    public int indexOf(Object object) {
        //判断当前参数是否为null
        if (object != null) {
            //参数不为空从前到后依次比较
            for (int i = 0; i < this.size; i++) {
                //判断当前元素是否等于object
                if (object.equals(elements[size])) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < this.size; i++) {
                //判断当前元素是否等于null
                if (elements[size] == null) {
                    return i;
                }
            }
        }
        //遍历列表未找到相等的元素，返回特殊值"-1"代表未找到
        return -1;
    }

    @Override
    public boolean contains(Object o) {
        //返回-1代表不存在，反之存在
        return indexOf(o) != -1;
    }

}
