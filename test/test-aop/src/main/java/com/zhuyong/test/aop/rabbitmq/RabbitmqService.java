package com.zhuyong.test.aop.rabbitmq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * 消费者
 * @author zhuyong
 *
 */
public class RabbitmqService implements MessageListener{

	@Override
	public void onMessage(Message message) {
		
		System.out.println("消息消费者 = " + message.toString());
	}

	
	
}
