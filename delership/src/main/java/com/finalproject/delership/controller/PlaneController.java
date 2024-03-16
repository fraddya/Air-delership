package com.finalproject.delership.controller;

import com.finalproject.delership.domain.Plane;
import com.finalproject.delership.domain.base.PagingListResponseWrapper;
import com.finalproject.delership.domain.base.SingleItemResponseWrapper;
import com.finalproject.delership.domain.criteria.PlaneCriteria;
import com.finalproject.delership.dto.request.plane.PlaneCreateRequest;
import com.finalproject.delership.dto.request.plane.PlaneSearchRequest;
import com.finalproject.delership.dto.response.plane.PlaneCreateResponse;
import com.finalproject.delership.dto.response.plane.PlaneSearchResponse;
import com.finalproject.delership.mapper.PlaneMapper;
import com.finalproject.delership.service.PlaneService;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@Schema(name = "PlaneController", description = "create/search/view/update/delete")
public class PlaneController {

    @Autowired
    private PlaneService planeService;

    @Autowired
    private PlaneMapper planeMapper;

    @PostMapping("${app.endpoint.planeCreate}")
    public ResponseEntity<SingleItemResponseWrapper<PlaneCreateResponse>> create(
            @Validated @RequestBody PlaneCreateRequest request) {

        Plane plane = planeMapper.mapToPlane(request);

        Plane plane1  = planeService.save(plane);

        PlaneCreateResponse response = planeMapper.mapToUpdateResponse(plane1);

        return new ResponseEntity<>(new SingleItemResponseWrapper<>(response), HttpStatus.CREATED);
    }

    @PutMapping("${app.endpoint.planeUpdate}")
    public ResponseEntity<SingleItemResponseWrapper<PlaneCreateResponse>> update(
            @PathVariable Long id, @Validated @RequestBody PlaneCreateRequest request) {

        Plane plane = planeMapper.mapToPlane(request);

        plane.setId(id);

        Plane updatePlane = planeService.update(plane);

        PlaneCreateResponse response = planeMapper.mapToUpdateResponse(updatePlane);

        return new ResponseEntity<>(new SingleItemResponseWrapper<>(response), HttpStatus.OK);
    }

    @GetMapping("${app.endpoint.planeSearch}")
    public ResponseEntity<PagingListResponseWrapper<PlaneSearchResponse>> retrieve(
            @Validated PlaneSearchRequest request) {

        PlaneCriteria criteria = planeMapper.mapToCriteria(request);

        Page<Plane> results = planeService.search(criteria);

        List<PlaneSearchResponse> responses = planeMapper.mapToSearchResponse(results.getContent());

        PagingListResponseWrapper.Pagination pagination =
                new PagingListResponseWrapper.Pagination(
                        results.getNumber() + 1,
                        results.getSize(),
                        results.getTotalPages(),
                        results.getTotalElements());

        return new ResponseEntity<>(new PagingListResponseWrapper<>(responses, pagination), HttpStatus.OK);
    }

    @GetMapping("${app.endpoint.planeView}")
    public ResponseEntity<SingleItemResponseWrapper<PlaneSearchResponse>> retrieve(
            @PathVariable Long id) {

        Plane plane = planeService.retrieve(id);

        PlaneSearchResponse response = planeMapper.mapToPlaneViewResponse(plane);

        return new ResponseEntity<>(new SingleItemResponseWrapper<>(response), HttpStatus.OK);
    }

    @DeleteMapping("${app.endpoint.planeDelete}")
    public ResponseEntity<SingleItemResponseWrapper<PlaneCreateResponse>> delete(
            @PathVariable Long id) {
        Plane plane = planeService.delete(id);

        PlaneCreateResponse response = new PlaneCreateResponse();

        if (plane != null) {
            response = planeMapper.mapToUpdateResponse(plane);
        }
        return new ResponseEntity<>(new SingleItemResponseWrapper<>(response), HttpStatus.OK);
    }
}
