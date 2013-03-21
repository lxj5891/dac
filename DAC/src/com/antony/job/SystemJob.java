package com.antony.job;


import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class SystemJob extends QuartzJobBean {
	private int id;
	public void setId(int id) {
		this.id = id;
	}

	@Override
	protected void executeInternal(JobExecutionContext arg0)
			throws JobExecutionException {
		// TODO Auto-generated method stub
		System.out.println("系统正在运行...");
	}
}