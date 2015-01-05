package org.polux.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.polux.domain.Teams;

public class AddItemUtility {

	private SessionFactory sessionLocal;
	private Teams itemIn;
	private Logger localLogger;

	public AddItemUtility(SessionFactory sessionLocal, Teams itemIn) {
		this.sessionLocal = sessionLocal;
		this.itemIn = itemIn;
		this.localLogger = LogManager.getLogger();
	}

	public Long addItem() {
		Session session = sessionLocal.openSession();
		Transaction tx = null;
		Long teamID = null;

		try {
			localLogger.info("Begin TX");

			tx = session.beginTransaction();
			Teams newTeam = itemIn;

			localLogger.info("Saving new Team");
			teamID = (Long) session.save(newTeam);

			localLogger.info("Commit");
			tx.commit();

		} catch (HibernateException hex) {
			if (tx != null) {
				tx.rollback();
			}

			localLogger.error("Error inserting new team");
			localLogger.error(hex.getMessage());

		} finally {

			localLogger.warn("Closing connection");
			session.close();
		}

		return teamID;
	}
}
