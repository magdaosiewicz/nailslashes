package com.example.naillashes.dto;

import com.example.naillashes.entity.Role;
import com.example.naillashes.entity.RoleName;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleDTO {

    private Long id;
    private RoleName name;

    public static RoleDTO ofRole(Role role){
        return RoleDTO.builder()
                .id(role.getId())
                .name(role.getName())
                .build();
    }


}
