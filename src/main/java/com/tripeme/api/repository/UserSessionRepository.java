package com.tripeme.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tripeme.api.bo.UserSession;


@Repository
public interface UserSessionRepository extends JpaRepository<UserSession, String> {
}
