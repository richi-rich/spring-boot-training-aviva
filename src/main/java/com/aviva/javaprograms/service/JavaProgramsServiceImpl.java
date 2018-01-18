package com.aviva.javaprograms.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.aviva.javaprograms.exception.InputIsNotInRangeException;
import com.aviva.javaprograms.exception.InvalidInputException;
import com.aviva.javaprograms.util.JavaProgramsUtils;

/**
 * @author Vishal Mali
 *         <p>
 *         This is a service implementation of {@link JavaProgramsService} which
 *         provides various services related to java programs. Services are
 *         listed below:
 *         <ul>
 *         <li>Get Vertical list from 1 to given number</li>
 *         <li>Get Vertical list from 1 to given number with pagination</li>
 *         </ul>
 */
@Service
public class JavaProgramsServiceImpl implements JavaProgramsService {
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<String> getVerticalList(String input) {
		validateInput(input);
		return JavaProgramsUtils.getVerticalList(Integer.parseInt(input));
	}

	/**
	 * Validates input string
	 * <p>
	 * Input is validated if it is not numeric as well as if it not in between
	 * the range provided.
	 * 
	 * @param input
	 *            String to be validated
	 * @exception throws
	 *                {@link InvalidInputException} if passed input string is
	 *                not numeric or zero
	 * @exception throws
	 *                {@link InputIsNotInRangeException} if passed input string
	 *                is not in between the range provided
	 */
	private void validateInput(String input) {
		if (!StringUtils.isNumeric(input)) {
			throw new InvalidInputException("'" + input + "'" + " passed is not a valid number");
		}

		int lowerBound = 1;
		int upperBound = 1000;
		int number = Integer.parseInt(input);
		if (number < lowerBound || number > upperBound) {
			throw new InputIsNotInRangeException(
					"'" + input + "'" + " passed is not in between " + lowerBound + " and " + upperBound);
		}
	}
}
