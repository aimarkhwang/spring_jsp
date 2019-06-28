package com.gg.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gg.mylib.MyUtils;
import com.gg.vo.MovieVO;

@Controller
public class JspController {
	   @RequestMapping(value="/", method = RequestMethod.GET)      // localhost
	    public String root() {
	        return "hello";          // 실제 호출될 /WEB-INF/jsp/viewtest.jsp       
	    }
	   
	   @GetMapping("/main")
	    public String main() {
	        return "main";
	    }
	   
	   @RequestMapping(value="/hello")      // localhost
	    public String hello(Model model) {
		   model.addAttribute("msg", "html");
	        return "hello2";          // 실제 호출될 /WEB-INF/jsp/viewtest.jsp       
	    }
	     
	    @RequestMapping(value="/test", produces="text/html;charset=UTF-8")  // localhost/test
	    @ResponseBody
	    public String test(HttpServletRequest request) {
	    	String name = request.getParameter("name");
	        return "<h1>당신의 이름은? " + name + "</h1>";        // 실제 호출될 /WEB-INF/jsp/test/viewtest2.jsp       
	    }
	    
	    @RequestMapping(value="/nv", produces="application/json;charset=UTF-8")
	    @ResponseBody
	    public String naver() {
	    	String nvapi = MyUtils.getNvAPI("불금");
	        return nvapi;       
	    }
	    
	    @RequestMapping(value="/daum")
	    @ResponseBody
	    public MovieVO daum() {
	    	MovieVO vo = new MovieVO();
	    	vo.setImg("aa");
	    	vo.setLnk("nn");
	    	vo.setTitle("title");
	        return vo;       
	    }
	    
	    

}
