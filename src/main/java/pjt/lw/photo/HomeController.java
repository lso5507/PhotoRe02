package pjt.lw.photo;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import org.springframework.web.servlet.ModelAndView;

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
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(HttpServletRequest request) {
		
		  logger.debug("###INDEX PAGE###");
		    String rtnPage = "index";
		    String ipAddress = request.getHeader("X-FORWARDED-FOR");
		    if (ipAddress == null) {
		        ipAddress = request.getRemoteAddr();
		    }
		    logger.info(ipAddress + " : " + rtnPage);
		    
		
		
		return "test";
	}
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String main(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		
		
		return "home";
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(Member member, HttpSession session, HttpServletResponse response) {
		Member mem = service.search(member);
		
		if(mem==null) {
			try {
				PrintWriter out=response.getWriter();
				out.println("<script>alert('로그인 정보가 일치하지 않습니다.'); location.href='/photo/home';</script>");  // java에서 js 명령어 사용
				out.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return "loginForm";
		}
		session.setAttribute("member", mem);
		return "home";
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
	@RequestMapping(value="/idModify",method=RequestMethod.POST)
	public String idModify(HttpServletRequest request) {
		String memId=request.getParameter("memId");
		String reMemId=request.getParameter("reMemId");
		if(memId.equals(reMemId)) {

			
			Member member=service.modify(memId,"ID");   // ID변경 PW변경을 service 객체에서 구분하기 위해 string 값 전달
			request.setAttribute("member", member);  // request.setAttribute() 설정하여 뷰단에서 member클래스 getter 사용
			if(member==null) {
				return "modifyFail";
			}
			return "modifySuccess";
		}
		else {
			return "modifyFail";
		}
		
	}
	@RequestMapping(value="/pwModify",method=RequestMethod.POST)
	public String pwModify(HttpServletRequest request) {
		String memPw=request.getParameter("memPw");
		String reMemPw=request.getParameter("reMemPw");
		if(memPw.equals(reMemPw)) {

			
			Member member=service.modify(memPw,"PW");
			request.setAttribute("member", member);
			if(member==null) {
				return "modifyFail";
			}
			return "modifySuccess";
		}
		else {
			return "modifyFail";
		}
		
	}
	@RequestMapping(value="/idModifyForm",method=RequestMethod.GET)
	public String idModifyForm(HttpServletRequest request) {

		return "idModifyForm";
	}
	@RequestMapping(value="/testMain",method=RequestMethod.GET)
	public String testMain(HttpServletRequest request) {
		
		return "testMain";
	}
	@RequestMapping(value="/pwModifyForm",method=RequestMethod.GET)
	public String pwModifyForm(HttpServletRequest request) {
		
		return "pwModifyForm";
	}
	@RequestMapping(value="/remove",method=RequestMethod.GET)
	public ModelAndView remove(HttpServletRequest request,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		session = request.getSession();
		Member member= (Member) session.getAttribute("member"); 
		mav.addObject("member",member);  //뷰단에서 member객체 호출가능
		
		Member mem=service.remove(member);
		if(mem==null) {
			mav.setViewName("removeFail");
			return mav;
		}
		session.invalidate();
		mav.setViewName("removeSuccess");
		return mav;
	}
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		Member member = (Member)session.getAttribute("member");
		mav.addObject("member", member);
		mav.setViewName("logout");
		session.invalidate(); //session 초기화
		
		return mav;
	}
}
