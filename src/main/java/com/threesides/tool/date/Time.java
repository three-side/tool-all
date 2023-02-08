package com.threesides.tool.date;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

import static java.time.temporal.ChronoField.NANO_OF_DAY;
import static java.time.temporal.ChronoField.SECOND_OF_DAY;

/**
 * @author Di Wu
 * @date 2023/2/8
 */
public final class Time extends Date {

	/**
	 * Hours per day.
	 */
	static final int HOURS_PER_DAY = 24;
	/**
	 * Minutes per hour.
	 */
	static final int MINUTES_PER_HOUR = 60;
	/**
	 * Minutes per day.
	 */
	static final int MINUTES_PER_DAY = MINUTES_PER_HOUR * HOURS_PER_DAY;
	/**
	 * Seconds per minute.
	 */
	static final int SECONDS_PER_MINUTE = 60;
	/**
	 * Seconds per hour.
	 */
	static final int SECONDS_PER_HOUR = SECONDS_PER_MINUTE * MINUTES_PER_HOUR;
	/**
	 * Seconds per day.
	 */
	static final int SECONDS_PER_DAY = SECONDS_PER_HOUR * HOURS_PER_DAY;
	/**
	 * Milliseconds per day.
	 */
	static final long MILLIS_PER_DAY = SECONDS_PER_DAY * 1000L;
	/**
	 * Microseconds per day.
	 */
	static final long MICROS_PER_DAY = SECONDS_PER_DAY * 1000_000L;
	/**
	 * Nanos per second.
	 */
	static final long NANOS_PER_SECOND = 1000_000_000L;
	/**
	 * Nanos per minute.
	 */
	static final long NANOS_PER_MINUTE = NANOS_PER_SECOND * SECONDS_PER_MINUTE;
	/**
	 * Nanos per hour.
	 */
	static final long NANOS_PER_HOUR = NANOS_PER_MINUTE * MINUTES_PER_HOUR;
	/**
	 * Nanos per day.
	 */
	static final long NANOS_PER_DAY = NANOS_PER_HOUR * HOURS_PER_DAY;
	private final byte hour;

	private final byte minute;

	private final byte second;

	private Time(int hour, int minute, int second) {
		this.hour = (byte) hour;
		this.minute = (byte) minute;
		this.second = (byte) second;
	}


	public static Time now() {
		return now(Clock.systemDefaultZone());
	}

	public static Time of(Date date) {
		if (date instanceof Time) {
			return (Time) date;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return of(calendar);
	}
	public static Time of(Calendar calendar) {
		int hours = calendar.get(Calendar.HOUR);// 小时
		int minutes = calendar.get(Calendar.MINUTE);// 分
		int seconds = calendar.get(Calendar.SECOND);// 秒
		return create(hours, minutes, seconds);
	}


	private static Time now(Clock clock) {
		Objects.requireNonNull(clock, "clock");
		final Instant now = clock.instant();  // called once
		ZoneOffset offset = clock.getZone().getRules().getOffset(now);
		long localSecond = now.getEpochSecond() + offset.getTotalSeconds();  // overflow caught later
		int secsOfDay = (int) Math.floorMod(localSecond, SECONDS_PER_DAY);
		return ofNanoOfDay(secsOfDay * NANOS_PER_SECOND + now.getNano());
	}

	public static Time ofSecondOfDay(long secondOfDay) {
		// SECOND_OF_DAY.checkValidValue(secondOfDay);
		int hours = (int) (secondOfDay / SECONDS_PER_HOUR);
		secondOfDay -= hours * SECONDS_PER_HOUR;
		int minutes = (int) (secondOfDay / SECONDS_PER_MINUTE);
		secondOfDay -= minutes * SECONDS_PER_MINUTE;
		return create(hours, minutes, (int) secondOfDay);
	}

	private static Time ofNanoOfDay(long nanoOfDay) {
		NANO_OF_DAY.checkValidValue(nanoOfDay);
		int hours = (int) (nanoOfDay / NANOS_PER_HOUR);
		nanoOfDay -= hours * NANOS_PER_HOUR;
		int minutes = (int) (nanoOfDay / NANOS_PER_MINUTE);
		nanoOfDay -= minutes * NANOS_PER_MINUTE;
		int seconds = (int) (nanoOfDay / NANOS_PER_SECOND);

		return create(hours, minutes, seconds);
	}


	private static Time create(int hour, int minute, int second) {
		return new Time(hour, minute, second);
	}

	@Override
	public String toString() {
		int hourValue = hour;
		int minuteValue = minute;
		int secondValue = second;
		return (hourValue < 10 ? "0" : "") + hourValue +
				(minuteValue < 10 ? ":0" : ":") + minuteValue +
				(secondValue < 10 ? ":0" : ":") + secondValue;
	}

}
