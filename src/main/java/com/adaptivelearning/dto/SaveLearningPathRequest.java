package com.adaptivelearning.dto;

import com.adaptivelearning.model.CanvasState;
import com.adaptivelearning.model.Edge;
import com.adaptivelearning.model.Node;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaveLearningPathRequest {

    @NotBlank(message = "Name is required")
    @Size(min = 1, max = 150, message = "Name must be between 1 and 150 characters")
    private String name;

    @Size(max = 1000, message = "Description must not exceed 1000 characters")
    private String description;

    @NotBlank(message = "Status is required")
    @Pattern(regexp = "draft|published", message = "Status must be 'draft' or 'published'")
    private String status;

    private CanvasState canvas;

    @NotEmpty(message = "At least two nodes are required")
    @Valid
    private List<Node> nodes;

    @NotEmpty(message = "At least one edge is required")
    @Valid
    private List<Edge> edges;
}
