package net.cebarks.ahome.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Version {

	private File configFile;
	private int major;
	private int minor;
	private int build;

	public Version(String configPath) {
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

	private void parseConfig() throws IOException {
		Scanner in = new Scanner(new InputStreamReader(new FileInputStream(configFile)));

		ArrayList<String> rawVersionLines = new ArrayList<String>();

		while (in.hasNext()) {
			String line = in.nextLine();
			rawVersionLines.add(line);
		}

		for (String s : rawVersionLines) {
			String[] ss = s.split("=");
			if(ss[0].equalsIgnoreCase("major")) {
				major = Integer.parseInt(ss[1]);
			}
			if(ss[0].equalsIgnoreCase("minor")) {
				major = Integer.parseInt(ss[1]);
			}
			if(ss[0].equalsIgnoreCase("build")) {
				major = Integer.parseInt(ss[1]);
			}
		}

		in.close();
	}
	
	public int getMajor() {
		return major;
	}

	public int getMinor() {
		return minor;
	}
	
	public int getBuild() {
		return build;
	}
	
	public String getVersion() {
		return major + "." + minor + "." + build;
	}
}
