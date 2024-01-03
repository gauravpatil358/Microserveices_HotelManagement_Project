package com.user.service;

import com.user.service.entity.Rating;
import com.user.service.external.services.RatingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest
class UserServiceApplicationTests {

	@Test
	void contextLoads() {
	}

//	@Autowired
//	private RatingService ratingService;
//
//	@Test
//	 void createRating(){
//		 Rating rating= Rating.builder().rating(10).userId("55").hotelId("SK").feedback("this is created using feign client").build();
//		 Rating saveRating = ratingService.createRating(rating);
//
//		 System.out.println("new Rating created");
//	 }

}
