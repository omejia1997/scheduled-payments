package com.banquito.schedulepayment.collection.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class CollectionOrderDTO {

    private String collectionId;

    private String referenceId;

    private CollectionCustomerDTO customer;

    private BigDecimal amount;

    private String reference;

    private String state;

    private Date collectedDate;

    private Date startCollectionDate;

    private Date endCollectionDate;

    private String journalId;

}
