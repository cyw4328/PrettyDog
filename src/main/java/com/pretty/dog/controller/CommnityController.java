package com.pretty.dog.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.pretty.dog.dto.CommunityDTO;
import com.pretty.dog.dto.DogDTO;
import com.pretty.dog.service.CommunityService;

@Controller
public class CommnityController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired CommunityService communityService;	
	
	//리스트 페이지 이동, 카테고리 리스트 출력
	@RequestMapping(value =  {"/freeList","/categoryList"}, method = RequestMethod.GET)
	   public String home(Model model) {
	      logger.info("리스트 페이지로 이동, 카테고리 출력");
	      ArrayList<CommunityDTO> arr = communityService.categoryList();
	      model.addAttribute("category",arr);
	      return "freeList";
	   }
		
		// 게시판 리스트 출력,페이징 
	   @RequestMapping(value="/listCall")
	   @ResponseBody
	   public HashMap<String, Object> listCall(@RequestParam HashMap<String, Object> params) {
		  logger.info("리스트요청"); 
	      logger.info("리스트 요청 : {} 페이지, {} 개씩",params.get("page"),params.get("cnt"));
	      
	      System.out.println(params.get("page")+" / "+params.get("cnt")+" / "+params.get("catNum"));
	      
	      int currPage = Integer.parseInt((String) params.get("page"));
	      int pagePerCnt = Integer.parseInt((String) params.get("cnt"));
	      
	      //카테고리번호, 블라인드 코드, 관리자 카테고리 코드가 붙어 있어 카테고리번호만 추출해야 한다.
	      
	      String catNumCut = (String) params.get("catNum");//스트링으로 catNum 받기
	      
	      String catNumSave = catNumCut.substring(0,1);//0번쨰 1개 컷
	      
	      System.out.println("카테고리 넘버 : "+catNumSave);
	      
	      int catNum = Integer.parseInt(catNumSave);//추출한 값 인트 변환
	      
	      logger.info("params:{}",params);
	      logger.info("현재 페이지 "+currPage+" / 페이지 갯수"+pagePerCnt);
	      
	      
	      HashMap<String, Object> map = new HashMap<String, Object>();

	      map = communityService.listCall(currPage,pagePerCnt,catNum);
	      
	      return map;
	   }
	
	  
	   
	//검색
	/*   
	@RequestMapping(value = "/freeSearch")
	   public ModelAndView freeSearch(@RequestParam HashMap<String, String> params) {

	      logger.info("검색 요청");
	      logger.info("params:{}",params);
	      
	      return communityService.freeSearch(params);
	   }
	 */
	   
	//게시판  게시물 작성 페이지 이동, 카테고리 호출
	@RequestMapping(value = "/freeWriteForm", method = RequestMethod.GET)
	   public String writeForm(Model model) {
	      logger.info("자유게시판 글쓰기 페이지 요청, 카테고리 출력");
	      ArrayList<CommunityDTO> arr = communityService.categoryList();
	      model.addAttribute("category",arr);
	      return "freeWriteForm";
	   }
	
	//게시물 작성, 사진 업로드
	/**
	 @RequestMapping(value = "/freeWrite", method = RequestMethod.POST)
	   //write 라는 요청이 오면 할 동작들, 다수의 데이터를 주고 받기에 POST 사용
	   public String freeWrite(Model model, MultipartFile imgs, @RequestParam HashMap<String, Object> params) {
		   				//MultipartFile은 업로드한 파일을 받을 수 있다. 다수의 데이터를 받아야 하기에 해쉬맵(게시물 정보)	
		 
	      logger.info("글쓰기 요청 : {}",params);
	      //글쓰기 요청 : {subject,user, content}
	    
	      //파일이 저장된 배열의 길이 - 파일의 갯수
	      //서비스에서 어느 페이지로 보낼건지 결정
	      return communityService.freeWrite(imgs,params);
	      //사진(배열),게시물내용(HM)을 매개변수로 서비스의 write 매서드를 실행 
	   }
	**/
	 
		@RequestMapping(value = "/freeWrite", method = RequestMethod.POST)
		   // MultipartFile 을 배열 형식으로 받는 이유는 writeForm에서 input타입 설정 할때 멀티플 속성을 사용해서 이다
		   // @RequestParam 에서 HashMap<String, String> 을 사용한 이유는 writeForm 에서 받아오는 값이 3개 이상이어서 이다.
		   public String beautyTrendWrite(Model model, MultipartFile imgs, @RequestParam HashMap<String, Object> params) {
		      logger.info("글쓰기 요청 : {}", params);
		      logger.info("업로드 할 파일 명 : {}", imgs.getOriginalFilename());
		      return communityService.freeWrite(imgs,params);
		   }
		
		
	
	 @RequestMapping(value = "/freeDetail", method = RequestMethod.GET)
	   public String freeDetail(Model model,@RequestParam String community_boardnum) {
	      logger.info("상세보기 : {}",community_boardnum);
	      
	      //게시글 가져오기
	      CommunityDTO dto = communityService.freeDetail(community_boardnum);
	      logger.info("community_date:{}",dto.getCommunity_date());
	      model.addAttribute("dto", dto);
	      
	      //사진 목록 가져오기
	      ArrayList<CommunityDTO> photos = communityService.photoList(community_boardnum);
	  
	    		  if(photos.size()!=0) {
	    			  
	    			  photos.get(0).getBphoto_newname();
	    			  
	    		  }
	    		 
	      logger.info("사진 수 : {}",photos.size());
	      model.addAttribute("photos", photos);
	      
	      return "freeDetail";
	   }
	
	
	 @RequestMapping(value = "/freeDelete", method = RequestMethod.GET)
	   public String freeDelete(Model model, @RequestParam String community_boardnum) {
	      logger.info("delete : {}", community_boardnum);
	      
	      communityService.freeDelete(community_boardnum);
	      
	      return "redirect:/freeList";
	   }
	
	
	 @RequestMapping(value = "/freeUpdateForm", method = RequestMethod.GET)
	   public String freeUpdateForm(Model model, @RequestParam String community_boardnum) {
	      logger.info("updateForm : {}",community_boardnum);
	      ArrayList<CommunityDTO> arr = communityService.categoryList();
	      model.addAttribute("category",arr);
	      return communityService.freeUpdateForm(model,community_boardnum);
	   }   
	 
	 
	 @RequestMapping(value = "/freeUpdate", method = RequestMethod.POST)
	   public String freeUpdate(Model model, MultipartFile imgs, @RequestParam HashMap<String, String> params) {
	      logger.info("수정 요청 : {}",params);
	      return communityService.freeUpdate(imgs,params);
	   }
	 
	 
	 
	 
	
	
	
}
