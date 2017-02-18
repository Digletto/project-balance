package utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConfigReader {
	Scanner cfgScanner;
	String cfgPath;
	File cfgFile;
	ArrayUtility arrayUtil = new ArrayUtility();

	public ConfigReader(String cfgPath) {
		this.cfgPath = cfgPath;
		this.cfgFile = new File(cfgPath);
	}

	public String[] loadActorTypes() {
		ArrayList<String> types = new ArrayList<String>();
		restartCfgScanner();
		String currentLine;
		while (cfgScanner.hasNextLine()) {
			currentLine = cfgScanner.nextLine();
			if (currentLine.startsWith("$")) {
				types.add((currentLine.substring(1)));
			}
		}
		cfgScanner.close();
		return arrayUtil.arrayListToArray(types);
	}

	public String[] loadStats(String type) {
		restartCfgScanner();
		ArrayList<String> stats = new ArrayList<String>();
		String currentLine;
		while (cfgScanner.hasNextLine()) {
			currentLine = cfgScanner.nextLine();
			if (currentLine.startsWith("@" + type)) {
				currentLine = cfgScanner.nextLine();
				while (!currentLine.contains(">@")) {
					stats.add(currentLine);
					currentLine = cfgScanner.nextLine();
				}
			}
		}
		cfgScanner.close();
		return arrayUtil.arrayListToArray(stats);
	}

	private void restartCfgScanner() {
		try {
			cfgScanner = new Scanner(cfgFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}