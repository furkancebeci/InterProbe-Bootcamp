package com.furkancebeci.interprobefirsthomework.dao;

import com.furkancebeci.interprobefirsthomework.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersDao extends JpaRepository<Users, Long> {
}
