package org.aam229.jongoquery;

import java.util.Arrays;
import java.util.Objects;

/**
 * Represents an array of criteria and their parameters. 
 * @author Alexandre Massonneau
 *
 */
public class CriteriaArray extends Criteria {
	protected StringJoiner joiner = new StringJoiner(", ", "[", "]");
	
	/**
	 * Add an item to the criteria array
	 * @param str A value template
	 * @param params The parameters for the template
	 * @return
	 */
	public CriteriaArray add(String str, Object... params){
		Objects.requireNonNull(str, "The criteria must not be null");
		joiner.add(str);
		parameters.addAll(Arrays.asList(params));
		return this;
	}
	
	/**
	 * Add an item to the criteria array
	 * @param criteria 
	 * @return
	 */
	public CriteriaArray add(Criteria criteria){
		Objects.requireNonNull(criteria, "The criteria must not be null");
		joiner.add(criteria.getQuery());
		parameters.addAll(criteria.getParameters());
		return this;
	}
	
	@Override
	public String getQuery(){
		return joiner.toString();
	}
}
