package com.tripeme.api.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tripeme.api.bo.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserId(Long userId);
    User findByEmailId(String emailId);
    
    /*@Query(value="insert into user_track (user_id,track_id) values (?1 ,?2)", nativeQuery=true)
    void saveUserTrack(Long userId, String trackId);*/
}
