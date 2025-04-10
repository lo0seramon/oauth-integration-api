package com.limadev.meetime.oauthintegrationapi.adapter.out.mongodb.repository;

import com.limadev.meetime.oauthintegrationapi.adapter.out.mongodb.entity.TokenEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TokenRepository extends CrudRepository<TokenEntity, String> {
    Optional<TokenEntity> findFirstByOrderByCreatedAtDesc();
}
