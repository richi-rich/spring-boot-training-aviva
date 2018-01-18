package com.aviva.javaprograms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.aviva.javaprograms.service.JavaProgramsService;

/**
 * @author Vishal Mali
 *         <p>
 *         Controller for all the java programs
 *         <p>
 *         Here java programs are exposed as restful web services. Services are
 *         listed below:
 *         <ul>
 *         <li>Get Vertical list from 1 to given number</li>
 *         <li>Get Vertical list from 1 to given number with pagination</li>
 *         </ul>
 */
@RestController
public class JavaProgramsController {
	@Autowired
	JavaProgramsService javaProgramsService;

	/**
	 * Gets Vertical list from 1 to given number
	 * 
	 * @param input
	 *            A number in String format up to which vertical list is to be
	 *            generated
	 * @return {@link ResponseEntity} composed of vertical list of numbers
	 */
	@GetMapping("/v1/verticallist/{input}")
	public ResponseEntity<List<String>> getVerticalList(@PathVariable String input) {
		return new ResponseEntity<List<String>>(javaProgramsService.getVerticalList(input), HttpStatus.OK);
	}
}
