package com.banquito.core.schedulepayment.payments.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class ServiceOfferedDTO {
  private String internalId;

  private String groupInternalId;

  private String referenceId;

  private String creditorAccount;

  private String creditorIdentification;

  private String creditorEmail;

  private String debtorAccount;

  private String serviceName;

  private String description;

  private BigDecimal maxAmount;

  private String aprobationState;

  private String recurrentState;

  private String frecuency;

  private Date firstScheduleDate;

  private Date finalScheduleDate;

  private Date lastPaymentDate;
}
