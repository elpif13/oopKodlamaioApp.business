package oopWithKodlamaioApp.business;

import oopWithKodlamaio.dataAccess.KursDao;

import oopWithKodlamaioApp.core.logging.Logger;
import oopWithKodlamaioApp.entities.Kurs;

public class KursManager {
	
	private KursDao kursDao;
	private Logger[] loggers;
	
	
	public KursManager(KursDao kursDao, Logger[] loggers) {
		
		this.kursDao=kursDao;
		this.loggers=loggers;
	}
	
	public void add(Kurs kurs) throws Exception {
		
		if(kurs.getPrice()<0) {
			
			throw new Exception("Kursun fiyatı sıfırdan küçük olamaz!");
		}
		
		for(Kurs nameOfCourses : kursDao.getCourses()) {
			if(kurs.getName().equals(nameOfCourses.getName()))
				throw new Exception("Kursun ismi diğer kurslardan biriyle aynı olamaz!");
		}
		
	
         	kursDao.add(kurs);
		 
		for(Logger logger: loggers) {
			
		  logger.log(kurs.getName());
		}
	}
	

}
