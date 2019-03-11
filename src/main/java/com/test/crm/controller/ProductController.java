package com.test.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.crm.entity.Product;
import com.test.crm.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("product/list.do")
	@ResponseBody
	public List<Product> selectProduct(){
		
		List<Product> list = productService.selectProduct();
		
		return list;
		
	}
	

}
