package com.user.service.controller;


import com.user.service.entity.User;
import com.user.service.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")

public class UserController {

    @Autowired
    private UserService userService;

        Logger logger= LoggerFactory.getLogger(UserController.class);

    //create
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User user1 = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }
    //single user get

//    int retryCount=1;
    @GetMapping("/{userId}")
//    @CircuitBreaker(name= "ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
//    @Retry(name = "ratingHotelService",fallbackMethod = "ratingHotelFallback")
     @RateLimiter(name = "userRateLimiter",fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId) {
        logger.info("Get single User Handler: UserController");
//        logger.info("Retry count: {}",retryCount);
//        retryCount++;
        User user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }

    //creating fallback method for circuitBreaker -(Same Method returntype and same parameter also  )
    //This method is Run only when some service is Down

    public ResponseEntity<User> ratingHotelFallback(String userId,Exception ex){
//        logger.info("Fallback is executed because service is down: ",ex.getMessage());

        ex.printStackTrace();

        User user = User.builder()
                .userId("141234")
                .email("dummy@gmail.com")
                .name("Dummy")
                .about("This service is created dummy because some service is down")
                .build();
        return new ResponseEntity<>(user,HttpStatus.OK);

    }



    //all user get
    @GetMapping
    public ResponseEntity<List<User>> getAllUser() {
        List<User> allUser = userService.getAllUser();
        return ResponseEntity.ok(allUser);
    }
}
