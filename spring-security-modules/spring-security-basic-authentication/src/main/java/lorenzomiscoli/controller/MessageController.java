package lorenzomiscoli.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import lorenzomiscoli.model.Response;

@RestController
public class MessageController {

	@GetMapping("/messages")
	public Response getMessage() {
		return new Response("Ok");
	}
}
