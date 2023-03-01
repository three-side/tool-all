package com.threesides.date;


import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;


/**
 * @author Di Wu
 */
public class DateTimeUtilTest {


	@Test
	public void getDateTime() {

		Date date = DateTimeUtil.getDateTime();
		Assert.assertNotNull(date);
	}

	@Test
	public void testGetDateTime() {

		Date date = DateTimeUtil.getDateTime(Calendar.getInstance());
		Assert.assertNotNull(date);
	}

	@Test
	public void format() {
		final String dateStr = "2023-02-20";
		final Date date = DateTimeUtil.parse(dateStr, DatePattern.DATE_MIDDLE_LINE_PATTERN);
		String formatDate = DateTimeUtil.format(date, DatePattern.DATE_CHINESE_PATTERN);
		Assert.assertEquals("2023年02月20日", formatDate);
	}

	@Test
	public void parse() {

		final String dateStr = "2023-02-25 13:38";
		Date date = DateTimeUtil.parse(dateStr, DatePattern.DATE_MIDDLE_LINE_HOUR_MINUTE_COLON_PATTERN);
		Assert.assertNotNull(date);

	}

	@Test
	public void getThisYear() {
		int thisYear = DateTimeUtil.getThisYear();
		Assert.assertEquals(2023, thisYear);
	}

	@Test
	public void getYear() {
		int newDateYear = DateTimeUtil.getYear(new Date());
		Assert.assertEquals(2023, newDateYear);

		final String dateStr = "2022-02-25";
		Date parseDate = DateTimeUtil.parse(dateStr, DatePattern.DATE_MIDDLE_LINE_PATTERN);
		int parseYear = DateTimeUtil.getYear(parseDate);
		Assert.assertEquals(2022, parseYear);

	}

