package com.zhuyong.service;

import com.zhuyong.mapper.UsertblMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface UsertblService {




    public List<Map<String, Object>> getUserTBLInfo(Map<String, Object> map);

}
