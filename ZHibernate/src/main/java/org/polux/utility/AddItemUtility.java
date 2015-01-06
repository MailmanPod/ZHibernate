package org.polux.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.polux.domain.Engine;
import org.polux.domain.Teams;

public class AddItemUtility {

	private SessionFactory sessionLocal;
	
	private Teams itemIn;
	private Engine itemInG;
	
	private Logger localLogger;

	public AddItemUtility(SessionFactory sessionLocal) {
		this.sessionLocal = sessionLocal;
		this.localLogger = LogManager.getLogger();
	}

	public void setItemTeam(Teams itemIn){
		this.itemIn=itemIn;
	}
	
	public void setItemEngine(Engine itemIn){
		this.itemInG = itemIn;
	}
	
	public Long addItemTeam() {
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
	
	public Long addItemEngine(){
		Session session = sessionLocal.openSession();
		Transaction tx = null;
		Long engineId = null;
		
		try{
			localLogger.info("Begin Tx for Engine objects");
			tx = session.beginTransaction();
			Engine eng = this.itemInG;
			
			localLogger.info("Saving new Engine");
			engineId = (Long) session.save(eng);
			
			localLogger.info("Begin commit");
			tx.commit();
		}catch(HibernateException hex){
			localLogger.error("Error inserting new Engine");
			localLogger.error(hex.getMessage());
			if(tx != null){
				tx.rollback();
			}
		}finally{
			localLogger.warn("Closing Session");
			session.close();
		}
		return engineId;
	}
}
