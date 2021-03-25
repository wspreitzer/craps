package com.williamspreitzer.craps.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;

public class CrapsUtils {

	public static final short TABLE_MINIMUM = 10;
	public static final Properties props = getProperties();
	public static byte ZERO = (byte) 0;

	private static byte point;
	private static boolean isSmallBetWon;
	private static boolean isTallBetWon;
	
	public static byte getPoint() {
		return point;
	}
	
	public static void setPoint(byte point) {
		CrapsUtils.point = point;
	}
	
	public static boolean isSmallBetWon() {
		return isSmallBetWon;
	}
	
	public static boolean isTallBetWon() {
		return isTallBetWon;
	}
	
	public static void setIsTallBetWon(boolean isTallBetWon) {
		CrapsUtils.isTallBetWon = isTallBetWon; 
	}
	
	public static void setIsSmallBetWon(boolean isSmallBetWon) {
		CrapsUtils.isSmallBetWon = isSmallBetWon;
	}
	private static Properties getProperties() {
		Properties props = new Properties();
		try {
			FileInputStream fis = new FileInputStream(new File(CrapsUtils.class.getResource("/craps.properties").toURI()));
			props.load(fis);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return props;
	}
}