package oopWithKodlamaioApp.business;

import oopWithKodlamaio.dataAccess.KategoriDao;
import oopWithKodlamaioApp.core.logging.Logger;
import oopWithKodlamaioApp.entities.Kategori;

public class KategoriManager {
	
	private KategoriDao kategoriDao;
	private Logger[] loggers;

	
	public KategoriManager(KategoriDao kategoriDao, Logger[] loggers) {
		
		this.kategoriDao=kategoriDao;
		this.loggers=loggers;
		
	}
	
	
	public void add(Kategori kategori) throws Exception {
		
		for(Kategori nameOfCourses : kategoriDao.getCategories()) {
			
			if(kategori.getName().equals(nameOfCourses.getName()))
				throw new Exception("Kategorinin ismi diğer kategorilerden biriyle aynı olamaz!");
			
			
		}
			kategoriDao.add(kategori);
		
		for(Logger logger : loggers) {
			
			logger.log(kategori.getName());
		}
		
		
	}
	
}

