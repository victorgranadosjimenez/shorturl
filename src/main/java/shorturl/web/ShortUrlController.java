package shorturl.web;



import shorturl.application.service.ShortUrlService;
import shorturl.domain.model.ShortUrl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api")
public class ShortUrlController {

    private final ShortUrlService service;

    public ShortUrlController(ShortUrlService service) {
        this.service = service;
    }

    @PostMapping("/shorten")
    public ResponseEntity<String> shorten(@RequestParam String url) {
        ShortUrl shortUrl = service.createShortUrl(url);
        return ResponseEntity.ok("http://localhost:8080/" + shortUrl.getId());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> redirect(@PathVariable String id) {
        return service.getOriginalUrl(id)
                .map(shortUrl -> ResponseEntity.status(302)
                        .location(URI.create(shortUrl.getOriginalUrl()))
                        .build())
                .orElse(ResponseEntity.notFound().build());
    }

}
