package lk.ijse.service.impl;

import lk.ijse.dto.UserDTO;
import lk.ijse.entity.User;
import lk.ijse.repository.UserRepository;
import lk.ijse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public ArrayList<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();

        ArrayList<UserDTO> userDTOS = new ArrayList<>();
        for (User user: users) {
            UserDTO userDTO = new UserDTO(user.getUserName(), user.getPassword());
            userDTOS.add(userDTO);
        }
        return userDTOS;
    }

    @Override
    public UserDTO getUser(String id) {
        User user = userRepository.findById(id).get();
        return new UserDTO(user.getUserName(), user.getPassword());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean deleteUser(String id) {
        userRepository.deleteById(id);
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean addUser(UserDTO userDTO) {
        userRepository.save(new User(userDTO.getUserName(), userDTO.getPassword()));
        return true;
    }

    @Override
    public boolean canAuthenticate(UserDTO userDTO) {
        if(!userRepository.existsById(userDTO.getUserName())) {
            return false;
        } else {
            User user = userRepository.findById(userDTO.getUserName()).get();
            return user.getPassword().equals(userDTO.getPassword());
        }
    }
}
