package com.cyan.daoImpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cyan.dao.PictureDao;
import com.cyan.entity.Picture;

@Repository
public class PictureDaoImpl implements PictureDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void insert(Picture picture) {
		sessionFactory.getCurrentSession().save(picture);
	}

}
