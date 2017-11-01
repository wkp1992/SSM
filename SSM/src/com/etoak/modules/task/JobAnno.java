package com.etoak.modules.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class JobAnno {
	
	//@Scheduled(cron="0/5 * * * * ?")
	public void job(){
		System.out.println("взЭО-et1702-anno");
	}

}
