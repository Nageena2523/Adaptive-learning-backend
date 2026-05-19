package com.adaptivelearning.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LearningPath {
    private String id;
    private String name;
    private String description;
    private String status; // "draft" | "published"
    private Integer version;
    private CanvasState canvas;
    private List<Node> nodes;
    private List<Edge> edges;
    private Instant createdAt;
    private Instant updatedAt;
    private Instant publishedAt;
}
