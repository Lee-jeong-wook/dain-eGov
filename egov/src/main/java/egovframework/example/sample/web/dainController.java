package egovframework.example.sample.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class dainController {
	@RequestMapping(value = "/home.do")
	public String showExPage() throws Exception {
		return "sample/ex";
	}
	@RequestMapping(value = "/room.do")
	public String showRoomPage() throws Exception {
		return "sample/room";
	}
}
