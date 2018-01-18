package com.aviva.javaprograms.exception;

/**
 * @author Vishal Mali
 *         <p>
 *         Customized exception class, used when input provided is not in the
 *         given range
 */
public class InputIsNotInRangeException extends RuntimeException {
	private static final long serialVersionUID = -1817363873256345008L;

	public InputIsNotInRangeException(String message) {
		super(message);
	}
}
