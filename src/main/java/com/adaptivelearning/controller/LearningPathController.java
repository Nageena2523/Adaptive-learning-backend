package com.adaptivelearning.controller;

import com.adaptivelearning.dto.LearningPathResponse;
import com.adaptivelearning.dto.SaveLearningPathRequest;
import com.adaptivelearning.service.LearningPathService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/learning-paths")
@RequiredArgsConstructor
public class LearningPathController {

    private final LearningPathService learningPathService;

    @PostMapping
    public ResponseEntity<LearningPathResponse> saveDraft(
            @Valid @RequestBody SaveLearningPathRequest request) {
        LearningPathResponse response = learningPathService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LearningPathResponse> getById(@PathVariable String id) {
        return ResponseEntity.ok(learningPathService.getById(id));
    }

    @PutMapping("/{id}/publish")
    public ResponseEntity<LearningPathResponse> publish(@PathVariable String id) {
        return ResponseEntity.ok(learningPathService.publish(id));
    }
}
