package az.edu.turinghackaton.dao.entity;

import az.edu.turinghackaton.model.enums.Title;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "POSTS")
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    Long id;

    @Column(name = "TITLE")
    @Enumerated(EnumType.STRING)
    Title title;

    @Column(name = "DESCRIPTION")
    String description;

    @Column(name = "COMPANY")
    String company;

    @Lob
    @Column(name = "COMPANY_IMAGE")
    byte[] companyImage;

    @Column(name = "LOCATION")
    String location;

    @Column(name = "JOB_TYPE")
    String jobType;

    @Column(name = "APPLICATION_DEADLINE")
    LocalDateTime applicationDeadline;

    @Column(name = "DATE_ADDED")
    LocalDateTime dateAdded;

    @PrePersist
    public void prePersist() {
        dateAdded = LocalDateTime.now();
    }
}
