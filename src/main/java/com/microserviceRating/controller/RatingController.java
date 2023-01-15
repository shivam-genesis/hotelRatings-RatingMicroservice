package com.microserviceRating.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microserviceRating.entity.Rating;
import com.microserviceRating.service.RatingService;

@RestController
public class RatingController {

	@Autowired
	private RatingService ratingService;

	@PostMapping("/rating")
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
		Rating r = this.ratingService.createRating(rating);
		return new ResponseEntity<Rating>(r, HttpStatus.OK);
	}

	@GetMapping("/rating/{ratingId}")
	public ResponseEntity<Rating> getRatingById(@PathVariable String ratingId) {
		Rating rating = this.ratingService.getRatingById(ratingId);
		return new ResponseEntity<Rating>(rating, HttpStatus.OK);
	}

	@GetMapping("/ratings")
	public ResponseEntity<List<Rating>> getAllRatings() {
		List<Rating> ratings = this.ratingService.getAllRatings();
		return new ResponseEntity<List<Rating>>(ratings, HttpStatus.OK);
	}

	@GetMapping("/ratings/userid/{userId}")
	public ResponseEntity<List<Rating>> getRatingsByUser(@PathVariable String userId) {
		List<Rating> ratings = this.ratingService.getAllRatingsByUser(userId);
		return new ResponseEntity<List<Rating>>(ratings, HttpStatus.OK);
	}

	@GetMapping("/ratings/hotelid/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingsByHotel(@PathVariable String hotelId){
		List<Rating> ratings = this.ratingService.getAllRatingsByHotel(hotelId);
		return new ResponseEntity<List<Rating>>(ratings,HttpStatus.OK);
	}
}
