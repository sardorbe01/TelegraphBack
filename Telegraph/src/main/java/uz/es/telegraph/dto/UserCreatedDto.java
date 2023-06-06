package uz.es.telegraph.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserCreatedDto {
    @NotEmpty(message = "can not be empty")
    private String name;
    @NotEmpty(message = "not null")
    @Pattern(regexp = "^\\d+$")
    @Column(unique = true,name = "is phoneNumber already exists")
    private String phoneNumber;
    @NotEmpty(message = "not empty mazgi")
    private String password;
}
