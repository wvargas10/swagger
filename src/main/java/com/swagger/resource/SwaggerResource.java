package com.swagger.resource;

import static com.swagger.constants.SwaggerAppConstants.API_CONTEXT_ROOT;
import static com.swagger.constants.SwaggerAppConstants.FAILURE_RESPONSE;
import static com.swagger.constants.SwaggerAppConstants.GREETING_GENERAl_ENDPOINT;
import static com.swagger.constants.SwaggerAppConstants.GREETING_PATH_VARIABLE_ENDPOINT;
import static com.swagger.constants.SwaggerAppConstants.GREETING_REQUEST_PARAM_ENDPOINT;
import static com.swagger.constants.SwaggerAppConstants.HEADER;
import static com.swagger.constants.SwaggerAppConstants.HTTP_200;
import static com.swagger.constants.SwaggerAppConstants.HTTP_400;
import static com.swagger.constants.SwaggerAppConstants.REGISTER_PERSON_ENDPOINT;
import static com.swagger.constants.SwaggerAppConstants.REQUEST_ID;
import static com.swagger.constants.SwaggerAppConstants.SUCCESS_RESPONSE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.swagger.dto.PersonPayloadInput;
import com.swagger.dto.PersonPayloadOutput;
import com.swagger.exception.ServiceInvocationException;
import com.swagger.service.PersonRegistrationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@Api(tags = { "Swagger" })
@Slf4j
@RequestMapping(value = API_CONTEXT_ROOT)
@RestController
public class SwaggerResource {

	@Autowired
	PersonRegistrationService personRegistrationService;

	@ApiOperation(httpMethod = "GET", value = "General greeting", notes = "REST method returns a general greeting")
	@ApiResponses(value = { @ApiResponse(description = SUCCESS_RESPONSE, responseCode = HTTP_200) })
	@ApiImplicitParams({
			@ApiImplicitParam(name = REQUEST_ID, 
					required = false, 
					dataTypeClass = String.class, 
					paramType = HEADER, 
					example = "requestID") })
	@GetMapping(value = GREETING_GENERAl_ENDPOINT)
	public String getGreeting() {
		final String methodName = "getGreeting";
		log.debug("[{}] Started", methodName);
		String greet = personRegistrationService.registerPersonGreetGeneral();

		return greet;
	}

	@ApiOperation(httpMethod = "GET", 
			value = "Register person greeting name through path variable", 
			notes = "REST method returns personalized name greting provided by path variable", hidden = false)
	@ApiImplicitParams({
		@ApiImplicitParam(name = REQUEST_ID, 
				required = false, 
				dataTypeClass = String.class, 
				paramType = HEADER, 
				example = "requestID") })
	@GetMapping(value = GREETING_PATH_VARIABLE_ENDPOINT)
	public String getGreetingNamePathVariable(
			@ApiParam(value = "Path Variable value", required = true) @PathVariable(value = "name", required = true) String name) {
		final String methodName = "getGreetingNamePathVariable";
		log.debug("[{}] Started", methodName);

		log.debug("name = {} ", name);
		String greet = personRegistrationService.registerPersonGreetName(name);

		return greet;
	}

	@ApiOperation(httpMethod = "GET", 
			value = "Register person greeting name through request param", 
			notes = "REST method  returns personlized name greting provided by request param, ie "
			+ API_CONTEXT_ROOT + GREETING_REQUEST_PARAM_ENDPOINT + "?name=Mike")
	@ApiResponses(value = { @ApiResponse(description = SUCCESS_RESPONSE, responseCode = HTTP_200) })
	@ApiImplicitParams({
		@ApiImplicitParam(name = REQUEST_ID, 
				required = false, 
				dataTypeClass = String.class, 
				paramType = HEADER, 
				example = "requestID") })	@GetMapping(value = GREETING_REQUEST_PARAM_ENDPOINT)
	public String getGreetingNameRequestParam(
			@Parameter(description = "Request Param value", 
					   in = ParameterIn.QUERY, 
					   required = true, 
					   example = "nameRequestParam") @RequestParam(value = "name", required = true) String name) {
		final String methodName = "getGreetingNameRequestParam";
		log.debug("[{}] Started", methodName);

		log.debug("name = {} ", name);
		String greet = personRegistrationService.registerPersonGreetName(name);

		return greet;
	}

	@ApiOperation(httpMethod = "POST", value = "Register person", notes = "REST method  registers person")
	@ApiResponses(value = { @ApiResponse(description = SUCCESS_RESPONSE, responseCode = HTTP_200, content = {
			@Content(schema = @Schema(implementation = PersonPayloadOutput.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
			@ApiResponse(description = FAILURE_RESPONSE, responseCode = HTTP_400, content = {
					@Content(mediaType = MediaType.APPLICATION_JSON_VALUE) }) })
	@ApiImplicitParams({
		@ApiImplicitParam(name = REQUEST_ID, 
				required = false, 
				dataTypeClass = String.class, 
				paramType = HEADER, 
				example = "requestID") })
	@PostMapping(value = REGISTER_PERSON_ENDPOINT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonPayloadOutput registerPerson(@RequestBody PersonPayloadInput payloadInput)throws ServiceInvocationException {
		final String methodName = "registerPerson";
		log.debug("[{}] Started", methodName);

		log.debug("payloadInput = {} ", payloadInput);
		PersonPayloadOutput output = personRegistrationService.registPerson(payloadInput);

		return output;
	}
}
