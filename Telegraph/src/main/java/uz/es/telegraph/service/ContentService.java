package uz.es.telegraph.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.es.telegraph.dto.ContentCreatedDto;

import uz.es.telegraph.entity.ContentEntity;

import uz.es.telegraph.entity.UserEntity;
import uz.es.telegraph.exceptons.ObjectsNotFoundException;
import uz.es.telegraph.repository.ContentRepository;
import uz.es.telegraph.repository.UserRepository;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ContentService {
    private final ContentRepository contentRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public ContentEntity add(ContentCreatedDto contentCreatedDto, UUID userId) {

        ContentEntity contentEntity = modelMapper.map(contentCreatedDto, ContentEntity.class);

        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found " + userId));

        user.getContents().add(contentEntity);
        contentEntity.setContentLink(String.join("-", contentEntity.getTittle(), LocalDateTime.now().toString()));
        contentEntity.setUserList(user);
        contentRepository.save(contentEntity);

        return contentEntity;
    }

    public void deleteById(UUID id) {
        contentRepository.deleteById(id);

    }

    public ContentEntity update(ContentCreatedDto update, UUID id) {
        ContentEntity contentEntityById = contentRepository.findContentEntityById(id);
        if (!update.getTittle().isEmpty()) {
            contentEntityById.setTittle(update.getTittle());
        }

        if (!update.getAuthor().isEmpty()) {
            contentEntityById.setAuthor(update.getAuthor());
        }
        if (!update.getContent().isEmpty()) {
            contentEntityById.setContent(update.getContent());
        }
        contentEntityById.setUpdatedDate(LocalDateTime.now());
        return contentRepository.save(contentEntityById);
    }

    public Optional<ContentEntity> getById(UUID id) {
        ContentEntity contentEntity = contentRepository.getContentEntityById(id).orElseThrow(()
                -> new ObjectsNotFoundException("content couldn't be found"));
        return Optional.ofNullable(contentEntity);
    }

    public List<ContentEntity> getUSerContents(int page, int size, UUID userId) {
        Pageable pageable = PageRequest.of(page, size);
        return contentRepository.findContentEntitiesByUserListId(pageable, userId);
    }

}
