package com.example.mywebapp.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Widget implements Comparable<Widget>{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String text;
	private String widgetType;
	private int size;
	private String paraText;
	private String listText;
	private String listType;
	private String linkURL;
	private String imageURL;
	private String linkText;
	private String widgetNameText;
	private int orderWidget;
	
	@ManyToOne
	@JsonIgnore
	private Topic topic;

	// Setters and Getters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	public String getWidgetType() {
		return widgetType;
	}
	public void setWidgetType(String widgetType) {
		this.widgetType = widgetType;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}

	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
	public String getParaText() {
		return paraText;
	}
	public void setParaText(String paraText) {
		this.paraText = paraText;
	}
	public String getListText() {
		return listText;
	}
	public void setListText(String listText) {
		this.listText = listText;
	}
	public String getListType() {
		return listType;
	}
	public void setListType(String listType) {
		this.listType = listType;
	}
	public String getLinkURL() {
		return linkURL;
	}
	public void setLinkURL(String linkURL) {
		this.linkURL = linkURL;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public String getLinkText() {
		return linkText;
	}
	public void setLinkText(String linkText) {
		this.linkText = linkText;
	}
	public String getWidgetNameText() {
		return widgetNameText;
	}
	public void setWidgetNameText(String widgetNameText) {
		this.widgetNameText = widgetNameText;
	}
	@Override
	public int compareTo(Widget order) {
		return this.getOrderWidget()-order.getOrderWidget();
	}
	public int getOrderWidget() {
		return orderWidget;
	}
	public void setOrderWidget(int orderWidget) {
		this.orderWidget = orderWidget;
	}
}
