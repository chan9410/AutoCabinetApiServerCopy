package com.example.demo.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

	public static LocalDateTime getCurrentDate() {
		return LocalDateTime.now();
	}

	public static String getString(String format) {
		return getString(LocalDateTime.now(), format);

	}

	public static String getString(LocalDateTime date, String format) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
		return date.format(formatter);
	}
}
