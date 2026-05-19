package com.adaptivelearning.service;

import com.adaptivelearning.dto.LearningPathResponse;
import com.adaptivelearning.dto.SaveLearningPathRequest;
import com.adaptivelearning.exception.InvalidOperationException;
import com.adaptivelearning.exception.ResourceNotFoundException;
import com.adaptivelearning.model.LearningPath;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Service
public class LearningPathService {

    private final Map<String, LearningPath> store = new ConcurrentHashMap<>();

    public LearningPathResponse save(SaveLearningPathRequest request) {
        String id = "lp-" + UUID.randomUUID().toString().replace("-", "").substring(0, 12);
        Instant now = Instant.now();

        LearningPath path = LearningPath.builder()
            .id(id)
            .name(request.getName())
            .description(request.getDescription())
            .status("draft")
            .version(1)
            .canvas(request.getCanvas())
            .nodes(request.getNodes())
            .edges(request.getEdges())
            .createdAt(now)
            .updatedAt(now)
            .build();

        store.put(id, path);
        log.debug("Saved learning path with id={}", id);
        return toResponse(path);
    }

    public LearningPathResponse getById(String id) {
        LearningPath path = store.get(id);
        if (path == null) {
            throw new ResourceNotFoundException("Learning path not found: " + id);
        }
        return toResponse(path);
    }

    public LearningPathResponse publish(String id) {
        LearningPath path = store.get(id);
        if (path == null) {
            throw new ResourceNotFoundException("Learning path not found: " + id);
        }
        if ("published".equals(path.getStatus())) {
            throw new InvalidOperationException("Learning path is already published: " + id);
        }

        Instant now = Instant.now();
        LearningPath published = LearningPath.builder()
            .id(path.getId())
            .name(path.getName())
            .description(path.getDescription())
            .status("published")
            .version(path.getVersion() + 1)
            .canvas(path.getCanvas())
            .nodes(path.getNodes())
            .edges(path.getEdges())
            .createdAt(path.getCreatedAt())
            .updatedAt(now)
            .publishedAt(now)
            .build();

        store.put(id, published);
        log.debug("Published learning path id={}", id);
        return toResponse(published);
    }

    private LearningPathResponse toResponse(LearningPath path) {
        return LearningPathResponse.builder()
            .id(path.getId())
            .name(path.getName())
            .description(path.getDescription())
            .status(path.getStatus())
            .version(path.getVersion())
            .canvas(path.getCanvas())
            .nodes(path.getNodes())
            .edges(path.getEdges())
            .createdAt(path.getCreatedAt())
            .updatedAt(path.getUpdatedAt())
            .publishedAt(path.getPublishedAt())
            .build();
    }
}
