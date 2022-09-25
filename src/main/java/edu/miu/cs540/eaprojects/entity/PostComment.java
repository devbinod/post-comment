package edu.miu.cs540.eaprojects.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostComment {

    @Id
    @GeneratedValue
    private Long id;
    private String comment;

    private LocalDate createdDate;
    private Long postId;
    private Long userId;

    @PrePersist
    public void prePersist() {
        if (createdDate == null) createdDate = LocalDate.now();
    }
}
