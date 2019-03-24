package zolcsak.zsolt.devtest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class PriorityQueueTest {
	@Test
	public void givenAnUnsortedArray_whenCreatingPriorityQueue_thenPopsElementsInDescendingNaturalOrder() {
		Integer[] unsortedArray = new Integer[] { 3, 1, 4, 2 };
		PriorityQueue<Integer> q = new PriorityQueue<>(unsortedArray);
		assertEquals((Integer) 4, q.pop());
		assertEquals((Integer) 3, q.pop());
		assertEquals((Integer) 2, q.pop());
		assertEquals((Integer) 1, q.pop());
		assertNull(q.pop());
	}

	@Test
	public void givenAnEmptyArray_whenCreatingPriorityQueue_thenPopsNulls() {
		PriorityQueue<Integer> q = new PriorityQueue<>(new Integer[] {});
		assertNull(q.pop());
		assertNull(q.pop());
	}

	@Test
	public void givenANumberOfElements_whenPushingOneWithTheHighestOrder_thenPopReturnsIt() {
		Integer[] unsortedArray = new Integer[] { 3, 1, 4, 2 };
		PriorityQueue<Integer> q = new PriorityQueue<>(unsortedArray);
		q.push(5);
		assertEquals((Integer) 5, q.pop());
	}

	@Test
	public void givenANumberOfElements_whenPushingAndPopping_thenSizeReflectsTheNumberOfElementsInTheQueue() {
		Integer[] unsortedArray = new Integer[] { 3, 1, 4, 2 };
		PriorityQueue<Integer> q = new PriorityQueue<>(unsortedArray);
		assertEquals(4, q.size());
		q.push(0);
		assertEquals(5, q.size());
		popFour(q);
		assertEquals(1, q.size());
		popFour(q);
		assertEquals(0, q.size());
	}

	private void popFour(PriorityQueue<Integer> q) {
		q.pop();
		q.pop();
		q.pop();
		q.pop();
	}
}
