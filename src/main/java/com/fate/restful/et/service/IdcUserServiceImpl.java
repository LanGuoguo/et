package com.fate.restful.et.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fate.restful.et.domain.IdcUser;
import com.fate.restful.et.persistence.IdcUserMapper;
/**
 * 
 * @author WangGang
 * 2016年05月31日16:39:46
 */
@Service("idcUserService")
public class IdcUserServiceImpl implements IdcUserService {
	@Autowired
	private IdcUserMapper idcUserMapper;

	@Override
	public List<IdcUser> findAllUsers() {
		return idcUserMapper.findAllUsers();
	}

	@Override
	public IdcUser findById(long id) {
		if(id <= 0){
			return null;
		}
		return idcUserMapper.findById(id);
	}

	@Override
	public IdcUser findByModel(IdcUser u) {
		if(u == null){
			return null;
		}
		return idcUserMapper.findByModel(u);
	}

	@Override
	public int add(IdcUser u) {
		if(u == null){
			return 0;
		}
		return idcUserMapper.add(u);
	}

	@Override
	public int modify(IdcUser u) {
		if(u == null || u.getId() <= 0){
			return 0;
		}
		return idcUserMapper.modify(u);
	}

}
