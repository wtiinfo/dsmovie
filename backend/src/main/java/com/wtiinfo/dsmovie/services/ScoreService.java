package com.wtiinfo.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wtiinfo.dsmovie.dto.MovieDTO;
import com.wtiinfo.dsmovie.dto.ScoreDTO;
import com.wtiinfo.dsmovie.entities.Movie;
import com.wtiinfo.dsmovie.entities.Score;
import com.wtiinfo.dsmovie.entities.User;
import com.wtiinfo.dsmovie.repositories.MovieRepository;
import com.wtiinfo.dsmovie.repositories.ScoreRepository;
import com.wtiinfo.dsmovie.repositories.UserRepository;

@Service
public class ScoreService {

	@Autowired
	private MovieRepository movieRepo;

	@Autowired
	private ScoreRepository scoreRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Transactional
	public MovieDTO saveScore(ScoreDTO dto) {
		User user = userRepo.findByEmail(dto.getEmail());
		if(user == null) {
			user = new User();
			user.setEmail(dto.getEmail());
			user = userRepo.saveAndFlush(user);
		}
		
		Movie movie = movieRepo.findById(dto.getMovieId()).orElseThrow();
		
		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(dto.getScore());
		
		score = scoreRepo.saveAndFlush(score);
		
		double sum = 0.0;
		for(Score s : movie.getScores()) {
			sum += s.getValue();
		}
		
		double avg = sum / movie.getScores().size();
		
		movie.setScore(avg);
		movie.setCount(movie.getScores().size());
		
		movie = movieRepo.save(movie);
		return new MovieDTO(movie);
	}
	
}
