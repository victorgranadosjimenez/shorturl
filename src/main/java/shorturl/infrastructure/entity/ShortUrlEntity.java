package shorturl.infrastructure.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class ShortUrlEntity {
    @Id
    private String id;
    private String originalUrl;
    private LocalDateTime createdAt;
    private int visits;


}
