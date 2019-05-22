package com.rating.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rating.domain.Rating;
import com.rating.exception.ResourceNotFoundException;
import com.rating.service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	private RatingService ratingService;

	@GetMapping
	public List<Rating> findRatingByProductId(
	@RequestParam(required = false, defaultValue = "0") Integer productId) throws ResourceNotFoundException{
		if(productId.equals(0)) {
			return (List<Rating>) ratingService.findAll();
		}
		Rating rating = ratingService.getById(productId);
		//Testing the re-build of docker image
		if(rating == null)
			throw new ResourceNotFoundException("Product id not found: " + productId);
		return Arrays.asList(rating);
	}

}
