package com.tekcapsule.insight.domain.model;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tekcapsule.core.domain.AggregateRoot;
import com.tekcapsule.core.domain.BaseDomainEntity;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(callSuper = true)
@DynamoDBTable(tableName = "Insight")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IndexRecord extends BaseDomainEntity implements AggregateRoot {
    @DynamoDBHashKey(attributeName="insightId")
    @DynamoDBAutoGeneratedKey
    private String insightId;
    @DynamoDBAttribute(attributeName = "stockIndex")
    @DynamoDBTypeConvertedEnum
    private StockIndex stockIndex;
    @DynamoDBAttribute(attributeName = "topic")
    @DynamoDBTypeConvertedEnum
    private Topic topic;
    @DynamoDBAttribute(attributeName = "publishedOn")
    private String publishedOn;
    @DynamoDBAttribute(attributeName = "valueOnClosing")
    private BigDecimal valueOnClosing;
    @DynamoDBAttribute(attributeName = "stocks")
    private List<Stock> stocks;
    @DynamoDBAttribute(attributeName = "comment")
    private String comment;
}
