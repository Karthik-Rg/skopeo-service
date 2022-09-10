package com.github.kr.skopeo.service;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.kr.skopeo.command.CommandExecutor;
import com.github.kr.skopeo.responses.InspectResponse;
import com.github.kr.skopeo.responses.TransferEntity;

@Service
public class SkopeoService {
	
	Logger logger = LoggerFactory.getLogger(SkopeoService.class);

	@Autowired
	CommandExecutor cmdExecutor;
	
	public InspectResponse inspectImage(String imageReference) {
		
		logger.info("inspectImage");
		InspectResponse inspectResponse = null;
		try {
			String response = cmdExecutor.executeInspectCommand(imageReference);
			inspectResponse = new ObjectMapper().readValue(response, InspectResponse.class);
		} catch (IOException | InterruptedException ex) {
			
			ex.printStackTrace();
		}
		
		return inspectResponse;
		
	}

	public String copyImage(TransferEntity transferEntity) {
		
		String source = transferEntity.getSource();
		String destination = transferEntity.getDestination();
		String response = "";
		
		try {
			response = cmdExecutor.executeCopyCommand(source, destination);
		} catch (IOException | InterruptedException ex) {
			ex.printStackTrace();
		}
		
		return response;
		
	}
	
}
