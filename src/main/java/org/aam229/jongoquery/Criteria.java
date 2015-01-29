package org.aam229.jongoquery;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a JSON value template with and its parameters. Its purpose is to store the arguments to Jongo's find and projection methods.
 *  
 * @author Alexandre Massonneau
 *
 */
public abstract class Criteria {
	protected List<Object> parameters = new ArrayList<>();
	
	/**
	 * @return The criteria as a JSON string
	 */
	public abstract String getQuery();
	
	/**
	 * 
	 * @return The criteria's parameters
	 */
	public Object[] getParameters(){
		return parameters.toArray();
	}
	
	public List<Object> getParametersList(){
		return parameters;
	}
}
