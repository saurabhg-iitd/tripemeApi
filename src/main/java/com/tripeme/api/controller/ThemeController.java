package com.tripeme.api.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tripeme.api.bo.Theme;
import com.tripeme.api.service.ThemeService;

@RestController
@CrossOrigin(origins = "http://localhost:8100")
public class ThemeController {
	@Autowired
	ThemeService themeService;
	
	@GetMapping("/theme/{id}")
	Theme getTheme(@PathVariable Long id) {
		return themeService.getThemeById(id);
	}
	
	@PostMapping("/theme")
	Theme addTheme(@RequestBody Theme theme) {
		return themeService.addTheme(theme);
	}
	
	@PostMapping("/theme/{id}")
	Theme addTheme(@RequestBody Theme theme,@PathVariable Long id) {
		theme.setId(id);
		theme.setUpdatedOn(new Date());
		return themeService.addTheme(theme);
	}
	
	@GetMapping("/themes")
	List<Theme> getThemes() {
		return themeService.getThemes();
	}
}
