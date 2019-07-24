package de.fraunhofer.fit.train.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

import org.apache.commons.io.FileUtils;

public class TrainUtil {

	public static String getChecksum(Serializable object) throws IOException, NoSuchAlgorithmException {
		ByteArrayOutputStream baos = null;
		ObjectOutputStream oos = null;
		try {
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(object);
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] thedigest = md.digest(baos.toByteArray());
			return DatatypeConverter.printHexBinary(thedigest);
		} finally {
			oos.close();
			baos.close();
		}
	}

	public static void deleteDirectoryRecursionJava6(File file) throws IOException {
		if (file.isDirectory()) {
			File[] entries = file.listFiles();
			if (entries != null) {
				for (File entry : entries) {
					deleteDirectoryRecursionJava6(entry);
				}
			}
		}
		if (!file.delete()) {
			throw new IOException("Failed to delete " + file);
		}
	}

	public static String readFileToStr(String filePath) throws IOException {
		File file = new File(filePath);
		return FileUtils.readFileToString(file, StandardCharsets.UTF_8);
	}

	public static String readFileToStr(File file) throws IOException {
		return FileUtils.readFileToString(file, StandardCharsets.UTF_8);
	}

	public static void showMehotsVakue(Object inputObj, String classname) {

		try {
			Class cls = Class.forName(classname);
			Object obj = cls.newInstance();
			Method[] methods = cls.getDeclaredMethods();
			for (int i = 0; i < methods.length; i++) {
				System.out.println("Method Name--->>>" + methods[i].getName());
				System.out.println("Method Return Type--->>>" + methods[i].getReturnType());
				methods[i].setAccessible(true);
				System.out.println("Method Value--->>>" + methods[i].invoke(obj));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void showFieldVakue(Object inputObj, String classname) {

		try {
			Class cls = Class.forName(classname);
			Object obj = cls.newInstance();
			Field[] fields = cls.getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				fields[i].setAccessible(true);
				System.out.println("Field Name-->" + fields[i].getName() + "\t" + "Field Type-->"
						+ fields[i].getType().getName() + "\t" + "Field Value-->" + fields[i].get(obj));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
