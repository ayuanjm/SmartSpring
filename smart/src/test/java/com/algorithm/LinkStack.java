package com.algorithm;

/**
 * 链式栈，单链表实现
 * 先进后出
 */
public class LinkStack<T> {
    //栈顶节点
    private LinkNode<T> top;

    public LinkStack() {
        this.top = new LinkNode<T>();
    }

    //是否栈空
    public boolean isNull() {
        return top == null || top.getData() == null ? true : false;
    }

    //压栈
    public void push(LinkNode<T> node) {
        if (isNull()) {
            //栈空，第一次插入
            top = node;
            top.setNext(null);
        } else {
            node.setNext(top);
            top = node;
        }
    }

    //弹栈
    public LinkNode<T> pop() {
        if (isNull()) {
            return null;
        } else {
            LinkNode<T> deleteNode = top;
            top = top.getNext();
            return deleteNode;
        }
    }

    //删除指定元素，成功返回ture
    public boolean delete(LinkNode<T> node) {
        if (isNull()) {
            return false;
        }
        LinkNode<T> current = top;
        LinkNode<T> previous = top;
        while (!current.equals(node)) {
            if (current.getNext() == null) {
                return false;
            } else {
                //如果删除元素存在，最终previous为删除元素的前一个节点
                previous = current;
                current = current.getNext();
            }
        }

        //如果删除的节点是第一个节点
        if (current == top) {
            top = current.getNext();
        } else {
            //删除的节点不是第一个节点
            previous.setNext(current.getNext());
        }
        return true;
    }

    //显示节点信息
    public void display() {
        LinkNode<T> head = top;
        while (head != null) {
            if (head.getNext() == null) {
                System.out.println(head.getData());
                return;
            }
            System.out.print(head.getData() + "-->");
            head = head.getNext();
        }
    }

    public static void main(String[] args) {
        LinkStack<Integer> ls = new LinkStack<>();

        //1状态
        System.out.println("栈是否为空：" + ls.isNull());

        //2操作
        //依次压栈
        Object o = new LinkNode<Integer>(1);
        ls.push((LinkNode<Integer>) o);
        ls.push(new LinkNode<Integer>(2));
        ls.push(new LinkNode<Integer>(3));
//        ls.delete((LinkNode<Integer>) o);
        ls.display();
        //依次弹栈
        System.out.println("弹栈顺序：");
        System.out.println(ls.pop().getData());
        System.out.println(ls.pop().getData());
    }
}

//链式节点
class LinkNode<T> {
    //数据域
    private T data;
    //指针域
    private LinkNode<T> next;

    public LinkNode() {
    }

    public LinkNode(T data) {
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LinkNode<T> getNext() {
        return next;
    }

    public void setNext(LinkNode<T> next) {
        this.next = next;
    }
}
