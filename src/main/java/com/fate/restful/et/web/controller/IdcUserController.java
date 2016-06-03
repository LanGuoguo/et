package com.fate.restful.et.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fate.restful.et.common.bean.ReqResult;
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
	@RequestMapping(value="/restApi/idcUsers", method=RequestMethod.GET)
	public ResponseEntity<ReqResult> ListAllUsers(){
		ReqResult rst = new ReqResult();
		List<IdcUser> list = idcUserService.findAllUsers();
		rst.setResultCode(ReqResult.CODE_SUCCESS);
		rst.setReturnObject(list);
		if (CollectionUtils.isEmpty(list)) {
			rst.setResultCode(204);
			rst.setReturnMessage("没有数据");
			return new ResponseEntity<ReqResult>(rst, HttpStatus.OK);
		}
		return new ResponseEntity<ReqResult>(rst, HttpStatus.OK);
	}
	
	/**
	 * Retrieve An User By Id
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/restApi/idcUser/{id}", method=RequestMethod.GET)
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
	@RequestMapping(value="/restApi/idcUser/model", method=RequestMethod.POST)
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
	@RequestMapping(value="/restApi/idcUser/add", method=RequestMethod.POST)
	public ResponseEntity<ReqResult> add(HttpServletRequest request, @RequestBody IdcUser u){
		ReqResult rst = new ReqResult();
		rst.setResultCode(ReqResult.CODE_SUCCESS);
		if (StringUtils.isEmpty(u.getUserName()) || StringUtils.isEmpty(u.getUserMail())) {
			rst.setResultCode(600);
			rst.setReturnObject("");
			rst.setReturnMessage("IdcUser param can not be null");
			return new ResponseEntity<ReqResult>(rst, HttpStatus.OK);
		}
		IdcUser check = null;
		for (int i = 0; i < 2; i++) {
			check = new IdcUser();
			if(i == 0) check.setUserName(u.getUserName());
			if(i == 0) check.setUserMail(u.getUserMail());
			if (idcUserService.findByModel(u) != null) {
				rst.setResultCode(601);
				rst.setReturnObject("");
				rst.setReturnMessage("Duplicate");
				return new ResponseEntity<ReqResult>(rst, HttpStatus.OK);
			}
		}
		if(StringUtils.isEmpty(u.getUserCode())) {
			IdcUser u4Code = new IdcUser();
			String uCode = "UC_" + RandomStringUtils.randomAlphanumeric(8).toUpperCase();
			u4Code.setUserCode(uCode);
			while(idcUserService.findByModel(u4Code) != null){
				uCode = "UC_" + RandomStringUtils.randomAlphanumeric(8).toUpperCase();
				u4Code.setUserCode(uCode);
			}
			u.setUserCode(uCode);
		}
		if(StringUtils.isEmpty(u.getUserLevel())) u.setUserLevel("normal");
		if(StringUtils.isEmpty(u.getUserGroup())) u.setUserGroup("basic");
		int line = idcUserService.add(u);
		if (line <= 0) {
			rst.setResultCode(700);
			rst.setReturnObject("");
			rst.setReturnMessage("add failed");
		}
		return new ResponseEntity<ReqResult>(rst, HttpStatus.OK);
	}
	
	/**
	 * Modify an user
	 * @param request
	 * @param u
	 * @return
	 */
	@RequestMapping(value="/restApi/idcUser/modify", method=RequestMethod.PUT)
	public ResponseEntity<String> modify(HttpServletRequest request, @RequestBody IdcUser u){
		if(u == null) return new ResponseEntity<String>("IdcUser param can not be null", HttpStatus.NOT_MODIFIED);
		if(u.getId() <= 0) return new ResponseEntity<String>("IdcUser.id can not less than or equal 0", HttpStatus.NOT_MODIFIED);
		int line = idcUserService.modify(u);
		if(line <= 0) return new ResponseEntity<String>(HttpStatus.NOT_MODIFIED);
		return new ResponseEntity<String>(HttpStatus.ACCEPTED);
	}
}
