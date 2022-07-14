package com.banquito.schedulepayment.collection.dto;

import java.util.Date;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CollectionDTO {

  private String internalId;

  private String groupInternalId;

  private Date creationDate;

  private CollectionServiceOfferedDTO serviceOffered;

  private String state;

  private String periodicity;

  private Date startCollectionDate;

  private Date endCollectionDate;
}
