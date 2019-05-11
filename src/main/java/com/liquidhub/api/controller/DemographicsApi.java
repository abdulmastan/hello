package com.liquidhub.api.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.liquidhub.api.model.BatchResponse;
import com.liquidhub.api.model.DemographicsListItem;
import com.liquidhub.api.model.DemographicsRequest;
import com.liquidhub.api.model.Identification;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "demographics", description = "the demographics API")
public interface DemographicsApi {

    @ApiOperation(value = "Update or Create one or more Patient Demographics records.", notes = "Update or Create one or more Patient Demographics records. BatchControl options are 1) specify OpenBatch to create a new batch where you will be returned a new BatchId to use on subsequent calls, 2) specify CloseBatch to explicitly create and close a batch consisting only of the records with the current request, 3) specify CloseBatch AND a BatchId to explicitly close a batch after handling the current request records.", response = BatchResponse.class, tags={ "demographics", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Response", response = BatchResponse.class),
        @ApiResponse(code = 400, message = "Error", response = BatchResponse.class) })
    @RequestMapping(value = "/demographics",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<BatchResponse> demographicsAdd(@ApiParam(value = "" ,required=true ) @RequestBody DemographicsRequest message);


    @ApiOperation(value = "Get list of patient identifiers with demographics updated since given status date.", notes = "Get list of patient identifiers with demographics updated since given status date so that updated demographics may be requested by id.", response = Identification.class, responseContainer = "List", tags={ "demographics", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Response", response = Identification.class),
        @ApiResponse(code = 400, message = "Error", response = Identification.class) })
    @RequestMapping(value = "/demographics/list",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<List<Identification>> demographicsFindByDate( @NotNull @ApiParam(value = "", required = true) @RequestParam(value = "statusDate", required = true) String statusDate);


    @ApiOperation(value = "Get the demographics record for one patient.", notes = "Retrieve demographics for a single patient by identifier. At least one identifier must be specified. (liquidHubPatientID, sourcePatientId, alternatePatientId).", response = DemographicsListItem.class, responseContainer = "List", tags={ "demographics", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Response", response = DemographicsListItem.class),
        @ApiResponse(code = 400, message = "Error", response = DemographicsListItem.class) })
    @RequestMapping(value = "/demographics",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<List<DemographicsListItem>> demographicsFindById( @ApiParam(value = "") @RequestParam(value = "liquidHubPatientId", required = false) String liquidHubPatientId,
         @ApiParam(value = "") @RequestParam(value = "sourcePatientId", required = false) String sourcePatientId,
         @ApiParam(value = "") @RequestParam(value = "alternatePatientId", required = false) String alternatePatientId);

}
