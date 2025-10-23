package shorturl.infrastructure.repository;



import shorturl.domain.model.ShortUrl;
import shorturl.domain.ports.ShortUrlRepositoryPort;
import shorturl.infrastructure.entity.ShortUrlEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ShortUrlRepositoryAdapter implements ShortUrlRepositoryPort {

    private final JpaShortUrlRepository jpaRepo;

    public ShortUrlRepositoryAdapter(JpaShortUrlRepository jpaRepo) {
        this.jpaRepo = jpaRepo;
    }

    @Override
    public ShortUrl save(ShortUrl shortUrl) {
        ShortUrlEntity entity = new ShortUrlEntity();
        entity.setId(shortUrl.getId());
        entity.setOriginalUrl(shortUrl.getOriginalUrl());
        entity.setCreatedAt(shortUrl.getCreatedAt());
        entity.setVisits(shortUrl.getVisits());
        jpaRepo.save(entity);
        return shortUrl;
    }

    @Override
    public Optional<ShortUrl> findById(String id) {
        return jpaRepo.findById(id).map(entity -> {
            ShortUrl s = new ShortUrl();
            s.setId(entity.getId());
            s.setOriginalUrl(entity.getOriginalUrl());
            s.setCreatedAt(entity.getCreatedAt());
            s.setVisits(entity.getVisits());
            return s;
        });
    }
}
