package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController

public class ConfigServerController {
@GetMapping
public ResponseEntity<String>home(){
	return ResponseEntity.ok("Admin ServerRunning");
}
}
