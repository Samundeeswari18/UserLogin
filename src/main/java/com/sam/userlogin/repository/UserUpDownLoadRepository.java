package com.sam.userlogin.repository;

import com.sam.userlogin.entity.UserUpDownLoad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserUpDownLoadRepository extends JpaRepository<UserUpDownLoad, Long> {

}
