package org.aam229.jongoquery;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CriteriaArrayTest {
	@Test
	public void testAdd(){
		CriteriaArray criteria = new CriteriaArray();
		criteria.add("#", "sir");
		criteria.add("hello");
		assertEquals("[#, hello]", criteria.getQuery());
		assertEquals(1, criteria.getParameters().size());
		assertEquals("sir", criteria.getParameters().get(0));
		
		criteria.add(criteria);
		assertEquals("[#, hello, [#, hello]]", criteria.getQuery());
		assertEquals(2, criteria.getParameters().size());
		assertEquals("sir", criteria.getParameters().get(0));
		assertEquals("sir", criteria.getParameters().get(1));		
	}
	
	@Test(expected = NullPointerException.class) 
	public void testAddNullString(){
		CriteriaArray criteria = new CriteriaArray();
		criteria.add(null, "sir");
	}
	
	@Test(expected = NullPointerException.class) 
	public void testAddNullCriteria(){
		CriteriaArray criteria = new CriteriaArray();
		criteria.add(null);
	}
}
