package com.github.kr.skopeo.responses;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class InspectResponse {

	@JsonProperty("Name")
	private String name;
	
	@JsonProperty("RepoTags")
	private List<String> repoTags;
	
	@JsonProperty("Digest")
	private String digest;
	
	@JsonProperty("Created")
	private String created;
	
	@JsonProperty("DockerVersion")
	private String dockerVersion;
	
	@JsonProperty("Labels")
	private String labels;
	
	@JsonProperty("Architecture")
	private String architecture;
	
	@JsonProperty("Os")
	private String os;
	
	@JsonProperty("Layers")
	private List<String> layers; 
	 
	@JsonProperty("Env") 
	private List<String> env;
	
}
