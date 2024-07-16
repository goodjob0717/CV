package com.boot.service;

import java.util.HashMap;

import com.boot.dto.CVDTO;

public interface CVService {
//	insert
	public void write(CVDTO cv);
	
	
	public void cv_save(CVDTO cv);
//	select
	public CVDTO contentView(HashMap<String, String> param);
//	update
	public void cv_modify(HashMap<String, String> param);
}