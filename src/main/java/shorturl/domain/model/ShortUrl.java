package shorturl.domain.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShortUrl {
    private String id;              // "abc123"
    private String originalUrl;     // "https://..."
    private LocalDateTime createdAt;
    private int visits;


}
