package org.polux.entry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.polux.domain.Teams;
import org.polux.utility.AddItemUtility;

public class HibernateEntry {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Logger logger = LogManager.getLogger();
		
		Configuration config = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
		SessionFactory factory = config.buildSessionFactory(builder.build());
		
		String name = "Mercedes Petronas";
		int constructor_champions = 3;
		int last_season = 1;
		Teams t1 = new Teams(name, constructor_champions, last_season);
		
		AddItemUtility addUtility = new AddItemUtility(factory, t1, logger);
		
		addUtility.addItem();
		
		factory.close();
	}
}
