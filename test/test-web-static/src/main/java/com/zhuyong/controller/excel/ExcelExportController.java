package com.zhuyong.controller.excel;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhuyong.test.common.base.util.excel.entity.Contacts;
import com.zhuyong.test.common.base.util.excel.entity.ContactsGroup;

import cn.afterturn.easypoi.entity.vo.MapExcelConstants;
import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;
import cn.afterturn.easypoi.view.PoiBaseView;

/**
 * excel 简单导出
 */
@RestController
@RequestMapping("/excelExport")
public class ExcelExportController {


	/**
	 * 注解式简单导出
	 * @param map
	 * @param request
	 * @param response
	 */
    @RequestMapping("/downloadByPoiBaseView")
    public void downloadByPoiBaseView(ModelMap map, HttpServletRequest request, HttpServletResponse response) {

        List<Contacts> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Contacts contacts = new Contacts();
            contacts.setBirthday(new Date());
            contacts.setName("小明"+i);
            contacts.setPhone("18797"+i);
            contacts.setCreateBy("joe");
            contacts.setId(i+"");
            contacts.setRemark("测试"+i);
            ContactsGroup group = new ContactsGroup();
            group.setGroupName("朋友"+i);
            contacts.setGroup(group);
            list.add(contacts);
        }
        ExportParams params = new ExportParams();
        // "通讯录表格名称", "通讯录列表", ExcelType.XSSF
        params.setSheetName("通讯录列表");
        params.setType(ExcelType.XSSF);
        // 表格title冰冻列
        params.setFreezeCol(5);
        map.put(NormalExcelConstants.DATA_LIST, list);
        map.put(NormalExcelConstants.CLASS, Contacts.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "导出下载测试");
        // 生成excel
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }
    
    /**
     * map式简单导出
     * @param map
     * @param request
     * @param response
     */
    @RequestMapping("/downloadByPoiBaseViewMap")
    public void downloadByPoiBaseViewMap(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
    	List<ExcelExportEntity> entity = new ArrayList<>();
    	
    	ExcelExportEntity excelExportEntity = new ExcelExportEntity("姓名", "name");
    	entity.add(excelExportEntity);
    	excelExportEntity = new ExcelExportEntity("性别", "sex");
    	entity.add(excelExportEntity);
       
    	
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map;
        for (int i = 0; i < 10; i++) {
            map = new HashMap<String, Object>();
            map.put("name", "1" + i);
            map.put("sex", "2" + i);
            list.add(map);
        }
        
        ExportParams params = new ExportParams("2412312", "测试", ExcelType.XSSF);
        params.setFreezeCol(2);
        modelMap.put(MapExcelConstants.MAP_LIST, list);
        modelMap.put(MapExcelConstants.ENTITY_LIST, entity);
        modelMap.put(MapExcelConstants.PARAMS, params);
        modelMap.put(MapExcelConstants.FILE_NAME, "EasypoiMapExcelViewTest");
        // 生成excel
        PoiBaseView.render(modelMap, request, response, MapExcelConstants.EASYPOI_MAP_EXCEL_VIEW);
    }
    
    /**
     * 合并同类项
     * @param modelMap
     * @param request
     * @param response
     */
    @RequestMapping("/downloadByPoiBaseViewMap2")
    public void downloadByPoiBaseViewMap2(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
    	List<ExcelExportEntity> entity = new ArrayList<ExcelExportEntity>();
        ExcelExportEntity excelentity = new ExcelExportEntity("部门", "depart");
        excelentity.setMergeVertical(true);
        entity.add(excelentity);
        
        excelentity = new ExcelExportEntity("姓名", "name");
        excelentity.setMergeVertical(true);
        excelentity.setMergeRely(new int[]{0});
        entity.add(excelentity);
        
        excelentity = new ExcelExportEntity("电话", "phone");
        excelentity.setMergeVertical(true);
        excelentity.setMergeRely(new int[] { 1 });
        entity.add(excelentity);
        
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map;
        for (int i = 0; i < 10; i++) {
        	map = new HashMap<String, Object>();
            map.put("depart", "设计部");
            map.put("name", "小明" + i);
            map.put("phone", "1311234567" + i);
            list.add(map);
        }
        for (int i = 0; i < 10; i++) {
            map = new HashMap<String, Object>();
            map.put("depart", "开发部");
            map.put("name", "小蓝" + i);
            map.put("phone", "1871234567" + i);
            list.add(map);
        }
        
        ExportParams params = new ExportParams("员工通讯录", "通讯录", ExcelType.XSSF);
        params.setFreezeCol(3);
        modelMap.put(MapExcelConstants.MAP_LIST, list);
        modelMap.put(MapExcelConstants.ENTITY_LIST, entity);
        modelMap.put(MapExcelConstants.PARAMS, params);
        modelMap.put(MapExcelConstants.FILE_NAME, "EasypoiMapExcelViewTest2");
        // 生成excel
        PoiBaseView.render(modelMap, request, response, MapExcelConstants.EASYPOI_MAP_EXCEL_VIEW);
    }
    
}
