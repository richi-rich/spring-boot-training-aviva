package com.aviva.javaprograms.service;

import java.util.List;

/**
 * @author Vishal Mali
 *         <p>
 *         This is a service interface layer which provides various services
 *         related to java programs. Services are listed below:
 *         <ul>
 *         <li>Get Vertical list from 1 to given number</li>
 *         <li>Get Vertical list from 1 to given number with pagination</li>
 *         </ul>
 */
public interface JavaProgramsService {
	/**
	 * Gets Vertical list from 1 to given number
	 * 
	 * @param input
	 *            A number in String format up to which vertical list is to be
	 *            generated
	 * @return List of numbers
	 */
	List<String> getVerticalList(String input);
}
