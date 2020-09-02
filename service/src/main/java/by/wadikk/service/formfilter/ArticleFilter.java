package by.wadikk.service.formfilter;


import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ArticleFilter {

    private List<String> category;
    private List<String> brand;
}
