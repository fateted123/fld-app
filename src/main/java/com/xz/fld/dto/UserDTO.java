package com.xz.fld.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UserDTO implements Serializable {
    private String userId;
    private String phone;
    private String email;
}
