package com.fate.restful.et.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fate.restful.et.domain.EtUsers;
import com.fate.restful.et.service.EtUsersService;

@RestController
public class EtUsresController {
	@Autowired
	private EtUsersService etUsersService;
	
	@RequestMapping(value="/etUsers", method=RequestMethod.GET)
	public ResponseEntity<List<EtUsers>> listAllEtUsers(){
		List<EtUsers> etUsers = etUsersService.findAllEtUsers();
		if(CollectionUtils.isEmpty(etUsers)){
			return new ResponseEntity<List<EtUsers>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<EtUsers>>(etUsers, HttpStatus.OK);
	}
	
	@RequestMapping(value="/etUsers/{id}", method=RequestMethod.GET)
	public ResponseEntity<EtUsers> getEtUser(@PathVariable("id") long id){
		EtUsers etUsers = etUsersService.findById(id);
		if(etUsers == null){
			return new ResponseEntity<EtUsers>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<EtUsers>(etUsers, HttpStatus.OK);
	}
}
