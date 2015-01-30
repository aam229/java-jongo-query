package org.aam229.jongoquery;

import java.util.Arrays;
import java.util.Objects;

/**
 * Represents a single json value (string, number, array, object). 
 * @author Alexandre Massonneau
 *
 */
public class CriteriaValue extends Criteria {
	protected String query;
	
	/**
	 * Set the criteria's avalue
	 * @param str A value template
	 * @param params The parameters for the template
	 * @return
	 */
	public CriteriaValue set(String str, Object... params){
		Objects.requireNonNull(str, "The value must not be null");
		query = str;
		parameters = Arrays.asList(params);
		return this;
	}
	
	@Override
	public String getQuery(){
		return query;
	}
}
