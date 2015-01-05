package org.polux.entry;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.polux.domain.Teams;
import org.polux.utility.AddItemUtility;

public class HibernateLauncher {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Logger logger = LogManager.getLogger();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss zZ");
		
		String startDate = sdf.format(new Date());
		
		logger.info("Application start at: " + startDate);
		
		logger.info("Building session factory object");
		Configuration config = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
		SessionFactory factory = config.buildSessionFactory(builder.build());
		
		logger.info("Building Item information");
		/*String name = "Mclaren Honda";
		int constructor_champions = 3;
		int last_season = 0;*/
		
		String name = args[0];
		int constructor_champions = Integer.parseInt(args[1]);
		int last_season = Integer.parseInt(args[2]);
		
		Teams t1 = new Teams(name, constructor_champions, last_season);
		
		logger.info("Calling add Utility");
		AddItemUtility addUtility = new AddItemUtility(factory, t1, logger);
		
		addUtility.addItem();
		
		logger.warn("Closing session factory");
		factory.close();
	}
}
