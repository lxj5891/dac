package com.xiaonei.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 要充分利用java的多线程特性，对于比较耗时，且用户无须等待通知的事件，可以考虑采用异步事件处理， 本文模拟发送邮件，以及一个自动更新的任务调度:
 * 
 * @author Administrator
 * 
 */
public class ExecutorsTest {

	/**
	 * 异步事件,发送邮件
	 */
	private ExecutorService service = Executors.newFixedThreadPool(8);

	/** 自动更新调度线程 */
	private ScheduledExecutorService scService = Executors
			.newSingleThreadScheduledExecutor();

	/** 自动更新时间间隔 */
	private static final int UPDATE_INTERVAL = 2; // s

	private AtomicInteger counter = new AtomicInteger(); // 计数器类

	private static ExecutorsTest instance = new ExecutorsTest();

	public static ExecutorsTest getInstance() {
		return instance;
	}

	private ExecutorsTest() {
		startUpdateMoniter();
	}

	private void startUpdateMoniter() {
		scService.scheduleWithFixedDelay(new Runnable() {
			@Override
			public void run() {
				System.out.println("任务自动更新:" + System.currentTimeMillis()
						+ ",次数:" + getNextId());
			}
		}, UPDATE_INTERVAL, UPDATE_INTERVAL, TimeUnit.SECONDS);
	}

	public int getNextId() {
		return counter.incrementAndGet();
	}

	/**
	 * 发送邮件
	 * 
	 * @param emails
	 * @return
	 */
	public boolean sendMail(String emails) {
		service.submit(new SendMailsTask(emails));
		return true;
	}

	public static void main(String[] args) {
		ExecutorsTest test = ExecutorsTest.getInstance();
		System.out.println(test.sendMail("yangxinyan@qq.com"));
	}
}

/**
 * 异步发送邮件
 */
class SendMailsTask implements Runnable {
	String emails = "";

	public SendMailsTask(String emails) {
		this.emails = emails;
	}

	@Override
	public void run() {
		System.out.println("--------发送邮件--:" + emails
				+ Thread.currentThread().getName());
	}
}