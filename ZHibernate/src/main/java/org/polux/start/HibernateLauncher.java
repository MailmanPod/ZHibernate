package org.polux.start;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.polux.utility.UtilityLauncher;

public class HibernateLauncher {

	private static ArrayList<String> commandOptions = new ArrayList<String>(4);
	private static Logger logger = LogManager.getLogger();

	private static void fillOptions() {
		commandOptions.add("-a");
		commandOptions.add("-u");
		commandOptions.add("-d");
		commandOptions.add("-l");
	}

	private static boolean findOptions(String option) {

		boolean flag = false;

		for (String op : commandOptions) {
			if (op.equalsIgnoreCase(option)) {
				flag = true;
				break;
			}
		}

		return flag;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String option = args[0];

		fillOptions();

		if (findOptions(option)) {
			UtilityLauncher launcher = new UtilityLauncher();
			launcher.entryPoint(args);
		} else {
			logger.warn("Incorrect Option");
			logger.warn("Usage: " + commandOptions.toString().toString());
		}
	}
}
