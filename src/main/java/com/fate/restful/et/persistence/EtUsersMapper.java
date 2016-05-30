package com.fate.restful.et.persistence;

import java.util.List;

import com.fate.restful.et.domain.EtUsers;

public interface EtUsersMapper {
	public List<EtUsers> findAllEtUsers();
	
	public EtUsers findById(long id);
}
