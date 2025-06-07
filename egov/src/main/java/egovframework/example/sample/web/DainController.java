package egovframework.example.sample.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import egovframework.example.sample.service.DainService;
import egovframework.example.sample.service.MemberVO;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class DainController {
	
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

	@PostMapping(value = "/updateComputer.do", consumes = {"application/json", "application/json;charset=UTF-8"})
	public String updateComputer(@RequestBody MemberVO vo, RedirectAttributes redirectAttributes) {
		dainService.updateComputer(vo.getId(), vo.getComputer());
		redirectAttributes.addAttribute("id", vo.getId());
		return "redirect:/room.do";
	}

	@RequestMapping(value = "/getUser.do")
	public String login(@RequestParam String id, @RequestParam String pw, RedirectAttributes redirectAttributes) {
		MemberVO member = dainService.getMemberInfo(id, pw);
		if (member == null) {
			redirectAttributes.addFlashAttribute("error", "존재하지 않는 사용자입니다.");
			return "redirect:/login.do";
		}
		redirectAttributes.addAttribute("id", member.getId());
		return "redirect:/room.do";
	}
}
