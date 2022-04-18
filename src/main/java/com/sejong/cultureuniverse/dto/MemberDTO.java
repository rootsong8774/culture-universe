package com.sejong.cultureuniverse.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDTO {
    
    
    @NotBlank
    @Size(min = 4, max = 16)
    private String username;
    
    @NotBlank
    private String password;
    
    
    private String name;
    
    private String role;
}
