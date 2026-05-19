package com.adaptivelearning.dto;

import com.adaptivelearning.model.Component;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AvailableComponentsResponse {
    private List<Component> items;
    private Integer totalCount;
}
