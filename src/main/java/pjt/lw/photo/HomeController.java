package pjt.lw.photo;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.Document;

import pjt.lw.Member.Member;
import pjt.lw.photo.service.MemberService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	MemberService service;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */

	
	@ModelAttribute("serverTime")
	public String getServerTime(Locale locale) {
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		return dateFormat.format(date);
	}
	@RequestMapping(value = "/loginForm", method = RequestMethod.GET)
	public String loginForm() {
		
		return "/loginForm";
	}
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		
		
		return "/home";
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
	@RequestMapping(value = "/uploadForm", method = RequestMethod.GET)
	public String uploadForm(HttpServletRequest request) {
		

		
				
		return "uploadForm";
	}
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(MultipartFile	uploadfile,HttpServletResponse response) {
		
		  logger.info("upload() POST ȣ��");
		    logger.info("���� �̸�: {}", uploadfile.getOriginalFilename());
		    logger.info("���� ũ��: {}", uploadfile.getSize());
		    if(service.imgInsert(uploadfile))
		    	try {
		    	PrintWriter outs=response.getWriter();
				outs.println("<script>alert('Success.'); location.href='/photo/home';</script>");  // java���� js ��ɾ� ���
				outs.flush();
				return "/home";
		    	}
		    catch (Exception e) {
		    	System.out.println("uploadError"+e.toString());
			}
		    else {
		    	try {
			    	PrintWriter outs=response.getWriter();
					outs.println("<script>alert('Fail.'); location.href='/photo/home';</script>");  // java���� js ��ɾ� ���
					outs.flush();
					return "/home";
			    	}
			    catch (Exception e) {
			    	System.out.println("uploadError"+e.toString());
				}
		    }
		
		
		
		return "upload";
	}
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String main(Locale locale, Model model,HttpServletRequest request) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		String realPath=request.getSession().getServletContext().getRealPath("/");

		
		System.out.println(realPath);
		
		return "/home";
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(Member member, HttpSession session, HttpServletResponse response,Model model) {
		Member mem = service.search(member); 
		
		if(mem==null) {
			try {	
				PrintWriter out=response.getWriter();
				out.println("<script>alert('�α��� 	������ ��ġ���� �ʽ��ϴ�.'); location.href='/photo/home';</script>");  // java���� js ��ɾ� ���
				out.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return "/loginForm";
		}
		session.setAttribute("member", mem);
		model.addAttribute("mem",mem);
//		session.setAttribute("imgLength", mem.getImgUrl());
		return "/home";
	}
	@RequestMapping(value="/joinForm",method=RequestMethod.GET)
	public String joinForm(Member member, HttpServletRequest request) {

		return "/joinForm";
	}
	@RequestMapping(value="/join",method=RequestMethod.POST)
	public String join(Member member, HttpServletRequest request) {
		Member mem = service.insert(member);
		
		if(mem==null) {
			request.setAttribute("member", member);
			return "joinFail";
		}
		
		return "/joinSuccess";
	}
	@RequestMapping(value="/idModify",method=RequestMethod.POST)
	public String idModify(HttpServletRequest request) {
		String memId=request.getParameter("memId");
		String reMemId=request.getParameter("reMemId");
		if(memId.equals(reMemId)) {

			
			Member member=service.modify(memId,"ID");   // ID���� PW������ service ��ü���� �����ϱ� ���� string �� ����
			request.setAttribute("member", member);  // request.setAttribute() �����Ͽ� ��ܿ��� memberŬ���� getter ���
			if(member==null) {
				return "modifyFail";
			}
			return "/modifySuccess";
		}
		else {
			return "/modifyFail";
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
			return "/modifySuccess";
		}
		else {
			return "/modifyFail";
		}
		
	}
	@RequestMapping(value="/idModifyForm",method=RequestMethod.GET)
	public String idModifyForm(HttpServletRequest request) {

		return "/idModifyForm";
	}
	@RequestMapping(value="/testMain",method=RequestMethod.GET)
	public String testMain(HttpServletRequest request) {
		
		return "testMain";
	}
	@RequestMapping(value="/pwModifyForm",method=RequestMethod.GET)
	public String pwModifyForm(HttpServletRequest request) {
		
		return "/pwModifyForm";
	}
	@RequestMapping(value="/remove",method=RequestMethod.GET)
	public ModelAndView remove(HttpServletRequest request,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		session = request.getSession();
		Member member= (Member) session.getAttribute("member"); 
		mav.addObject("member",member);  //��ܿ��� member��ü ȣ�Ⱑ��
		
		Member mem=service.remove(member);
		if(mem==null) {
			mav.setViewName("removeFail");
			return mav;
		}
		session.invalidate();
		mav.setViewName("/removeSuccess");
		return mav;
	}
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		Member member = (Member)session.getAttribute("member");
		mav.addObject("member", member);
		mav.setViewName("/logout");
		session.invalidate(); //session �ʱ�ȭ
		
		return mav;
	}
	@RequestMapping("/image")
	public void image(HttpServletRequest request,HttpServletResponse res) throws IOException {
		
		
	
		System.out.println("이미지맵핑이빈다.");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
	}
	
}
