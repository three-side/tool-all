package com.threesides.date;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.format.DatePrinter;
import cn.hutool.core.util.ObjectUtil;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Di Wu
 * @date 2023/2/8
 */
public class DateTime extends Date {

	public static DateTime now() {
		return new DateTime();
	}

	public static DateTime of(Date date) {
		if (date instanceof DateTime) {
			return (DateTime) date;
		}
		return new DateTime(date);
	}

	public static DateTime of(Calendar calendar) {
		return new DateTime(calendar);
	}

	public static DateTime of(long timeMillis) {
		return new DateTime(timeMillis);
	}

	private DateTime() {
		this(System.currentTimeMillis());
	}

	private DateTime(Date date) {
		this(ObjectUtil.defaultIfNull(date, new Date()).getTime());
	}

	public DateTime(Calendar calendar) {
		this(calendar.getTime());
	}

	public DateTime(long timeMillis) {
		super(timeMillis);

	}

	@Override
	public String toString() {
		return toString(DatePattern.NORM_DATETIME_FORMAT);
	}

	public String toString(DatePrinter format) {
		return format.format(this);
	}

}
