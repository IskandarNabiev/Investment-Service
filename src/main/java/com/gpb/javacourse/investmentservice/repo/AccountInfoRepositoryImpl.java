package com.gpb.javacourse.investmentservice.repo;

import com.gpb.javacourse.investmentservice.dto.AccountInfo;
import org.springframework.http.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class AccountInfoRepositoryImpl implements AccountInfoRepository{

    private final RestTemplate restTemplate;

    public AccountInfoRepositoryImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    //Нужно уточнить какой json возвращается из другого сервиса, чтобы заполнить AccountInfo
    @Override
    public AccountInfo findById(Long clientId) {
        HttpHeaders headers = new HttpHeaders();
        OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();
        headers.add("Authorization", "Bearer " + "тут должен быть токен");
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<AccountInfo> entity = restTemplate.exchange("http://service-schetov/{id}", HttpMethod.GET, httpEntity, AccountInfo.class, clientId);
        return entity.getBody();
    }
}
