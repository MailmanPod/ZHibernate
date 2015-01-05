package org.polux.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.polux.domain.Teams;

public final class UtilityLauncher {

	private Logger logger;
	private SessionFactory factory;

	public UtilityLauncher() {

	}

	public final void entryPoint(String args[]) {
		logger = LogManager.getLogger();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss zZ");

		String startDate = sdf.format(new Date());

		logger.info("Application start at: " + startDate);

		logger.info("Building session factory object");
		Configuration config = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(config.getProperties());
		factory = config.buildSessionFactory(builder.build());

		int option = Integer.parseInt(args[0]);

		switch (option) {
		case 1:
			logger.info("Entry in option 1 - addItem");
			addItem(args);
			break;
		}
	}

	private final void addItem(String args[]) {

		logger.info("Building Item information");

		String name = args[1];
		int constructor_champions = Integer.parseInt(args[2]);
		int last_season = Integer.parseInt(args[3]);

		Teams t1 = new Teams(name, constructor_champions, last_season);

		logger.info("Item Created: " + t1.toString());

		logger.info("Calling add Utility");
		AddItemUtility addUtility = new AddItemUtility(factory, t1);

		addUtility.addItem();

		logger.warn("Closing session factory");
		factory.close();
	}
}
