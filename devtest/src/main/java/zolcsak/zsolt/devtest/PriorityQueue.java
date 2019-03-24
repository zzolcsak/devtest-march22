package zolcsak.zsolt.devtest;

public final class PriorityQueue<T extends Comparable<? super T>> {
	private Object[] elements;
	private int size;

	public PriorityQueue(T... elements) {
		this.elements = new Object[elements.length * 2];
		for (int i = 0; i < elements.length; i++)
			push(elements[i]);
	}

	// performance: O(n^2)
	public synchronized T pop() {
		if (size == 0)
			return null;
		sortInDescendingOrder();
		@SuppressWarnings("unchecked")
		T result = (T) elements[0];
		elements[0] = cutLastElement();
		return result;
	}

	private void sortInDescendingOrder() {
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++) {
				if (isInAscendingOrder(i, j))
					switchElements(i, j);
			}
	}

	@SuppressWarnings("unchecked")
	private boolean isInAscendingOrder(int i, int j) {
		T left = (T) elements[i];
		T right = (T) elements[j];
		return left.compareTo(right) > 0;
	}

	private void switchElements(int i, int j) {
		Object temp = elements[i];
		elements[i] = elements[j];
		elements[j] = temp;
	}

	private T cutLastElement() {
		@SuppressWarnings("unchecked")
		T lastElement = (T) elements[size - 1];
		elements[--size] = null;
		return lastElement;
	}

	// performance: O(1)
	public synchronized void push(T element) {
		if (element == null)
			throw new UnsupportedOperationException("Cannot insert null element in queue.");
		if (size == elements.length)
			upsize();
		elements[size++] = element;
	}

	private void upsize() {
		Object[] newArray = new Object[elements.length * 2];
		for (int i = 0; i < elements.length; i++)
			newArray[i] = elements[i];
		elements = newArray;
	}

	public int size() {
		return size;
	}
}
