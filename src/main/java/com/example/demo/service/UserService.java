package com.example.demo.service;

import com.example.demo.dto.AddUserDto;
import com.example.demo.entity.AppUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserService {

    AppUser addUser(AddUserDto dto);

    List<AppUser> getAllUsers();

    AppUser getUserById(long id);
}

