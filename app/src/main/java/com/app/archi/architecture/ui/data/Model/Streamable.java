package com.app.archi.architecture.ui.data.Model;

public class Streamable{
	private String text;
	private String fulltrack;

	public void setText(String text){
		this.text = text;
	}

	public String getText(){
		return text;
	}

	public void setFulltrack(String fulltrack){
		this.fulltrack = fulltrack;
	}

	public String getFulltrack(){
		return fulltrack;
	}

	@Override
 	public String toString(){
		return 
			"Streamable{" + 
			"#text = '" + text + '\'' + 
			",fulltrack = '" + fulltrack + '\'' + 
			"}";
		}
}
