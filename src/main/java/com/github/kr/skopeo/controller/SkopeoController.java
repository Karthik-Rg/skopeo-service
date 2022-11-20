package com.github.kr.skopeo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.kr.skopeo.responses.InspectResponse;
import com.github.kr.skopeo.responses.TransferEntity;
import com.github.kr.skopeo.service.SkopeoService;
import com.github.kr.skopeo.util.Transport;

@RestController
public class SkopeoController {

	Logger logger = LoggerFactory.getLogger(SkopeoController.class);
	
	@Autowired
	SkopeoService skopeoService;
	
	@GetMapping("/ping")
	public String ping() {
		return "pong! ;)";
	}
	
	@GetMapping("/inspect")
	public InspectResponse inspectImage(@RequestParam("transport") Transport transport,  @RequestParam("tls-verify") boolean tlsVerify, @RequestParam("imageReference") String imageReference) {
		
		logger.info("inspectImage Controller");
		return skopeoService.inspectImage(transport.toString(), tlsVerify, imageReference);
		
	}

	@PostMapping("/copy")
	public String copyImage(@RequestBody TransferEntity transferEntity) {
		
		return skopeoService.copyImage(transferEntity);

	}


}
