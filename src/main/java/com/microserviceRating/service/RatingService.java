package com.microserviceRating.service;

import java.util.List;

import com.microserviceRating.entity.Rating;

public interface RatingService {

	Rating createRating(Rating rating);

	Rating getRatingById(String ratingId);

	List<Rating> getAllRatings();

	List<Rating> getAllRatingsByUser(String userId);

	List<Rating> getAllRatingsByHotel(String hotelId);
}
