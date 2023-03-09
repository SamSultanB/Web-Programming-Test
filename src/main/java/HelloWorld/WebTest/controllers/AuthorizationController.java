package HelloWorld.WebTest.controllers;

import HelloWorld.WebTest.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AuthorizationController {
    @Autowired
    StudentRepository studentRepository;


    @GetMapping("/")
    public ModelAndView login(Model model) {
        return new ModelAndView("login");
    }
}
