package com.wtiinfo.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wtiinfo.dsmovie.dto.MovieDTO;
import com.wtiinfo.dsmovie.entities.Movie;
import com.wtiinfo.dsmovie.repositories.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository repository;
	
	@Transactional(readOnly = true)
	public Page<MovieDTO> findAll(Pageable pageable){
		Page<Movie> movies = repository.findAll(pageable);
		Page<MovieDTO> dtosPage = movies.map(m -> new MovieDTO(m));
		return dtosPage;
	}
	
	@Transactional(readOnly = true)
	public MovieDTO findById(Long id){
		Movie movie = repository.findById(id).orElseThrow();
		MovieDTO dto = new MovieDTO(movie);
		return dto;
	}
}
