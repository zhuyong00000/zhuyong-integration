package com.zhuyong.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/mail")
public class MailController {
	
	@RequestMapping(value="/sendMail",method = {GET, POST}, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public Object sendMail(HttpServletRequest request) throws Exception {
		sendSomeThingMsg("测试邮件", "发给joezhu@jites.com.cn的中奖邮箱");
		return null;
	}
	
	
	/**
	 * 发送邮件
	 */
	public static void sendSomeThingMsg(String title,String content){
		try {
			Properties props = new Properties();
			props.setProperty("mail.smtp.auth", "true");
			props.setProperty("mail.transport.protocol", "smtp");
			props.setProperty("mail.host", "219.142.78.230");   //smtp.sina.com
			Session session = Session.getInstance(props,
				new Authenticator()
				{
					protected PasswordAuthentication getPasswordAuthentication()
					{
						return new PasswordAuthentication("995915020zy","zhuyong123456");
					}
				}
			);
			session.setDebug(true);
			
			Message msg = new MimeMessage(session);
			
			msg.setFrom(new InternetAddress("\"" + MimeUtility.encodeText("登机区") + "\" <995915020zy@sina.com>"));
			msg.setSubject(title);
			InternetAddress[] to = new InternetAddress[1];
			to[0] = new InternetAddress("joezhu@jites.com.cn");
			msg.setRecipients(RecipientType.TO, to);
			
			msg.setContent(content,"text/html;charset=utf-8");
			
			Transport.send(msg);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	
}
