package RestClient.Example.restClient.custom;

import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class RestClientExample03 {
    public static void main(String[] args) {
        // 객체 생성
        RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());

        // URI 생성
        UriComponents uriComponents = UriComponentsBuilder
                .newInstance()
                .scheme("http")
                .host("worldtimeapi.org")
                .path("/api/timezone/{continents}/{city}")
                .encode()
                .build();
        URI uri = uriComponents.expand("Asia", "Seoul").toUri();

        // Request 전송 / ResponseEntity로 헤더와 바디 정보를 모두 전달 받을 수 있음
        ResponseEntity<WorldTime> response = restTemplate.getForEntity(uri, WorldTime.class);
        System.out.println("# datatime: " + response.getBody().getDatetime());
        System.out.println("# timezone: " + response.getBody().getTimezone());
        System.out.println("# day_of_week: " + response.getBody().getDay_of_year());
        System.out.println("# HTTP Status Code: " + response.getStatusCode());
        System.out.println("# HTTP Status Value: " + response.getStatusCodeValue());
        System.out.println("# Content Type: " + response.getHeaders().getContentType());
        System.out.println(response.getHeaders().entrySet());
    }
}