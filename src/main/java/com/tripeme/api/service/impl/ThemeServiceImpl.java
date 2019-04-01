package com.tripeme.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tripeme.api.bo.Theme;
import com.tripeme.api.repository.ThemeRepository;
import com.tripeme.api.service.ThemeService;

@Service
public class ThemeServiceImpl implements ThemeService{
	@Autowired
	ThemeRepository themeRepository;

	@Override
	public Theme addTheme(Theme theme) {
		return themeRepository.save(theme);
	}

	@Override
	public Theme getThemeById(Long themeId) {
		return themeRepository.getOne(themeId);
	}

	@Override
	public List<Theme> getThemes() {
		// TODO Auto-generated method stub
		return themeRepository.findAll();
	}

}
