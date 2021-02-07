package lorenzomiscoli.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import lorenzomiscoli.model.CustomResponse;

@RestController
public class MessageController {

	@GetMapping("/messages")
	public CustomResponse getMessage() {
		return new CustomResponse("Ok");
	}

}
