package com.github.kr.skopeo.responses;

import com.github.kr.skopeo.util.Transport;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class TransferEntity {
	
	private String source;
	
	private String destination;
	
	private boolean securedTransportLayer;
	
	private Transport transport;
	
}
