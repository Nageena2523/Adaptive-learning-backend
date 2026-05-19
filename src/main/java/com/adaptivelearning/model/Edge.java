package com.adaptivelearning.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Edge {
    private String id;
    private String sourceNodeId;
    private String targetNodeId;
    private String label;
    private Integer priority;
    private Boolean isDefault;
    private Conditions conditions;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Conditions {
        private String operator; // "AND" | "OR"
        private List<Rule> rules;
    }
}
