package ch.hfu.movieapp.starter;

import com.lilittlecat.chatgpt.offical.ChatGPT;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * Configuration class for ChatGPT.
 */
@Configuration
public class ChatGptconfig {

    @Value("${application.chatgpt.key}")
    private String apiKey;

    /**
     * The OkHttpClient instance for ChatGPT, with specified timeouts.
     */
    OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build();

    /**
     * Creates a bean for ChatGPT using the configured API key and OkHttpClient.
     *
     * @return The ChatGPT instance.
     */
    @Bean
    public ChatGPT chatGPT() {
        return new ChatGPT(apiKey, client);
    }
}
