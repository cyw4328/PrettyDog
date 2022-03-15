package com.pretty.dog.dto;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

@Alias(value = "dog")
public class DogDTO {

	private String mem_id;
	private String mem_pw;
	private String mem_name;
	private String mem_email;
	private String mem_nick;
	private String mem_tel;
	private String mem_addr;
	private int mem_rank;
	private int mem_state;
	private Timestamp mem_date;
	private Timestamp mem_secession;
	private Timestamp mem_login;
	private int mem_point;
	private int mem_nopoint;
	
	public int getMem_nopoint() {
		return mem_nopoint;
	}
	public void setMem_nopoint(int mem_nopoint) {
		this.mem_nopoint = mem_nopoint;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_pw() {
		return mem_pw;
	}
	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_email() {
		return mem_email;
	}
	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}
	public String getMem_nick() {
		return mem_nick;
	}
	public void setMem_nick(String mem_nick) {
		this.mem_nick = mem_nick;
	}
	public String getMem_tel() {
		return mem_tel;
	}
	public void setMem_tel(String mem_tel) {
		this.mem_tel = mem_tel;
	}
	public String getMem_addr() {
		return mem_addr;
	}
	public void setMem_addr(String mem_addr) {
		this.mem_addr = mem_addr;
	}
	public int getMem_rank() {
		return mem_rank;
	}
	public void setMem_rank(int mem_rank) {
		this.mem_rank = mem_rank;
	}
	public int getMem_state() {
		return mem_state;
	}
	public void setMem_state(int mem_state) {
		this.mem_state = mem_state;
	}
	public Timestamp getMem_date() {
		return mem_date;
	}
	public void setMem_date(Timestamp mem_date) {
		this.mem_date = mem_date;
	}
	public Timestamp getMem_secession() {
		return mem_secession;
	}
	public void setMem_secession(Timestamp mem_secession) {
		this.mem_secession = mem_secession;
	}
	public Timestamp getMem_login() {
		return mem_login;
	}
	public void setMem_login(Timestamp mem_login) {
		this.mem_login = mem_login;
	}
	public int getMem_point() {
		return mem_point;
	}
	public void setMem_point(int mem_point) {
		this.mem_point = mem_point;
	}
	
	
	// 매장
	private String busin_num;
	private String busin_name;
	private String busin_info;
	private String busin_account;
	private int busin_smalldog;
	private int busin_middledog;
	private int busin_bigdog;
	private String busin_area;
	private int busin_likes;
	private Timestamp busin_date;
	private int busin_calss;
	private String busin_juso;
<<<<<<< HEAD

=======
	
>>>>>>> 8c42403ec16e7e79ddcff7ceba76196abfdb7153
	public String getBusin_juso() {
		return busin_juso;
	}
	public void setBusin_juso(String busin_juso) {
		this.busin_juso = busin_juso;
	}
	public String getBusin_num() {
		return busin_num;
	}
	public void setBusin_num(String busin_num) {
		this.busin_num = busin_num;
	}
	public String getBusin_name() {
		return busin_name;
	}
	public void setBusin_name(String busin_name) {
		this.busin_name = busin_name;
	}
	public String getBusin_info() {
		return busin_info;
	}
	public void setBusin_info(String busin_info) {
		this.busin_info = busin_info;
	}
	public String getBusin_account() {
		return busin_account;
	}
	public void setBusin_account(String busin_account) {
		this.busin_account = busin_account;
	}
	public int getBusin_smalldog() {
		return busin_smalldog;
	}
	public void setBusin_smalldog(int busin_smalldog) {
		this.busin_smalldog = busin_smalldog;
	}
	public int getBusin_middledog() {
		return busin_middledog;
	}
	public void setBusin_middledog(int busin_middledog) {
		this.busin_middledog = busin_middledog;
	}
	public int getBusin_bigdog() {
		return busin_bigdog;
	}
	public void setBusin_bigdog(int busin_bigdog) {
		this.busin_bigdog = busin_bigdog;
	}
	public String getBusin_area() {
		return busin_area;
	}
	public void setBusin_area(String busin_area) {
		this.busin_area = busin_area;
	}
	public int getBusin_likes() {
		return busin_likes;
	}
	public void setBusin_likes(int busin_likes) {
		this.busin_likes = busin_likes;
	}
	public Timestamp getBusin_date() {
		return busin_date;
	}
	public void setBusin_date(Timestamp busin_date) {
		this.busin_date = busin_date;
	}
	public int getBusin_calss() {
		return busin_calss;
	}
	public void setBusin_calss(int busin_calss) {
		this.busin_calss = busin_calss;
	}
	
