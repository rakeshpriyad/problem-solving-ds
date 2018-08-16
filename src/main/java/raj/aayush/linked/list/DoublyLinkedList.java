package raj.aayush.linked.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 */
public class DoublyLinkedList<E> extends LinkedList<E> {

    public static class DoublyLinkedNode<E> extends Node<E> {
        protected DoublyLinkedNode<E> prev;
    }


    @Override
    protected Node<E> getNewNode() {
        return new DoublyLinkedNode<>();
    }

    @Override
    public Node<E> appendFirst(E value) {
        Node<E> node = super.appendFirst(value);
        if (head.next != null)
            ((DoublyLinkedNode<E>) head.next).prev = (DoublyLinkedNode<E>) head;
        return node;
    }

    @Override
    public Node<E> insert(int index, E value) {
        DoublyLinkedNode<E> inserted = (DoublyLinkedNode<E>) super.insert(index, value);
        if(index!=0 && index!=length) {
            if (inserted.next != null) {
                inserted.prev = ((DoublyLinkedNode<E>) inserted.next).prev;
                ((DoublyLinkedNode<E>) inserted.next).prev = inserted;
            }
        }
        return inserted;
    }

    @Override
    public Node<E> appendLast(E value) {
        DoublyLinkedNode<E> origLast = (DoublyLinkedNode<E>) this.tail;
        Node<E> node = super.appendLast(value);
        ((DoublyLinkedNode<E>) this.tail).prev = origLast;
        return node;
    }

    @Override
    public Node<E> removeAtIndex(int index) {
        if(index<0||index>=length){
            throw new NoSuchElementException("index = "+index);
        }
        if(index==length-1){
            return removeLast();
        }
        DoublyLinkedNode<E> nodeRemoved = (DoublyLinkedNode<E>) super.removeAtIndex(index);
        if ((DoublyLinkedNode<E>) nodeRemoved.next != null)
            ((DoublyLinkedNode<E>) nodeRemoved.next).prev = nodeRemoved.prev;

        return nodeRemoved;
    }


    @Override
    public Node<E> removeFirst() {
        super.removeFirst();
        if (head != null) {
            ((DoublyLinkedNode<E>) head).prev = null;
        }
        return head;
    }

    public void removeNode(DoublyLinkedNode<E> node){
        if(node==tail){
            removeLast();
        }else if(node==head){
            removeFirst();
        }else{
            node.prev.next = node.next;
            length--;
        }
    }

    @Override
    public Node<E> removeLast() {
        Node<E> origLast = tail;
        if(tail==null){
            throw new IllegalStateException("Removing element from an empty list");
        }

        tail = ((DoublyLinkedNode<E>)tail).prev;
        if(tail!=null){
            tail.next = null;
        }else{
            head = null;
        }
        length--;
        return origLast;
    }

    protected class ReverseListIterator extends ListIterator{
        public ReverseListIterator(){
            nextNode = tail;
        }

        @Override
        public E next() {
            if(nextNode == null)
                throw new IllegalStateException();
            DoublyLinkedNode<E> nodeToReturn = (DoublyLinkedNode<E>) nextNode;
            nextNode = nodeToReturn.prev;
            return nodeToReturn.value;
        }
    }

    public Iterator<E> reverseIterator(){
        return new ReverseListIterator();
    }

    public static void main(String [] args){
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        doublyLinkedList.appendFirst(4);
        doublyLinkedList.appendFirst(1);
        doublyLinkedList.appendFirst(2);
        doublyLinkedList.appendFirst(3);
        doublyLinkedList.appendLast(8);
        doublyLinkedList.appendLast(7);
        doublyLinkedList.appendLast(18);
        doublyLinkedList.appendFirst(3);
        doublyLinkedList.appendLast(8);
        doublyLinkedList.appendLast(7);
        doublyLinkedList.appendLast(18);
        doublyLinkedList.insert(2, 51);
        doublyLinkedList.insert(0, 510);

        while (doublyLinkedList.getLength()>0){
            doublyLinkedList.removeLast();
        }


        Iterator<Integer> reverseIterator = doublyLinkedList.reverseIterator();
        while(reverseIterator.hasNext()){
            System.out.println(reverseIterator.next());
        }


    }
}

