package com.toure.project.service.implement;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.uploader.UploadMetaData;
import com.toure.project.service.FlickrService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ImplFlickrService implements FlickrService {
	
	
	private Flickr flickr;
	
	@Autowired
	public ImplFlickrService(Flickr flick) {
		this.flickr = flick;
	}
		

	@Override
	public String savePhoto(InputStream photo, String title) throws FlickrException  {
		
		UploadMetaData uploadM = new UploadMetaData();
		uploadM.setTitle(title);
		
		String photoId = flickr.getUploader().upload(photo, uploadM);

		return flickr.getPhotosInterface().getPhoto(photoId).getMedium640Url();
	}

}
