package com.threesides.tool.date;

import java.time.*;
import java.time.chrono.IsoChronology;
import java.util.Objects;

import static com.threesides.tool.date.Time.SECONDS_PER_DAY;
import static java.time.temporal.ChronoField.*;


/**
 * @author Di Wu
 * @date 2023/2/8
 */
public class Date extends java.util.Date {
	private static final int DAYS_PER_CYCLE = 146097;
	static final long DAYS_0000_TO_1970 = (DAYS_PER_CYCLE * 5L) - (30L * 365L + 7L);

	private final int year;
	/**
	 * The month-of-year.
	 */
	private final short month;
	/**
	 * The day-of-month.
	 */
	private final short day;

	private Date(int year, int month, int dayOfMonth) {
		this.year = year;
		this.month = (short) month;
		this.day = (short) dayOfMonth;
	}

	public static Date now() {
		return now(Clock.systemDefaultZone());
	}

	public static Date of(int year, Month month, int dayOfMonth) {
		YEAR.checkValidValue(year);
		Objects.requireNonNull(month, "month");
		DAY_OF_MONTH.checkValidValue(dayOfMonth);
		return create(year, month.getValue(), dayOfMonth);
	}

	public static Date of(int year, int month, int dayOfMonth) {
		YEAR.checkValidValue(year);
		MONTH_OF_YEAR.checkValidValue(month);
		DAY_OF_MONTH.checkValidValue(dayOfMonth);
		return create(year, month, dayOfMonth);
	}

	public static Date now(Clock clock) {
		Objects.requireNonNull(clock, "clock");
		// inline to avoid creating object and Instant checks
		final Instant now = clock.instant();  // called once
		ZoneOffset offset = clock.getZone().getRules().getOffset(now);
		long epochSec = now.getEpochSecond() + offset.getTotalSeconds();  // overflow caught later
		long epochDay = Math.floorDiv(epochSec, SECONDS_PER_DAY);
		return Date.ofEpochDay(epochDay);
	}

	public static Date ofEpochDay(long epochDay) {
		long zeroDay = epochDay + DAYS_0000_TO_1970;
		// find the march-based year
		zeroDay -= 60;  // adjust to 0000-03-01 so leap day is at end of four year cycle
		long adjust = 0;
		if (zeroDay < 0) {
			// adjust negative years to positive for calculation
			long adjustCycles = (zeroDay + 1) / DAYS_PER_CYCLE - 1;
			adjust = adjustCycles * 400;
			zeroDay += -adjustCycles * DAYS_PER_CYCLE;
		}
		long yearEst = (400 * zeroDay + 591) / DAYS_PER_CYCLE;
		long doyEst = zeroDay - (365 * yearEst + yearEst / 4 - yearEst / 100 + yearEst / 400);
		if (doyEst < 0) {
			// fix estimate
			yearEst--;
			doyEst = zeroDay - (365 * yearEst + yearEst / 4 - yearEst / 100 + yearEst / 400);
		}
		yearEst += adjust;  // reset any negative year
		int marchDoy0 = (int) doyEst;

		// convert march-based values back to january-based
		int marchMonth0 = (marchDoy0 * 5 + 2) / 153;
		int month = (marchMonth0 + 2) % 12 + 1;
		int dom = marchDoy0 - (marchMonth0 * 306 + 5) / 10 + 1;
		yearEst += marchMonth0 / 10;

		// check year now we are certain it is correct
		int year = YEAR.checkValidIntValue(yearEst);
		return new Date(year, month, dom);
	}

	private static Date create(int year, int month, int dayOfMonth) {
		if (dayOfMonth > 28) {
			int dom = 31;
			switch (month) {
				case 2:
					dom = (IsoChronology.INSTANCE.isLeapYear(year) ? 29 : 28);
					break;
				case 4:
				case 6:
				case 9:
				case 11:
					dom = 30;
					break;
			}
			if (dayOfMonth > dom) {
				if (dayOfMonth == 29) {
					throw new DateTimeException("Invalid date 'February 29' as '" + year + "' is not a leap year");
				} else {
					throw new DateTimeException("Invalid date '" + Month.of(month).name() + " " + dayOfMonth + "'");
				}
			}
		}
		return new Date(year, month, dayOfMonth);
	}


	@Override
	public String toString() {
		int yearValue = year;
		int monthValue = month;
		int dayValue = day;
		int absYear = Math.abs(yearValue);
		StringBuilder buf = new StringBuilder(10);
		if (absYear < 1000) {
			if (yearValue < 0) {
				buf.append(yearValue - 10000).deleteCharAt(1);
			} else {
				buf.append(yearValue + 10000).deleteCharAt(0);
			}
		} else {
			if (yearValue > 9999) {
				buf.append('+');
			}
			buf.append(yearValue);
		}
		return buf.append(monthValue < 10 ? "-0" : "-")
				.append(monthValue)
				.append(dayValue < 10 ? "-0" : "-")
				.append(dayValue)
				.toString();
	}
}
