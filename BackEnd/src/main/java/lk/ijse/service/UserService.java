package lk.ijse.service;

import lk.ijse.dto.UserDTO;

import java.util.ArrayList;

public interface UserService {

    public ArrayList<UserDTO> getAllUsers();

    public UserDTO getUser(String id);

    public boolean deleteUser(String id);

    public boolean addUser(UserDTO userDTO);

    public boolean canAuthenticate(UserDTO userDTO);

}
