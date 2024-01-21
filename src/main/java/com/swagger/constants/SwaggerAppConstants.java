/**
 * 
 */
package com.swagger.constants;

public class SwaggerAppConstants {
	private SwaggerAppConstants () {}

	public static final String API_CONTEXT_ROOT = "/swagger/v1";
	public static final String GREETING_GENERAl_ENDPOINT = "/generalgreeting";
	public static final String GREETING_PATH_VARIABLE_ENDPOINT = "/{name}";
	public static final String GREETING_REQUEST_PARAM_ENDPOINT = "/requestparamgreeting";
	public static final String REGISTER_PERSON_ENDPOINT = "/registerperson";

	public static final String HTTP_200 = "200"; // Success
	public static final String HTTP_400 = "400"; // Client Error
	public static final String HTTP_500 = "500"; // Server Error

	public static final String SUCCESS_RESPONSE = "Success Response";
	public static final String FAILURE_RESPONSE = "Failure Response";

	public static final String START_MSG = "[{}] started [{}]";
	public static final String END_MSG = "[{}] completed [{}]";

	public static final String HTTP_AUTH_TOKEN = "HTTP_AUTH_TOKEN";
	public static final String REQUEST_ID = "REQUEST_ID";
	public static final String STRING = "String";
	public static final String HEADER = "header";
}
