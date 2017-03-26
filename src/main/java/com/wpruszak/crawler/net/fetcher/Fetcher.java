package com.wpruszak.crawler.net.fetcher;

import com.wpruszak.crawler.net.http.ResponseInterface;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * {@author Wojciech Pruszak} <info@wpruszak.com> on 26.03.17.
 */
@Service
public class Fetcher {

    private long lastFetchTime = 0;

    public ResponseInterface fetchPage(String url) throws IOException {

        Connection.Response response = Jsoup.connect(url)
            .header("Accept-Encoding", "gzip, deflate, sdch, br")
            .maxBodySize(0)
            .timeout(10000)
            .userAgent("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36")
            .execute();

        Document dom = response.parse();
        return null;
    }
}
