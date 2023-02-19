package RestClient.Example.restClient.custom;

import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class RestClientExample02 {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());

        UriComponents uriComponents =
                UriComponentsBuilder
                        .newInstance()
                        .scheme("http")
                        .host("worldtimeapi.org")
                        .path("/api/timezone/{continents}/{city}")
                        .encode()
                        .build();
        URI uri = uriComponents.expand("Asia","Seoul").toUri();

        WorldTime worldTime = restTemplate.getForObject(uri, WorldTime.class);

        System.out.println("Date Time : "+worldTime.getDatetime());
        System.out.println("Time Zone : "+worldTime.getTimezone());
        System.out.println("Day Of Year : "+worldTime.getDay_of_year());
    }
}