	// 매장 인테리어 
	
	private int interior_photo;
	private String interior_oriname;
	private String interior_newname;
	private Timestamp interior_date;

	public int getInterior_photo() {
		return interior_photo;
	}
	public void setInterior_photo(int interior_photo) {
		this.interior_photo = interior_photo;
	}
	public String getInterior_oriname() {
		return interior_oriname;
	}
	public void setInterior_oriname(String interior_oriname) {
		this.interior_oriname = interior_oriname;
	}
	public String getInterior_newname() {
		return interior_newname;
	}
	public void setInterior_newname(String interior_newname) {
		this.interior_newname = interior_newname;
	}
	public Timestamp getInterior_date() {
		return interior_date;
	}
	public void setInterior_date(Timestamp interior_date) {
		this.interior_date = interior_date;
	}
	
	// 추가 항목
	private int add_num;
	private String add_sub;
	private int add_blind;

	public int getAdd_num() {
		return add_num;
	}
	public void setAdd_num(int add_num) {
		this.add_num = add_num;
	}
	public String getAdd_sub() {
		return add_sub;
	}
	public void setAdd_sub(String add_sub) {
		this.add_sub = add_sub;
	}
	public int getAdd_blind() {
		return add_blind;
	}
	public void setAdd_blind(int add_blind) {
		this.add_blind = add_blind;
	}
	
	// 매장가격표
	private int price_num;
	private int price_cost;
	private int price_class;

	public int getPrice_num() {
		return price_num;
	}
	public void setPrice_num(int price_num) {
		this.price_num = price_num;
	}
	public int getPrice_cost() {
		return price_cost;
	}
	public void setPrice_cost(int price_cost) {
		this.price_cost = price_cost;
	}
	public int getPrice_class() {
		return price_class;
	}
	public void setPrice_class(int price_class) {
		this.price_class = price_class;
	}
	
	// 포인트 내역
	
	private int point_num;
	private int point_cdc;
	private Timestamp point_date;
	private String point_cont;
	private int point_distin;

	public int getPoint_num() {
		return point_num;
	}
	public void setPoint_num(int point_num) {
		this.point_num = point_num;
	}
	public int getPoint_cdc() {
		return point_cdc;
	}
	public void setPoint_cdc(int point_cdc) {
		this.point_cdc = point_cdc;
	}
	public Timestamp getPoint_date() {
		return point_date;
	}
	public void setPoint_date(Timestamp point_date) {
		this.point_date = point_date;
	}
	public String getPoint_cont() {
		return point_cont;
	}
	public void setPoint_cont(String point_cont) {
		this.point_cont = point_cont;
	}
	public int getPoint_distin() {
		return point_distin;
	}
	public void setPoint_distin(int point_distin) {
		this.point_distin = point_distin;
	}
	
	private int poch_num;
	private String poch_id;
	private String poch_money;
	private String poch_bank;
	private String poch_banknum;
	private Timestamp poch_date;
	private Timestamp poch_cdate;
	private int poch_check;

