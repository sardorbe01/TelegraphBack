package uz.es.telegraph.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.es.telegraph.entity.ContentEntity;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ContentRepository extends JpaRepository<ContentEntity, UUID> {
    Optional<ContentEntity> getContentEntityById(UUID id);
    List<ContentEntity> findContentEntitiesByUserListId(Pageable pageable, UUID userId);
    ContentEntity findContentEntityById(UUID id);
}
