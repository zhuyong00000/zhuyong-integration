package com.zhuyong.test.aop.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhuyong.test.aop.rabbitmq.Producer;

@Controller
@RequestMapping("/rabbitmq")
public class RabbitMqController {

	@Autowired
	Producer producer;
	
	@ResponseBody
	@RequestMapping("/sendQueue")
	public String testQueue() {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
	        map.put("data", "hello rabbitmq");
			String queue = "test_mq";
			String exchangeKey = queue+"_exchange";
			String queueKey = queue+"_patt";
			producer.sendQueue(exchangeKey, queueKey, map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "发送完毕";
	}
	
}
