package RestClient.Example.restClient;

import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class RestClientExample01 {
    public static void main(String[] args) {
        // 객체 생성
        RestTemplate restTemplate =
                new RestTemplate(new HttpComponentsClientHttpRequestFactory());
        // URI 생성
        UriComponents uriComponents =
                UriComponentsBuilder
                        .newInstance()
                        .scheme("http")
                        .host("worldtimeapi.org")
//                        .port(80)
                        .path("/api/timezone/{continents}/{city}")
                        .encode()
                        .build();
        URI uri = uriComponents.expand("Asia","Seoul").toUri();
        
        // Request 전송
        String result = restTemplate.getForObject(uri,String.class);
        System.out.println(result);
    }
}
