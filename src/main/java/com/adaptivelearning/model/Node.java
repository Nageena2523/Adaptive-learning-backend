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
public class Node {
    private String id;
    private String componentId;
    private String type; // "start" | "unit" | "assessment" | "end"
    private String label;
    private String description;
    private Position position;
    private NodeConfig config;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Position {
        private Double x;
        private Double y;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class NodeConfig {
        private Integer approximateDurationMinutes;
        private AssessmentConfig assessment;

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class AssessmentConfig {
            private Integer maxScore;
            private Integer passingScore;
        }
    }
}
