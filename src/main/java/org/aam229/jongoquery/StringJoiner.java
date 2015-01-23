package org.aam229.jongoquery;
import java.util.Objects;

/**
 * StringJoiner is used to construct a sequence of characters separated by a delimiter and optionally starting with a supplied prefix and ending with a supplied suffix.
 * @author Alexandre
 *
 */
public class StringJoiner {
	StringBuilder value;
	String delimiter;
	String prefix;
	String suffix;
	
	/**
	 * Constructs a StringJoiner with no characters in it, with no prefix or suffix, and a copy of the supplied delimiter.
	 * @param delimiter
	 */
	public StringJoiner(CharSequence delimiter){
		this(delimiter, "", "");
	}
	
	/**
	 * Constructs a StringJoiner with no characters in it using copies of the supplied prefix, delimiter and suffix.
	 * @param delimiter
	 * @param prefix
	 * @param suffix
	 */
	public StringJoiner(CharSequence delimiter, CharSequence prefix, CharSequence suffix){
		Objects.requireNonNull(prefix, "The prefix must not be null");
        Objects.requireNonNull(delimiter, "The delimiter must not be null");
        Objects.requireNonNull(suffix, "The suffix must not be null");
        this.delimiter = delimiter.toString();
        this.prefix = prefix.toString();
        this.suffix = suffix.toString();
	}
	
	/**
	 * Adds copies of the given CharSequence values to the StringJoiner value
	 * @param strs
	 * @return This StringJoiner
	 */
	public StringJoiner add(Iterable<? extends CharSequence> strs){
		for(CharSequence str: strs){
			this.add(str);
		}
		return this;
	}
	
	/**
	 * Adds copies of the given CharSequence values to the StringJoiner value
	 * @param strs
	 * @return This StringJoiner
	 */
	public StringJoiner add(CharSequence[] strs){
		for(CharSequence str: strs){
			this.add(str);
		}
		return this;
	}
	
	/**
	 * Adds a copy of the given CharSequence value as the next element of the StringJoiner value.
	 * @param str
	 * @return This StringJoiner
	 */
	public StringJoiner add(CharSequence str){
		if(str == null){
			return this;
		}
		if(value == null){
			value = new StringBuilder();
			value.append(prefix);
		}else{
			value.append(delimiter);
		}
		value.append(str);
		return this;
	}	
	
	/**
	 * Reset the StringJoiner to its original state
	 * @return This StringJoiner
	 */
	public StringJoiner reset(){
		value = null;
		return this;
	}
	
	/**
	 * Returns the current value, consisting of the prefix, the values added so far separated by the delimiter, and the suffix, 
	 * unless no elements have been added in which case, the prefix + suffix characters are returned
	 * @return the string representation of this StringJoiner
	 */
	public String toString(){
		if(value == null){
			return prefix + suffix;
		}
		if(suffix.equals("")){
			return value.toString();
		}
		int length = value.length();
		String res = value.append(suffix).toString();
		value.setLength(length);
		return res;
	}
	
}
