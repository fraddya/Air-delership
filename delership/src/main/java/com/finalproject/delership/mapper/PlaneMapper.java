package com.finalproject.delership.mapper;

import com.finalproject.delership.domain.Plane;
import com.finalproject.delership.domain.criteria.PlaneCriteria;
import com.finalproject.delership.dto.request.plane.PlaneCreateRequest;
import com.finalproject.delership.dto.request.plane.PlaneSearchRequest;
import com.finalproject.delership.dto.response.plane.PlaneCreateResponse;
import com.finalproject.delership.dto.response.plane.PlaneSearchResponse;
import com.finalproject.delership.enums.Status;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",imports = {Status.class})
public interface PlaneMapper {

    Plane mapToPlane(PlaneCreateRequest request);

    PlaneCriteria mapToCriteria(PlaneSearchRequest request);

    List<PlaneSearchResponse> mapToSearchResponse(List<Plane> content);

    PlaneSearchResponse mapToPlaneViewResponse(Plane plane);

    PlaneCreateResponse mapToUpdateResponse(Plane planeUpdate);
}
