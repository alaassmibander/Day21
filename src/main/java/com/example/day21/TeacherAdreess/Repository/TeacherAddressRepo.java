package com.example.day21.TeacherAdreess.Repository;

import com.example.day21.TeacherAdreess.Model.TeacherAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherAddressRepo extends JpaRepository<TeacherAddress,Integer> {
    TeacherAddress findTeacherAddressById(Integer id);

}