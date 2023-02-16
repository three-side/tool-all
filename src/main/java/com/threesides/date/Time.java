package com.threesides.date;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

import static java.time.temporal.ChronoField.NANO_OF_DAY;

/**
 * @author Di Wu
 * @date 2023/2/8
 */
public final class Time extends Date {

	/**
	 * 每天小时数
	 */
	static final int HOURS_PER_DAY = 24;
	/**
	 * 每小时分钟数
	 */
	static final int MINUTES_PER_HOUR = 60;
	/**
	 * 每天分钟数
	 */
	static final int MINUTES_PER_DAY = MINUTES_PER_HOUR * HOURS_PER_DAY;
	/**
	 * 一分钟秒数
	 */
	static final int SECONDS_PER_MINUTE = 60;
	/**
	 * 一小时秒数
	 */
	static final int SECONDS_PER_HOUR = SECONDS_PER_MINUTE * MINUTES_PER_HOUR;
	/**
	 * 一天秒数
	 */
	static final int SECONDS_PER_DAY = SECONDS_PER_HOUR * HOURS_PER_DAY;
	/**
	 * 一天的毫秒
	 */
	static final long MILLIS_PER_DAY = SECONDS_PER_DAY * 1000L;
	/**
	 * 一天的微妙
	 */
	static final long MICROS_PER_DAY = SECONDS_PER_DAY * 1000_000L;
	/**
	 * 纳米秒
	 */
	static final long NANOS_PER_SECOND = 1000_000_000L;
	/**
	 * 一分钟的纳秒
	 */
	static final long NANOS_PER_MINUTE = NANOS_PER_SECOND * SECONDS_PER_MINUTE;
	/**
	 * 一小时的纳秒
	 */
	static final long NANOS_PER_HOUR = NANOS_PER_MINUTE * MINUTES_PER_HOUR;
	/**
	 * 一天的纳秒
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
