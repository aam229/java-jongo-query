package org.aam229.jongoquery;

import java.util.Arrays;
import java.util.Objects;

/**
 * Represents an object of criteria and their parameters. 
 * @author Alexandre Massonneau
 *
 */
public class CriteriaObject extends Criteria {
	protected StringJoiner joiner = new StringJoiner(", ", "{", "}");
	protected StringJoiner propJoiner = new StringJoiner(": ");
	
	/**
	 * Add an item to the criteria object
	 * @param str A property/value pair template to add to the object (ie "hello: [world, #]")
	 * @param params The parameters for the template
	 * @return
	 */
	public CriteriaObject add(String str, Object... params){
		Objects.requireNonNull(str, "The criteria must not be null");
		joiner.add(str);
		parameters.addAll(Arrays.asList(params));
		return this;
	}
	
	/**
	 * Add an item to the criteria object
	 * @param prop The name of the property for the corresponding template
	 * @param criteria
	 * @return
	 */
	public CriteriaObject add(String prop, Criteria criteria){
		Objects.requireNonNull(prop, "The property name must not be null");
		Objects.requireNonNull(criteria, "The criteria must not be null");
		joiner.add(propJoiner.reset().add(prop).add(criteria.getQuery()).toString());
		parameters.addAll(criteria.getParametersList());
		return this;
	}
	
	@Override
	public String getQuery(){
		return joiner.toString();
	}
}
