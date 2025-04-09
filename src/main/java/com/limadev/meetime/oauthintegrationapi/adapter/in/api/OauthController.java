package com.limadev.meetime.oauthintegrationapi.adapter.in.api;

import com.limadev.meetime.oauthintegrationapi.application.business.port.in.GetAuthorizationUrlUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/oauth")
@RequiredArgsConstructor
public class OauthController {

    private GetAuthorizationUrlUseCase getAuthorizationUrlUseCase;

    @GetMapping("v1/authorize")
    public ResponseEntity<String> getAuthorizationUrl() {
        String authorizationUrl = getAuthorizationUrlUseCase.getAuthorizationUrl();
        return new ResponseEntity<>(authorizationUrl, HttpStatus.OK);
    }
}
