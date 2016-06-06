package com.data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class FilterService {

	public FilterService() {
		
	}

	private static String deleteSpace(String S) {
		String out = S.trim();
		out = out.replaceAll("[ ]", "");
		return out;
	}
	public void exportToFile(File FileIn, File FileOut) {
		try {
			FileInputStream fileInputStream = new FileInputStream(FileIn);
			FileOutputStream fileOutputStream = new FileOutputStream(FileOut);
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
			
			String lineIn, lineOut;
			while ((lineIn = reader.readLine()) != null) {
				
				String buffStr[] = lineIn.trim().split("[/,]");
				lineOut = deleteSpace(buffStr[buffStr.length - 1]);
				writer.write(lineOut + System.lineSeparator());
				writer.flush();
			}
			reader.close();
			writer.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error");
			e.printStackTrace();
		}
		
	}
	public void fixInsideFile(File FileIn) {
		try {
			FileInputStream fileInputStream = new FileInputStream(FileIn);
			
			List<String> temp = new ArrayList<>();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));
	
			
			String lineIn;
			while ((lineIn = reader.readLine()) != null) {
				
				String buff = lineIn.replaceAll("[ ]", "");
				temp.add(buff);
			}			
			reader.close();
			
			FileOutputStream fileOutputStream = new FileOutputStream(FileIn);
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
			for (String string : temp) {
				writer.write(string + System.lineSeparator());
				writer.flush();
			}
			writer.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error");
			e.printStackTrace();
		}
	}
}
