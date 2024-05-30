package com.ty.HospitalManagementSystem.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.HospitalManagementSystem.dto.Address;
import com.ty.HospitalManagementSystem.repo.AddressRepo;
import com.ty.HospitalManagementSystem.service.AddressService;

@RestController
public class AddressController {

	@Autowired
	private AddressService service;
	@Autowired
	private AddressRepo repo;
	
	@PostMapping("/saveaddress")
	public Address saveAddress(@Valid @RequestBody Address address) {
		return service.saveAddress(address);
	}
	@PutMapping("/updateaddress")
	public Address updateaAddress(@Valid @RequestParam int id,@RequestBody Address address) {
		return service.updateAddress(id, address);
	}
	@DeleteMapping("/deleteaddress")
	public Address deleteAddress(@Valid @RequestParam int id) {
		return service.deleteAddress(id);
		
	}
	@GetMapping("/getaddressbyid")
	public Address getaddressbyid(@Valid @RequestParam int id) {
		return service.getaddressbyid(id);
	}
	@GetMapping("/findAllAddress")
	public Page<Address> findAllStudentByName( @RequestParam int pageNumber) {
		PageRequest pagerequest=PageRequest.of(pageNumber, 10);
		 Page<Address> findall = repo.findAll(pagerequest);
		return findall;
	}
}
