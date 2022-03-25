package com.pretty.dog.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

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

import com.pretty.dog.service.SshShopListService;

@Controller
public class SshShopController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired SshShopListService sshShopListService;
	
	// 매장 리스트 페이지 이동(영우님)
	@RequestMapping(value = "/sshShopList", method = RequestMethod.GET)
	public String sshShopList(Model model) {
		logger.info("shop리스트 페이지 이동");
		ArrayList<HashMap<String,Object>> sshShopList = sshShopListService.sshShopList();
		System.out.println("sshShopList.size()" + sshShopList.size());
		model.addAttribute("sshShopList", sshShopList);
		return "sshShopList";
	}
	
	// 매장 상세보기 페이지 이동
	@RequestMapping(value = "/sshShopDetail", method = RequestMethod.GET)
	public String sshShopDetail(Model model, @RequestParam String idx, HttpSession session) {
		logger.info("sshShopDetail리스트 페이지 이동");
		System.out.println("매장번호" + idx);
		String memId = (String) session.getAttribute("loginId");
		System.out.println("로그인한 아이디"+memId);
		String page = "sshShopDetail";
		ArrayList<HashMap<String,Object>> sshShopDetail = sshShopListService.sshShopDetail(idx);
		ArrayList<HashMap<String,Object>> sshMyInterestShopList = sshShopListService.sshMyInterestShopList(memId, idx);
		ArrayList<HashMap<String,Object>> sshShopQnaList = sshShopListService.sshShopQnaList(idx);
		ArrayList<HashMap<String,Object>> sshShopQnaIdChk = sshShopListService.sshShopQnaIdChk(memId);
		ArrayList<HashMap<String,Object>> sshShopQnaNnswerList = sshShopListService.sshShopQnaNnswerList();
		ArrayList<HashMap<String,Object>> sshShopRevList = sshShopListService.sshShopRevList(idx);
		ArrayList<HashMap<String,Object>> revLength = sshShopListService.revLength(memId, idx);
		//System.out.println("revLength 길이 : " + revLength.size());
		//System.out.println("sshMyInterestShopList 샾 길이 : " + sshMyInterestShopList.size());
		//System.out.println("revLength 프라이머리키값 : " + revLength.get(0).get("reser_num"));
		//System.out.println("sshShopQnaIdChk size() : " +  revLength.size() );
		System.out.println("sshShopDetail 값 : "+sshShopDetail);

		if(revLength.size() == 0) {
			model.addAttribute("reser_num", 0);
			//int reser_num = (int)revLength.get(0).get("reser_num");
			if(sshShopDetail.size() == 0) {
				ArrayList<HashMap<String,Object>> sshShopDetailTwo = sshShopListService.sshShopDetailTwo(idx);
				model.addAttribute("sshShopDetail", sshShopDetailTwo);
			}else {
				model.addAttribute("sshShopDetail", sshShopDetail);
			}
			model.addAttribute("sshShopQnaList", sshShopQnaList);
			model.addAttribute("memId", memId);
			model.addAttribute("sshMyInterestShop_size", sshMyInterestShopList.size());
			model.addAttribute("sshShopQnaIdChk", sshShopQnaIdChk);
			model.addAttribute("sshShopQnaNnswerList", sshShopQnaNnswerList);
			model.addAttribute("sshShopRevList", sshShopRevList);
			model.addAttribute("revLength_size", revLength.size());
			return page;
		}else {
			if(sshShopDetail.size() == 0) {
				ArrayList<HashMap<String,Object>> sshShopDetailTwo = sshShopListService.sshShopDetailTwo(idx);
				model.addAttribute("sshShopDetail", sshShopDetailTwo);
			}else {
				model.addAttribute("sshShopDetail", sshShopDetail);
			}
			int reser_num = (int)revLength.get(0).get("reser_num");
			model.addAttribute("sshShopQnaList", sshShopQnaList);
			model.addAttribute("memId", memId);
			model.addAttribute("sshMyInterestShop_size", sshMyInterestShopList.size());
			model.addAttribute("sshShopQnaIdChk", sshShopQnaIdChk);
			model.addAttribute("sshShopQnaNnswerList", sshShopQnaNnswerList);
			model.addAttribute("sshShopRevList", sshShopRevList);
			model.addAttribute("reser_num", reser_num);
			model.addAttribute("revLength_size", revLength.size());
			return page;
		}
	}
	
	// QnA 답변 체크된 리스트 요청
	@RequestMapping(value = "/qnaComChk", method = RequestMethod.POST)
	@ResponseBody
	public List<HashMap<String, Object>> qnaComChk(Model model, @RequestParam(value="a[]") List<String> a) {
		System.out.println("여기로 오냐고");
		System.out.println(a);
		List<HashMap<String,Object>> qnaComChk = sshShopListService.qnaComChk(a);
		System.out.println(qnaComChk);
		/*
		 * HashMap<String, Object> map = new HashMap<String, Object>();
		 * map.put("qnaComChk", qnaComChk);
		 */
		//if(qnaComChk)
		
		return qnaComChk;
	}
	
	// QnA답변 달기 요청
	@RequestMapping(value = "/QnaNnswerInsert", method = RequestMethod.GET)
	public String QnaNnswerInsert(Model model, @RequestParam String QnaNnswerText, HttpSession session, @RequestParam String qnaDivNum, @RequestParam String busin_num) {
		logger.info("QnaNnswerText :  "+ QnaNnswerText);
		String memId = (String) session.getAttribute("loginId");
		System.out.println("로그인한 아이디"+memId);
		logger.info("qnaDivNum :  "+ qnaDivNum);
		logger.info("busin_num :  "+ busin_num);
		sshShopListService.QnaNnswerInsert(QnaNnswerText, memId, qnaDivNum);
		return "redirect:/sshShopDetail?idx="+busin_num;
		//return "redirect:/beautyTrendList";
	}
	
	// QnA 달기 요청
	@RequestMapping(value = "/QnaWrite", method = RequestMethod.GET)
	public String QnaWrite(Model model, @RequestParam String qnaText, HttpSession session,@RequestParam String busin_num) {
		logger.info("QnaText QnaTextQnaText:  "+ qnaText);
		String memId = (String) session.getAttribute("loginId");
		System.out.println("로그인한 아이디"+memId);
		logger.info("busin_num busin_numbusin_num:  "+ busin_num);
		sshShopListService.QnaWrite(qnaText,memId,busin_num);
		return "redirect:/sshShopDetail?idx="+busin_num;
		//return null;
	}
	
	// 리뷰 달기 요청
	@RequestMapping(value = "/reviewWrite", method = RequestMethod.POST)
	public String reviewWrite(Model model, MultipartFile photos, @RequestParam HashMap<String, Object> params) {
		logger.info("글쓰기 요청 : {}", params);
		logger.info("업로드 할 파일 명 : {}", photos.getOriginalFilename());
		System.out.println("컨트롤러 reser_num : " + params.get("reser_num"));
		return sshShopListService.reviewWrite(params, photos);
		//return null;
	}
	
	// 리뷰 삭제 요청
	@RequestMapping(value = "/ReviewDelete")
	public String ReviewDelete(@RequestParam String idx, @RequestParam String newFilename, HttpSession session,@RequestParam String busin_num) {
		System.out.println("삭제 요청 번호 : " + idx);
		 System.out.println("삭제 요청 이미지 이름 : " + newFilename);
		 String memId = (String) session.getAttribute("loginId");
		 System.out.println("로그인한 아이디"+memId);
		 System.out.println("삭제 요청 사업자번호 : " + busin_num);
		 //sshShopListService.ReviewDelete(idx, newFilename);
		 //return "redirect:/sshShopDetail?idx="+busin_num+"&memId="+memId;
		 return null;
	 }

	// 매장 좋아요 추가/삭제 제어 요청
	@RequestMapping(value = "/myShopLike")
	public String myShopLike(@RequestParam String likeVal, HttpSession session, @RequestParam String idx) {
		System.out.println("매장 좋아요 상태 : " + likeVal);
		String memId = (String) session.getAttribute("loginId");
		 System.out.println("로그인한 아이디"+memId);
		System.out.println("매장 번호 : " + idx);
		String page = "redirect:/sshShopDetail?idx="+idx;
		if(likeVal.equals("0")) {
			sshShopListService.myShopLikeInsert(memId, idx);
			sshShopListService.shopLikeUpdate(idx);
			return page;
			//return null;
		}else {
			sshShopListService.myShopLikeDelete(memId,idx);
			sshShopListService.shopLikeDown(idx);
			return page;
			//return null;
		}
		
	 }
}



























































































































