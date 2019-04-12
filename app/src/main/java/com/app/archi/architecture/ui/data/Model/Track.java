package com.app.archi.architecture.ui.data.Model;

import java.util.List;

public class Track {
	private String duration;
	private List<ImageItem> image;
	private String mbid;
	private String listeners;
	private Streamable streamable;
	private Artist artist;
	private String playcount;
	private String name;
	private String url;

	public void setDuration(String duration){
		this.duration = duration;
	}

	public String getDuration(){
		return duration;
	}

	public void setImage(List<ImageItem> image){
		this.image = image;
	}

	public List<ImageItem> getImage(){
		return image;
	}

	public void setMbid(String mbid){
		this.mbid = mbid;
	}

	public String getMbid(){
		return mbid;
	}

	public void setListeners(String listeners){
		this.listeners = listeners;
	}

	public String getListeners(){
		return listeners;
	}

	public void setStreamable(Streamable streamable){
		this.streamable = streamable;
	}

	public Streamable getStreamable(){
		return streamable;
	}

	public void setArtist(Artist artist){
		this.artist = artist;
	}

	public Artist getArtist(){
		return artist;
	}

	public void setPlaycount(String playcount){
		this.playcount = playcount;
	}

	public String getPlaycount(){
		return playcount;
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
				"TrackItem{" +
						"duration = '" + duration + '\'' +
						",image = '" + image + '\'' +
						",mbid = '" + mbid + '\'' +
						",listeners = '" + listeners + '\'' +
						",streamable = '" + streamable + '\'' +
						",artist = '" + artist + '\'' +
						",playcount = '" + playcount + '\'' +
						",name = '" + name + '\'' +
						",url = '" + url + '\'' +
						"}";
	}
}