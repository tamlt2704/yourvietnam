package io.yourvn.batch.util;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BusUtil {
    public static HttpResponse<String> searchFullHNBus() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://timbus.vn/Engine/Business/Search/action.ashx"))
                .header("X-Requested-With", "XMLHttpRequest")
                .header("Referer", "http://timbus.vn/")
//                .header("Accept", "application/json, text/javascript, ; q=0.01")
                .header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                .POST(HttpRequest.BodyPublishers.ofString("act=searchfull&typ=1&key="))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
