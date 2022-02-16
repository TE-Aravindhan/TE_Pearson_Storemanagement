package com.te.storesmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.te.storesmanagementsystem.beans.Response;
import com.te.storesmanagementsystem.service.StoreService;

@RestController
@RequestMapping("/store")
public class StoreController {

	@Autowired
	StoreService service;

	@GetMapping("/getalldata/")
	public ResponseEntity<Response> getAllData(@RequestParam("file") MultipartFile file, @RequestParam("option") String option) {
		Response response = new Response(false,service.getAllData(file, option) );
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@GetMapping("/getdata/")
	public ResponseEntity<Response> getDataById(@RequestParam("file") MultipartFile file, @RequestParam String storeId) {
		Response response = new Response(false,service.getDataById(file, storeId));
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

}
