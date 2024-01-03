package com.rating.service.repository;


import com.rating.service.entity.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RatingRepository extends MongoRepository<Rating,String> {

    //Custom Finder Method
    List<Rating> findByUserId(String userId);
    List<Rating> findByHotelId(String hotelId);

    //Create Method as per your need and follow Upparcamel case convention
    //for name

}
