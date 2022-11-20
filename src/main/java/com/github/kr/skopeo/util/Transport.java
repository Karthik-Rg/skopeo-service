package com.github.kr.skopeo.util;

/**
 * 
 * @author karthik
 *
 */

public enum Transport {
	
	DOCKER("docker"), GITLAB("gitlab");

	private final String transport;
	
	Transport(final String transport) {
		
		this.transport = transport;
		
	}
	
	
	@Override
	public String toString() {
		return this.transport;
	}
	
	
	
	

}
