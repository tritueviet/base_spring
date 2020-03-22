package com.ecommerce.ibg.api.api;

import com.ecommerce.ibg.model.user.UserDemo;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
public class RestApi {
    protected RestTemplate restTemplate;

    @Autowired
    public RestApi() {
        CloseableHttpClient httpClient
                = HttpClients.custom()
                .setSSLHostnameVerifier(new NoopHostnameVerifier())
                .build();
        HttpComponentsClientHttpRequestFactory requestFactory
                = new HttpComponentsClientHttpRequestFactory();


        requestFactory.setHttpClient(httpClient);
        requestFactory.setReadTimeout(15000);
        requestFactory.setConnectTimeout(15000);
        this.restTemplate = new RestTemplate(requestFactory);
    }

    public UserDemo callApiDemo(Object jsonObject) {
        try {
            return restTemplate.postForEntity("http://xxx", jsonObject, UserDemo.class).getBody();
        } catch (RestClientException e) {
        }
        return null;
    }
}
