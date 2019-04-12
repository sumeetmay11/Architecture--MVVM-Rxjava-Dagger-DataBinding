package com.app.archi.architecture.ui.data.Model;

public class Artist{
	private String mbid;
	private String name;
	private String url;

	public void setMbid(String mbid){
		this.mbid = mbid;
	}

	public String getMbid(){
		return mbid;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	@Override
 	public String toString(){
		return 
			"Artist{" + 
			"mbid = '" + mbid + '\'' + 
			",name = '" + name + '\'' + 
			",url = '" + url + '\'' + 
			"}";
		}
}
