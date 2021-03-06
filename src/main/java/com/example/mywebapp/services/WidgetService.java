package com.example.mywebapp.services;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mywebapp.model.Lesson;
import com.example.mywebapp.model.Topic;
import com.example.mywebapp.model.Widget;
import com.example.mywebapp.repositories.TopicRepository;
import com.example.mywebapp.repositories.WidgetRepository;

@RestController
@CrossOrigin(origins="*")
public class WidgetService {
	@Autowired
	WidgetRepository widgetRepository;
	@Autowired
	TopicRepository topicRepository;
	
	@GetMapping("api/topic/{topicId}/widget")
	public List<Widget> findWidgetByTopicId(@PathVariable("topicId") int topicId){
		Optional<Topic> data = topicRepository.findById(topicId);
		if(data.isPresent()) {
			Topic topic = data.get();
			List<Widget> widgetList= topic.getWidgets();
			Collections.sort(widgetList);
			return widgetList;
		}
		return null;	
	}
	
	@PostMapping("/api/topic/{topicId}/widget/save")
	public void saveWidgetForTopic(@RequestBody List<Widget> widgets, @PathVariable("topicId") int topicId) {
		
		Optional<Topic> data=topicRepository.findById(topicId);
		if(data.isPresent()) {
			Topic topic = data.get();
			List<Widget> widgetList = topic.getWidgets();
			for(Widget widget:widgetList) {
				widgetRepository.deleteById(widget.getId());
			}
		}
		for(Widget widget: widgets) {
			Optional<Topic> topicfound = topicRepository.findById(topicId);
			if(data.isPresent()) {
				Topic topic = topicfound.get();
				widget.setTopic(topic);
				widgetRepository.save(widget);
			}
		}
	}
	
	@GetMapping("/api/widget")
	public List<Widget> findAllWidgets(){
		return (List<Widget>) widgetRepository.findAll();
	}
	
	@DeleteMapping("/api/widget/{widgetId}")
	public void deleteWidget(@PathVariable("widgetId") int widgetId)
	{
		widgetRepository.deleteById(widgetId);
	}
}
