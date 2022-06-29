package com.furkancebeci.interprobefirsthomework.controller;
import com.furkancebeci.interprobefirsthomework.dao.UsersDao;
import com.furkancebeci.interprobefirsthomework.entity.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UsersDao usersDao;

    @PostMapping("/save")
    public Users save(@RequestBody Users users){
        return usersDao.save(users);
    }

    @GetMapping("/findall")
    public List<Users> findAll(){
        return usersDao.findAll();
    }
}
