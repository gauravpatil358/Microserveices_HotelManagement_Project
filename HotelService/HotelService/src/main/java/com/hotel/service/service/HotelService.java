package com.hotel.service.service;

import com.hotel.service.entities.Hotel;

import java.util.List;

public interface HotelService {

    //Create
    Hotel create(Hotel hotel);

    //get
    Hotel get(String id);

    //getAll
     List<Hotel> getAll();
}
