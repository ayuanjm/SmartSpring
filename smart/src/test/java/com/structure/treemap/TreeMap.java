package com.structure.treemap;

import java.util.Iterator;

public class TreeMap<K, V> implements Map<K, V> {
    /**
     * 根节点
     */
    private EntryNode<K, V> root;

    /**
     * 比较器(初始化之后，不能改)
     */
    private final Comparator<? super K> comparator;

    /**
     * 当前二叉树的大小
     */
    private int size;

    /**
     * 默认构造函数
     */
    public TreeMap() {
        this.comparator = null;
    }

    /**
     * 指定了比较器的构造函数
     */
    public TreeMap(Comparator<? super K> comparator) {
        this.comparator = comparator;
    }

    @Override
    public V put(K key, V value) {
        return null;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public boolean containsKey(K key) {
        return false;
    }

    @Override
    public boolean containsValue(V value) {
        return false;
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
    public Iterator<Map.EntryNode<K, V>> iterator() {
        return null;
    }

    /**
     * 二叉搜索树 内部节点
     */
    static class EntryNode<K, V> implements Map.EntryNode<K, V> {
        /**
         * key值
         */
        K key;

        /**
         * value值
         */
        V value;

        /**
         * 左孩子节点
         */
        EntryNode<K, V> left;

        /**
         * 右孩子节点
         */
        EntryNode<K, V> right;

        /**
         * 双亲节点
         */
        EntryNode<K, V> parent;

        EntryNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        EntryNode(K key, V value, EntryNode<K, V> parent) {
            this.key = key;
            this.value = value;
            this.parent = parent;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }
    }
}
