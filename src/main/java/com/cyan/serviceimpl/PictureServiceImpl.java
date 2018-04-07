package com.cyan.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyan.dao.PictureDao;
import com.cyan.entity.Picture;
import com.cyan.service.PictureService;

@Service
public class PictureServiceImpl implements PictureService{

	@Autowired
	private PictureDao pictureDao;
	
	@Transactional
	@Override
	public void uploadPictures(Integer productId, List<String> paths) {
		
		paths.parallelStream().forEach( path -> {
			Picture picture = new Picture();
			picture.setPath(path);
			picture.setProductId(productId);
			pictureDao.insert(picture);
		});
	}
	
}
