package shorturl.domain.ports;

import shorturl.domain.model.ShortUrl;
import java.util.Optional;

/*
Es una interfaz que dice: “Mi dominio necesita guardar y recuperar URLs, pero no me importa cómo.”
 */
public interface ShortUrlRepositoryPort {
    ShortUrl save(ShortUrl shortUrl);
    Optional<ShortUrl> findById(String id);
}
