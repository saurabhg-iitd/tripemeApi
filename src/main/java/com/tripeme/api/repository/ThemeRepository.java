package com.tripeme.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tripeme.api.bo.Theme;

@Repository
public interface ThemeRepository extends JpaRepository<Theme, Integer> {

}
