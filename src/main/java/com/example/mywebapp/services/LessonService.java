package com.example.mywebapp.services;

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
import com.example.mywebapp.model.Module;
import com.example.mywebapp.repositories.CourseRepository;
import com.example.mywebapp.repositories.LessonRepository;
import com.example.mywebapp.repositories.ModuleRepository;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class LessonService {

	@Autowired
	CourseRepository courseRepository;
	@Autowired
	ModuleRepository moduleRepository;
	@Autowired
	LessonRepository lessonRepository;
	
	@GetMapping("/api/lesson")
	public Iterable<Lesson> findAllLessons() {
		return lessonRepository.findAll(); 
	}
	
	@GetMapping("/api/course/{courseId}/module/{moduleId}/lesson")
	public List<Lesson> findAllLessonsForModule(
			@PathVariable("courseId") int courseId,
			@PathVariable("moduleId") int moduleId){
	Optional<Module> data = moduleRepository.findById(moduleId);
	if(data.isPresent()) {
		Module module = data.get();
		return module.getLessons();
	}
	return null;
}
	@GetMapping("/api/lesson/{lessonId}")
	public Lesson findLessonById(
			@PathVariable("lessonId") int lessonId){
	Optional<Lesson> data = lessonRepository.findById(lessonId);
	if(data.isPresent()) {
		return data.get();
	}
	return null;
}
	
	@PostMapping("/api/course/{courseId}/module/{moduleId}/lesson")
	public Lesson createLesson(
			@PathVariable("courseId") int courseId,
			@PathVariable("moduleId") int moduleId,
			@RequestBody Lesson newLesson) {
		Optional<Module> data = moduleRepository.findById(moduleId);
		if(data.isPresent()) {
			Module module = data.get();
			newLesson.setModule(module);
			return lessonRepository.save(newLesson);
		}
		return null;
	}
	
	@DeleteMapping("/api/lesson/{lessonId}")
	public void deleteLesson(@PathVariable("lessonId") int lessonId)
	{
		lessonRepository.deleteById(lessonId);
	}
}
