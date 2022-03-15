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
	
	
}
