package raj.aayush.linked.list;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

import raj.aayush.heap.LinkedHeap;
import raj.aayush.queue.PriorityQueue;

/**
 */
public class LinkedList<E> implements Iterable<E> {
	protected int length = 0;
	protected Node<E>[] lastModifiedNode;
	protected Node<E> head;
	protected Node<E> tail;

	public int getLength() {
		return length;
	}

	public void appendAllLast(LinkedList<E> anotherList) {
		if (this.head == null) {
			this.head = anotherList.head;
			this.tail = anotherList.tail;
		} else {
			this.tail.next = anotherList.head;
			this.tail = anotherList.tail;
		}
		this.length += anotherList.length;

	}

	public E head() {
		return this.head.value;
	}
	
	/*public LinkedList<Node<E>> tail() {
		return new LinkedList<Node<E>>().appendLast(this.tail);
	}*/

	public boolean isEmpty() {
		return this.head == null ? true : false;
	}

	public static void main(String[] args) {
		// LinkedList<Integer> linkedList = new LinkedList<>();
		// linkedList.appendFirst(4);
		// linkedList.appendFirst(1);
		// linkedList.appendFirst(2);
		// linkedList.appendFirst(3);
		// linkedList.appendLast(8);
		// linkedList.appendLast(7);
		// linkedList.appendLast(18);
		// linkedList.appendFirst(50);
		// linkedList.insert(5, 500);
		// linkedList.insert(9, 501);
		// linkedList.removeAtIndex(8);
		// linkedList.insert(8, 502);
		// linkedList.removeAtIndex(1);

		LinkedList<Integer> anotherList = new LinkedList<>();
		anotherList.appendFirst(4);
		anotherList.appendFirst(1);
		anotherList.appendFirst(2);
		anotherList.appendFirst(3);
		anotherList.appendLast(8);
		anotherList.appendLast(7);
		anotherList.appendLast(1);
		anotherList.appendLast(2);
		anotherList.appendLast(3);
		anotherList.appendLast(18);
		// linkedList.appendAllLast(anotherList);
		//
		// // linkedList.visualize(visualizer);
		//
		//
		// while(anotherList.getLength()>0){
		// anotherList.removeLast();
		// }

		// linkedList.<Integer>zip(anotherList).visualize(visualizer);
		// Iterator<Integer> iter = anotherList.iterator();
		// while (iter.hasNext()){
		// int val = iter.next();
		// System.out.println();
		// if(val<=4)
		// iter.remove();
		// anotherList.visualize(visualizer);
		// }
	}

	@Override
	public Iterator<E> iterator() {
		return new ListIterator();
	}

	@SuppressWarnings("unchecked")
	protected Node<E> getNewNode() {
		Node<E> node = new Node<>();
		lastModifiedNode = new Node[] { node };
		return node;
	}

	public Node<E> appendFirst(E value) {
		Node<E> node = getNewNode();
		node.value = value;
		node.next = head;
		head = node;
		if (length == 0)
			tail = node;
		length++;
		return node;
	}

	public Node<E> appendLast(E value) {
		Node<E> node = getNewNode();
		node.value = value;
		if (tail != null)
			tail.next = node;
		tail = node;
		if (head == null) {
			head = node;
		}

		length++;
		return node;
	}

	public Node<E> insert(int index, E value) {
		Node<E> node = getNewNode();
		if (index < 0 || index > length) {
			throw new IllegalArgumentException("Invalid index for insertion");
		} else if (index == length) {
			return appendLast(value);
		} else if (index == 0) {
			return appendFirst(value);
		} else {
			Node<E> prev = head;
			while (index > 1) {
				index--;
				prev = prev.next;
			}
			node.value = value;
			node.next = prev.next;
			prev.next = node;
			length++;
			return node;
		}
	}

	public E getFirst() {
		if (length == 0) {
			throw new NoSuchElementException();
		}
		return head.value;
	}

	public E getLast() {
		if (length == 0) {
			throw new NoSuchElementException();
		}
		return tail.value;
	}

	public Node<E> removeFirst() {
		if (length == 0) {
			throw new NoSuchElementException();
		}
		Node<E> origFirst = head;
		head = head.next;
		length--;
		if (length == 0) {
			tail = null;
		}
		return origFirst;
	}

