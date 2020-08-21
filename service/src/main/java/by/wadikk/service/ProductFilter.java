package by.wadikk.service;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductFilter {

    private String categories;
    private String name;
    private Long price;
}
