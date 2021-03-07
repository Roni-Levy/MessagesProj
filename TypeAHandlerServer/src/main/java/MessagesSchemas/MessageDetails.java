/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package MessagesSchemas;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class MessageDetails extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"MessageDetails\",\"namespace\":\"MessagesSchemas\",\"fields\":[{\"name\":\"sendingTime\",\"type\":[\"long\"],\"logicalType\":\"time-millis\"},{\"name\":\"messageContent\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"],\"default\":\"null\"},{\"name\":\"parsed\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"],\"default\":\"null\"},{\"name\":\"serviceId\",\"type\":[{\"type\":\"string\",\"avro.java.string\":\"String\"},\"null\"],\"default\":\"null\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public Object sendingTime;
  @Deprecated public String messageContent;
  @Deprecated public String parsed;
  @Deprecated public String serviceId;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public MessageDetails() {}

  /**
   * All-args constructor.
   */
  public MessageDetails(Object sendingTime, String messageContent, String parsed, String serviceId) {
    this.sendingTime = sendingTime;
    this.messageContent = messageContent;
    this.parsed = parsed;
    this.serviceId = serviceId;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public Object get(int field$) {
    switch (field$) {
    case 0: return sendingTime;
    case 1: return messageContent;
    case 2: return parsed;
    case 3: return serviceId;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, Object value$) {
    switch (field$) {
    case 0: sendingTime = (Object)value$; break;
    case 1: messageContent = (String)value$; break;
    case 2: parsed = (String)value$; break;
    case 3: serviceId = (String)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'sendingTime' field.
   */
  public Object getSendingTime() {
    return sendingTime;
  }

  /**
   * Sets the value of the 'sendingTime' field.
   * @param value the value to set.
   */
  public void setSendingTime(Object value) {
    this.sendingTime = value;
  }

  /**
   * Gets the value of the 'messageContent' field.
   */
  public String getMessageContent() {
    return messageContent;
  }

  /**
   * Sets the value of the 'messageContent' field.
   * @param value the value to set.
   */
  public void setMessageContent(String value) {
    this.messageContent = value;
  }

  /**
   * Gets the value of the 'parsed' field.
   */
  public String getParsed() {
    return parsed;
  }

  /**
   * Sets the value of the 'parsed' field.
   * @param value the value to set.
   */
  public void setParsed(String value) {
    this.parsed = value;
  }

  /**
   * Gets the value of the 'serviceId' field.
   */
  public String getServiceId() {
    return serviceId;
  }

  /**
   * Sets the value of the 'serviceId' field.
   * @param value the value to set.
   */
  public void setServiceId(String value) {
    this.serviceId = value;
  }

  /** Creates a new MessageDetails RecordBuilder */
  public static Builder newBuilder() {
    return new Builder();
  }
  
  /** Creates a new MessageDetails RecordBuilder by copying an existing Builder */
  public static Builder newBuilder(Builder other) {
    return new Builder(other);
  }
  
  /** Creates a new MessageDetails RecordBuilder by copying an existing MessageDetails instance */
  public static Builder newBuilder(MessageDetails other) {
    return new Builder(other);
  }
  
  /**
   * RecordBuilder for MessageDetails instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<MessageDetails>
    implements org.apache.avro.data.RecordBuilder<MessageDetails> {

    private Object sendingTime;
    private String messageContent;
    private String parsed;
    private String serviceId;

    /** Creates a new Builder */
    private Builder() {
      super(MessageDetails.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.sendingTime)) {
        this.sendingTime = data().deepCopy(fields()[0].schema(), other.sendingTime);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.messageContent)) {
        this.messageContent = data().deepCopy(fields()[1].schema(), other.messageContent);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.parsed)) {
        this.parsed = data().deepCopy(fields()[2].schema(), other.parsed);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.serviceId)) {
        this.serviceId = data().deepCopy(fields()[3].schema(), other.serviceId);
        fieldSetFlags()[3] = true;
      }
    }
    
    /** Creates a Builder by copying an existing MessageDetails instance */
    private Builder(MessageDetails other) {
            super(MessageDetails.SCHEMA$);
      if (isValidValue(fields()[0], other.sendingTime)) {
        this.sendingTime = data().deepCopy(fields()[0].schema(), other.sendingTime);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.messageContent)) {
        this.messageContent = data().deepCopy(fields()[1].schema(), other.messageContent);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.parsed)) {
        this.parsed = data().deepCopy(fields()[2].schema(), other.parsed);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.serviceId)) {
        this.serviceId = data().deepCopy(fields()[3].schema(), other.serviceId);
        fieldSetFlags()[3] = true;
      }
    }

    /** Gets the value of the 'sendingTime' field */
    public Object getSendingTime() {
      return sendingTime;
    }
    
    /** Sets the value of the 'sendingTime' field */
    public Builder setSendingTime(Object value) {
      validate(fields()[0], value);
      this.sendingTime = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'sendingTime' field has been set */
    public boolean hasSendingTime() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'sendingTime' field */
    public Builder clearSendingTime() {
      sendingTime = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'messageContent' field */
    public String getMessageContent() {
      return messageContent;
    }
    
    /** Sets the value of the 'messageContent' field */
    public Builder setMessageContent(String value) {
      validate(fields()[1], value);
      this.messageContent = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'messageContent' field has been set */
    public boolean hasMessageContent() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'messageContent' field */
    public Builder clearMessageContent() {
      messageContent = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'parsed' field */
    public String getParsed() {
      return parsed;
    }
    
    /** Sets the value of the 'parsed' field */
    public Builder setParsed(String value) {
      validate(fields()[2], value);
      this.parsed = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'parsed' field has been set */
    public boolean hasParsed() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'parsed' field */
    public Builder clearParsed() {
      parsed = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'serviceId' field */
    public String getServiceId() {
      return serviceId;
    }
    
    /** Sets the value of the 'serviceId' field */
    public Builder setServiceId(String value) {
      validate(fields()[3], value);
      this.serviceId = value;
      fieldSetFlags()[3] = true;
      return this; 
    }
    
    /** Checks whether the 'serviceId' field has been set */
    public boolean hasServiceId() {
      return fieldSetFlags()[3];
    }
    
    /** Clears the value of the 'serviceId' field */
    public Builder clearServiceId() {
      serviceId = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    public MessageDetails build() {
      try {
        MessageDetails record = new MessageDetails();
        record.sendingTime = fieldSetFlags()[0] ? this.sendingTime : (Object) defaultValue(fields()[0]);
        record.messageContent = fieldSetFlags()[1] ? this.messageContent : (String) defaultValue(fields()[1]);
        record.parsed = fieldSetFlags()[2] ? this.parsed : (String) defaultValue(fields()[2]);
        record.serviceId = fieldSetFlags()[3] ? this.serviceId : (String) defaultValue(fields()[3]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}