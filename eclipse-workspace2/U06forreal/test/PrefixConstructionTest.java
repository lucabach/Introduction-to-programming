import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.jupiter.api.Test;

public class PrefixConstructionTest {


	@Test
	public void test1() {
		
		
		assertTrue(PrefixConstruction.isPrefixConstruction("aaaaaaa", "aaa", 3));
		assertTrue(PrefixConstruction.isPrefixConstruction("aaa", "a", 4));
		
		assertFalse(PrefixConstruction.isPrefixConstruction("abcbcabc", "abc", 4));
		
		assertFalse(PrefixConstruction.isPrefixConstruction("babcabc", "abc", 3));	
		assertFalse(PrefixConstruction.isPrefixConstruction("aaa", "a", 2));
		
		assertTrue(PrefixConstruction.isPrefixConstruction("abab", "abac", 2));
		
		assertTrue(PrefixConstruction.isPrefixConstruction("abcababc", "abc", 4));
		
		assertTrue(PrefixConstruction.isPrefixConstruction("a", "ab", 1));
		
		assertFalse(PrefixConstruction.isPrefixConstruction("abc", "ab", 1));
		assertFalse(PrefixConstruction.isPrefixConstruction("acb", "ab", 1));
		assertFalse(PrefixConstruction.isPrefixConstruction("cab", "ab", 2));
		assertFalse(PrefixConstruction.isPrefixConstruction("aaaaaab", "aaa", 3));
		assertFalse(PrefixConstruction.isPrefixConstruction("aaaaaaa", null, 3));
		assertFalse(PrefixConstruction.isPrefixConstruction(null, "aaa", 3));
		assertFalse(PrefixConstruction.isPrefixConstruction("aaaaaaa", "", 3));
		assertTrue(PrefixConstruction.isPrefixConstruction("", "a", 1));
		
		assertTrue(PrefixConstruction.isPrefixConstruction("a", "a", 1));
		assertFalse(PrefixConstruction.isPrefixConstruction("ab", "a", 1));
		assertTrue(PrefixConstruction.isPrefixConstruction("ab", "ab", 1));
		assertTrue(PrefixConstruction.isPrefixConstruction("ababab", "ab", 3));
		assertFalse(PrefixConstruction.isPrefixConstruction("abababc", "ab", 3));
		assertFalse(PrefixConstruction.isPrefixConstruction("aaaaaaaab", "aaa", 3));
		assertTrue(PrefixConstruction.isPrefixConstruction("ababa", "ab", 3));
		assertTrue(PrefixConstruction.isPrefixConstruction("ababab", "ab", 3));
		assertTrue(PrefixConstruction.isPrefixConstruction("a", "ab", 1));
		assertFalse(PrefixConstruction.isPrefixConstruction("ab", "b", 3));
		assertTrue(PrefixConstruction.isPrefixConstruction("", "abc", 1));
		
		assertTrue(PrefixConstruction.isPrefixConstruction("ababab", "ababa", 2));
		
		assertTrue(PrefixConstruction.isPrefixConstruction("abababc", "ababc", 2));
		assertTrue(PrefixConstruction.isPrefixConstruction("ababababcababababa", "abc", 10));
		
		
		
		
		
		
	
	
		
	}
	
}
