package com.example.mywebapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.mywebapp.model.Lesson;
import com.example.mywebapp.model.Module;
import com.example.mywebapp.model.Topic;
import com.example.mywebapp.repositories.CourseRepository;
import com.example.mywebapp.repositories.LessonRepository;
import com.example.mywebapp.repositories.ModuleRepository;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class TopicService {
	@Autowired
	CourseRepository courseRepository;
	@Autowired
	ModuleRepository moduleRepository;
	@Autowired
	LessonRepository lessonRepository;
	
	
	@GetMapping("/api/course/{courseId}/module/{moduleId}/lesson/{lessonId}/topic")
	public List<Topic> findAllTopicsForLesson(
			@PathVariable("courseId") int courseId,
			@PathVariable("moduleId") int moduleId,
			@PathVariable("lessonId") int lessonId){
	Optional<Lesson> data = lessonRepository.findById(lessonId);
	if(data.isPresent()) {
		Lesson lesson = data.get();
		return lesson.getTopics();
	}
	return null;
}
}
