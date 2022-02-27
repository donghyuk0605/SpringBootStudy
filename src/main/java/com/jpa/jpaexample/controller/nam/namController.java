package com.jpa.jpaexample.controller.nam;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jpa.jpaexample.controller.nam.service.NamService;
import com.jpa.jpaexample.domain.CrudEntity;

@Controller
@RequestMapping(value="/nam")
public class namController {
	
	@Autowired
	private NamService namService;
	
    @GetMapping("/boardList")
    public String hello(Model model){
    	List<CrudEntity> test = namService.searchAll();
        model.addAttribute("test",test);
        return "nam/boardList";
    }

    @GetMapping("/boardInsertPage")
    public String boardInsert(Model model){
    	return "nam/boardInsertPage";
    }
    
    @GetMapping("/boardDetail")
    public String boardDetail(@RequestParam Map<String,Object> paramMap,CrudEntity crudEntity,Model model){
    	crudEntity.setName((String) paramMap.get("name"));
    	CrudEntity boardDetail = namService.searchBoardDetail(crudEntity);
        model.addAttribute("boardDetail",boardDetail);
    	return "nam/boardDetail";
    }
    
    @PostMapping("/boardInsert")
    public String boardInsert(CrudEntity crudEntity) {
    	namService.insertMember(crudEntity);
    	return "redirect:/nam/boardList";
    }

	@PostMapping("/boardUpdate")
	public String boardUpdate(CrudEntity crudEntity) {
		namService.insertMember(crudEntity);
		return "redirect:/nam/boardList";
	}
}
