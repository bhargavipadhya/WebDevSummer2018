package com.example.mywebapp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mywebapp.model.Exam;
import com.example.mywebapp.model.TrueFalseQuestion;
import com.example.mywebapp.repositories.ExamJoined;
import com.example.mywebapp.repositories.TrueFalseRepo;

@RestController
public class TrueFalseService {
	@Autowired
	private ExamJoined examRepo;
	
	@Autowired
	private TrueFalseRepo tfRepo;
	
	@PostMapping("/api/exam/{examId}/truefalse")
	public TrueFalseQuestion addQuestionByExamId(@PathVariable("examId") int eid,@RequestBody TrueFalseQuestion tfQn) {
		 Optional<Exam> data = examRepo.findById(eid);
		 if(data.isPresent()) {
			 Exam exam = data.get();
			 tfQn.setExam(exam);
			 return tfRepo.save(tfQn);
		 }
		return null;
	}
}
