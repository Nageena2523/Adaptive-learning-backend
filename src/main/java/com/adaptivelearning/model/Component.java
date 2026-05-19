package com.adaptivelearning.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Component {
    private String id;
    private String title;
    private String shortDescription;
    private String type; // "unit" | "assessment"
    private Integer approximateDurationMinutes;
    private ComponentMetadata metadata;
}
