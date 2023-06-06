package uz.es.telegraph.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContentCreatedDto {
    @NotEmpty(message = "can not be empty")
    private String tittle;
    @NotEmpty(message = "can not be empty")
    private String author;
    @NotEmpty(message = "can not be empty")
    private String content;
}
