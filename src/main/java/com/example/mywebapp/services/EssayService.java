package com.example.mywebapp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mywebapp.model.EssayQuestion;
import com.example.mywebapp.model.Exam;
import com.example.mywebapp.repositories.EssayRepo;
import com.example.mywebapp.repositories.ExamJoined;

@RestController
public class EssayService {
	@Autowired
	private ExamJoined examRepository;
	
	@Autowired
	private EssayRepo essayRepository;
	
	
	@PostMapping("/api/exam/{examId}/essay")
	public EssayQuestion addQuestionByExamId(@PathVariable("examId") int eid,
			@RequestBody EssayQuestion essayQn) {
		 Optional<Exam> data = examRepository.findById(eid);
		 if(data.isPresent()) {
			 Exam exam = data.get();
			 essayQn.setExam(exam);
			 return essayRepository.save(essayQn);
		 }
		return null;
	}
}
