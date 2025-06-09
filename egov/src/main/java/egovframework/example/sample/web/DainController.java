package egovframework.example.sample.web;

import egovframework.example.sample.common.ErrorRedirect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import egovframework.example.sample.service.DainService;
import egovframework.example.sample.service.MemberVO;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;


@Controller
public class DainController {
	
	@Autowired
	private DainService dainService;

	@GetMapping(value = "/room.do")
	public String showRoom(@CookieValue(name = "id", required = false) String cookieId, Model model, RedirectAttributes redirectAttributes){
		if(cookieId == null || cookieId.isEmpty()){
			return ErrorRedirect.sendRedirectMessage("로그인 정보가 존재하지 않습니다.", "login.do", redirectAttributes);
		}
		MemberVO vo = dainService.getMember(cookieId);
		if(vo == null){
			return ErrorRedirect.sendRedirectMessage("사용자 입력 정보가 잘못되었습니다.", "login.do", redirectAttributes);
		}
		model.addAttribute("vo", vo);
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

	@PostMapping(value = "/updateComputer.do", consumes = {"application/json", "application/json;charset=UTF-8"})
	public String updateComputer(@RequestBody MemberVO vo, @CookieValue(required = false, name = "id") String id,RedirectAttributes redirectAttributes) {
		dainService.updateComputer(id, vo.getComputer());
		return "redirect:/room.do";
	}

	@RequestMapping(value = "/getUser.do")
	public String login(@RequestParam String id, @RequestParam String pw, RedirectAttributes redirectAttributes, HttpServletResponse response) {
		MemberVO member = dainService.getMemberInfo(id, pw);
		if (member == null) {
			return ErrorRedirect.sendRedirectMessage("로그인 정보가 잘못되었습니다.", "login.do", redirectAttributes);
		}
		response.addCookie(new Cookie("id", member.getId()));
		return "redirect:/room.do";
	}

	@RequestMapping(value = "/addUser.do")
	public String signup(@RequestParam String id, @RequestParam String pw, @RequestParam String name,RedirectAttributes redirectAttributes) {
		try {
			dainService.addMemberInfo(id, pw, name, "[[0 ,0 ,0],[0 ,0 ,0],[0 ,0 ,0],[0 ,0 ,0]]");
		} catch (Exception e) {
			return ErrorRedirect.sendRedirectMessage("회원가입 중 오류가 발생하였습니다.", "signup.do", redirectAttributes);
		}
		return "redirect:/login.do";
	}
}
