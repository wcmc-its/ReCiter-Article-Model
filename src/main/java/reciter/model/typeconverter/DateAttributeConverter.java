package reciter.model.typeconverter;

import java.time.Instant;

import software.amazon.awssdk.enhanced.dynamodb.AttributeConverter;
import software.amazon.awssdk.enhanced.dynamodb.AttributeValueType;
import software.amazon.awssdk.enhanced.dynamodb.EnhancedType;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public class DateAttributeConverter implements AttributeConverter<Instant> {

    @Override
    public AttributeValue transformFrom(Instant input) {
        return input != null ? AttributeValue.builder().s(input.toString()).build() : AttributeValue.builder().nul(true).build();
    }

    @Override
    public Instant transformTo(AttributeValue input) {
        return input.s() != null ? Instant.parse(input.s()) : null;
    }

    @Override
    public EnhancedType<Instant> type() {
        return EnhancedType.of(Instant.class);
    }

    @Override
    public AttributeValueType attributeValueType() {
        return AttributeValueType.S; // Store as String
    }
}