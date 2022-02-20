package com.jpa.jpaexample.controller.dong;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jpa.jpaexample.controller.dong.service.DongService;
import com.jpa.jpaexample.domain.CrudEntity;

@Controller
@RequestMapping(value="/dong")
public class dongController {
	@Autowired
	private DongService dongService;
    @GetMapping("helloworld2")
    
    public String hello(Model model){
    	List<CrudEntity> test = dongService.searchAll();
        model.addAttribute("test",test);
        return "test";
    }

}
