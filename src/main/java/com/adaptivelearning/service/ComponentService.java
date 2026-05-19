package com.adaptivelearning.service;

import com.adaptivelearning.dto.AvailableComponentsResponse;
import com.adaptivelearning.model.Component;
import com.adaptivelearning.model.ComponentMetadata;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComponentService {

    public AvailableComponentsResponse getAvailableComponents() {
        List<Component> components = buildSampleComponents();
        return AvailableComponentsResponse.builder()
            .items(components)
            .totalCount(components.size())
            .build();
    }

    private List<Component> buildSampleComponents() {
        return List.of(
            Component.builder()
                .id("cmp-assess-math-1")
                .title("Math Module 1 Assessment")
                .shortDescription("Baseline math diagnostic used to route learners.")
                .type("assessment")
                .approximateDurationMinutes(35)
                .metadata(ComponentMetadata.builder()
                    .assessment(ComponentMetadata.AssessmentMeta.builder()
                        .maxScore(100)
                        .passingScore(50)
                        .build())
                    .build())
                .build(),

            Component.builder()
                .id("cmp-unit-math-2-easy")
                .title("Math Module 2 - Easy")
                .shortDescription("Foundational math remediation unit.")
                .type("unit")
                .approximateDurationMinutes(35)
                .metadata(ComponentMetadata.builder()
                    .unit(ComponentMetadata.UnitMeta.builder()
                        .recommendedMinutes(30)
                        .build())
                    .build())
                .build(),

            Component.builder()
                .id("cmp-unit-math-2-advanced")
                .title("Math Module 2 - Advanced")
                .shortDescription("Advanced math enrichment unit for high scorers.")
                .type("unit")
                .approximateDurationMinutes(40)
                .metadata(ComponentMetadata.builder()
                    .unit(ComponentMetadata.UnitMeta.builder()
                        .recommendedMinutes(35)
                        .build())
                    .build())
                .build(),

            Component.builder()
                .id("cmp-assess-reading-1")
                .title("Reading & Comp Module 1 Assessment")
                .shortDescription("Baseline reading and comprehension diagnostic.")
                .type("assessment")
                .approximateDurationMinutes(32)
                .metadata(ComponentMetadata.builder()
                    .assessment(ComponentMetadata.AssessmentMeta.builder()
                        .maxScore(100)
                        .passingScore(50)
                        .build())
                    .build())
                .build(),

            Component.builder()
                .id("cmp-unit-rc-2-easy")
                .title("R&C Module 2 - Easy")
                .shortDescription("Foundational reading comprehension support unit.")
                .type("unit")
                .approximateDurationMinutes(32)
                .metadata(ComponentMetadata.builder()
                    .unit(ComponentMetadata.UnitMeta.builder()
                        .recommendedMinutes(30)
                        .build())
                    .build())
                .build(),

            Component.builder()
                .id("cmp-unit-rc-2-advanced")
                .title("R&C Module 2 - Advanced")
                .shortDescription("Advanced reading comprehension enrichment unit.")
                .type("unit")
                .approximateDurationMinutes(32)
                .metadata(ComponentMetadata.builder()
                    .unit(ComponentMetadata.UnitMeta.builder()
                        .recommendedMinutes(30)
                        .build())
                    .build())
                .build()
        );
    }
}
