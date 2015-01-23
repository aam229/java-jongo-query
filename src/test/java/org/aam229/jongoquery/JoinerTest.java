package org.aam229.jongoquery;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class JoinerTest {
	@Test
	public void testAdd(){
		StringJoiner joiner = new StringJoiner(" ");
		joiner.add("hello");
		assertEquals("hello", joiner.toString());
		joiner.add("world");
		assertEquals("hello world", joiner.toString());
		
		joiner = new StringJoiner(" ", "[", "");
		joiner.add("hello");
		assertEquals("[hello", joiner.toString());
		joiner.add("world");
		assertEquals("[hello world", joiner.toString());
		
		joiner = new StringJoiner(" ", "[", "]");
		joiner.add("hello");
		assertEquals("[hello]", joiner.toString());
		joiner.add("world");
		assertEquals("[hello world]", joiner.toString());
	}
	
	@Test
	public void testAddIterable(){
		StringJoiner joiner = new StringJoiner(" ", "[", "]");
		List<String> parts = Arrays.asList(new String[]{"hello", "world"});
		joiner.add(parts);
		assertEquals("[hello world]", joiner.toString());
		joiner.add(parts);
		assertEquals("[hello world hello world]", joiner.toString());
	}
	
	@Test
	public void testAddArray(){
		StringJoiner joiner = new StringJoiner(" ", "[", "]");
		String[] parts = new String[]{"hello", "world"};
		joiner.add(parts);
		assertEquals("[hello world]", joiner.toString());
		joiner.add(parts);
		assertEquals("[hello world hello world]", joiner.toString());
	}
	
	@Test
	public void testReset(){
		StringJoiner joiner = new StringJoiner(" ", "[", "]");
		String[] parts = new String[]{"hello", "world"};
		joiner.add(parts);
		assertEquals("[hello world]", joiner.toString());
		joiner.reset();
		joiner.add(parts);
		assertEquals("[hello world]", joiner.toString());
	}
}
