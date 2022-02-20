package com.jpa.jpaexample.controller.nam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jpa.jpaexample.controller.nam.service.NamService;
import com.jpa.jpaexample.domain.CrudEntity;

@Controller
@RequestMapping(value="/nam")
public class namController {
	@Autowired
	private NamService namService;
    @GetMapping("helloworld2")
    
    public String hello(Model model){
    	List<CrudEntity> test = namService.searchAll();
        model.addAttribute("test",test);
        return "dong/test";
    }

}
