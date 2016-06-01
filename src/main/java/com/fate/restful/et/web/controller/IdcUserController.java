package com.fate.restful.et.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fate.restful.et.domain.IdcUser;
import com.fate.restful.et.service.IdcUserService;

/**
 * 
 * @author WangGang
 * 2016年05月31日16:45:56
 */
@RestController
public class IdcUserController {
	@Autowired
	private IdcUserService idcUserService;
	
	/**
	 * Retrieve All Users
	 * @return
	 */
	@RequestMapping(value="/idcUsers", method=RequestMethod.GET)
	public ResponseEntity<List<IdcUser>> ListAllUsers(){
		List<IdcUser> list = idcUserService.findAllUsers();
		if(CollectionUtils.isEmpty(list)) return new ResponseEntity<List<IdcUser>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<IdcUser>>(list, HttpStatus.OK);
	}
	
	/**
	 * Retrieve An User By Id
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/idcUser/{id}", method=RequestMethod.GET)
	public ResponseEntity<IdcUser> getById(@PathVariable("id") long id){
		if(id <= 0) return new ResponseEntity<IdcUser>(HttpStatus.PRECONDITION_FAILED);
		IdcUser u = idcUserService.findById(id);
		if(u == null) return new ResponseEntity<IdcUser>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<IdcUser>(u, HttpStatus.OK);
	}
	
	/**
	 * Retrieve an user by model
	 * @param request
	 * @param u
	 * @return
	 */
	@RequestMapping(value="/idcUser/model", method=RequestMethod.POST)
	public ResponseEntity<IdcUser> getByModel(HttpServletRequest request, @RequestBody IdcUser u){
		if(u == null) return new ResponseEntity<IdcUser>(HttpStatus.PRECONDITION_FAILED);
		IdcUser rst = idcUserService.findByModel(u);
		if(rst == null) return new ResponseEntity<IdcUser>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<IdcUser>(rst, HttpStatus.OK);
	}
	
	/**
	 * Add an user
	 * @param request
	 * @param u
	 * @return
	 */
	@RequestMapping(value="/idcUser/add", method=RequestMethod.POST)
	public ResponseEntity<String> add(HttpServletRequest request, @RequestBody IdcUser u){
		if(u == null) return new ResponseEntity<String>("IdcUser param can not be null", HttpStatus.PRECONDITION_FAILED);
		if(u.getUserCode() == null) {
			IdcUser u4Code = new IdcUser();
			String uCode = "UC_" + RandomStringUtils.randomAlphanumeric(8).toUpperCase();
			u4Code.setUserCode(uCode);
			while(idcUserService.findByModel(u4Code) != null){
				uCode = "UC_" + RandomStringUtils.randomAlphanumeric(8).toUpperCase();
				u4Code.setUserCode(uCode);
			}
			u.setUserCode(uCode);
		}
		if(u.getUserLevel() == null) u.setUserLevel("normal");
		if(u.getUserGroup() == null) u.setUserGroup("basic");
		int line = idcUserService.add(u);
		if(line <= 0) return new ResponseEntity<String>("add failed", HttpStatus.EXPECTATION_FAILED);
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}
	
	/**
	 * Modify an user
	 * @param request
	 * @param u
	 * @return
	 */
	@RequestMapping(value="/idcUser/modify", method=RequestMethod.PUT)
	public ResponseEntity<String> modify(HttpServletRequest request, @RequestBody IdcUser u){
		if(u == null) return new ResponseEntity<String>("IdcUser param can not be null", HttpStatus.NOT_MODIFIED);
		if(u.getId() <= 0) return new ResponseEntity<String>("IdcUser.id can not less than or equal 0", HttpStatus.NOT_MODIFIED);
		int line = idcUserService.modify(u);
		if(line <= 0) return new ResponseEntity<String>(HttpStatus.NOT_MODIFIED);
		return new ResponseEntity<String>(HttpStatus.ACCEPTED);
	}
}
