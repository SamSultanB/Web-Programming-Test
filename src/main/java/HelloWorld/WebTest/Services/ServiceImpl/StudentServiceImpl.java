package HelloWorld.WebTest.Services.ServiceImpl;

import HelloWorld.WebTest.Services.StudentService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class StudentServiceImpl implements StudentService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
