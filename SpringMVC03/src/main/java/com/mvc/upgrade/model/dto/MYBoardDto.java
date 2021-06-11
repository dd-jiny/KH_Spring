package com.mvc.upgrade.model.dto;

public class MYBoardDto {
	
	private int myno;
	private String myname;
	private String mytitle;
	private String mycontent;
	private String mydate;
	
	public MYBoardDto() {

	}

	public MYBoardDto(int myno, String myname, String mytitle, String mycontent, String mydate) {

		this.myno = myno;
		this.myname = myname;
		this.mytitle = mytitle;
		this.mycontent = mycontent;
		this.mydate = mydate;
	}

	public int getMyno() {
		return myno;
	}

	public void setMyno(int myno) {
		this.myno = myno;
	}

	public String getMyname() {
		return myname;
	}

	public void setMyname(String myname) {
		this.myname = myname;
	}

	public String getMytitle() {
		return mytitle;
	}

	public void setMytitle(String mytitle) {
		this.mytitle = mytitle;
	}

	public String getMycontent() {
		return mycontent;
	}

	public void setMycontent(String mycontent) {
		this.mycontent = mycontent;
	}

	public String getMydate() {
		return mydate;
	}

	public void setMydate(String mydate) {
		this.mydate = mydate;
	}
	
	
	
	
	
	

}
