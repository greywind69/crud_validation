package com.example.crud_validation.Dao;

import com.example.crud_validation.Model.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userrepo extends JpaRepository<user, Integer> {
}
