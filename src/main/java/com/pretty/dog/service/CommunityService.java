package com.pretty.dog.service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.pretty.dog.dao.CommunityDAO;
import com.pretty.dog.dto.CommunityDTO;


@Service
public class CommunityService {
	
	@Autowired CommunityDAO communityDao;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/*
	public ArrayList<DogDTO> freeList() {
		logger.info("리스트 불러오기");				
		return communityDao.freeList();
	}
	*/
	
	//카테고리 불러오기
	public ArrayList<CommunityDTO> categoryList() {		
		return communityDao.categoryList();
	}
	
	
	//페이징
		 public HashMap<String, Object> listCall(int currPage, int pagePerCnt, int catNum ) {
		      
		      HashMap<String, Object> map = new HashMap<String, Object>(); 
		      
		      int offset = ((currPage-1) * pagePerCnt-1) >=0 ? ((currPage-1) * pagePerCnt-1) : 0; //어디서부터 보여줘야 하는가?
		      
		      int totalCount = communityDao.allCount(catNum);
		      
		      int range = totalCount%pagePerCnt>0?	
		    		  (totalCount/pagePerCnt)+1:(totalCount/pagePerCnt);
		      logger.info("총갯수:{}",totalCount);
		      logger.info("만들 수 있는 총 페이지:{}",range);
		      
		      logger.info("리스트 콜 서비스 : DAO 호출");
		      
		      map.put("pages",range);
		      map.put("list",communityDao.listCall(pagePerCnt, offset, catNum));
		      
		      //logger.info("Map에 담긴 정보"+map);
		      
		      return map;
		   }
	
	//게시판 검색
	/**	 
	public ModelAndView freeSearch(HashMap<String, String> params) {
		ModelAndView mav = new ModelAndView();
		ArrayList<CommunityDTO> list = communityDao.freeSearch(params);
		mav.addObject("list", list);
		mav.setViewName("freeList");
		return mav;
	}
	**/
		 
	/**
	public String freeWrite(MultipartFile imgs, HashMap<String, Object> params) {
		
		String page = "redirect:/";
		//우리는 방금 insert한 글의 idx를 뽑아내야 한다.
		//성공하면 특정 상세보기로 넘어갈때 글번호가 필요하기에
		//파일을 업로드한 경우 photo table에 글번호를 넣어야 하기에
		//방금 넣은 데이터에 대한 idx를 알고 싶다면 몇가지 조건이 있다.
		
		//조건1. parameter는 DTO형태로 넣을 것
		
		CommunityDTO dto = new CommunityDTO();
		//DB의 데이터를 Service나 Controller 등으로 보낼 때 사용하는 객체
		//BoardDTO의 경우 
		dto.setCommunity_sub((String) params.get("community_sub"));
		dto.setMem_id((String) params.get("mem_id"));
		dto.setCommunity_cont((String) params.get("community_cont"));
		//카테고리 값
		dto.setCategory_num(Integer.parseInt((String) params.get("category_num")));

		System.out.println(imgs);
		
		communityDao.freeWrite(dto);
		
		//그렇게 실행하고 나면 dto에 방금 넣은 게시물에 대한 idx가 담겨져 나온다
		//idx? 
		int idx = dto.getCommunity_boardnum();
		logger.info("idx: " + idx);
		if(idx>0){
			page="redirect:/freeList";
			saveFile(idx,imgs);//파일 저장 처리
		}
		return page;
	}
	**/
		
	
	public String freeWrite(MultipartFile photos, HashMap<String, Object> params){
		
		
	      String page = "redirect:/";
	      HashMap<String, Object> freeWrite = params;
	      //HashMap<String, Object> beautyTrendWrite = new HashMap<String, Object>();
	      logger.info("프리라이트 서비스");
	      freeWrite.put("community_sub", params.get("community_sub"));
	      freeWrite.put("community_cont", params.get("community_cont"));
	      freeWrite.put("mem_id", params.get("mem_id"));
	      freeWrite.put("category_num",Integer.parseInt((String) params.get("category_num")));
	      //dto.setCategory_num(Integer.parseInt((String) params.get("category_num"))
	      freeWrite.put("community_boardnum", 0);
	      
	      System.out.println(freeWrite.get("community_sub"));
	      System.out.println(freeWrite.get("community_cont"));
	      System.out.println(freeWrite.get("mem_id"));
	      System.out.println(freeWrite.get("category_num"));
	      
	      communityDao.freeWrite(freeWrite);
	       
	
	      //System.out.println(beautyTrendWrite.get("community_boardnum"));
	        
	      int community_boardnum = (int)freeWrite.get("community_boardnum");
	      if(community_boardnum > 0) {
	         page = "redirect:/freeDetail?idx="+community_boardnum;
	         saveFile(community_boardnum, photos);
	      }
	      return page;
	   }
	 
	
	/**
	private void saveFile(int idx, MultipartFile[] imgs) {
		logger.info("파일 업로드 서비스");

		for(MultipartFile photo : imgs) {
	         
	         try {
	            String oriFileName = photo.getOriginalFilename(); //원본 파일명을 추출
	            
	            int index = oriFileName.lastIndexOf("."); //뒤에서부터 . 을 찾아 해당 인덱스의 번호를 반환
	            String ext = oriFileName.substring(index); //인자값 인덱스부터 이하의 부분을 반환 (확장자를 추출하는 과정)
	            
	            //방어 코트 : 예외가 발생 예상되는 지점을 피해가도록 처리
	            if(index>0) {
	               String newFileName = System.currentTimeMillis()+ext; // 새로운 파일명을 생성하기 위해 (중복 회피)
	               logger.info(oriFileName+" => "+newFileName);
	               
	               //파일 저장 (photo 로 부터 byte를 뽑아내 경로를 지정하여 넣는다.)
	               //steam 을 사용하지 않았기 때문에 합리적으로 nio 를 사용했다고 생각 할 수는 있다.
	               byte[] bytes = photo.getBytes();
	               
	               Path path = Paths.get("C:/STUDY/PrettyDog/PrettyDog/src/main/webapp/resources/commu/" + newFileName);;
	               
	               Files.write(path,bytes);
	               logger.info(oriFileName + " SAVE OK!! ");
	               //DB 에 저장한 파일명을 기록
	               communityDao.fileWrite(idx,oriFileName,newFileName);               
	            }
	            
	            
	            Thread.sleep(1);
	            
	         } catch (Exception e) {
	            e.printStackTrace();
	         }
	      }
		
	}
	**/
	
