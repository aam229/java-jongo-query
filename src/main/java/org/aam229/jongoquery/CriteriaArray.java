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
	 * Add an item to the criteria array. The provided String cannot be null
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
	 * Add an item to the criteria array. If the criteria is null, it is 
	 * a no-op.
	 * @param criteria 
	 * @return
	 */
	public CriteriaArray add(Criteria criteria){
		if(criteria == null){
			return this;
		}
		joiner.add(criteria.getQuery());
		parameters.addAll(criteria.getParametersList());
		return this;
	}
	
	/**
	 * Get the size of the criteria array
	 * @return
	 */
	public int size(){
		return this.parameters.size();
	}
	
	@Override
	public String getQuery(){
		return joiner.toString();
	}
}
