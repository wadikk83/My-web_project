package by.wadikk.service.filter;


import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProductFilter {

    private List<String> category;
}
