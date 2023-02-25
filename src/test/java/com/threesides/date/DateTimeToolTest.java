package com.threesides.date;


import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;


/**
 * @author Di Wu
 *
 */
public class DateTimeToolTest {


	@Test
	public void getDateTime() {

		Date date = DateTimeTool.getDateTime();
		Assert.assertNotNull(date);
	}

	@Test
	public void testGetDateTime() {

		Date date = DateTimeTool.getDateTime(Calendar.getInstance());
		Assert.assertNotNull(date);
	}

	@Test
	public void format() {
		final String dateStr = "2023-02-20";
		final Date date = DateTimeTool.parse(dateStr, DatePattern.DATE_MIDDLE_LINE_PATTERN);
		String formatDate = DateTimeTool.format(date, DatePattern.DATE_CHINESE_PATTERN);
		Assert.assertEquals("2023年02月20日",formatDate);
	}

	@Test
	public void parse() {

		final String dateStr = "2023-02-25 13:38";
		Date date = DateTimeTool.parse(dateStr, DatePattern.DATE_MIDDLE_LINE_HOUR_MINUTE_COLON_PATTERN);
		Assert.assertNotNull(date);

	}

	@Test
	public void getThisYear() {
		int thisYear = DateTimeTool.getThisYear();
		Assert.assertEquals(2023,thisYear);
	}

	@Test
	public void getYear() {
		int newDateYear = DateTimeTool.getYear(new Date());
		Assert.assertEquals(2023,newDateYear);

		final String dateStr = "2022-02-25";
		Date parseDate = DateTimeTool.parse(dateStr, DatePattern.DATE_MIDDLE_LINE_PATTERN);
		int parseYear = DateTimeTool.getYear(parseDate);
		Assert.assertEquals(2022,parseYear);

	}

	@Test
	public void testGetYear() {
		int calendarYear = DateTimeTool.getYear(Calendar.getInstance());
		Assert.assertEquals(2023,calendarYear);

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, 2021);
		int setCalendarYear = DateTimeTool.getYear(calendar);
		Assert.assertEquals(2021,setCalendarYear);
	}

	@Test
	public void beginOfThisYear() {
	}

	@Test
	public void beginOfYear() {
	}

	@Test
	public void testBeginOfYear() {
	}

	@Test
	public void testBeginOfYear1() {
	}

	@Test
	public void endOfThisYear() {
	}

	@Test
	public void endOfYear() {
	}

	@Test
	public void testEndOfYear() {
	}

	@Test
	public void testEndOfYear1() {
	}

	@Test
	public void betweenYear() {
	}

	@Test
	public void testBetweenYear() {
	}

	@Test
	public void getThisMonth() {
	}

	@Test
	public void getMonth() {
	}

	@Test
	public void testGetMonth() {
	}

	@Test
	public void beginOfThisMonth() {
	}

	@Test
	public void beginOfMonth() {
	}

	@Test
	public void testBeginOfMonth() {
	}

	@Test
	public void testBeginOfMonth1() {
	}

	@Test
	public void endOfThisMonth() {
	}

	@Test
	public void endOfMonth() {
	}

	@Test
	public void testEndOfMonth() {
	}

	@Test
	public void testEndOfMonth1() {
	}

	@Test
	public void betweenMonth() {
	}

	@Test
	public void testBetweenMonth() {
	}

	@Test
	public void getThisDayOfYear() {
	}

	@Test
	public void getDayOfYear() {
	}

	@Test
	public void testGetDayOfYear() {
	}

	@Test
	public void beginOfThisDay() {
	}

	@Test
	public void beginOfDay() {
	}

	@Test
	public void testBeginOfDay() {
	}

	@Test
	public void testBeginOfDay1() {
	}

	@Test
	public void testBeginOfDay2() {
	}

	@Test
	public void endOfThisDay() {
	}

	@Test
	public void endOfDay() {
	}

	@Test
	public void testEndOfDay() {
	}

	@Test
	public void testEndOfDay1() {
	}

	@Test
	public void testEndOfDay2() {
	}

	@Test
	public void betweenDay() {
	}

	@Test
	public void testBetweenDay() {
	}

	@Test
	public void weekOfYear() {
	}

	@Test
	public void testWeekOfYear() {
	}

	@Test
	public void weekOfYearMaxWeek() {
	}

	@Test
	public void testWeekOfYearMaxWeek() {
	}

	@Test
	public void beginOfWeek() {
	}

	@Test
	public void testBeginOfWeek() {
	}

	@Test
	public void testBeginOfWeek1() {
	}

	@Test
	public void endOfWeek() {
	}

	@Test
	public void testEndOfWeek() {
	}

	@Test
	public void testEndOfWeek1() {
	}

	@Test
	public void betweenWeek() {
	}

	@Test
	public void testBetweenWeek() {
	}

	@Test
	public void between() {
	}
}