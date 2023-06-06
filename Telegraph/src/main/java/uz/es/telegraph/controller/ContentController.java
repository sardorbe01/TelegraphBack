package uz.es.telegraph.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.es.telegraph.dto.ContentCreatedDto;
import uz.es.telegraph.entity.ContentEntity;
import uz.es.telegraph.service.ContentService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ContentController {
    private final ContentService contentService;

    @PostMapping("/api/v1/add-content")
    public String addContent(@RequestParam UUID id, @RequestBody ContentCreatedDto contentCreatedDto) {
        contentService.add(contentCreatedDto, id);
        return "ok";
    }

    @DeleteMapping("/api/v1/delete-content")
    public String deleteContent(@RequestParam UUID id) {
        if (contentService.getById(id) !=null) {
            contentService.deleteById(id);
            return "ok";
        }
        return "content not found";
    }

    @PutMapping("/api/v1/update-content")
    public ContentEntity update(
            @RequestBody ContentCreatedDto contentCreatedDto,
            @PathVariable UUID id
    ){
        return contentService.update(contentCreatedDto,id);
    }

    @GetMapping("/api/v1/get-allContent")
    public List<ContentEntity> getAllContent(
            @RequestParam UUID id,
            @RequestParam int page,
            @RequestParam int size,
            Model model
    ) {
        return contentService.getUSerContents(page, size, id);


    }
}
