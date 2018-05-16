package com.zhuyong.service.impl;

import com.zhuyong.mapper.UsertblMapper;
import com.zhuyong.service.UsertblService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class UsertblServiceImpl implements UsertblService {

    @Autowired
    UsertblMapper usertblMapper;

    @Override
    public List<Map<String, Object>> getUserTBLInfo(Map<String, Object> map) {
        return usertblMapper.getUserTBLInfo(map);
    }
}
