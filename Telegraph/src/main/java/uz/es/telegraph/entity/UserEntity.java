package uz.es.telegraph.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity extends BaseEntity {
    private String name;
    private String phoneNumber;
    private String password;
    @OneToMany(cascade = CascadeType.ALL)
    private List<ContentEntity> contents;

}
