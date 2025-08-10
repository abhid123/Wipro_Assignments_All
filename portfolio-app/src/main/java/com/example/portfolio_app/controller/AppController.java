package com.example.portfolio_app.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController {
	@GetMapping("/")
	public String showHomePage() {
        return "home"; // This will map to /templates/home.html
    }
	@GetMapping("/about")
	public String AboutPage() {
        return "about"; // This will map to /templates/about.html
    }
	@GetMapping("/contact")
	public String contactPage() {
        return "contact"; // This will map to /templates/contact.html
    }
	@GetMapping("/education")
	public String educationPage() {
        return "education"; // This will map to /templates/education.html
    }
	@GetMapping("/skills")
	public String skillPage() {
        return "skills"; // This will map to /templates/education.html
    }
}
