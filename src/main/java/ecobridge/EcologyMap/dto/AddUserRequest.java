package ecobridge.EcologyMap.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AddUserRequest {
    private String username;
    private String password;
    private String refreshToken;
    private String accessToken;
}