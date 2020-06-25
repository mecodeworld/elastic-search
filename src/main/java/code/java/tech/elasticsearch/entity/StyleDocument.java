package code.java.tech.elasticsearch.entity;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "style")
public class StyleDocument {

    @Id
    private String id;
    private String styleNo;
    private String info;
    private Date validTo;

    @Field(type = FieldType.Nested,
            includeInParent = true)
    private List<ItemDocument> items;

}
