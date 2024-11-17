package com.example.demo.service.serviceImpl;

import com.example.demo.dto.AddUserDto;
import com.example.demo.entity.AppUser;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public AppUser addUser(AddUserDto dto) {

        AppUser newUser = new AppUser();
        newUser.setAge(dto.getAge());
        newUser.setName(dto.getName());
        return userRepository.save(newUser);

    }

    @Override
    public List<AppUser> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public AppUser getUserById(long id) {
        return null;
    }
}
