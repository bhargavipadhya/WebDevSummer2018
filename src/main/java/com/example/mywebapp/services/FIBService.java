package com.example.mywebapp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.mywebapp.model.Exam;
import com.example.mywebapp.model.FillInTheBlankQuestion;
import com.example.mywebapp.repositories.ExamJoined;
import com.example.mywebapp.repositories.FillInTheBlankRepo;

@RestController
public class FIBService {
	
	@Autowired
	private ExamJoined examRepository;
	
	@Autowired
	private FillInTheBlankRepo fibRepository;
	
	@PostMapping("/api/exam/{examId}/blanks")
	public FillInTheBlankQuestion addQuestionByExamId(@PathVariable("examId") int eid,
			@RequestBody FillInTheBlankQuestion fibQn) {
		 Optional<Exam> data=examRepository.findById(eid);
		 if(data.isPresent()) {
			 Exam exam=data.get();
			 fibQn.setExam(exam);
			 return 	fibRepository.save(fibQn);
		 }
		return null;
	}
}
