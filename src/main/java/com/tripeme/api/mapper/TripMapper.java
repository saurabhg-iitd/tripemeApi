package com.tripeme.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.tripeme.api.bo.Trip;
import com.tripeme.api.dto.TripDto;

@Mapper
public interface TripMapper {

	
	TripMapper INSTANCE = Mappers.getMapper( TripMapper.class ); 
	 
	    TripDto tripToTripDto(Trip trip);
	    Trip tripDtoToTrip(TripDto tripDto);
}
