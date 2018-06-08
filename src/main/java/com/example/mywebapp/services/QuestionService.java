package com.example.mywebapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.mywebapp.model.Exam;
import com.example.mywebapp.model.Question;
import com.example.mywebapp.repositories.ExamJoined;

@RestController
public class QuestionService {
	
	@Autowired
	private ExamJoined examRepo;
	
	@GetMapping("/api/exam/{examId}/questions")
	public List<Question> findQuestionByExamId(@PathVariable("examId") int eid){
		//System.out.println(eid);
		Optional<Exam> data = examRepo.findById(eid);
		if(data.isPresent()) {
			Exam exam = data.get();
			List<Question> qnList= exam.getQuestions();
			return qnList;
		}
		return null;	
	}
}
