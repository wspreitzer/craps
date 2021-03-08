package com.williamspreitzer.craps.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.williamspreitzer.craps.roll.Dice;

public class CrapsUtils {

	private static byte point;
	private static final List<Byte> rollTracker = new ArrayList<Byte>();
	private static final List<Byte> pointTracker = new ArrayList<Byte>();
	private static Map<Integer, Dice> diceTracker = new HashMap<Integer, Dice>();	
	public static final short TABLE_MINIMUM = 10;
	public static final Properties props = getProperties();
	public static byte ZERO = (byte) 0;

	public static byte getPoint() {
		return point;
	}
	
	public static List<Byte> getRollTracker() {
		return rollTracker;
	}
	
	public static List<Byte> getPointTracker() {
		return pointTracker;
	}
	
	public static Map<Integer, Dice> getDiceTracker() {
		return diceTracker;
	}
	
	public static void setPoint(byte point) {
		CrapsUtils.point = point;
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