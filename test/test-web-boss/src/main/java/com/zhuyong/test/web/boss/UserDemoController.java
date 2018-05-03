package com.zhuyong.test.web.boss;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhuyong.test.facede.user.service.IPmsUserFacede;

@Controller
@RequestMapping("/user")
public class UserDemoController {

	@Autowired
	IPmsUserFacede pmsUserFacede;
	
	@RequestMapping(value="/test1",method = {GET, POST}, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public Object queryMyTaskList(HttpServletRequest request, HttpServletResponse response) throws Exception{
		pmsUserFacede.testPmsUserDubboDemo();
		return "sss";
	}
}
