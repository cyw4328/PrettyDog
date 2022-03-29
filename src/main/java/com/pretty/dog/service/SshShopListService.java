package com.pretty.dog.service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.pretty.dog.dao.SshShopListDAO;

@Service
public class SshShopListService {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired SshShopListDAO sshShopListDAO;

	public ArrayList<HashMap<String,Object>> sshShopList() {
		System.out.println("sshShopList 서비스 이동");
		return sshShopListDAO.sshShopList();
	}

	public ArrayList<HashMap<String, Object>> sshShopDetail(String idx) {
		System.out.println("sshShopDetail 서비스 이동");
		System.out.println("매장번호" + idx);
		return sshShopListDAO.sshShopDetail(idx);
	}

	public ArrayList<HashMap<String, Object>> sshShopQnaList(String idx) {
		System.out.println("sshShopQnaList 서비스 이동");
		System.out.println("매장 번호" + idx);
		return sshShopListDAO.sshShopQnaList(idx);
	}

	public ArrayList<HashMap<String, Object>> sshShopQnaIdChk(String memId) {
		System.out.println("sshShopQnaIdChk 서비스 이동");
		System.out.println("로그인 아이디 : " + memId);
		return sshShopListDAO.sshShopQnaIdChk(memId);
	}

	public List<HashMap<String, Object>> qnaComChk(List<String> a) {
		System.out.println("qnaComChk 서비스 이동");
		System.out.println("넘어온 아이디 값들 : " + a);
		return sshShopListDAO.qnaComChk(a);
	}

	public void QnaNnswerInsert(String qnaNnswerText, String memId, String qnaDivNum) {
		System.out.println("QnaNnswerInsert 서비스 이동");
		System.out.println("넘어온 답글 내용 : " + qnaNnswerText);
		System.out.println("넘어온 로그인 아이디 : " + memId);
		System.out.println("넘어온 번호 : " + qnaDivNum);
		sshShopListDAO.QnaNnswerInsert(qnaNnswerText, memId, qnaDivNum);
	}

	public ArrayList<HashMap<String, Object>> sshShopQnaNnswerList() {
		System.out.println("sshShopQnaNnswerList 서비스 이동");
		return sshShopListDAO.sshShopQnaNnswerList();
	}

	public void QnaWrite(String qnaText, String memId, String busin_num) {
		System.out.println("QnaWrite 서비스 이동" + qnaText);
		System.out.println("QnaWrite 서비스 이동" + memId);
		System.out.println("QnaWrite 서비스 이동" + busin_num);
		sshShopListDAO.QnaWrite(qnaText,memId,busin_num);
	}

	public ArrayList<HashMap<String, Object>> sshShopRevList(String idx) {
		System.out.println("sshShopRevList 서비스 이동");
		return sshShopListDAO.sshShopRevList(idx);
	}

	@Transactional
	public String reviewWrite(HashMap<String, Object> params, MultipartFile photos) {
		String busin_num = (String)params.get("busin_num");
		System.out.println("Service busin_numbusin_numbusin_num : " + busin_num);
		String page = "redirect:/sshShopDetail?idx="+busin_num;
		//String page = "sshShopDetail?idx="+busin_num;
		HashMap<String, Object> reviewWrite = new HashMap<String, Object>();
		reviewWrite.put("busin_num", params.get("busin_num"));
		reviewWrite.put("apprai_cont", params.get("apprai_cont"));
		reviewWrite.put("shop_boardcont", params.get("shop_boardcont"));
		reviewWrite.put("mem_id", params.get("mem_id"));
		reviewWrite.put("reser_num", params.get("reser_num"));
		System.out.println("reviewWrite.get('busin_num')" + reviewWrite.get("busin_num"));
		System.out.println("reviewWrite.get('apprai_cont')" + reviewWrite.get("apprai_cont"));
		String apprai_cont = (String)reviewWrite.get("apprai_cont");
		System.out.println(reviewWrite.get("shop_boardcont"));
		System.out.println(reviewWrite.get("mem_id"));
		System.out.println("reviewWrite photos : " + photos.getOriginalFilename());
		String photoName = photos.getOriginalFilename();
		sshShopListDAO.reviewWrite(reviewWrite);
		System.out.println("NEW shop_boardnum : " + reviewWrite.get("shop_boardnum"));
		int shop_boardnum = (int)reviewWrite.get("shop_boardnum");
		System.out.println("shop_boardnum : " + shop_boardnum);
		String reser_num = (String)reviewWrite.get("reser_num");
		System.out.println("서비스 reser_num : " + reser_num);
		if(shop_boardnum > 0) {
			page = "redirect:/sshShopDetail?idx="+busin_num;
			if(photoName == "") {
				System.out.println("shop_boardnum : "+ shop_boardnum);
				sshShopListDAO.recommendationWrite(shop_boardnum,apprai_cont);
				String sphoto_oriname = "basic.GIF";
				String sphoto_newname = "basic.GIF";
				sshShopListDAO.baseSaveFile(shop_boardnum,sphoto_oriname, sphoto_newname);
				String memId = (String)reviewWrite.get("mem_id");
				sshShopListDAO.reservationUpdate(reser_num);
				sshShopListDAO.memberPointUpdate(memId);
				sshShopListDAO.pointListInsert(memId);
			}else {
				sshShopListDAO.recommendationWrite(shop_boardnum,apprai_cont);
				saveFile(shop_boardnum, photos);
				String memId = (String)reviewWrite.get("mem_id");
				sshShopListDAO.reservationUpdate(reser_num);
				sshShopListDAO.memberPointUpdate(memId);
				sshShopListDAO.pointListInsert(memId);
			}
		}
		return page;
		//return null;
	}
	
