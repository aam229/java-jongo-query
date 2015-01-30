package org.aam229.jongoquery;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CriteriaValueTest {
	@Test
	public void testAdd(){
		CriteriaValue criteria = new CriteriaValue();
		criteria.set("[hello, #]", "sir");
		assertEquals("[hello, #]", criteria.getQuery());
		assertEquals("sir", criteria.getParametersList().get(0));
		criteria.set("[hola, #]", "senor");
		assertEquals("[hola, #]", criteria.getQuery());
		assertEquals("senor", criteria.getParametersList().get(0));
	}
	
	@Test(expected = NullPointerException.class) 
	public void testAddNullString(){
		CriteriaValue criteria = new CriteriaValue();
		criteria.set(null, "sir");
	}
}