	public E findAtIndex(int index) {
		Node<E> result = head;
		while (index >= 0) {
			if (result == null) {
				throw new NoSuchElementException();
			} else if (index == 0) {
				return result.value;
			} else {
				index--;
				result = result.next;
			}
		}
		return null;
	}

	protected Node<E> removeAtIndex(int index) {
		if (index >= length || index < 0) {
			throw new NoSuchElementException();
		}

		if (index == 0) {
			Node<E> nodeRemoved = head;
			removeFirst();
			return nodeRemoved;
		}

		Node<E> justBeforeIt = head;
		while (--index > 0) {
			justBeforeIt = justBeforeIt.next;
		}

		Node<E> nodeRemoved = justBeforeIt.next;
		if (justBeforeIt.next == tail) {
			tail = justBeforeIt.next.next;
		}
		justBeforeIt.next = justBeforeIt.next.next;

		length--;

		return nodeRemoved;

	}

	public void setValueAtIndex(int index, E value) {
		Node<E> result = head;
		while (index >= 0) {
			if (result == null) {
				throw new NoSuchElementException();
			} else if (index == 0) {
				result.value = value;
				return;
			} else {
				index--;
				result = result.next;
			}
		}
	}

	public Node<E> removeLast() {
		return removeAtIndex(length - 1);
	}

	public static class Node<E> {
		protected E value;
		protected Node<E> next;

		public String toString() {
			return value.toString();
		}

		public Node<E> getNext() {
			return next;
		}

		public E getValue() {
			return value;
		}
	}

	public class ListIterator implements Iterator<E> {
		protected Node<E> nextNode = head;
		protected Node<E> currentNode = null;
		protected Node<E> prevNode = null;

		@Override
		public boolean hasNext() {
			return nextNode != null;
		}

		@Override
		public E next() {
			if (!hasNext()) {
				throw new IllegalStateException();
			}
			prevNode = currentNode;
			currentNode = nextNode;
			nextNode = nextNode.next;
			return currentNode.value;
		}

		@Override
		public void remove() {
			if (currentNode == null || currentNode == prevNode) {
				throw new IllegalStateException();
			}
			if (currentNode == head) {
				head = nextNode;
			} else {
				prevNode.next = nextNode;
			}
			currentNode = prevNode;

		}

		public void setValue(E value) {
			currentNode.value = value;
		}

	}

	public void sort(Comparator<E> comparator) {
		PriorityQueue<E> priorityQueue = new LinkedHeap<E>(comparator);
		while (head != null) {
			priorityQueue.enqueue(getFirst());
			removeFirst();
		}
		while (priorityQueue.checkMinimum() != null) {
			appendLast(priorityQueue.dequeueMinimum());
		}

	}

	public <F> LinkedList<OrderedPair<E, F>> zip(LinkedList<F> rhs) {
		Iterator<E> lhsIter = this.iterator();
		Iterator<F> rhsIter = rhs.iterator();
		LinkedList<OrderedPair<E, F>> newList = new LinkedList<>();
		while (true) {
			if (lhsIter.hasNext() && rhsIter.hasNext()) {
				newList.appendLast(new OrderedPair<E, F>(lhsIter.next(), rhsIter.next()));
			} else if (lhsIter.hasNext()) {
				newList.appendLast(new OrderedPair<E, F>(lhsIter.next(), null));
			} else if (rhsIter.hasNext()) {
				newList.appendLast(new OrderedPair<E, F>(null, rhsIter.next()));
			} else {
				break;
			}
		}
		return newList;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		Node<E> node = head;
		while (node != null) {
			if (node.value == null) {
				sb.append("null");
			} else {
				sb.append(node.value.toString() + ", ");
			}
			node = node.next;
		}
		sb.append("]");
		return sb.toString();
	}

	public LinkedList<E> tail() {
		LinkedList<E> l =new LinkedList<E>();
		l.appendLast(this.tail.value);
		return l;
	}

	public LinkedList<Integer> add(int n) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static <E> LinkedList<E> emptyList(){
        return null;
    }
}
