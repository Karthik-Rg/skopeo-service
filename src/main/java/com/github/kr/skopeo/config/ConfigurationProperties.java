package com.github.kr.skopeo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Configuration
@Getter
@Setter
public class ConfigurationProperties {

	@Value("${docker.tls.verify}")
	private boolean tlsVerify;
	
}
