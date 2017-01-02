package com.dhmo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dhmo.model.RestRoom;

public interface RestRoomRepository extends CrudRepository<RestRoom, Long> {
	
    List<RestRoom> findByName(String name);
}
