package com.tripeme.api.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tripeme.api.bo.Destination;
import com.tripeme.api.bo.Theme;
import com.tripeme.api.bo.Trip;
import com.tripeme.api.dto.TripDto;
import com.tripeme.api.bo.Resource;
import com.tripeme.api.enums.ResourceType;
import com.tripeme.api.mapper.TripMapper;
import com.tripeme.api.request.TripRequest;
import com.tripeme.api.response.UploadFileResponse;
import com.tripeme.api.service.ResourceService;
import com.tripeme.api.service.DestinationService;
import com.tripeme.api.service.ThemeService;
import com.tripeme.api.service.TripService;

@RestController
public class TripController {
	@Autowired
	TripService tripService;
	
	@Autowired
	ThemeService themeService;
	
	@Autowired
	DestinationService destinationService;
	@Autowired
	FileController fileController;
	
	@Autowired
	ResourceService resourceService;
	
	@GetMapping("/trip/{id}")
    public TripDto getTrip(@PathVariable Long id) {
		Trip trip = tripService.getTripById(id);
		TripDto tripDto = TripMapper.INSTANCE.tripToTripDto(trip);
		List<Resource> resources = resourceService.getResources(trip.getId(), ResourceType.trip);
		tripDto.setImages(resources);
		return tripDto;
	}
	
	@PutMapping("/trip/{id}")
    public Trip updateTrip(@RequestBody TripDto tripDto,@PathVariable Long id) {
		Trip trip = TripMapper.INSTANCE.tripDtoToTrip(tripDto);
		trip.setId(id);
		return tripService.saveTrip(trip);
	}
	
	@GetMapping("/trip")
    public List<Trip> getAllTrip() {
		return tripService.getAllTrips();
	}
	
	@PostMapping("/trip")
	public Trip addTrip(@RequestBody TripRequest request) {
		Theme theme = themeService.getThemeById(request.getTheme().getId());
		Destination destination = destinationService.getDestinationById(request.getDestination().getId());
		Trip trip = new Trip();
		trip.setCreatedOn(new Date());
		trip.setUpdatedOn(new Date());
		trip.setTheme(theme);
		trip.setEndDate(request.getEndDate());
		trip.setStartDate(request.getStartDate());
		trip.setMaxBookings(request.getMaxBookings());
		trip.setDestination(destination);
		/*trip = tripService.addTrip(trip);*/
		/*List<UploadFileResponse> fileResponses = fileController.uploadMultipleFiles(request.getFiles(), ImageType.trip, trip.getTripId());
		Set<Image> images = new HashSet<>();
		for (UploadFileResponse res : fileResponses) {
			Image image = new Image();
			image.setTrip(trip);
			image.setUrl(res.getFileDownloadUri());
			images.add(image);
		}*/
		return  tripService.saveTrip(trip);
	}
	
	@GetMapping("/trip/destination/{name}")
	public List<Trip> getTripsByDestinationName(@PathVariable String name) {
		return tripService.getTripsByDestinationName(name);
		
	}
	
	@GetMapping("/trip/destinationId/{id}")
	public List<Trip> getTripsByDestinationId(@PathVariable Long id) {
		return tripService.getTripsByDestinationId(id);
		
	}

	
}
