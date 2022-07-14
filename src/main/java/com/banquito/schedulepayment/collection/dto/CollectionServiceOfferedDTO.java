package com.banquito.schedulepayment.collection.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CollectionServiceOfferedDTO {
    private String name;

    private String description;
}
