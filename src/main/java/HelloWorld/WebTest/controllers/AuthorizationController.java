package HelloWorld.WebTest.controllers;

import HelloWorld.WebTest.models.Student;
import HelloWorld.WebTest.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class AuthorizationController {
    @Autowired
    StudentRepository studentRepository;

    @ModelAttribute("student")
    public Student student(){
        return new Student();
    }
    @GetMapping("/registration")
    public ModelAndView login(Model model) {
        return new ModelAndView("login");
    }

    @PostMapping("/registration")
    public ModelAndView saveStudent(@ModelAttribute("student") Student student){
        studentRepository.save(student);
        return new ModelAndView("redirect:/registration?success");
    }
}
