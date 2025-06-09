package egovframework.example.sample.common;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public class ErrorRedirect {
    public static String sendRedirectMessage(String errorMessage, String redirectUrl, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("error", errorMessage);
        return  "redirect:/" + redirectUrl;
    }
}