	   private void saveFile(int idx, MultipartFile imgs){
		   
	      String oriFileName = imgs.getOriginalFilename();
	      logger.info("세이브 파일 서비스");
	      int index = oriFileName.lastIndexOf(".");
	      try {
	         if(index>0) {
	            String ext = oriFileName.substring(index);// 확장자(보여주기 시작할 인덱스)
	            logger.info("ext : {}", ext);
	            String newFileName = System.currentTimeMillis()+ext; // 새로운 파일명 생성(중복을 피하기 위해 / 확장자 없으면 사용 불가)
	            logger.info(oriFileName + " = >" + newFileName);
	            byte[] bytes = imgs.getBytes(); // photo에 여러개의 정보(파일명/크기/byte... 등등)가 있지만 byte만 뽑아와서 byte[]배열에 담아준다
	            
	            Path path = Paths.get("C:/STUDY/PrettyDog/PrettyDog/src/main/webapp/resources/commu/" + newFileName); // 파일을 저장할 경로와 파일 이름을 설정해 준다.
	            // 스트림을 사용 안해서 Files가  nio 라는걸 알수 있다 Files의 라이트 메서드를 사용해서(저장할 위치와 photo로부터 뽑아온 byte[]의 값을 사용해서 저장한다.)
	            // 이때는 그냥 컴퓨터에 저장을 하는것(DB에 저장은 dao로 해야 한다.)
	            System.out.println(path);
	            Files.write(path, bytes);
	            // Files.write(path, bytes); 까지 성공 하면 컴퓨터에 저장이 된거기 때문에 oriFileName 을 출력할수 있기 때문에 logger 로 확인해 본다
	            logger.info(oriFileName + "SAVE OK!!"); 
	            communityDao.fileWrite(idx, oriFileName, newFileName);// DB 에 저장할 파일명을 기록               
	         }
	      } catch (Exception e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	   }
	
	public CommunityDTO freeDetail(String community_boardnum) {

		CommunityDTO dto = null;
		int success=communityDao.community_view(community_boardnum);
		
		if(success>0) {
			
			dto = communityDao.detail(community_boardnum);
		}
		return dto;
		
	}
	
	
	
	public ArrayList<CommunityDTO> photoList(String community_boardnum) {
		// TODO Auto-generated method stub
		return communityDao.photoList(community_boardnum);
	}


	public void freeDelete(String community_boardnum) {
		 //1. 게시물에 사진이 있는지 확인
	      ArrayList<CommunityDTO> list = communityDao.photoList(community_boardnum);
	      
	      //2. 게시물 삭제
	      int success = communityDao.freeDelete(community_boardnum);

	      //3. 삭제가 완료되면 D:/upload/ 에 해당 파일 삭제(이때 newFileName을 이용)
	      
	      if(success>0) {
	         for(CommunityDTO dto : list) {
	            //4. 있으면 업로드 된 사진 이름(newFileName) 알아오기
	            File file = new File("C:/STUDY/PrettyDog/PrettyDog/src/main/webapp/resources/commu/"+dto.getBphoto_newname());
	            boolean yn = file.delete();      
	            logger.info(dto.getBphoto_oriname()+" delete : "+yn);
	         }         
	      }
		
	}


	public String freeUpdateForm(Model model, String community_boardnum) {

			CommunityDTO dto = communityDao.detail(community_boardnum);
			ArrayList<CommunityDTO> list = communityDao.photoList(community_boardnum);
	      
			logger.info("subject : "+dto.getCommunity_sub());
			logger.info("category : "+dto.getCategory_num());
			logger.info("cont : "+dto.getCommunity_cont());
			logger.info("photo : {}",list);
	      
			model.addAttribute("dto",dto);
			model.addAttribute("photos",list);
		
		
		return "freeUpdateForm";
	}


	public String freeUpdate(MultipartFile imgs, HashMap<String, String> params) {
		

		int community_boardnum = Integer.parseInt(params.get("community_boardnum"));
	      String page = "redirect:/updateForm?idx="+community_boardnum;
	      
	      if(communityDao.freeUpdate(params)>0) {
	         page = "redirect:/detail?idx="+community_boardnum;
	         saveFile(community_boardnum,imgs);
	      }
	      
	      return page;
		
		
		
		
	}


	



	
	
	
	
	
	
	
}
