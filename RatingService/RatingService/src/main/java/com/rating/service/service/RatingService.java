package com.rating.service.service;

import com.rating.service.entity.Rating;

import java.util.List;

public interface RatingService {

    //create
    Rating create(Rating rating);

    //getAll
    List<Rating> getRatings();

    //get all by userId
    List<Rating> getRatingByUserId(String userId);

    //get all by ratingId
    List<Rating> getRatingByHotelId(String hotelId);

}
