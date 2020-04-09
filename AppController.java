package com.osk.SpringTest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {
	
	@Autowired
	private CrudService service;
	@RequestMapping("/")
	public String viewHomepage(Model model) {
		List<CrudData> listdata=service.listAll();
		model.addAttribute("listdata", listdata);  
		return "home";
	}
	@RequestMapping("/signup")
	public String showSignUp(Model model) {
		CrudData crud=new CrudData();
		model.addAttribute("crud", crud);
		return "signUp";
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveInfo(@ModelAttribute("crud") CrudData crud) {
		service.save(crud);
		return ("redirect:/");
	}
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditForm(@PathVariable(name="id")Long id) {
		ModelAndView mav=new ModelAndView("edit_form");
		CrudData crud=service.get(id);
		mav.addObject("crud", crud);
		return mav;
	}
	@RequestMapping("/delete/{id}")
	public String deleteInfo(@PathVariable(name="id")Long id) {
		service.delete(id);
		return  ("redirect:/");
	}
	
}
