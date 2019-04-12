package com.app.archi.architecture.ui.data.Model;

public class Attr{
	private String total;
	private String perPage;
	private String totalPages;
	private String page;

	public void setTotal(String total){
		this.total = total;
	}

	public String getTotal(){
		return total;
	}

	public void setPerPage(String perPage){
		this.perPage = perPage;
	}

	public String getPerPage(){
		return perPage;
	}

	public void setTotalPages(String totalPages){
		this.totalPages = totalPages;
	}

	public String getTotalPages(){
		return totalPages;
	}

	public void setPage(String page){
		this.page = page;
	}

	public String getPage(){
		return page;
	}

	@Override
 	public String toString(){
		return 
			"Attr{" + 
			"total = '" + total + '\'' + 
			",perPage = '" + perPage + '\'' + 
			",totalPages = '" + totalPages + '\'' + 
			",page = '" + page + '\'' + 
			"}";
		}
}
