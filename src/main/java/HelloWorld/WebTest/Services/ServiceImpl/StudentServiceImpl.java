package HelloWorld.WebTest.Services.ServiceImpl;

import HelloWorld.WebTest.Services.StudentService;
import HelloWorld.WebTest.models.Role;
import HelloWorld.WebTest.models.Student;
import HelloWorld.WebTest.repositories.StudentRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;
    private Student student;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Student student = studentRepository.findByEmail(email);
        if(student == null) {
            throw new UsernameNotFoundException("Wrong password or name");
        }
        return new org.springframework.security.core.userdetails.User(student.getEmail(), student.getPassword(), mapRolesToAuthorities(student.getRole()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
