package com.accessmanagement.dao;

import java.util.ArrayList;

import com.accessmanagement.model.Software;

public interface SoftwareDao {
	
	int addSoftware(Software software);
	Software getSoftware(String softwareName);
	ArrayList<Software> getAllSoftware();
}
