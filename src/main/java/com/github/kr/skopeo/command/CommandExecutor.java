package com.github.kr.skopeo.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CommandExecutor {

	Logger logger = LoggerFactory.getLogger(CommandExecutor.class);

	public String executeInspectCommand(String imageReference) throws IOException, InterruptedException {

		StringJoiner execCmdToken = new StringJoiner(" ");

		execCmdToken.add(Commands.INSPECT).add(imageReference);

		logger.info("Inspect Command -> {}", execCmdToken.toString());

		Process cmdProcessor = Runtime.getRuntime().exec(execCmdToken.toString());

		logger.info("Inspect");

		if (cmdProcessor.waitFor() != 0) {

			logger.error("Execution of {} Command failed!", execCmdToken.toString());

		}

		InputStreamReader inputStreamReader = new InputStreamReader(cmdProcessor.getInputStream());
		BufferedReader br = new BufferedReader(inputStreamReader);
		String temp = "";
		StringBuilder builder = new StringBuilder();
		while (br.readLine() != null) {
			builder.append(br.readLine());
		}

		while((temp=br.readLine()) != null) {
			logger.info(temp);
			System.out.println(temp);
		}
		
		return builder.toString();

	}

}
