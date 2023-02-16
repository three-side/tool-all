package com.threesides.date.tool;


import com.threesides.date.Date;
import com.threesides.date.DateTime;
import com.threesides.date.Time;

import java.util.Calendar;


/**
 * @author Di Wu
 * @date 2023/2/7
 */
public class DateTool {


	// TODO DateTime ----------------------------------------------------------------
	public static DateTime getDateTime() {
		return DateTime.now();
	}

	public static DateTime getDateTime( java.util.Date date) {
		return DateTime.of(date);
	}

	public static DateTime getDateTime(Calendar calendar) {
		return DateTime.of(calendar);
	}




	//  TODO Date ----------------------------------------------------------------
	public static Date getDate(java.util.Date date) {
		return Date.of(date);
	}

	public static Date getDate(Calendar calendar) {
		return Date.of(calendar);
	}

	public static Date getDate() {
		return Date.now();
	}

	// TODO Time ----------------------------------------------------------------

	public static Time getTime() {
		return Time.now();
	}

	public static Time getTime(java.util.Date date) {
		return Time.of(date);

	}

	public static Time getTime(Calendar calendar) {
		return Time.of(calendar);
	}
}
