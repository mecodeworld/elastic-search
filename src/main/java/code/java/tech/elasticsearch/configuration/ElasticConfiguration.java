package code.java.tech.elasticsearch.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "code.java.tech.elasticsearch.repository")
@ComponentScan(basePackages = { "code.java.tech.elasticsearch" })
public class ElasticConfiguration {

}
