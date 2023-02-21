package HelloWorld.WebTest.controllers;

import HelloWorld.WebTest.models.Student;
import HelloWorld.WebTest.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/students")
    public ModelAndView login(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        return new ModelAndView("home");
    }

    @PostMapping("/students")
    public ModelAndView addStudent(@ModelAttribute("student") Student student) {
        studentRepository.save(student);
        return new ModelAndView("redirect:/students");
    }
}
