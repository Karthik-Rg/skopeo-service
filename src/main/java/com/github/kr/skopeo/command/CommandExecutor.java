package com.github.kr.skopeo.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CommandExecutor {

	Logger logger = LoggerFactory.getLogger(CommandExecutor.class);

	public String executeInspectCommand(boolean tlsVerify, String imageReference) throws IOException, InterruptedException {

		StringJoiner execCmdToken = new StringJoiner(" ");

		execCmdToken.add(Commands.INSPECT.concat(String.valueOf(tlsVerify))).add(imageReference);

		logger.info("Inspect Command -> {}", execCmdToken.toString());

		Process cmdProcessor = cmdExecutor(execCmdToken);

		logger.info("Inspect");

		if (cmdProcessor.waitFor() != 0) {

			logger.error("Execution of {} Command failed!", execCmdToken.toString());

		}

		return getResponse(cmdProcessor);
		
	}
	
	public String executeCopyCommand(String source, String destination, boolean transportSecured) throws IOException, InterruptedException {
		
		StringJoiner execCmdToken = new StringJoiner(" ");
		
		execCmdToken.add(Commands.BASE_COPY.concat(String.valueOf(transportSecured))).add(Commands.DOCKER.concat(source)).add(Commands.DOCKER.concat(destination));
		
		logger.info("Copy Command -> {}", execCmdToken.toString());

		Process cmdProcessor = cmdExecutor(execCmdToken);

		logger.info("Copy");

		if (cmdProcessor.waitFor() != 0) {

			logger.error("Execution of {} Command failed!", execCmdToken.toString());

		}
		
		return getResponse(cmdProcessor);
		
	}

	private String getResponse(Process cmdProcessor) {
		return new BufferedReader(
			      new InputStreamReader(cmdProcessor.getInputStream(), StandardCharsets.UTF_8))
			        .lines()
			        .collect(Collectors.joining("\n"));
	}

	private Process cmdExecutor(StringJoiner execCmdToken) throws IOException {
		return Runtime.getRuntime().exec(execCmdToken.toString());
	}

}
