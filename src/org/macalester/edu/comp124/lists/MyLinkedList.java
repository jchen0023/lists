package org.macalester.edu.comp124.lists;

import com.sun.tools.classfile.Annotation;

/**
 * An unfinished implementation of a basic doubly-linked list.
 *
 * Note that the head and the tail contain "sentinel" nodes without values.
 * This makes the edge cases of the algorithm easier because the list always has a discrete head and tail.
 *
 * @author shilad
 * @param <E>
 */
public class MyLinkedList<E> {
	public MyLinkedNode<E> head;
	public MyLinkedNode<E> tail;
	public int numElements = 0;

    /**
     * Creates a new empty linked list.
     */
	public MyLinkedList() {
		head = new MyLinkedNode<E>(null);
		tail = new MyLinkedNode<E>(null);
		clear();
	}

    /**
     * Returns the element at position index.
     * @param index
     * @return
     */
	public E get(int index) {
		MyLinkedNode<E> temp = new MyLinkedNode<E>(null);
        temp = head.getNext();
        for (int i = 0; i < index; i++){
            temp = temp.getNext();
        }
        return temp.getValue();

	}

    /**
     * Adds a new element to the end of the list:
     *
     * @param elem
     */
	public void add(E elem) {
        MyLinkedNode<E> newnode = new MyLinkedNode<E>(elem);
        MyLinkedNode<E> lastnode = tail.getPrev();
        tail.setPrev(newnode);
        newnode.setNext(tail);
        newnode.setPrev(lastnode);
        lastnode.setNext(newnode);
        numElements = numElements + 1;
	}

    /**
     * Inserts a new element at the specified index.
     *
     * @param elem
     */
	public void add(int i, E elem) {
        MyLinkedNode<E> temp = new MyLinkedNode<E>(elem);
        MyLinkedNode<E> dec = new MyLinkedNode<E>(null);
        dec = head.getNext();
        for (int x = 0; x < i; x++){
            dec = dec.getNext();
        }
        dec.getPrev().setNext(temp);
        temp.setNext(dec);
        numElements = numElements + 1;
	}

    /**
     * Returns the current size of the list.
     * @return
     */
	public int size() {
		return numElements;
	}

    /**
     * Clears the contents of the list.
     */
	public void clear() {
		// set head's next to the tail
		head.setNext(tail);
		head.setPrev(null);
		
		// set tails prev to the head
		tail.setPrev(head);
		tail.setNext(null);
		numElements = 0;
	}


    /**
     * These methods are only used by the unit tests.
     * They are intentionally not public.
     * @return
     */
    MyLinkedNode getHead() { return head; }
    MyLinkedNode getTail() { return tail; }
}

