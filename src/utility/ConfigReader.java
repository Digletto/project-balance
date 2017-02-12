package utility;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ConfigReader {
	Stream<String> configStream;
	String configPath;
	
	public ConfigReader(String configPath) {
		this.configPath = configPath;		
	}
	
	
}
