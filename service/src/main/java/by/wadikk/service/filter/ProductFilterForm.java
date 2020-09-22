package by.wadikk.service.filter;

import lombok.Data;

import java.util.List;

@Data
public class ProductFilterForm {

    private List<String> category;
    private Integer pricelow;
    private Integer pricehigh;
    private String sort;
    private Integer page;
    private String search;
}
