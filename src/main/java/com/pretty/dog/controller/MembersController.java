package com.pretty.dog.controller;

import java.util.HashMap;
import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.executor.ReuseExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.multipart.MultipartFile;

import com.pretty.dog.service.MembersService;


@Controller
public class MembersController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired MembersService service;
	@Autowired private JavaMailSender mailSender;
	@Autowired HttpSession session;

	
	
	@RequestMapping(value = "/JoinFormshs", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("회원가입 페이지");
		
		return "JoinFormshs";
	}
	
	
	
	
	@RequestMapping(value = "/joinShs", method = RequestMethod.POST)
	public String join(Model model,@RequestParam HashMap<String, String> params) {
		logger.info("일반 회원가입 요청");	
		logger.info("params : {}",params);
		service.joinShs(params);
		
		return "Main";
	}
	
	
	@RequestMapping(value = "/ShopJoinFormshs", method = RequestMethod.GET)
	public String ShopjoinShs(Model model) {
		logger.info(" 점주 회원가입 페이지");
		
		return "ShopJoinFormshs";
	}
	
	
	@RequestMapping(value = "/ShopjoinShs", method = RequestMethod.POST)
	public String ShopjoinShs(Model model,@RequestParam HashMap<String, String> params,@RequestParam String id,@RequestParam String nickname) {
		logger.info("점주 회원가입 요청");	
		logger.info("params : {}",params);
		
		service.ShopjoinShs(params);
		model.addAttribute("id",id);
		model.addAttribute("nickname",nickname);
		return "ShopInfoFormshs";
	}
	
	@RequestMapping(value = "/ShopInfo", method = RequestMethod.POST)
	public String ShopInfo(Model model,MultipartFile shopPhoto,@RequestParam HashMap<String, String> params,@RequestParam String shopSaup) {
		logger.info("점주 매장정보 요청 컨트롤러");	
		logger.info("params : {}",params);
		logger.info("shopPhoto : {}",shopPhoto);
		service.ShopInfo(shopPhoto,params,shopSaup);
		
		return "Main";
	}
	
	
	
	
	
	@GetMapping(value="/mailCheck",consumes = {MediaType.TEXT_PLAIN_VALUE})
	@ResponseBody
	public String mailCheck(String email) throws Exception{
//		logger.info("이메일 데이터 전송확인");
//		logger.info("인증 메일 : "+email);
		
		Random random = new Random();
		int checkNum = random.nextInt(888888)+111111; // 111111 - 999999
//		logger.info("인증번호 : "+checkNum);
		
		//이메일 보내기
		String setFrom = "PrettyDog";
		String toEmail = email;
		String title = "PrettyDog 회원가입 인증 이메일 입니다.";
		String content = "PrettyDog 가입해주셔서 감사합니다."+ "<br/><br/>"+"인증 번호는 "+checkNum+" 입니다.<br/>"+
							"해당 인증번호를 인증번호 확인란에 기입하여 주세요.";
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
            helper.setFrom(setFrom);
            helper.setTo(toEmail);
            helper.setSubject(title);
            helper.setText(content,true);
            mailSender.send(message);
            
            
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        String num = Integer.toString(checkNum);
        return num;
	}
	


		//ajax 통신 - 중복 아이디 확인
		@RequestMapping(value = "/overlayid", method = RequestMethod.GET)
		@ResponseBody
		public HashMap<String, Object> overlayid(@RequestParam String id) {		
			logger.info("중복 아이디 체크 : {}",id);		
			return service.overlayShsid(id);
		}		
		


		@RequestMapping(value = "/ShopInfoFormshs", method = RequestMethod.GET)
		public String ShopInfoFormshs(Model model) {
			logger.info(" 점주 회원가입 페이지");
			
			return "ShopInfoFormshs";
		}
		
		
// 여기까지가 회원가입 기능 		
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	

		@RequestMapping(value = "/ShopPriFormshs", method = RequestMethod.GET)
		public String ShopPrifo(Model model) {
			logger.info("요금표 폼");	

			return "ShopPriFormshs";
		}
	
	
		
		
		@RequestMapping(value = "/MemberCkshs", method = RequestMethod.GET)
		public String memberPassCk(Model model,HttpSession session) {
//			logger.info("비밀번호체크 페이지 컨트롤러");	

			return "MemberCkshs";
			}
		

		
	
}


