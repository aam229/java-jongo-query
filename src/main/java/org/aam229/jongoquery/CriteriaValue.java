package org.aam229.jongoquery;

import java.util.Arrays;
import java.util.Objects;

/**
 * Represents an array of criteria and their parameters. 
 * @author Alexandre Massonneau
 *
 */
public class CriteriaValue extends Criteria {
	protected String query;
	
	/**
	 * Add an item to the criteria array
	 * @param str A value template
	 * @param params The parameters for the template
	 * @return
	 */
	public CriteriaValue set(String str, Object... params){
		Objects.requireNonNull(str, "The criteria must not be null");
		query = str;
		parameters = Arrays.asList(params);
		return this;
	}
	
	@Override
	public String getQuery(){
		return query;
	}
}
