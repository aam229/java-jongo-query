package org.aam229.jongoquery;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CriteriaObjectTest {
	@Test
	public void testAdd(){
		CriteriaObject criteria = new CriteriaObject();
		criteria.add("hello: #", "sir");
		assertEquals("{hello: #}", criteria.getQuery());
		assertEquals(1, criteria.getParametersList().size());
		assertEquals("sir", criteria.getParametersList().get(0));
		
		criteria.add("prop", criteria);
		assertEquals("{hello: #, prop: {hello: #}}", criteria.getQuery());
		assertEquals(2, criteria.getParametersList().size());
		assertEquals("sir", criteria.getParametersList().get(0));
		assertEquals("sir", criteria.getParametersList().get(1));		
	}
	
	@Test(expected = NullPointerException.class) 
	public void testAddNullString(){
		CriteriaObject criteria = new CriteriaObject();
		criteria.add(null, "sir");
	}
	
	@Test(expected = NullPointerException.class) 
	public void testAddNullCriteria(){
		CriteriaObject criteria = new CriteriaObject();
		criteria.add(null);
	}
}
