package com.example.spring02.model.board.dto;
 
import java.util.Date;
 
public class BoardVO {
    private int bno;            // 番号
    private String title;       // 掲示物のタイトル
    private String content;     // 掲示物作成者
    private String writer;      // 掲示物作成者
    private Date regdate;       // 掲示物作成日 
    private int viewcnt; 		// 掲示物照会数
    private String upd_id;		// 修正者
    private Date upd_date;		// 修正日
    private int del_cd;			// 削除

    
    // Getters and Setter
    public int getBno() {
		return bno;
    }	
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getViewcnt() {
		return viewcnt;
	}
	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}
	public String getUpd_id() {
		return upd_id;
	}
	public void setUpd_id(String upd_id) {
		this.upd_id = upd_id;
	}
	public Date getUpd_date() {
		return upd_date;
	}
	public void setUpd_date(Date upd_date) {
		this.upd_date = upd_date;
	}
	public int getDel_cd() {
		return del_cd;
	}
	public void setDel_cd(int del_cd) {
		this.del_cd = del_cd;
	}
}
