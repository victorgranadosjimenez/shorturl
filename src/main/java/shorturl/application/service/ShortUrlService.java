package shorturl.application.service;


import shorturl.domain.model.ShortUrl;
import shorturl.domain.ports.ShortUrlRepositoryPort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
public class ShortUrlService {

    private final ShortUrlRepositoryPort repository;

    public ShortUrlService(ShortUrlRepositoryPort repository) {
        this.repository = repository;
    }

    public ShortUrl createShortUrl(String originalUrl) {
        String id = generateShortId();
        ShortUrl shortUrl = new ShortUrl();
        shortUrl.setId(id);
        shortUrl.setOriginalUrl(originalUrl);
        shortUrl.setCreatedAt(LocalDateTime.now());
        shortUrl.setVisits(0);
        return repository.save(shortUrl);
    }

    public Optional<ShortUrl> getOriginalUrl(String id) {
        return repository.findById(id);
    }

    // Nuevo método para generar IDs tipo TinyURL
    private String generateShortId() {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 7; i++) { // puedes cambiar el 7 por 6 o 8 según prefieras
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }
}
