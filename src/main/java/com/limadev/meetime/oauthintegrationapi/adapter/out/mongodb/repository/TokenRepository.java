package com.limadev.meetime.oauthintegrationapi.adapter.out.mongodb.repository;

import com.limadev.meetime.oauthintegrationapi.adapter.out.mongodb.entity.TokenEntity;
import org.springframework.data.repository.CrudRepository;

public interface TokenRepository extends CrudRepository<TokenEntity, String> {
}
