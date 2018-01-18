package com.aviva.javaprograms.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author Vishal Mali
 *         <p>
 *         Utility class for all the java programs
 *         <p>
 *         Java programs are listed below:
 *         <ul>
 *         <li>Get Vertical list from 1 to given number</li>
 *         <li>Checks the day of the week</li>
 *         </ul>
 */
public class JavaProgramsUtils {

	private static final String FIZZ = "fizz";
	private static final String BUZZ = "buzz";
	private static final String FIZZ_BUZZ = "fizz buzz";
	private static final String WIZZ = "wizz";
	private static final String WUZZ = "wuzz";
	private static final String WIZZ_WUZZ = "wizz wuzz";
	private static final int DAY = Calendar.WEDNESDAY;

	/**
	 * Gets Vertical list from 1 to given number
	 * 
	 * @param input
	 *            A number in String format up to which vertical list is to be
	 *            generated
	 * @return List of vertical list of numbers
	 */
	public static List<String> getVerticalList(int number) {
		List<String> verticalList = new ArrayList<>();
		for (int i = 1; i < number; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				if (checkDay(DAY)) {
					verticalList.add(WIZZ_WUZZ);
				} else {
					verticalList.add(FIZZ_BUZZ);
				}
			} else if (i % 3 == 0) {
				if (checkDay(DAY)) {
					verticalList.add(WIZZ);
				} else {
					verticalList.add(FIZZ);
				}
			} else if (i % 5 == 0) {
				if (checkDay(DAY)) {
					verticalList.add(WUZZ);
				} else {
					verticalList.add(BUZZ);
				}
			} else {
				verticalList.add(String.valueOf(i));
			}
		}

		return verticalList;
	}

	/**
	 * Checks the day of the week
	 * 
	 * @param day
	 *            Integer value for the day in a week. e.g. 1=Sunday, 2=Monday
	 * @return true if day value is matched with the passed integer, false
	 *         otherwise
	 */
	public static boolean checkDay(int day) {

		Calendar calender = Calendar.getInstance();
		calender.setTime(new Date());

		return calender.get(Calendar.DAY_OF_WEEK) == day;
	}
}
