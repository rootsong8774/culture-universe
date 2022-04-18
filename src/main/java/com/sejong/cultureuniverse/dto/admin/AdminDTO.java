package com.sejong.cultureuniverse.dto.admin;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AdminDTO {
    
    @NotBlank(message = "아이디를 입력해주세요")
    @Size(min = 4, max = 16, message = "아이디를 4자 이상 16자 이하의 문자열로 입력해 주세요..")
    private String adminId;
    
    @NotBlank(message = "비밀번호를 입력해주세요")
    @Size(min=8, max = 16,message = "비밀번호를 8자 이상 16자 이하의 문자열로 입력해 주세요.")
    private String adminPw;
    
    private String role;
}
