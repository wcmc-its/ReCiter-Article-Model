package reciter.model.typeconverter;

import java.time.Instant;

import software.amazon.awssdk.enhanced.dynamodb.AttributeConverter;
import software.amazon.awssdk.enhanced.dynamodb.AttributeValueType;
import software.amazon.awssdk.enhanced.dynamodb.EnhancedType;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

/**
 * A custom attribute converter for mapping {@link Instant} timestamps
 * to and from DynamoDB string attributes.
 *
 * <p>This converter stores the {@code Instant} as an ISO-8601 formatted {@code String}
 * (e.g., {@code 2023-07-25T10:15:30Z}) in DynamoDB. When reading from the database,
 * it parses the string back into an {@code Instant}.</p>
 *
 * <p>Used for fields annotated with {@code @DynamoDbConvertedBy(DateAttributeConverter.class)}</p>
 *
 * Example DynamoDB entry:
 * <pre>
 * {
 *   "retrievalDate": { "S": "2023-07-25T10:15:30Z" }
 * }
 * </pre>
 *
 * @author ved4006
 */
public class DateAttributeConverter implements AttributeConverter<Instant> {

    /**
     * Transform from.
     *
     * @param input the input
     * @return the attribute value
     */
    @Override
    public AttributeValue transformFrom(Instant input) {
        return input != null ? AttributeValue.builder().s(input.toString()).build() : AttributeValue.builder().nul(true).build();
    }

    /**
     * Transform to.
     *
     * @param input the input
     * @return the instant
     */
    @Override
    public Instant transformTo(AttributeValue input) {
        return input.s() != null ? Instant.parse(input.s()) : null;
    }

    /**
     * Type.
     *
     * @return the enhanced type
     */
    @Override
    public EnhancedType<Instant> type() {
        return EnhancedType.of(Instant.class);
    }

    /**
     * Attribute value type.
     *
     * @return the attribute value type
     */
    @Override
    public AttributeValueType attributeValueType() {
        return AttributeValueType.S; 
    }
}