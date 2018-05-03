package com.zhuyong.test.aop.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * rabbitmq 生产者
 * @author zhuyong
 *
 */
@Service
public class Producer {
	
	
	@Autowired
	AmqpTemplate amqpTemplate;
	
	public void sendQueue(String exchangeKey, String queueKey, Object object) {
		// convertAndSend 将Java对象转换为消息发送至匹配key的交换机中Exchange
		amqpTemplate.convertAndSend(exchangeKey, queueKey, object);
	}
	
}
