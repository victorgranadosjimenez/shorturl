package shorturl.web;

import jakarta.servlet.http.HttpServletRequest;
import shorturl.application.service.ShortUrlService;
import shorturl.domain.model.ShortUrl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class ShortUrlController {

    private final ShortUrlService service;

    public ShortUrlController(ShortUrlService service) {
        this.service = service;
    }

    // POST para crear un short URL
    @PostMapping("/api/shorten")
    public ResponseEntity<String> shortenUrl(@RequestParam String url, HttpServletRequest request) {
        ShortUrl shortUrl = service.createShortUrl(url);

        // Construye la URL base automáticamente según el dominio real (Render)
        String baseUrl = request.getRequestURL().toString().replace(request.getRequestURI(), "");
        String shortLink = baseUrl + "/" + shortUrl.getId(); // GET queda sin /api

        return ResponseEntity.ok(shortLink);
    }



    // GET para redirigir desde el short URL
    @GetMapping("/{id}")
    public ResponseEntity<?> redirect(@PathVariable String id) {
        return service.getOriginalUrl(id)
                .map(shortUrl -> ResponseEntity.status(302)
                        .location(URI.create(shortUrl.getOriginalUrl()))
                        .build())
                .orElse(ResponseEntity.notFound().build());
    }
}
