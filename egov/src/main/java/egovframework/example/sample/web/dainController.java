package egovframework.example.sample.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.example.sample.service.DainService;
import egovframework.example.sample.service.MemberVO;


@Controller
public class dainController {
	
	@Autowired
	private DainService dainService;
	
	@RequestMapping(value = "/home.do")
	public String showExPage() throws Exception {
		return "sample/ex";
	}
	@GetMapping(value = "/room.do")
	public String showRoom() throws Exception{
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
	
	@RequestMapping(value = "/getUser.do")
	public String login(@RequestParam String id, @RequestParam String pw, Model model) {
	    MemberVO vo = dainService.getMemberInfo(id, pw);
	    model.addAttribute("vo", vo);
	    return "sample/room";
	}
	
	@RequestMapping(value = "/updateComputer.do")
	public String login(@RequestBody MemberVO vo, Model model) {
	    dainService.updateComputer(vo.getId(), vo.getComputer());
	    MemberVO member = dainService.getMember(vo.getId());
	    model.addAttribute("vo", member);
	    System.out.println("work");
	    return "sample/room";
	}
}
