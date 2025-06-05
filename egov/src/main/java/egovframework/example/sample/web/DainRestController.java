package egovframework.example.sample.web;

import egovframework.example.sample.service.DainService;
import egovframework.example.sample.service.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
public class DainRestController {
    @Autowired
    private DainService dainService;
    @PostMapping(value = "/updateComputer.do", consumes = {"application/json", "application/json;charset=UTF-8"})
    public String updateComputer(@RequestBody MemberVO vo, RedirectAttributes redirectAttributes) {
        dainService.updateComputer(vo.getId(), vo.getComputer());
        redirectAttributes.addAttribute("id", vo.getId());
        return "redirect:/room.do";
    }

    @RequestMapping(value = "/getUser.do")
    public String login(@RequestParam String id, @RequestParam String pw, RedirectAttributes redirectAttributes) {
        MemberVO member = dainService.getMemberInfo(id, pw);
        redirectAttributes.addAttribute("id", member.getId());
        return "redirect:/room.do";
    }

    @RequestMapping(value = "/login.do")
    public String login(@RequestBody MemberVO vo, RedirectAttributes redirectAttributes) {
        dainService.updateComputer(vo.getId(), vo.getComputer());
        MemberVO member = dainService.getMember(vo.getId());
        redirectAttributes.addAttribute("id", member.getId());
        return "redirect:/room.do";
    }
}