	public int getPoch_num() {
		return poch_num;
	}
	public void setPoch_num(int poch_num) {
		this.poch_num = poch_num;
	}
	public String getPoch_id() {
		return poch_id;
	}
	public void setPoch_id(String poch_id) {
		this.poch_id = poch_id;
	}
	public String getPoch_money() {
		return poch_money;
	}
	public void setPoch_money(String poch_money) {
		this.poch_money = poch_money;
	}
	public String getPoch_bank() {
		return poch_bank;
	}
	public void setPoch_bank(String poch_bank) {
		this.poch_bank = poch_bank;
	}
	public String getPoch_banknum() {
		return poch_banknum;
	}
	public void setPoch_banknum(String poch_banknum) {
		this.poch_banknum = poch_banknum;
	}
	public Timestamp getPoch_date() {
		return poch_date;
	}
	public void setPoch_date(Timestamp poch_date) {
		this.poch_date = poch_date;
	}
	public Timestamp getPoch_cdate() {
		return poch_cdate;
	}
	public void setPoch_cdate(Timestamp poch_cdate) {
		this.poch_cdate = poch_cdate;
	}
	public int getPoch_check() {
		return poch_check;
	}
	public void setPoch_check(int poch_check) {
		this.poch_check = poch_check;
	}
	
	private int category_num;
	private String category_name;
	private int category_admin;
	private int category_blind;

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
	
	private int reser_num;
	private Timestamp reser_askdate;
	private String reser_dog;
	private String reser_service;
	private Timestamp reser_visitday;
	private int reser_money;
	private int reser_state;
	private Timestamp reser_updateday;
	
	
	
	public int getReser_num() {
		return reser_num;
	}
	public void setReser_num(int reser_num) {
		this.reser_num = reser_num;
	}
	public Timestamp getReser_askdate() {
		return reser_askdate;
	}
	public void setReser_askdate(Timestamp reser_askdate) {
		this.reser_askdate = reser_askdate;
	}
	public String getReser_dog() {
		return reser_dog;
	}
	public void setReser_dog(String reser_dog) {
		this.reser_dog = reser_dog;
	}
	public String getReser_service() {
		return reser_service;
	}
	public void setReser_service(String reser_service) {
		this.reser_service = reser_service;
	}
	public Timestamp getReser_visitday() {
		return reser_visitday;
	}
	public void setReser_visitday(Timestamp reser_visitday) {
		this.reser_visitday = reser_visitday;
	}
	public int getReser_money() {
		return reser_money;
	}
	public void setReser_money(int reser_money) {
		this.reser_money = reser_money;
	}
	public int getReser_state() {
		return reser_state;
	}
	public void setReser_state(int reser_state) {
		this.reser_state = reser_state;
	}
	public Timestamp getReser_updateday() {
		return reser_updateday;
	}
	public void setReser_updateday(Timestamp reser_updateday) {
		this.reser_updateday = reser_updateday;
		
	}
	
	private int alarm_num;
	private Timestamp alarm_date;
	private int alarm_class;
	
	public int getAlarm_num() {
		return alarm_num;
	}
	public void setAlarm_num(int alarm_num) {
		this.alarm_num = alarm_num;
	}
	public Timestamp getAlarm_date() {
		return alarm_date;
	}
	public void setAlarm_date(Timestamp alarm_date) {
		this.alarm_date = alarm_date;
	}
	public int getAlarm_class() {
		return alarm_class;
	}
	public void setAlarm_class(int alarm_class) {
		this.alarm_class = alarm_class;
	}
	
	private int community_boardnum;
	private String community_sub;
	private String community_cont;
	private Timestamp community_date;
	private Timestamp community_updatedate;
	private int community_view;
	private int community_likes;
	private int community_blind;

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
	public Timestamp getCommunity_updatedate() {
		return community_updatedate;
	}
	public void setCommunity_updatedate(Timestamp community_updatedate) {
		this.community_updatedate = community_updatedate;
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
	
	private int bcomment_num;   
	private String bcomment_cont;
	private Timestamp bcomment_date;
	private int bcomment_blind;

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
	
	private int interestshop_num;

	public int getInterestshop_num() {
		return interestshop_num;
	}
	public void setInterestshop_num(int interestshop_num) {
		this.interestshop_num = interestshop_num;
	}
	
	
	
	
}
