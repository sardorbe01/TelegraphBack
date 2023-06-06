package uz.es.telegraph.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;


@Entity(name = "contents")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ContentEntity extends BaseEntity{
    private String tittle;
    private String author;
    private String content;
    private String contentLink;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="owner_id",referencedColumnName = "id")
    private UserEntity userList;
}
