package com.pretty.dog.controller;

import java.util.HashMap;
import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.pretty.dog.dto.DogDTO;
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
	
	
	
	
	String hashText="";
	@RequestMapping(value = "/joinShs", method = RequestMethod.POST)
	public String joinShs(Model model,@RequestParam String id,@RequestParam String pw,
			@RequestParam String name,@RequestParam String phone,@RequestParam String email,@RequestParam String nickname) {
		logger.info("일반 회원가입 요청");	
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		hashText = encoder.encode(pw);
		logger.info("암호화값 {}",hashText);
		int row = service.joinShs(id,hashText,name,phone,email,nickname);
		if(row>0) {
			String msg = "회원가입에 실패하였습니다.";
			model.addAttribute("msg",msg);
		}
		return "Main";
	}
	
	@RequestMapping(value = "/ShopJoinFormshs", method = RequestMethod.GET)
	public String ShopjoinShs(Model model) {
		logger.info(" 점주 회원가입 페이지");
		
		return "ShopJoinFormshs";
	}
	
	
	@RequestMapping(value = "/ShopjoinShs", method = RequestMethod.POST)
	public String ShopjoinShs(Model model,@RequestParam String id,@RequestParam String pw,
			@RequestParam String name,@RequestParam String phone,@RequestParam String email,@RequestParam String nickname) {
		logger.info("점주 회원가입 요청");	
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		hashText = encoder.encode(pw);
		logger.info("암호화값 {}",hashText);
		int row = service.ShopjoinShs(id,hashText,name,phone,email,nickname);
		if(row>0) {
			String msg = "회원가입에 실패하였습니다.";
			model.addAttribute("msg",msg);
		}
		
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
	
	
		
		
		@RequestMapping(value = "/memberPassCk", method = RequestMethod.GET)
		public String memberPassCk(Model model,HttpSession session) {
//			logger.info("비밀번호체크 페이지 컨트롤러");	
			String object = (String) session.getAttribute("loginId");

			String Page ="redirect:/loginPage";
			if(object != null) {
				session.getAttribute("loginId");
				Page ="MemberCkshs";
			}	

			return Page;
			}
		
		
		@RequestMapping(value = "/PassCk", method = RequestMethod.POST)
		public String PassCk(Model model,HttpSession session, @RequestParam String pw,@RequestParam String id) {
//			logger.info("비밀번호체크 컨트롤러{}",pw+id);	
			Object object = session.getAttribute("loginId");
		
			String Page ="redirect:/loginPage";
			if(object != null) {
				session.getAttribute("loginId");
				String msg ="비밀번호가 일치하지 않습니다.";
				String Ck = service.PassCk(id,pw);
				
				if(Ck != null) {
					Page ="redirect:/MyjungboSujungshs";
				}else {
					Page ="redirect:/memberPassCk";

				}
				
				
			}	
		
			return Page;
		}
		
		
		//개인정보 수정페이지
		@RequestMapping(value = "/MyjungboSujungshs", method = RequestMethod.GET)
			public String memberDe(Model model,HttpSession session) {
			
				String id = (String) session.getAttribute("loginId");
				logger.info("세션아이디 값 : {}",id);
				
				DogDTO dto = service.MyjungboSujungshs(id);
				model.addAttribute("info", dto);
				
			return "MyjungboSujungshs";
		}
		
		//매장정보 수정페이지
		@RequestMapping(value = "/MyShopInfoshs", method = RequestMethod.GET)
			public String MyjungboSujungshs(Model model,HttpSession session) {
					
				String id = (String) session.getAttribute("loginId");
				logger.info("세션아이디 값 : {}",id);
						
				DogDTO dto = service.MyShopInfoshs(id);
				model.addAttribute("shopinfo", dto);
						
			return "MyShopInfoshs";
		}
		
		
		
	//개인 강아지 등록페이지
		@RequestMapping(value = "/MyDogInfoshs", method = RequestMethod.GET)
		public String MyDogInfoshs(Model model,HttpSession session) {
				
			String id = (String) session.getAttribute("loginId");
			logger.info("세션아이디 값 : {}",id);
		
		return "MyDogInfoshs";
	}		
		
		//개인 강아지 등록페이지
		@RequestMapping(value = "/DogUp", method = RequestMethod.POST)
		public String DogUp(Model model,HttpSession session,@RequestParam String dogname,@RequestParam String dogage
				,@RequestParam String dogweight,@RequestParam String dogchar) {

			String id = (String) session.getAttribute("loginId");
			
			int row= service.DogUp(id,dogname,dogage,dogweight,dogchar); 
			
		return "Main";
	}	
		
		//애견 정보 확인 등록페이지
		@RequestMapping(value = "/Mydogshs", method = RequestMethod.GET)
		public String DogUp(Model model,HttpSession session) {

			String id = (String) session.getAttribute("loginId");
			logger.info("세션아이디 값 : {}",id);
					
			//DogDTO dto = service.Mydogshs(id);
			
			//model.addAttribute("mydoginfo", dto);
			
		return "Mydogshs";
	}	



		
	
}


