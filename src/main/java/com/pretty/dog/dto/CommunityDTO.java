package com.pretty.dog.dto;

import java.sql.Timestamp;

public class CommunityDTO {

	
	//커뮤니티
	private String mem_id;
	public int community_boardnum;
	public String community_sub;
	public String community_cont;
	public Timestamp community_date;
	public Timestamp communoty_updatedate;
	public int community_view;
	public int community_likes;
	public int community_blind;
	
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public int getCommunity_boardnum() {
		return community_boardnum;
	}
	public void setCommunity_boardnum(int community_boardnum) {
		this.community_boardnum = community_boardnum;
	}
	public String getCommunity_sub() {
		return community_sub;
	}
	public void setCommunity_sub(String community_sub) {
		this.community_sub = community_sub;
	}
	public String getCommunity_cont() {
		return community_cont;
	}
	public void setCommunity_cont(String community_cont) {
		this.community_cont = community_cont;
	}
	public Timestamp getCommunity_date() {
		return community_date;
	}
	public void setCommunity_date(Timestamp community_date) {
		this.community_date = community_date;
	}
	public Timestamp getCommunoty_updatedate() {
		return communoty_updatedate;
	}
	public void setCommunoty_updatedate(Timestamp communoty_updatedate) {
		this.communoty_updatedate = communoty_updatedate;
	}
	public int getCommunity_view() {
		return community_view;
	}
	public void setCommunity_view(int community_view) {
		this.community_view = community_view;
	}
	public int getCommunity_likes() {
		return community_likes;
	}
	public void setCommunity_likes(int community_likes) {
		this.community_likes = community_likes;
	}
	public int getCommunity_blind() {
		return community_blind;
	}
	public void setCommunity_blind(int community_blind) {
		this.community_blind = community_blind;
	}
	
	//카테고리
	public int category_num;
	public String category_name;	
	public int category_admin;
	public int category_blind;
	public int getCategory_num() {
		return category_num;
	}
	public void setCategory_num(int category_num) {
		this.category_num = category_num;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public int getCategory_admin() {
		return category_admin;
	}
	public void setCategory_admin(int category_admin) {
		this.category_admin = category_admin;
	}
	public int getCategory_blind() {
		return category_blind;
	}
	public void setCategory_blind(int category_blind) {
		this.category_blind = category_blind;
	}
	
	//커뮤니티 사진
	public int bphoto_num;
	public String bphoto_oriname;
	public String bphoto_newname;
	public Timestamp bphoto_date;
	
	public int getBphoto_num() {
		return bphoto_num;
	}
	public void setBphoto_num(int bphoto_num) {
		this.bphoto_num = bphoto_num;
	}
	public String getBphoto_oriname() {
		return bphoto_oriname;
	}
	public void setBphoto_oriname(String bphoto_oriname) {
		this.bphoto_oriname = bphoto_oriname;
	}
	public String getBphoto_newname() {
		return bphoto_newname;
	}
	public void setBphoto_newname(String bphoto_newname) {
		this.bphoto_newname = bphoto_newname;
	}
	public Timestamp getBphoto_date() {
		return bphoto_date;
	}
	public void setBphoto_date(Timestamp bphoto_date) {
		this.bphoto_date = bphoto_date;
	}
	
	//커뮤니티 댓글
	public int bcomment_num;
	public String bcomment_cont;
	public Timestamp bcomment_date;
	public int bcomment_blind;
	
	
	
	public int getBcomment_num() {
		return bcomment_num;
	}
	public void setBcomment_num(int bcomment_num) {
		this.bcomment_num = bcomment_num;
	}
	public String getBcomment_cont() {
		return bcomment_cont;
	}
	public void setBcomment_cont(String bcomment_cont) {
		this.bcomment_cont = bcomment_cont;
	}
	public Timestamp getBcomment_date() {
		return bcomment_date;
	}
	public void setBcomment_date(Timestamp bcomment_date) {
		this.bcomment_date = bcomment_date;
	}
	public int getBcomment_blind() {
		return bcomment_blind;
	}
	public void setBcomment_blind(int bcomment_blind) {
		this.bcomment_blind = bcomment_blind;
	}

	//신고관련
	
	public int decl_num;
	public int dec_state;
	public Timestamp dec_date;
	public int dec_target;
	public int dec_targetNum;
	public String dec_id;
	
	public int decO_num;
	public String decO_cont;
	public int decO_blind;
	
	public String getDecO_cont() {
		return decO_cont;
	}
	public void setDecO_cont(String decO_cont) {
		this.decO_cont = decO_cont;		
	}

	public int getDecl_num() {
		return decl_num;
	}
	public void setDecl_num(int decl_num) {
		this.decl_num = decl_num;
	}
	public int getDec_state() {
		return dec_state;
	}
	public void setDec_state(int dec_state) {
		this.dec_state = dec_state;
	}
	public Timestamp getDec_date() {
		return dec_date;
	}
	public void setDec_date(Timestamp dec_date) {
		this.dec_date = dec_date;
	}
	public int getDec_target() {
		return dec_target;
	}
	public void setDec_target(int dec_target) {
		this.dec_target = dec_target;
	}
	public int getDec_targetNum() {
		return dec_targetNum;
	}
	public void setDec_targetNum(int dec_targetNum) {
		this.dec_targetNum = dec_targetNum;
	}
	public String getDec_id() {
		return dec_id;
	}
	public void setDec_id(String dec_id) {
		this.dec_id = dec_id;
	}
	public int getDecO_num() {
		return decO_num;
	}
	public void setDecO_num(int decO_num) {
		this.decO_num = decO_num;
	}
	
	public int getDecO_blind() {
		return decO_blind;
	}
	public void setDecO_blind(int decO_blind) {
		this.decO_blind = decO_blind;
	}
	
	
	
	
	
}
