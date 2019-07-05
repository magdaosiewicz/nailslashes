package com.example.naillashes.repository;

import com.example.naillashes.entity.Role;
import com.example.naillashes.entity.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(RoleName roleName);

}
