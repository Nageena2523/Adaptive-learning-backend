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
public class Rule {
    private String id;
    private String sourceType; // "assessment" | "unit"
    private String sourceNodeId;
    private String metric; // "completion" | "passed" | "score" | "score_range" | "time_spent_minutes" | "percentage_completion"
    private String operator; // "eq" | "ne" | "gt" | "gte" | "lt" | "lte" | "between"
    private Object value; // boolean | number | string
    private Range range;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Range {
        private Double min;
        private Double max;
        private Boolean minInclusive;
        private Boolean maxInclusive;
    }
}
