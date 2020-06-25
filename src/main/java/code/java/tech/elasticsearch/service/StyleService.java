package code.java.tech.elasticsearch.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;

import code.java.tech.elasticsearch.entity.ItemDocument;
import code.java.tech.elasticsearch.entity.StyleDocument;
import code.java.tech.elasticsearch.repository.StyleRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class StyleService {

    @Resource
    private StyleRepository styleRepository;

    @PutMapping(value = "/dump/{count}")
    public void dump(@PathVariable Long count) {

        count = count != null ? count : 5;

        for (Long i = 1L; i <= count; i++) {

            StyleDocument document = StyleDocument.builder()
                    .id(UUID.randomUUID()
                            .toString())
                    .styleNo(Long.toString(i))
                    .info("style is created with no " + i)
                    .validTo(new Date())
                    .items(Lists.newArrayList(ItemDocument.builder()
                            .id(UUID.randomUUID()
                                    .toString())
                            .itemNo("Item" + i)
                            .linkLevel("ITEM")
                            .build()))
                    .build();
            styleRepository.save(document);
        }
    }

    @PutMapping(value = "/create/{styleNo}")
    public void create(@PathVariable String styleNo) {

        StyleDocument document = StyleDocument.builder()
                .id(UUID.randomUUID()
                        .toString())
                .styleNo(styleNo)
                .info("style is created with no " + styleNo)
                .validTo(new Date())
                .items(Lists.newArrayList(ItemDocument.builder()
                        .id(UUID.randomUUID()
                                .toString())
                        .itemNo("Item " + styleNo)
                        .linkLevel("ITEM")
                        .build()))
                .build();
        StyleDocument save = styleRepository.save(document);

        log.info("Saved style no is " + save.getStyleNo());

    }

    @PostMapping(value = "/search/{styleNo}")
    public List<StyleDocument> findAll(@PathVariable String styleNo) {

        List<StyleDocument> list = styleRepository.findByStyleNo(styleNo);

        log.info("Found styles are " + list.size());
        return list;
    }

    @PostMapping(value = "/findAll")
    public List<StyleDocument> findAll() {

        Iterable<StyleDocument> iterable = styleRepository.findAll();

        List<StyleDocument> result = new ArrayList<>();
        iterable.forEach(result::add);

        log.info("Found styles are " + result.size());
        return result;
    }

    @DeleteMapping(value = "/del")
    public void deleteAll() {
        Iterable<StyleDocument> result = styleRepository.findAll();
        result.forEach(f -> {
            log.info("deleting style id" + f.getId());
            styleRepository.delete(f);
        });
    }

}
