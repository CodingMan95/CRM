package com.test.crm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.crm.entity.DataDic;
import com.test.crm.service.DataDicService;

@Controller
public class DataDicController {

	@Autowired
	private DataDicService dataDicService;
	
	@RequestMapping("dataDic/list.do")
	@ResponseBody
	public List<DataDic> selectDataDic(){
		
		List<DataDic> list = dataDicService.selectDataDic();
		
		return list;
		
	}
	
	@RequestMapping("dataDic/save.do")
	@ResponseBody
	public int add(HttpServletRequest request){
		DataDic dataDic = new DataDic();
		
		String dataDicName = request.getParameter("dataDicName");
		String dataDicValue = request.getParameter("dataDicValue");
		
		dataDic.setDataDicName(dataDicName);
		dataDic.setDataDicValue(dataDicValue);
		int result = dataDicService.addDataDic(dataDic );
		
		return result;
	}
	
	@RequestMapping("dataDic/update.do")
	@ResponseBody
	public int update(HttpServletRequest request){
		DataDic dataDic = new DataDic();
		
		Integer id = Integer.valueOf(request.getParameter("id"));
		String dataDicName = request.getParameter("dataDicName");
		String dataDicValue = request.getParameter("dataDicValue");
		
		dataDic.setId(id);
		dataDic.setDataDicName(dataDicName);
		dataDic.setDataDicValue(dataDicValue);
		
		int result = dataDicService.updateDataDic(dataDic);
		
		return result;
	}
	
	@RequestMapping("dataDic/delete.do")
	@ResponseBody
	public int delete(HttpServletRequest request){
		Integer id = Integer.valueOf(request.getParameter("ids"));
		
		int result = dataDicService.deleteDataDic(id);
		
		return result;
	}
	
	
	@RequestMapping("dataDic/findDataDicName.do")
	@ResponseBody
	public List<DataDic> findDataDicName(HttpServletRequest request){
		
		List<DataDic> list = dataDicService.findDataDicName();
		
		return list;
	}
}
