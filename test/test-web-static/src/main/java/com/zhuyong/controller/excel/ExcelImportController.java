package com.zhuyong.controller.excel;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.zhuyong.entity.excel.MapImportHandler;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;

@RestController
@RequestMapping("/excelImport")
public class ExcelImportController {

	/**
	 * excel 简单导入
	 * @param modelMap
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/import")
	public void downloadByPoiBaseView(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
		if (multipartResolver.isMultipart(request)) {
			// 转换成多部分request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			Iterator<String> fileNames = multiRequest.getFileNames();
			while (fileNames.hasNext()) {
				MultipartFile file = multiRequest.getFile(fileNames.next());
				InputStream inputStream = file.getInputStream();
				
				importExcel(inputStream);
			}
		}
		
		
		
	}
	
	
	private static void importExcel(InputStream inputStream) throws Exception {
		ImportParams params = new ImportParams();
		params.setTitleRows(1);
		params.setHeadRows(1);
		params.setDataHandler(new MapImportHandler());
		long start = new Date().getTime();
		List<Map<String, Object>> list = ExcelImportUtil.importExcel(inputStream, Map.class, params);
		for (Map<String, Object> map : list) {
			System.out.println(map);
		}
		System.out.println("time : "+(new Date().getTime() - start));
	}
	
	public static void main(String[] args) {
		try {
//			InputStream resourceAsStream = ExcelImportController.class.getClassLoader().getResourceAsStream("import/check.xls");
			String path = ExcelImportController.class.getClassLoader().getResource("").toURI().getPath();
			String file = path.substring(1) + "import/checks.xlsx";
			System.out.println(file);
			InputStream inputStream = new FileInputStream(file);
			importExcel(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
