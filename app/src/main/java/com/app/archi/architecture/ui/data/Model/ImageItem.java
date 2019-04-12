package com.app.archi.architecture.ui.data.Model;

import com.google.gson.annotations.SerializedName;

public class ImageItem{
	@SerializedName("#text")
	private String text;
	private String size;

	public void setText(String text){
		this.text = text;
	}

	public String getText(){
		return text;
	}

	public void setSize(String size){
		this.size = size;
	}

	public String getSize(){
		return size;
	}

	@Override
 	public String toString(){
		return 
			"ImageItem{" + 
			"#text = '" + text + '\'' +
			",size = '" + size + '\'' +
			"}";
		}
}
