package code.java.tech.elasticsearch.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

import code.java.tech.elasticsearch.entity.StyleDocument;

@Component
public interface StyleRepository extends ElasticsearchRepository<StyleDocument, String> {

    List<StyleDocument> findByStyleNo(String styleNo);

}
