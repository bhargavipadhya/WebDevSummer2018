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

import com.example.mywebapp.model.Course;
import com.example.mywebapp.model.Lesson;
import com.example.mywebapp.model.Module;
import com.example.mywebapp.repositories.CourseRepository;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class CourseService {
	@Autowired
	CourseRepository courseRepository;	
	
	/**
	 * FIND ALL THE COURSES
	 * @return
	 */
	@GetMapping("/api/course")
	public Iterable<Course> findAllCourses() {
		return courseRepository.findAll(); 
	}
	
	@GetMapping("/api/course/{courseId}")
	public Course findCourseById(
			@PathVariable("courseId") int courseId){
	Optional<Course> data = courseRepository.findById(courseId);
	if(data.isPresent()) {
		return data.get();
	}
	return null;
}

	/**
	 * CREATE A NEW COURSE
	 * @param course
	 * @return
	 */
	@PostMapping("/api/course")
	public Course createCourse
	(@RequestBody Course course) {
			return courseRepository.save(course);
	}
	
	@DeleteMapping("/api/course/{courseId}")
	public void deleteCourse(
	@PathVariable("courseId") int id) {
		courseRepository.deleteById(id);
	}


}
