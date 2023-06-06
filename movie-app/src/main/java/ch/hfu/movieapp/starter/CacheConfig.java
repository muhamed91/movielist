package ch.hfu.movieapp.starter;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Configuration class for cache management.
 */
@Configuration
@EnableCaching
public class CacheConfig {

    /**
     * Creates a cache manager bean for caching movie details.
     *
     * @return The cache manager.
     */
    @Bean
    public CacheManager cacheManager() {
        ConcurrentMapCacheManager mgr = new ConcurrentMapCacheManager();
        mgr.setCacheNames(List.of("movieDetail"));
        return mgr;
    }
}
