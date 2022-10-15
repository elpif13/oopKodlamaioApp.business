package oopWithKodlamaioApp.business;

import oopWithKodlamaioApp.core.logging.*;

import oopWithKodlamaio.dataAccess.EğitmenDao;
import oopWithKodlamaioApp.entities.Eğitmen;

public class EğitmenManager {
	
	private EğitmenDao eğitmenDao;
	private Logger[] loggers;
	
	public EğitmenManager(EğitmenDao eğitmenDao, Logger[] loggers) {
		
		this.eğitmenDao=eğitmenDao;
		this.loggers=loggers;
	}
	
	public void add(Eğitmen eğitmen) {
		
		eğitmenDao.add(eğitmen);
		
		for(Logger logger : loggers) {
			logger.log(eğitmen.getName());
		}
	}
	
	

}
