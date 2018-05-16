package com.zhuyong.controller;

import com.zhuyong.service.UsertblService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UsertblController {

    @Autowired
    UsertblService usertblService;

    @RequestMapping(value = "/getUser", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public Object getUserTBLInfo(String userId, String nickName, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        map.put("UserId", userId);
        map.put("Nickname", nickName);
        return usertblService.getUserTBLInfo(map);
    }

}
