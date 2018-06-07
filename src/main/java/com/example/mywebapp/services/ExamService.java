package com.example.mywebapp.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mywebapp.model.Exam;
import com.example.mywebapp.model.Topic;
import com.example.mywebapp.model.Widget;
import com.example.mywebapp.repositories.ExamJoined;
import com.example.mywebapp.repositories.TopicRepository;

@RestController
public class ExamService {

	@Autowired
	private ExamJoined examRepo;
	
	@Autowired
	private TopicRepository topicRepository;
	
	@GetMapping("/api/exam")
	public List<Exam> findAllExams(){
		return (List<Exam>) examRepo.findAll();
	}
	
	@PostMapping("/api/topic/{topicId}/exam")
	public Exam createExam(@PathVariable("topicId") int topicId,
			@RequestBody Exam exam) {
		Optional<Topic> data = topicRepository.findById(topicId);
		 if(data.isPresent()) {
			 Topic topic = data.get();
			 exam.setTopic(topic);
			 return examRepo.save(exam);
		 }
		 return null;
	}
	
	@GetMapping("/api/topic/{topicId}/exam")
	public List<Exam> findExamByTopicId(@PathVariable("topicId") int topicId){
		 Optional<Topic> data = topicRepository.findById(topicId);
		 List<Exam> examList = new ArrayList<>();
		 if(data.isPresent()) {
			 Topic topic = data.get();
			 List<Widget> widgetList = topic.getWidgets();
			 Iterator<Widget> widgetItr = widgetList.iterator();
			 while(widgetItr.hasNext()) {
				 Widget widget = widgetItr.next();
				 if(widget.getWidgetType().equals("exam")) {
					 Optional<Exam> examfound = examRepo.findById(widget.getWidgetId());
					 if(examfound.isPresent()) {
						 examList.add(examfound.get());
					 }
				 }
			 }
			 return examList;
		 }
		 return null;
	}
	
	@DeleteMapping("/api/exam/{examId}")
	public void deleteExam(@PathVariable("examId") int examId) {
		examRepo.deleteById(examId);
	}
	
}
