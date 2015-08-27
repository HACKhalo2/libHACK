package com.hackhalo2.libhack.gdx.util;

import java.io.IOException;
import java.io.OutputStream;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;
import com.hackhalo2.libhack.util.IOHandler;

/**
 * A JSON Helper class designed to, well, help deal with JSON files.
 * @author hackhalo2
 *
 */
public class JSONHandler {
	private static Json jason;

	private JSONHandler() { }
	
	public static <T> T readJSONFile(Class<T> clazz, FileHandle handle) {
		String input = new String(handle.readBytes(), IOHandler.UTF8);
		return jason.fromJson(clazz, input);
	}
	
	public static void writeJSONFile(String json, FileHandle handle) {
		JSONHandler.writeJSONFile(json, handle, false);
	}
	
	public static void writeJSONFile(String json, FileHandle handle, boolean append) {
		byte[] array = json.getBytes(IOHandler.UTF8);
		OutputStream out = handle.write(append);
		
		try {
			out.write(array);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
