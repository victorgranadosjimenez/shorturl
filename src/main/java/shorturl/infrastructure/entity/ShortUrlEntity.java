package shorturl.infrastructure.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "short_url_entity") // 👈 Nombre real de la tabla en tu BD
public class ShortUrlEntity {
    @Id
    private String id;
    private String originalUrl;
    private LocalDateTime createdAt;
    private int visits;
}
