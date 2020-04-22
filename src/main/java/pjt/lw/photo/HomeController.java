package pjt.lw.photo;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pjt.lw.Member.Member;
import pjt.lw.photo.service.MemberService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Autowired
	MemberService service;
	
	@ModelAttribute("serverTime")
	public String getServerTime(Locale locale) {
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		return dateFormat.format(date);
	}
	@RequestMapping(value = "/loginForm", method = RequestMethod.GET)
	public String loginForm() {
		
		return "loginForm";
	}
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		
		
		return "home";
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(Member member, HttpSession session) {
		Member mem = service.search(member);
		
		if(mem==null) {
			
			return "loginFail";
		}
		session.setAttribute("member", mem);
		return "loginSuccess";
	}
	@RequestMapping(value="/joinForm",method=RequestMethod.GET)
	public String joinForm(Member member, HttpServletRequest request) {

		return "joinForm";
	}
	@RequestMapping(value="/join",method=RequestMethod.POST)
	public String join(Member member, HttpServletRequest request) {
		Member mem = service.insert(member);
		
		if(mem==null) {
			request.setAttribute("member", member);
			return "joinFail";
		}
		
		return "joinSuccess";
	}
	@RequestMapping(value="/modify",method=RequestMethod.GET)
	public String modify(@RequestParam("memId")String memId,@RequestParam("memPw")String memPw) {
//		HttpSession session =null;
//		session.setAttribute("bfMemId", memId);
//		session.setAttribute("bfMemPw", memPw);
		
		
		return "modifyForm";	
	}
	@RequestMapping(value="/modifyForm",method=RequestMethod.GET)
	public String modifyForm(HttpServletRequest request) {
		
		return "modifyForm";
	}

}
