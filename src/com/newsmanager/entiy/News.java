package com.newsmanager.entiy;

import java.util.Date;

public class News {
	private Integer newsid;
	private String newstitle;
	private String newsContent;
	private String newsStatus;
	private String newsType;
	private Date createtime;

	public News() {

	}

	public News(Integer newsid, String newstitle, String newsContent, String newsStatus, String newsType,
			Date createtime) {
		this.newsid = newsid;
		this.newstitle = newstitle;
		this.newsContent = newsContent;
		this.newsStatus = newsStatus;
		this.newsType = newsType;
		this.createtime = createtime;
	}

	public Integer getNewsid() {
		return newsid;
	}

	public void setNewsid(Integer newsid) {
		this.newsid = newsid;
	}

	public String getNewstitle() {
		return newstitle;
	}

	public void setNewstitle(String newstitle) {
		this.newstitle = newstitle;
	}

	public String getNewsContent() {
		return newsContent;
	}

	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}

	public String getNewsStatus() {
		return newsStatus;
	}

	public void setNewsStatus(String newsStatus) {
		this.newsStatus = newsStatus;
	}

	public String getNewsType() {
		return newsType;
	}

	public void setNewsType(String newsType) {
		this.newsType = newsType;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
}
