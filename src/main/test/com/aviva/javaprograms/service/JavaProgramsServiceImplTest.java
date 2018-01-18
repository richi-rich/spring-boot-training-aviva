package com.aviva.javaprograms.service;

import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import com.aviva.javaprograms.exception.InputIsNotInRangeException;
import com.aviva.javaprograms.exception.InvalidInputException;

public class JavaProgramsServiceImplTest {
	private JavaProgramsServiceImpl javaProgramsServiceImpl;

	@Before
	public void setUp() {
		javaProgramsServiceImpl = new JavaProgramsServiceImpl();
	}

	@Test(expected = InvalidInputException.class)
	public void testGetVerticalListForInvalidInputException() {
		javaProgramsServiceImpl.getVerticalList("foobar");
	}

	@Test(expected = InvalidInputException.class)
	public void testGetVerticalListForInvalidInputExceptionWhenInputIsNegative() {
		javaProgramsServiceImpl.getVerticalList("-20");
	}

	@Test(expected = InputIsNotInRangeException.class)
	public void testGetVerticalListForResourceNotFoundException() {
		javaProgramsServiceImpl.getVerticalList("1001");
	}

	@Test
	public void testGetVerticalList() {
		List<String> fibonacciList = new ArrayList<>();
		fibonacciList.add("1");
		fibonacciList.add("2");
		fibonacciList.add("fizz");
		fibonacciList.add("4");
		fibonacciList.add("buzz");
		fibonacciList.add("fizz");

		List<String> actualList = javaProgramsServiceImpl.getVerticalList("7");

		assertThat(actualList, CoreMatchers.is(fibonacciList));
	}
}
