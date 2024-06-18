package com.example.springSecurityG124.repository;

import com.example.springSecurityG124.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Integer> {

    @Query("SELECT p FROM Permission p WHERE p.role = 'ROLE_STUDENT'")
    Permission getStandartPermission();
}
