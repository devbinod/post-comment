package edu.miu.cs540.eaprojects.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PostDto {
    private Long id;
    private String title;
    private String description;
}
