package com.threesides.tool.date;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * @author Di Wu
 * @date 2023/2/7
 */
public class DateTool {


	public static LocalDateTime getLocalDateTime() {

		return LocalDateTime.now();
	}

	public static LocalDate getLocalDate() {
		return LocalDate.now();
	}

	public static LocalTime getTime() {
	return 	LocalTime.now();
		// return new Time();
	}

	public static Time getTime2() {
		return Time.of(new Date());
		// return Time.now();
	}
}
