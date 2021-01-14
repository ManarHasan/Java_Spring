package com.axsos.dojooverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.axsos.dojooverflow.models.Answer;
import com.axsos.dojooverflow.models.Connection;
import com.axsos.dojooverflow.models.Question;
import com.axsos.dojooverflow.models.Tag;
import com.axsos.dojooverflow.repositories.AnswerRepository;
import com.axsos.dojooverflow.repositories.ConnectionRepository;
import com.axsos.dojooverflow.repositories.QuestionRepository;
import com.axsos.dojooverflow.repositories.TagRepository;

@Service
public class AppService {
	private final AnswerRepository answerRepo;
	private final ConnectionRepository connectionRepo;
	private final QuestionRepository questionRepo;
	private final TagRepository tagRepo;

	
	public AppService(AnswerRepository answerRepo, ConnectionRepository connectionRepo, QuestionRepository questionRepo,
			TagRepository tagRepo) {
		this.answerRepo = answerRepo;
		this.connectionRepo = connectionRepo;
		this.questionRepo = questionRepo;
		this.tagRepo = tagRepo;
	}
	
	public List<Question> findAllQuestions(){
		return questionRepo.findAll();
	}
	public Question findQuestionById(Long id) {
		Optional<Question> optionalQuestion = questionRepo.findById(id);
        if (optionalQuestion.isPresent()) {
            return optionalQuestion.get();
        } else {
            return null;
        }
	}
	
	public Question createQuestion(Question question) {
		return questionRepo.save(question);
	}
	public List<Tag> findAllTags(){
		return tagRepo.findAll();
	}
	public Tag createTag(Tag tag) {
		return tagRepo.save(tag);
	}
	public Connection createConnection(Connection connection) {
		return connectionRepo.save(connection);
	}
	public Answer createAnswer(Answer answer) {
		return answerRepo.save(answer);
	}

}
