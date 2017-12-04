package com.chinaroam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.chinaroam.model.Printer;
import com.chinaroam.service.IPrinterService;
import com.chinaroam.service.throwable.ServiceException;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private IPrinterService printerService;

	@GetMapping("printer/{id}")
	public ResponseEntity<Printer> findPrinter(@PathVariable("id") Integer id) {
		try {
			Printer printer = printerService.find(id);
			return new ResponseEntity<Printer>(printer, HttpStatus.OK);
		}
		catch(ServiceException sex) {
			return new ResponseEntity<Printer>(HttpStatus.BAD_REQUEST);
		}
		
	}

	@GetMapping("printers")
	public ResponseEntity<List<Printer>> queryAllPrinters(@PathVariable("access_token") String access_token) {
		try {
			List<Printer> list = printerService.queryAll(access_token);
			return new ResponseEntity<List<Printer>>(list, HttpStatus.OK);
		}
		catch(ServiceException sex) {
			return new ResponseEntity<List<Printer>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("printer")
	public ResponseEntity<Void> addPrinter(@PathVariable("access_token") String access_token
			, @RequestBody Printer printer, UriComponentsBuilder builder) {
		try {
			printerService.add(printer);

			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(builder.path("/printer/{id}").buildAndExpand(printer.getId()).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		}
		catch(ServiceException sex) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}		
	}


	@PutMapping("printer")
	public ResponseEntity<Printer> updatePrinter(@PathVariable("access_token") String access_token
			, @RequestBody Printer printer) {
		try {
			printerService.update(printer);		
			return new ResponseEntity<Printer>(printer, HttpStatus.OK);
		}
		catch(ServiceException sex) {
			return new ResponseEntity<Printer>(HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@DeleteMapping("printer/{id}")
	public ResponseEntity<Void> deletePrinter(@PathVariable("access_token") String access_token
			, @PathVariable("id") Integer id) {
		try {
			printerService.delete(id);		
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		catch(ServiceException sex) {
				return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
}
