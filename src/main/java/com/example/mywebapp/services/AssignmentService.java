package com.example.mywebapp.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mywebapp.model.Assignment;
import com.example.mywebapp.model.Topic;
import com.example.mywebapp.model.Widget;
import com.example.mywebapp.repositories.AssignmentJoined;
import com.example.mywebapp.repositories.TopicRepository;
import com.example.mywebapp.repositories.WidgetRepository;

@RestController
@CrossOrigin(origins="*")
public class AssignmentService {
	@Autowired
	TopicRepository topicRepository;
	@Autowired
	AssignmentJoined assnRepo;
	
	@GetMapping("/api/assignment")
	public List<Assignment> findAllAssignments(){
		return (List<Assignment>) assnRepo.findAll();
	}
	
	@GetMapping("/api/assignment/{assnId}")
	public Assignment findAssignmentById(@PathVariable("assnId") int assnId){
		Optional<Assignment> data = assnRepo.findById(assnId);
		if(data.isPresent())
			return data.get();
		return null;
	}
	
	@GetMapping("api/topic/{topicId}/assignment")
	public List<Assignment> findAssignmentByTopicId(@PathVariable("topicId") int topicId){
		Optional<Topic> data = topicRepository.findById(topicId);
		List<Assignment> assnList = new ArrayList<>();
		if(data.isPresent()) {
			Topic topic = data.get();
			List<Widget> widgetList = topic.getWidgets();
			Iterator<Widget> widgetItr = widgetList.iterator();
			while(widgetItr.hasNext()) {
				Widget widget = widgetItr.next();
				if(widget.getWidgetType().equals("assignment")) {
					Optional<Assignment> assignment = assnRepo.findById(widget.getWidgetId());
					 if(assignment.isPresent()) {
						 assnList.add(assignment.get());
					 }
				}
			}
			return assnList;
		}
		return null;	
	}

	@PostMapping("api/topic/{topicId}/assignment")
	public Assignment createAssignnment(@RequestBody Assignment newWidget, 
			@PathVariable("topicId") int topicId) {
		Optional<Topic> data = topicRepository.findById(topicId);
		if(data.isPresent()) {
			Topic topic = data.get();
			newWidget.setTopic(topic);
			return assnRepo.save(newWidget);
		}
		return null;
	}
	
	@DeleteMapping("/api/assignment/{assnId}")
	public void deleteAssignment(@PathVariable("assnId") int aid)
	{
		assnRepo.deleteById(aid);
	}
	
	@PutMapping("api/assignment/{assnId}")
	public Assignment updateAssignment (
			@PathVariable("assnId") int aid,
			@RequestBody Assignment newAssn) {
		Optional<Assignment> data = assnRepo.findById(aid);
		System.out.println("hello");
		if(data.isPresent()) {
			Assignment assn = data.get();
			assn.setTitle(newAssn.getTitle());
			assn.setDescription(newAssn.getDescription());
			assn.setPoints(newAssn.getPoints());
			assn.setText(newAssn.getText());
			assn.setWidgetType(newAssn.getWidgetType());
			assnRepo.save(assn);
			return assn;
		}
		return null;
	}
	
}
