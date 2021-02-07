package lorenzomiscoli.model;

import io.swagger.annotations.ApiModelProperty;

public class CustomResponse {

	@ApiModelProperty(notes = "A simple message")
	private String message;

	public CustomResponse(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
