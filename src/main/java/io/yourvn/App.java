package io.yourvn;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@SpringBootApplication
@EnableBatchProcessing
@ComponentScan
//@ComponentScan("io.yourvn.config")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
/*
curl 'http://timbus.vn/Engine/Business/Search/action.ashx'
  -H 'Accept: application/json, text/javascript, ; q=0.01'
  -H 'Accept-Language: en-US,en;q=0.9'
  -H 'Connection: keep-alive'
  -H 'Content-Type: application/x-www-form-urlencoded; charset=UTF-8'
  -H 'Cookie: _ga=GA1.2.1640118029.1697372530; _gid=GA1.2.579000574.1697500200; ASP.NET_SessionId=xk0kdyhm2ctjvlhw3z4huves; _ga_5XYX6Q8W6V=GS1.2.1697543698.4.1.1697543729.0.0.0'
  -H 'Origin: http://timbus.vn'
        -H 'Referer: http://timbus.vn/'
        -H 'User-Agent: Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36'
        -H 'X-Requested-With: XMLHttpRequest'
        --data-raw 'act=searchfull&typ=1&key='
        --compressed
        --insecure
 */
