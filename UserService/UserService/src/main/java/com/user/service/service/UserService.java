package com.user.service.service;

import com.user.service.entity.User;

import java.util.List;

public interface UserService {

    //user operations

    //create
    User saveUser(User user);

    //get all user
    List<User> getAllUser();

    //get single user of given userId

    User getUser(String userId);

    //TODO: delete
    //TODO: update


}
