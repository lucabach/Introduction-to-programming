import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;

public class MedianTest {

	@Test
	public void testMedianSimple() {
		Scanner input = new Scanner("1 5 4 3 0");
		double result = Median.median(input);
		assertEquals(3, result, 0.0001);
	}
	
	@Test
	public void testMedian2() {
		Scanner input = new Scanner("5 4 3 0");
		double result = Median.median(input);
		assertEquals(3.5, result, 0.0001);
	}
	
	
}
