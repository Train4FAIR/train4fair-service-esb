package de.fraunhofer.fit.train.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.CRC32;
import java.util.zip.Checksum;

import javax.xml.bind.DatatypeConverter;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import de.fraunhofer.fit.train.facade.ServiceFacade;
import de.fraunhofer.fit.train.model_v2.nodered.BasicMetadataNoderedNODE;

@EnableAspectJAutoProxy
@RestController
@Service
public class TrainUtil {
	
	
    @Autowired
    private ServiceFacade facade;
    
    
	public  static String  ByteArrayToString(byte[] arr) {
		String str = new String(arr);
		return str;

	}
	

	public static String getChechSumCRC32ByByteArray(byte[] byteArr){
		
		String str = "Generate CRC32 Checksum For Byte Array Example";
		
		//Convert string to bytes
		byte bytes[] = str.getBytes();
		
		Checksum checksum = new CRC32();
		
		/*
		 * To compute the CRC32 checksum for byte array, use
		 * 
		 * void update(bytes[] b, int start, int length)
		 * method of CRC32 class.
		 */
		 
		checksum.update(bytes,0,bytes.length);
		
		/*
		 * Get the generated checksum using
		 * getValue method of CRC32 class.
		 */
		long lngChecksum = checksum.getValue();
		
		System.out.println("CRC32 checksum for byte array is :" + lngChecksum);
		
		return  Long.toString(lngChecksum);
	}

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

	public static void showFieldValue(Object inputObj, String classname) {

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
	

	public String readFile(String file) throws IOException {
	    BufferedReader reader = new BufferedReader(new FileReader (file));
	    String         line = null;
	    StringBuilder  stringBuilder = new StringBuilder();
	    String         ls = System.getProperty("line.separator");

	    try {
	        while((line = reader.readLine()) != null) {
	            stringBuilder.append(line);
	            stringBuilder.append(ls);
	        }

	        return stringBuilder.toString();
	    } finally {
	        reader.close();
	    }
	}
	
	//==
	
    private static final boolean IS_CHUNKED = true;


    /**
     * This method converts the content of a source file into Base64 encoded data and saves that to a target file.
     * If isChunked parameter is set to true, there is a hard wrap of the output  encoded text.
     */
    public static void encode(String sourceFile, String targetFile, boolean isChunked) throws Exception {

        byte[] base64EncodedData = org.apache.commons.codec.binary.Base64.encodeBase64(loadFileAsBytesArray(sourceFile), isChunked);

        writeByteArraysToFile(targetFile, base64EncodedData);
    }

    public static void decode(String sourceFile, String targetFile) throws Exception {

        byte[] decodedBytes = org.apache.commons.codec.binary.Base64.decodeBase64(loadFileAsBytesArray(sourceFile));

        writeByteArraysToFile(targetFile, decodedBytes);
    }

    /**
     * This method loads a file from file system and returns the byte array of the content.
     * 
     * @param fileName
     * @return
     * @throws Exception
     */
    public static byte[] loadFileAsBytesArray(String fileName) throws Exception {

        File file = new File(fileName);
        int length = (int) file.length();
        BufferedInputStream reader = new BufferedInputStream(new FileInputStream(file));
        byte[] bytes = new byte[length];
        reader.read(bytes, 0, length);
        reader.close();
        return bytes;

    }

    /**
     * This method writes byte array content into a file.
     * 
     * @param fileName
     * @param content
     * @throws IOException
     */
    public static void writeByteArraysToFile(String fileName, byte[] content) throws IOException {

        File file = new File(fileName);
        BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(file));
        writer.write(content);
        writer.flush();
        writer.close();

    }

	public String convertTwoDimensionsArrIntoStr(String[][] wires, String internalId) {
		BasicMetadataNoderedNODE[] wagonNodeArr = facade.findWagonsArrByInternalId(internalId);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<wagonNodeArr.length;i++) {
        	BasicMetadataNoderedNODE wagonNode = wagonNodeArr[i];
        	for(int j=0;j<wagonNode.getWires().length;j++) {
        		String wiresArr[] = wagonNode.getWires()[j];
        		for(int h = 0; h<wiresArr.length;h++) {
        			String wireStr =  wiresArr[h];
        			sb.append(wireStr);
        			sb.append("%");
        		}
        	}

        }
        String result = sb.toString();
        if(result.endsWith("%")) {
        	result = result.substring(0, result.length()-1);
        }
        
        System.out.println(result);
		return result;
	}

}
