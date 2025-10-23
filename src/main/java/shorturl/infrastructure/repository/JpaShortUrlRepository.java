package shorturl.infrastructure.repository;



import shorturl.infrastructure.entity.ShortUrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaShortUrlRepository extends JpaRepository<ShortUrlEntity, String> {}