	@Test
	public void testGetYear() {
		int calendarYear = DateTimeUtil.getYear(Calendar.getInstance());
		Assert.assertEquals(2023, calendarYear);

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, 2021);
		int setCalendarYear = DateTimeUtil.getYear(calendar);
		Assert.assertEquals(2021, setCalendarYear);
	}

	@Test
	public void beginOfThisYear() {
		Date beginOfThisYearDate = DateTimeUtil.beginOfThisYear();
		String formatDate = DateTimeUtil.format(beginOfThisYearDate, DatePattern.DATE_MIDDLE_LINE_PATTERN);

		Assert.assertEquals("2023-01-01", formatDate);
	}

	@Test
	public void beginOfYear() {
		String strDate = "2023-02-16";
		Date parseDate = DateTimeUtil.parse(strDate, DatePattern.DATE_MIDDLE_LINE_PATTERN);
		Date beginOfYeardate = DateTimeUtil.beginOfYear(parseDate);
		String formatDate = DateTimeUtil.format(beginOfYeardate, DatePattern.DATE_MIDDLE_LINE_PATTERN);
		Assert.assertEquals("2023-01-01", formatDate);
	}

	@Test
	public void testBeginOfYear() {
		String strDate = "2023-02-16";
		Date parseDate = DateTimeUtil.parse(strDate, DatePattern.DATE_MIDDLE_LINE_PATTERN);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(parseDate);
		Date beginOfYeardate = DateTimeUtil.beginOfYear(calendar);
		String formatDate = DateTimeUtil.format(beginOfYeardate, DatePattern.DATE_MIDDLE_LINE_PATTERN);
		Assert.assertEquals("2023-01-01", formatDate);
	}

	@Test
	public void testBeginOfYear1() {
		Date beginOfYeardate = DateTimeUtil.beginOfYear(2023);
		String formatDate = DateTimeUtil.format(beginOfYeardate, DatePattern.DATE_MIDDLE_LINE_PATTERN);
		Assert.assertEquals("2023-01-01", formatDate);
	}

	@Test
	public void endOfThisYear() {

		Date beginOfThisYearDate = DateTimeUtil.endOfThisYear();
		String formatDate = DateTimeUtil.format(beginOfThisYearDate, DatePattern.DATE_MIDDLE_LINE_PATTERN);
		Assert.assertEquals("2023-12-31", formatDate);
	}

	@Test
	public void endOfYear() {

		String strDate = "2023-02-16";
		Date parseDate = DateTimeUtil.parse(strDate, DatePattern.DATE_MIDDLE_LINE_PATTERN);
		Date beginOfYeardate = DateTimeUtil.endOfYear(parseDate);
		String formatDate = DateTimeUtil.format(beginOfYeardate, DatePattern.DATE_MIDDLE_LINE_PATTERN);
		Assert.assertEquals("2023-12-31", formatDate);
	}

	@Test
	public void testEndOfYear() {
		String strDate = "2023-02-16";
		Date parseDate = DateTimeUtil.parse(strDate, DatePattern.DATE_MIDDLE_LINE_PATTERN);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(parseDate);
		Date beginOfYeardate = DateTimeUtil.endOfYear(calendar);
		String formatDate = DateTimeUtil.format(beginOfYeardate, DatePattern.DATE_MIDDLE_LINE_PATTERN);
		Assert.assertEquals("2023-12-31", formatDate);
	}

	@Test
	public void testEndOfYear1() {
		Date beginOfYeardate = DateTimeUtil.endOfYear(2023);
		String formatDate = DateTimeUtil.format(beginOfYeardate, DatePattern.DATE_MIDDLE_LINE_PATTERN);
		Assert.assertEquals("2023-12-31", formatDate);
	}

	@Test
	public void betweenYear() {
		String startStrDate = "2022-02-16";
		Date startDate = DateTimeUtil.parse(startStrDate, DatePattern.DATE_MIDDLE_LINE_PATTERN);
		String endStrDate = "2024-01-16";
		Date endDate = DateTimeUtil.parse(endStrDate, DatePattern.DATE_MIDDLE_LINE_PATTERN);
		int betweenYear = DateTimeUtil.betweenYear(startDate, endDate);
		Assert.assertEquals(2,betweenYear);
	}

	@Test
	public void testBetweenYear() {

		String startStrDate = "2021-02-16";
		Date startDate = DateTimeUtil.parse(startStrDate, DatePattern.DATE_MIDDLE_LINE_PATTERN);
		Calendar  startCalendar = Calendar.getInstance();
		startCalendar.setTime(startDate);

		String endStrDate = "2024-03-16";
		Date endDate = DateTimeUtil.parse(endStrDate, DatePattern.DATE_MIDDLE_LINE_PATTERN);
		Calendar endCalendar = Calendar.getInstance();
		endCalendar.setTime(endDate);

		int betweenYear = DateTimeUtil.betweenYear(startCalendar, endCalendar);
		Assert.assertEquals(3,betweenYear);
	}

	@Test
	public void getThisMonth() {

		int thisMonth = DateTimeUtil.getThisMonth();
		Assert.assertNotNull(thisMonth);

	}

	@Test
	public void getMonth() {
		String strDate = "2022-04-16";
		Date date = DateTimeUtil.parse(strDate, DatePattern.DATE_MIDDLE_LINE_PATTERN);
		int month = DateTimeUtil.getMonth(date);
		Assert.assertEquals(4,month);

	}

	@Test
	public void testGetMonth() {
		String strDate = "2022-04-16";
		Date date = DateTimeUtil.parse(strDate, DatePattern.DATE_MIDDLE_LINE_PATTERN);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int month = DateTimeUtil.getMonth(calendar);
		Assert.assertEquals(4,month);

	}

	@Test
	public void beginOfThisMonth() {
		Date date = DateTimeUtil.beginOfThisMonth();
		Assert.assertNotNull(date);
	}

	@Test
	public void beginOfMonth() {

		String strDate = "2022-04-16";
		Date date = DateTimeUtil.parse(strDate, DatePattern.DATE_MIDDLE_LINE_PATTERN);
		Date beginOfMonthDate = DateTimeUtil.beginOfMonth(date);
		String formatDate = DateTimeUtil.format(beginOfMonthDate, DatePattern.DATE_MIDDLE_LINE_TIME_COLON_PATTERN);
		Assert.assertEquals("2022-04-01 00:00:00", formatDate);
	}

	@Test
	public void testBeginOfMonth() {
		String strDate = "2022-04-16";
		Date date = DateTimeUtil.parse(strDate, DatePattern.DATE_MIDDLE_LINE_PATTERN);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		Date beginOfMonthDate = DateTimeUtil.beginOfMonth(calendar);
		String formatDate = DateTimeUtil.format(beginOfMonthDate, DatePattern.DATE_MIDDLE_LINE_TIME_COLON_PATTERN);
		Assert.assertEquals("2022-04-01 00:00:00", formatDate);
	}

	@Test
	public void testBeginOfMonth1() {

		Date beginOfMonthDate = DateTimeUtil.beginOfMonth(2022, 3);
		String formatDate = DateTimeUtil.format(beginOfMonthDate, DatePattern.DATE_MIDDLE_LINE_TIME_COLON_PATTERN);
		Assert.assertEquals("2022-03-01 00:00:00", formatDate);
	}

	@Test
	public void endOfThisMonth() {

		Date date = DateTimeUtil.endOfThisMonth();
		Assert.assertNotNull(date);
	}

	@Test
	public void endOfMonth() {
		String strDate = "2022-04-16";
		Date date = DateTimeUtil.parse(strDate, DatePattern.DATE_MIDDLE_LINE_PATTERN);
		Date beginOfMonthDate = DateTimeUtil.endOfMonth(date);
		String formatDate = DateTimeUtil.format(beginOfMonthDate, DatePattern.DATE_MIDDLE_LINE_TIME_COLON_PATTERN);
		Assert.assertEquals("2022-04-30 23:59:59", formatDate);
	}

	@Test
	public void testEndOfMonth() {
		String strDate = "2022-04-16";
		Date date = DateTimeUtil.parse(strDate, DatePattern.DATE_MIDDLE_LINE_PATTERN);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		Date beginOfMonthDate = DateTimeUtil.endOfMonth(calendar);
		String formatDate = DateTimeUtil.format(beginOfMonthDate, DatePattern.DATE_MIDDLE_LINE_TIME_COLON_PATTERN);
		Assert.assertEquals("2022-04-30 23:59:59", formatDate);
	}

	@Test
	public void testEndOfMonth1() {
		Date beginOfMonthDate = DateTimeUtil.endOfMonth(2022, 4);
		String formatDate = DateTimeUtil.format(beginOfMonthDate, DatePattern.DATE_MIDDLE_LINE_TIME_COLON_PATTERN);
		Assert.assertEquals("2022-04-30 23:59:59", formatDate);
	}

	@Test
	public void betweenMonth() {
		String startStrDate = "2022-02-16";
		Date startDate = DateTimeUtil.parse(startStrDate, DatePattern.DATE_MIDDLE_LINE_PATTERN);

		String endStrDate = "2022-08-16";
		Date endDate = DateTimeUtil.parse(endStrDate, DatePattern.DATE_MIDDLE_LINE_PATTERN);

		int betweenMonth = DateTimeUtil.betweenMonth(startDate, endDate);
		Assert.assertEquals(6,betweenMonth);
	}

	@Test
	public void testBetweenMonth() {
		String startStrDate = "2022-02-16";
		Date startDate = DateTimeUtil.parse(startStrDate, DatePattern.DATE_MIDDLE_LINE_PATTERN);
		Calendar  startCalendar = Calendar.getInstance();
		startCalendar.setTime(startDate);

		String endStrDate = "2022-08-16";
		Date endDate = DateTimeUtil.parse(endStrDate, DatePattern.DATE_MIDDLE_LINE_PATTERN);
		Calendar endCalendar = Calendar.getInstance();
		endCalendar.setTime(endDate);
		int betweenMonth = DateTimeUtil.betweenMonth(startCalendar, endCalendar);
		Assert.assertEquals(6,betweenMonth);

	}

	@Test
	public void getThisDayOfYear() {
		int thisDayOfYear = DateTimeUtil.getThisDayOfYear();
		Assert.assertNotNull(thisDayOfYear);
	}

	@Test
	public void getDayOfYear() {

		String strDate = "2023-02-28";
		Date date = DateTimeUtil.parse(strDate, DatePattern.DATE_MIDDLE_LINE_PATTERN);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int dayOfYear = DateTimeUtil.getDayOfYear(date);

		Assert.assertEquals(59, dayOfYear);

	}

	@Test
	public void testGetDayOfYear() {
		String strDate = "2022-02-28";
		Date date = DateTimeUtil.parse(strDate, DatePattern.DATE_MIDDLE_LINE_PATTERN);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int dayOfYear = DateTimeUtil.getDayOfYear(calendar);
		Assert.assertEquals(59, dayOfYear);
	}

	@Test
	public void getThisDayOfMonth() {
		int dayOfMonth = DateTimeUtil.getThisDayOfMonth();
		Assert.assertNotNull(dayOfMonth);

	}

	@Test
	public void getDayOfMonth() {
		String strDate = "2022-02-28";
		Date date = DateTimeUtil.parse(strDate, DatePattern.DATE_MIDDLE_LINE_PATTERN);

		int dayOfMonth = DateTimeUtil.getDayOfMonth(date);
		Assert.assertEquals(28, dayOfMonth);
	}

	@Test
	public void testGetDayOfMonth() {
		String strDate = "2022-02-28";
		Date date = DateTimeUtil.parse(strDate, DatePattern.DATE_MIDDLE_LINE_PATTERN);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int dayOfMonth = DateTimeUtil.getDayOfMonth(calendar);
		Assert.assertEquals(28, dayOfMonth);
	}


	@Test
	public void beginOfThisDay() {
		Date beginOfThisDayDate = DateTimeUtil.beginOfThisDay();
		Assert.assertNotNull(beginOfThisDayDate);
	}

	@Test
	public void beginOfDay() {

		String strDate = "2022-04-16";
		Date date = DateTimeUtil.parse(strDate, DatePattern.DATE_MIDDLE_LINE_PATTERN);

		Date beginOfDayDate = DateTimeUtil.beginOfDay(date);
		String formatDate = DateTimeUtil.format(beginOfDayDate, DatePattern.DATE_MIDDLE_LINE_TIME_COLON_PATTERN);
		Assert.assertEquals("2022-04-16 00:00:00", formatDate);

	}

	@Test
	public void testBeginOfDay() {
		String strDate = "2022-04-16";
		Date date = DateTimeUtil.parse(strDate, DatePattern.DATE_MIDDLE_LINE_PATTERN);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		Date beginOfDayDate = DateTimeUtil.beginOfDay(calendar);
		String formatDate = DateTimeUtil.format(beginOfDayDate, DatePattern.DATE_MIDDLE_LINE_TIME_COLON_PATTERN);
		Assert.assertEquals("2022-04-16 00:00:00", formatDate);
	}

	@Test
	public void testBeginOfDay1() {

		Date beginOfDayDate = DateTimeUtil.beginOfDay(2022,4,16);
		String formatDate = DateTimeUtil.format(beginOfDayDate, DatePattern.DATE_MIDDLE_LINE_TIME_COLON_PATTERN);
		Assert.assertEquals("2022-04-16 00:00:00", formatDate);
	}

	@Test
	public void testBeginOfDay2() {
		Date beginOfDayDate = DateTimeUtil.beginOfDay(2022, 106);
		String formatDate = DateTimeUtil.format(beginOfDayDate, DatePattern.DATE_MIDDLE_LINE_TIME_COLON_PATTERN);
		Assert.assertEquals("2022-04-16 00:00:00", formatDate);
	}

	@Test
	public void endOfThisDay() {
		Date endOfThisDayDate = DateTimeUtil.endOfThisDay();
		Assert.assertNotNull(endOfThisDayDate);
	}

	@Test
	public void endOfDay() {
		String strDate = "2022-04-16";
		Date date = DateTimeUtil.parse(strDate, DatePattern.DATE_MIDDLE_LINE_PATTERN);

		Date endOfDayDate = DateTimeUtil.endOfDay(date);
		String formatDate = DateTimeUtil.format(endOfDayDate, DatePattern.DATE_MIDDLE_LINE_TIME_COLON_PATTERN);
		Assert.assertEquals("2022-04-16 23:59:59", formatDate);

	}

	@Test
	public void testEndOfDay() {
		String strDate = "2022-04-16";
		Date date = DateTimeUtil.parse(strDate, DatePattern.DATE_MIDDLE_LINE_PATTERN);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		Date endOfDayDate = DateTimeUtil.endOfDay(calendar);
		String formatDate = DateTimeUtil.format(endOfDayDate, DatePattern.DATE_MIDDLE_LINE_TIME_COLON_PATTERN);
		Assert.assertEquals("2022-04-16 23:59:59", formatDate);
	}

	@Test
	public void testEndOfDay1() {
		Date endOfDayDate = DateTimeUtil.endOfDay(2022,4,16);
		String formatDate = DateTimeUtil.format(endOfDayDate, DatePattern.DATE_MIDDLE_LINE_TIME_COLON_PATTERN);
		Assert.assertEquals("2022-04-16 23:59:59", formatDate);
	}

	@Test
	public void testEndOfDay2() {
		Date endOfDayDate = DateTimeUtil.endOfDay(2022, 106);
		String formatDate = DateTimeUtil.format(endOfDayDate, DatePattern.DATE_MIDDLE_LINE_TIME_COLON_PATTERN);
		Assert.assertEquals("2022-04-16 23:59:59", formatDate);
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