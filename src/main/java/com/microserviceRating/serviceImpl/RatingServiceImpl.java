package com.microserviceRating.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microserviceRating.entity.Rating;
import com.microserviceRating.exceptions.ResourceNotFoundException;
import com.microserviceRating.repository.RatingRepository;
import com.microserviceRating.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingRepository ratingRepo;

	@Override
	public Rating createRating(Rating rating) {

		Rating createdRating = this.ratingRepo.save(rating);
		return createdRating;
	}

	@Override
	public Rating getRatingById(String ratingId) {
		Rating rating = this.ratingRepo.findById(ratingId)
				.orElseThrow(() -> new ResourceNotFoundException("Rating", "ratingId", ratingId));
		return rating;
	}

	@Override
	public List<Rating> getAllRatings() {
		List<Rating> ratings = this.ratingRepo.findAll();
		if (ratings.isEmpty()) {
			throw new ResourceNotFoundException("Rating");
		}
		return ratings;
	}

	@Override
	public List<Rating> getAllRatingsByUser(String userId) {
		List<Rating> ratings = this.ratingRepo.findByUserId(userId);
//		if (ratings.isEmpty()) {
//			throw new ResourceNotFoundException("Ratings", "UserId", userId);
//		}
		return ratings;
	}

	@Override
	public List<Rating> getAllRatingsByHotel(String hotelId) {
		List<Rating> ratings = this.ratingRepo.findByHotelId(hotelId);
		if (ratings.isEmpty()) {
			throw new ResourceNotFoundException("Ratings", "HotelId", hotelId);
		}
		return ratings;
	}
}
