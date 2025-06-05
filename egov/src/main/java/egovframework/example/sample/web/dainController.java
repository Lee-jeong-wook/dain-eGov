package egovframework.example.sample.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import egovframework.example.sample.service.DainService;
import egovframework.example.sample.service.MemberVO;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class dainController {
	
	@Autowired
	private DainService dainService;
	
	@RequestMapping(value = "/home.do")
	public String showExPage() throws Exception {
		return "sample/ex";
	}
	@GetMapping(value = "/room.do")
	public String showRoom(@RequestParam String id, Model model) throws Exception{
		System.out.println("worked");
		model.addAttribute("vo", dainService.getMember(id));
		return "sample/room";
	}
	@GetMapping(value= "/login.do")
	public String loginPage() throws Exception{
		return "sample/login";
	}
	@GetMapping(value = "/signup.do")
	public String signinPage() throws Exception{
		return "sample/signup";
	}
}
