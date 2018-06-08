package com.example.mywebapp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.mywebapp.model.Exam;
import com.example.mywebapp.model.MultipleChoiceQuestion;
import com.example.mywebapp.repositories.ExamJoined;
import com.example.mywebapp.repositories.MultipleChoiceRepo;

@RestController
public class MCQService {
	@Autowired
	private ExamJoined examRepository;
	
	@Autowired
	private MultipleChoiceRepo multipleChoiceRepository;
	
	@PostMapping("/api/exam/{examId}/choice")
	public MultipleChoiceQuestion addQuestionByExamId(@PathVariable("examId") int eid,
			@RequestBody MultipleChoiceQuestion mcQn) {
		//System.out.println(eid);
		Optional<Exam> data = examRepository.findById(eid);
		 if(data.isPresent()) {
			 Exam exam = data.get();
			 mcQn.setExam(exam);
			 return multipleChoiceRepository.save(mcQn);
		 }
		return null;
	}
}
