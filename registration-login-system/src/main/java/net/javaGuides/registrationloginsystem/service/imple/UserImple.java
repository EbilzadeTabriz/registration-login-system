package net.javaGuides.registrationloginsystem.service.imple;

import lombok.AllArgsConstructor;
import net.javaGuides.registrationloginsystem.dto.UserDto;
import net.javaGuides.registrationloginsystem.entity.Role;
import net.javaGuides.registrationloginsystem.entity.User;
import net.javaGuides.registrationloginsystem.repository.RoleRepository;
import net.javaGuides.registrationloginsystem.repository.UserRepository;
import net.javaGuides.registrationloginsystem.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@AllArgsConstructor
public class UserImple  implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    @Override
    public void saveUser(UserDto userDto) {
        User user= new User();
        user.setName(userDto.getName());
        user.setEmail(user.getEmail());
        //encrypt the password using spring security
        user.setPassword(user.getPassword());
        Role role = roleRepository.findByName("ROLE_ADMIN");
        if (role==null){
            role=checkRoleExist();
        }
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);


    }
    private Role checkRoleExist(){
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        return roleRepository.save(role);

    }
}
