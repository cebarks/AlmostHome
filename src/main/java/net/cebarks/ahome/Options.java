package net.cebarks.ahome;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Options {

	private File configFile;
	HashMap<String, String> config = new HashMap<String, String>();

	public Options(String configPath) {
		configFile = new File(configPath);
		try {
			if (configFile.exists())
				parseConfig();
			else
				configFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void reparse() {
		try {
			parseConfig();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void parseConfig() throws IOException {
		Scanner in = new Scanner(new InputStreamReader(new FileInputStream(configFile)));

		ArrayList<String> rawConfigLines = new ArrayList<String>();

		while (in.hasNext()) {
			String line = in.nextLine();
			rawConfigLines.add(line);
		}

		for (String s : rawConfigLines) {
			String[] ss = s.split("=");
			config.put(ss[0], ss[1]);
		}

		in.close();
	}

	public void saveConfig() throws IOException {
		PrintWriter out = new PrintWriter(configFile);
		for (String s : config.keySet())
			out.write(s + "=" + config.get(s) + "\n");
		out.close();
		System.out.println("Saved Config.");
	}

	public String getValue(String value) {
		return config.get(value);
	}

	public void setValue(String key, Object value) {
		config.remove(key);
		config.put(key, value.toString());
		try {
			saveConfig();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
