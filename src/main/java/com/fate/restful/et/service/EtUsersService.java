package com.fate.restful.et.service;

import java.util.List;

import com.fate.restful.et.domain.EtUsers;

public interface EtUsersService {
	public List<EtUsers> findAllEtUsers();
	
	public EtUsers findById(long id);
}
