import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class NeighborTest {

	@Test
	public void testNeighborExamples() {
		
		assertArrayEquals(new int[] {5, 4, 7}, Neighbor.neighbor(new int[] {1, 4, 5, 7, 9, 10}, 5));
		int[] test2 = Neighbor.neighbor(new int[] {1, 4, 5, 6, 9, 10}, 5);
		assertTrue(test2 != null && test2.length == 3 && test2[0] == 5 && ((test2[1] == 4 && test2[2] == 6) || (test2[1] == 6 && test2[2] == 4)));
		assertArrayEquals(new int[] {10, 9, 6}, Neighbor.neighbor(new int[] {1, 4, 5, 6, 9, 10}, 10));
	}
	
	@Test
	
		public void selfMadeTests() {
	
			
	
			assertArrayEquals(new int[] {20, 25, 8}, Neighbor.neighbor(new int[] {3, 4, 8, 20, 25, 50},20 ));
	
			int[] test3 = Neighbor.neighbor(new int[] {1,3,5,7,10,12},5);
	
			assertTrue(test3 != null && test3.length == 3 && test3[0] == 5 && ((test3[1] == 3 && test3[2] == 7) || (test3[1] == 7 && test3[2] == 3)));
	
			
	
			int[] test4 = Neighbor.neighbor(new int[] {1,2,3,4,5},3);
	
			assertTrue(test4 != null && test4.length == 3 && test4[0] == 3 && ((test4[1] == 2 && test4[2] == 4) || (test4[1] == 4 && test4[2] == 2)));
		}
}
