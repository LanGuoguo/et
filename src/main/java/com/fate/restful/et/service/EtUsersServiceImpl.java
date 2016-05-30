package com.fate.restful.et.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fate.restful.et.domain.EtUsers;
import com.fate.restful.et.persistence.EtUsersMapper;

@Service("etUsersService")
public class EtUsersServiceImpl implements EtUsersService {
	@Autowired
	private EtUsersMapper etUsersMapper;
	
	@Override
	public List<EtUsers> findAllEtUsers() {
		return etUsersMapper.findAllEtUsers();
	}

	@Override
	public EtUsers findById(long id) {
		return etUsersMapper.findById(id);
	}

}
