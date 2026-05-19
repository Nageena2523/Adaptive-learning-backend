package com.adaptivelearning.controller;

import com.adaptivelearning.dto.AvailableComponentsResponse;
import com.adaptivelearning.service.ComponentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/components")
@RequiredArgsConstructor
public class ComponentController {

    private final ComponentService componentService;

    @GetMapping
    public ResponseEntity<AvailableComponentsResponse> getComponents() {
        return ResponseEntity.ok(componentService.getAvailableComponents());
    }
}
