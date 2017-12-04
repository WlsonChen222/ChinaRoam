package com.chinaroam.client;

import java.net.URI;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.chinaroam.model.Printer;

public class PrinterClientUtil {
	
	public final static String BASE_URL = "http://localhost:8081";

    public static void main(String args[]) {
    	PrinterClientUtil util = new PrinterClientUtil();
    	util.testAddPrinter();
    	util.testQueryAllPrinters();
    } 
	
    public void testFindPrinterById() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = BASE_URL + "/user/printer/{id}";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Printer> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Printer.class, 1);
        Printer printer = responseEntity.getBody();
        System.out.println("Find:"+printer);      
    }
    
    public void testAddPrinter() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = BASE_URL + "/user/printer";
        Printer obj = new Printer();
        obj.setName("Spring REST Security using Hibernate");
        obj.setEmail("Spring@boot.com");
        obj.setIpaddress("localhost");
        HttpEntity<Printer> requestEntity = new HttpEntity<Printer>(obj, headers);
        URI uri = restTemplate.postForLocation(url, requestEntity);
        System.out.println(uri.getPath());    	
    }

    
    public void testQueryAllPrinters() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = BASE_URL + "/user/printers";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Printer[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Printer[].class);
        Printer[] printers = responseEntity.getBody();
        for(Printer printer : printers) {
              System.out.println("Id:"+printer);
        }
    }
    
    public void testUpdatePrinter() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = BASE_URL + "/user/printer";
        Printer obj = new Printer();
        obj.setId(1);
        obj.setName("Update:Java Concurrency");
        HttpEntity<Printer> requestEntity = new HttpEntity<Printer>(obj, headers);
        restTemplate.put(url, requestEntity);
    }

    public void testDeletePrinter() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = BASE_URL + "/user/printer/{id}";
        HttpEntity<Printer> requestEntity = new HttpEntity<Printer>(headers);
        restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Void.class, 1);        
    }
    
    
}
