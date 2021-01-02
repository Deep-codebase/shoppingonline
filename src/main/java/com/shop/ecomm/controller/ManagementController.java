package com.shop.ecomm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shop.ecomm.dao.CategoryDAO;
import com.shop.ecomm.dao.ProductDAO;
import com.shop.ecomm.entity.Category;
import com.shop.ecomm.entity.Product;
import com.shop.ecomm.util.FileUploadUtility;

@Controller
public class ManagementController {

	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private CategoryDAO categoryDAO;	
	
	@GetMapping("/manageproduct")
	public ModelAndView manageProduct(@RequestParam(name="success",required=false)String success) {		
		
		ModelAndView mv = new ModelAndView("page");	
		Product nProduct = new Product();
		nProduct.setSupplierId(1);
		nProduct.setActive(true);
		mv.addObject("product", nProduct);
		
		mv.addObject("title","Product Management");		
		mv.addObject("userClickManageProduct",true);
			

		if(success != null) {
			if(success.equals("product")){
				mv.addObject("message", "Product submitted successfully!");
			}	
			else if (success.equals("category")) {
				mv.addObject("message", "Category submitted successfully!");
			}
		}
		
		return mv;
		
	}

	
	@PostMapping(value = "/saveproduct")
	public String managePostProduct(@ModelAttribute("product") Product mProduct, Model model, HttpServletRequest request) {
		
		
		if(mProduct.getId() == 0 ) {
			productDAO.add(mProduct);
		}
		else {
			productDAO.update(mProduct);
		}
		
		// mandatory file upload check
		if(!mProduct.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadFile(request, mProduct.getFile(), mProduct.getCode());
		}
		
		System.out.println(mProduct);
		productDAO.add(mProduct);
		model.addAttribute("title","Product Management");		
		model.addAttribute("userClickManageProduct",true);
		model.addAttribute("product", new Product());
		
		return "redirect:manageproduct?success=product";
	}
	
	

	@RequestMapping("showProduct")
	public ModelAndView manageProductEdit(@RequestParam("id") int id) {		

		ModelAndView mv = new ModelAndView("page");	
		mv.addObject("title","Product Management");		
		mv.addObject("userClickManageProduct",true);
		
		// Product nProduct = new Product();		
		mv.addObject("product", productDAO.get(id));

			
		return mv;
		
	}
	
	@RequestMapping(value = "/productdeactivation", method=RequestMethod.GET)
	@ResponseBody
	public String managePostProductActivation(@RequestParam("id") int id) {		
		Product product = productDAO.get(id);
		boolean isActive = product.isActive();
		product.setActive(!isActive);
		productDAO.update(product);		
		return (isActive)? "Product Dectivated Successfully!": "Product Activated Successfully";
	}
	
	@RequestMapping(value = "/savecategory", method=RequestMethod.POST)
	public String managePostCategory(@ModelAttribute("category") Category mCategory, HttpServletRequest request) {					
		categoryDAO.add(mCategory);		
		return "redirect:manageproduct?success=category";
	}
	
	@ModelAttribute("categories") 
	public List<Category> modelCategories() {
		return categoryDAO.list();
	}
	

	@ModelAttribute("category")
	public Category modelCategory() {
		return new Category();
	}
}
