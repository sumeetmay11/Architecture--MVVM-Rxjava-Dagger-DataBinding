package com.app.archi.architecture.ui.data.Model;

import java.util.List;

public class Tracks{
	private Attr attr;
	private List<Track> track;

	public void setAttr(Attr attr){
		this.attr = attr;
	}

	public Attr getAttr(){
		return attr;
	}

	public List<Track> getTrack() {
		return track;
	}

	public void setTrack(List<Track> track) {
		this.track = track;
	}

	@Override
 	public String toString(){
		return 
			"Tracks{" + 
			",@attr = '" + attr + '\'' +
			",track = '" + track + '\'' + 
			"}";
		}
}