	private void saveFile(int shop_boardnum, MultipartFile photos){
		String oriFileName = photos.getOriginalFilename();
		int index = oriFileName.lastIndexOf(".");
		try {
			if(index>0) {
				String ext = oriFileName.substring(index);// 확장자(보여주기 시작할 인덱스)
				logger.info("ext : {}", ext);
				String newFileName = System.currentTimeMillis()+ext; // 새로운 파일명 생성(중복을 피하기 위해 / 확장자 없으면 사용 불가)
				logger.info(oriFileName + " = >" + newFileName);
				byte[] bytes = photos.getBytes(); // photo에 여러개의 정보(파일명/크기/byte... 등등)가 있지만 byte만 뽑아와서 byte[]배열에 담아준다
				// C:\STUDY\PrettyDog\PrettyDog\src\main\webapp\resources\trend
				Path path = Paths.get("C:/STUDY/PrettyDog/PrettyDog/src/main/webapp/resources/rev/" + newFileName); // 파일을 저장할 경로와 파일 이름을 설정해 준다.
				// 스트림을 사용 안해서 Files가  nio 라는걸 알수 있다 Files의 라이트 메서드를 사용해서(저장할 위치와 photo로부터 뽑아온 byte[]의 값을 사용해서 저장한다.)
				// 이때는 그냥 컴퓨터에 저장을 하는것(DB에 저장은 dao로 해야 한다.)
				System.out.println(path);
				Files.write(path, bytes);
				// Files.write(path, bytes); 까지 성공 하면 컴퓨터에 저장이 된거기 때문에 oriFileName 을 출력할수 있기 때문에 logger 로 확인해 본다
				logger.info(oriFileName + "SAVE OK!!"); 
				sshShopListDAO.fileWrite(shop_boardnum, oriFileName, newFileName);// DB 에 저장할 파일명을 기록					
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void ReviewDelete(String idx, String newFilename) {
		File file = new File("C:/STUDY/PrettyDog/PrettyDog/src/main/webapp/resources/rev/" + newFilename);
		boolean yn = file.delete();
		logger.info("newFilename "+"delete : " + yn);
		sshShopListDAO.deleteSbpNewname(newFilename);
		sshShopListDAO.deleteRecommendation(idx);
		sshShopListDAO.ReviewDelete(idx);
	}

	public ArrayList<HashMap<String, Object>> revLength(String memId, String idx) {
		return sshShopListDAO.revLength(memId, idx);
	}

	public ArrayList<HashMap<String, Object>> sshMyInterestShopList(String memId, String idx) {
		System.out.println("sshMyInterestShopList 서비스 도착 : " + memId);
		return sshShopListDAO.sshMyInterestShopList(memId, idx);
	}

	public ArrayList<HashMap<String, Object>> sshShopDetailTwo(String idx) {
			
		return sshShopListDAO.sshShopDetailTwo(idx);
	}

	public void myShopLikeInsert(String memId, String idx) {
		sshShopListDAO.myShopLikeInsert(memId, idx);
		
	}

	public void shopLikeUpdate(String idx) {
		sshShopListDAO.shopLikeUpdate(idx);
		
	}

	public void myShopLikeDelete(String memId, String idx) {
		sshShopListDAO.myShopLikeDelete(memId, idx);
		
	}

	public void shopLikeDown(String idx) {
		sshShopListDAO.shopLikeDown(idx);
		
	}

}

































































































































































