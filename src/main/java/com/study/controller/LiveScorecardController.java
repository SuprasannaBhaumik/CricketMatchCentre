package com.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableBinding(Source.class)
public class LiveScorecardController {
	
	@Autowired
	Source output;
	//ScorecardStream scorecardStream;
	
	@RequestMapping(value="/putScore", method=RequestMethod.POST)
	public void putScoreToStream(@RequestBody String score) {
		System.out.println(score);
		GenericMessage<String> message = new GenericMessage<>(score);
		this.output.output().send(message);
	}

}
