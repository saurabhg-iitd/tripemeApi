package com.tripeme.api.service;

import java.util.List;

import com.tripeme.api.bo.Theme;

public interface ThemeService {
	Theme addTheme(Theme theme);
	Theme getThemeById(Long themeId);
	List<Theme> getThemes();
	

}
