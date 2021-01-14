package com.axsos.dojooverflow.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.axsos.dojooverflow.models.Answer;
import com.axsos.dojooverflow.models.Connection;
import com.axsos.dojooverflow.models.CustomValid;
import com.axsos.dojooverflow.models.Question;
import com.axsos.dojooverflow.models.Tag;
import com.axsos.dojooverflow.services.AppService;

@Controller
public class AppController {
	private final AppService appService;

	public AppController(AppService appService) {
		this.appService = appService;
	}
	
	@RequestMapping("")
	public String root() {
		return "redirect:/questions";
	}
	
	@RequestMapping("/questions")
	public String showQuestions(Model model) {
		List<Question> questions = appService.findAllQuestions();
		model.addAttribute("questions",questions);
		return "questions.jsp";
	}
	
	@RequestMapping("/questions/new")
	public String addQuestionsForm(@ModelAttribute("custom_valid") CustomValid customValid) {
		return "newQuestion.jsp";
	}
	
	@RequestMapping("/question/add")
	public String addQuestion(@Valid @ModelAttribute("custom_valid") CustomValid customValid, @RequestParam(value="questionText") String questionText, @RequestParam(value="subject") String subject, BindingResult result) {
		if (result.hasErrors()) {
            return "newCategory.jsp";
        } else {
            Question question = new Question(questionText);
            String[] subjects = subject.split(", ");
            List<Tag> tags = appService.findAllTags();
            appService.createQuestion(question);
            for(int i = 0;i<subjects.length;i++) {
            	if(tags.size()==0) {
            		Tag tag = new Tag(subjects[i]);
        			appService.createTag(tag);
        			Connection connect = new Connection(question, tag);
        			appService.createConnection(connect);
            	} else{for(int j = 0;j<tags.size();j++) {
	        		if(subjects[i].equals(tags.get(j).getSubject())) {
	        			Connection connect = new Connection(question, tags.get(j));
	        			appService.createConnection(connect);
	        		} else {
	            			Tag tag = new Tag(subjects[i]);
	            			appService.createTag(tag);
	            			Connection connect = new Connection(question, tag);
	            			appService.createConnection(connect);
	            		}
	            	}
	            }
            }
            return "redirect:/question-profile/"+question.getId();
        }
	}
	@RequestMapping("/question-profile/{id}")
	public String addAnswersForm(@ModelAttribute("answer") Answer answer, @PathVariable("id") Long id, Model model) {
		Question question = appService.findQuestionById(id);
		List<Question> questions = appService.findAllQuestions();
		model.addAttribute("question", question);
		model.addAttribute("questions", questions);
		return "questionProfile.jsp";
	}
	@RequestMapping("/answers/{id}/add")
	public String addQuestion(@Valid @ModelAttribute("answer") Answer answer, @PathVariable("id") Long id, BindingResult result) {
		if (result.hasErrors()) {
            return "newCategory.jsp";
        } else {
        	Question question = appService.findQuestionById(id);
        	answer.setQuestion(question);
        	appService.createAnswer(answer);
        	return "redirect:/question-profile/"+question.getId();
        }
	}

}
