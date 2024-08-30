/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.example.avro;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class ElectronicOrder extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 699742589352477637L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"ElectronicOrder\",\"namespace\":\"com.example.avro\",\"fields\":[{\"name\":\"order_id\",\"type\":\"string\"},{\"name\":\"electronic_id\",\"type\":\"string\"},{\"name\":\"user_id\",\"type\":\"string\"},{\"name\":\"price\",\"type\":\"double\",\"default\":0.0},{\"name\":\"time\",\"type\":\"long\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<ElectronicOrder> ENCODER =
      new BinaryMessageEncoder<ElectronicOrder>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<ElectronicOrder> DECODER =
      new BinaryMessageDecoder<ElectronicOrder>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<ElectronicOrder> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<ElectronicOrder> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<ElectronicOrder> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<ElectronicOrder>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this ElectronicOrder to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a ElectronicOrder from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a ElectronicOrder instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static ElectronicOrder fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

   private java.lang.CharSequence order_id;
   private java.lang.CharSequence electronic_id;
   private java.lang.CharSequence user_id;
   private double price;
   private long time;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public ElectronicOrder() {}

  /**
   * All-args constructor.
   * @param order_id The new value for order_id
   * @param electronic_id The new value for electronic_id
   * @param user_id The new value for user_id
   * @param price The new value for price
   * @param time The new value for time
   */
  public ElectronicOrder(java.lang.CharSequence order_id, java.lang.CharSequence electronic_id, java.lang.CharSequence user_id, java.lang.Double price, java.lang.Long time) {
    this.order_id = order_id;
    this.electronic_id = electronic_id;
    this.user_id = user_id;
    this.price = price;
    this.time = time;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return order_id;
    case 1: return electronic_id;
    case 2: return user_id;
    case 3: return price;
    case 4: return time;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: order_id = (java.lang.CharSequence)value$; break;
    case 1: electronic_id = (java.lang.CharSequence)value$; break;
    case 2: user_id = (java.lang.CharSequence)value$; break;
    case 3: price = (java.lang.Double)value$; break;
    case 4: time = (java.lang.Long)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'order_id' field.
   * @return The value of the 'order_id' field.
   */
  public java.lang.CharSequence getOrderId() {
    return order_id;
  }


  /**
   * Sets the value of the 'order_id' field.
   * @param value the value to set.
   */
  public void setOrderId(java.lang.CharSequence value) {
    this.order_id = value;
  }

  /**
   * Gets the value of the 'electronic_id' field.
   * @return The value of the 'electronic_id' field.
   */
  public java.lang.CharSequence getElectronicId() {
    return electronic_id;
  }


  /**
   * Sets the value of the 'electronic_id' field.
   * @param value the value to set.
   */
  public void setElectronicId(java.lang.CharSequence value) {
    this.electronic_id = value;
  }

  /**
   * Gets the value of the 'user_id' field.
   * @return The value of the 'user_id' field.
   */
  public java.lang.CharSequence getUserId() {
    return user_id;
  }


  /**
   * Sets the value of the 'user_id' field.
   * @param value the value to set.
   */
  public void setUserId(java.lang.CharSequence value) {
    this.user_id = value;
  }

  /**
   * Gets the value of the 'price' field.
   * @return The value of the 'price' field.
   */
  public double getPrice() {
    return price;
  }


  /**
   * Sets the value of the 'price' field.
   * @param value the value to set.
   */
  public void setPrice(double value) {
    this.price = value;
  }

  /**
   * Gets the value of the 'time' field.
   * @return The value of the 'time' field.
   */
  public long getTime() {
    return time;
  }


  /**
   * Sets the value of the 'time' field.
   * @param value the value to set.
   */
  public void setTime(long value) {
    this.time = value;
  }

  /**
   * Creates a new ElectronicOrder RecordBuilder.
   * @return A new ElectronicOrder RecordBuilder
   */
  public static com.example.avro.ElectronicOrder.Builder newBuilder() {
    return new com.example.avro.ElectronicOrder.Builder();
  }

  /**
   * Creates a new ElectronicOrder RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new ElectronicOrder RecordBuilder
   */
  public static com.example.avro.ElectronicOrder.Builder newBuilder(com.example.avro.ElectronicOrder.Builder other) {
    if (other == null) {
      return new com.example.avro.ElectronicOrder.Builder();
    } else {
      return new com.example.avro.ElectronicOrder.Builder(other);
    }
  }

  /**
   * Creates a new ElectronicOrder RecordBuilder by copying an existing ElectronicOrder instance.
   * @param other The existing instance to copy.
   * @return A new ElectronicOrder RecordBuilder
   */
  public static com.example.avro.ElectronicOrder.Builder newBuilder(com.example.avro.ElectronicOrder other) {
    if (other == null) {
      return new com.example.avro.ElectronicOrder.Builder();
    } else {
      return new com.example.avro.ElectronicOrder.Builder(other);
    }
  }

  /**
   * RecordBuilder for ElectronicOrder instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<ElectronicOrder>
    implements org.apache.avro.data.RecordBuilder<ElectronicOrder> {

    private java.lang.CharSequence order_id;
    private java.lang.CharSequence electronic_id;
    private java.lang.CharSequence user_id;
    private double price;
    private long time;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.example.avro.ElectronicOrder.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.order_id)) {
        this.order_id = data().deepCopy(fields()[0].schema(), other.order_id);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.electronic_id)) {
        this.electronic_id = data().deepCopy(fields()[1].schema(), other.electronic_id);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.user_id)) {
        this.user_id = data().deepCopy(fields()[2].schema(), other.user_id);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.price)) {
        this.price = data().deepCopy(fields()[3].schema(), other.price);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.time)) {
        this.time = data().deepCopy(fields()[4].schema(), other.time);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
    }

    /**
     * Creates a Builder by copying an existing ElectronicOrder instance
     * @param other The existing instance to copy.
     */
    private Builder(com.example.avro.ElectronicOrder other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.order_id)) {
        this.order_id = data().deepCopy(fields()[0].schema(), other.order_id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.electronic_id)) {
        this.electronic_id = data().deepCopy(fields()[1].schema(), other.electronic_id);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.user_id)) {
        this.user_id = data().deepCopy(fields()[2].schema(), other.user_id);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.price)) {
        this.price = data().deepCopy(fields()[3].schema(), other.price);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.time)) {
        this.time = data().deepCopy(fields()[4].schema(), other.time);
        fieldSetFlags()[4] = true;
      }
    }

    /**
      * Gets the value of the 'order_id' field.
      * @return The value.
      */
    public java.lang.CharSequence getOrderId() {
      return order_id;
    }


    /**
      * Sets the value of the 'order_id' field.
      * @param value The value of 'order_id'.
      * @return This builder.
      */
    public com.example.avro.ElectronicOrder.Builder setOrderId(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.order_id = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'order_id' field has been set.
      * @return True if the 'order_id' field has been set, false otherwise.
      */
    public boolean hasOrderId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'order_id' field.
      * @return This builder.
      */
    public com.example.avro.ElectronicOrder.Builder clearOrderId() {
      order_id = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'electronic_id' field.
      * @return The value.
      */
    public java.lang.CharSequence getElectronicId() {
      return electronic_id;
    }


    /**
      * Sets the value of the 'electronic_id' field.
      * @param value The value of 'electronic_id'.
      * @return This builder.
      */
    public com.example.avro.ElectronicOrder.Builder setElectronicId(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.electronic_id = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'electronic_id' field has been set.
      * @return True if the 'electronic_id' field has been set, false otherwise.
      */
    public boolean hasElectronicId() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'electronic_id' field.
      * @return This builder.
      */
    public com.example.avro.ElectronicOrder.Builder clearElectronicId() {
      electronic_id = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'user_id' field.
      * @return The value.
      */
    public java.lang.CharSequence getUserId() {
      return user_id;
    }


    /**
      * Sets the value of the 'user_id' field.
      * @param value The value of 'user_id'.
      * @return This builder.
      */
    public com.example.avro.ElectronicOrder.Builder setUserId(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.user_id = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'user_id' field has been set.
      * @return True if the 'user_id' field has been set, false otherwise.
      */
    public boolean hasUserId() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'user_id' field.
      * @return This builder.
      */
    public com.example.avro.ElectronicOrder.Builder clearUserId() {
      user_id = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'price' field.
      * @return The value.
      */
    public double getPrice() {
      return price;
    }


    /**
      * Sets the value of the 'price' field.
      * @param value The value of 'price'.
      * @return This builder.
      */
    public com.example.avro.ElectronicOrder.Builder setPrice(double value) {
      validate(fields()[3], value);
      this.price = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'price' field has been set.
      * @return True if the 'price' field has been set, false otherwise.
      */
    public boolean hasPrice() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'price' field.
      * @return This builder.
      */
    public com.example.avro.ElectronicOrder.Builder clearPrice() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'time' field.
      * @return The value.
      */
    public long getTime() {
      return time;
    }


    /**
      * Sets the value of the 'time' field.
      * @param value The value of 'time'.
      * @return This builder.
      */
    public com.example.avro.ElectronicOrder.Builder setTime(long value) {
      validate(fields()[4], value);
      this.time = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'time' field has been set.
      * @return True if the 'time' field has been set, false otherwise.
      */
    public boolean hasTime() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'time' field.
      * @return This builder.
      */
    public com.example.avro.ElectronicOrder.Builder clearTime() {
      fieldSetFlags()[4] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public ElectronicOrder build() {
      try {
        ElectronicOrder record = new ElectronicOrder();
        record.order_id = fieldSetFlags()[0] ? this.order_id : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.electronic_id = fieldSetFlags()[1] ? this.electronic_id : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.user_id = fieldSetFlags()[2] ? this.user_id : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.price = fieldSetFlags()[3] ? this.price : (java.lang.Double) defaultValue(fields()[3]);
        record.time = fieldSetFlags()[4] ? this.time : (java.lang.Long) defaultValue(fields()[4]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<ElectronicOrder>
    WRITER$ = (org.apache.avro.io.DatumWriter<ElectronicOrder>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<ElectronicOrder>
    READER$ = (org.apache.avro.io.DatumReader<ElectronicOrder>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.order_id);

    out.writeString(this.electronic_id);

    out.writeString(this.user_id);

    out.writeDouble(this.price);

    out.writeLong(this.time);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.order_id = in.readString(this.order_id instanceof Utf8 ? (Utf8)this.order_id : null);

      this.electronic_id = in.readString(this.electronic_id instanceof Utf8 ? (Utf8)this.electronic_id : null);

      this.user_id = in.readString(this.user_id instanceof Utf8 ? (Utf8)this.user_id : null);

      this.price = in.readDouble();

      this.time = in.readLong();

    } else {
      for (int i = 0; i < 5; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.order_id = in.readString(this.order_id instanceof Utf8 ? (Utf8)this.order_id : null);
          break;

        case 1:
          this.electronic_id = in.readString(this.electronic_id instanceof Utf8 ? (Utf8)this.electronic_id : null);
          break;

        case 2:
          this.user_id = in.readString(this.user_id instanceof Utf8 ? (Utf8)this.user_id : null);
          break;

        case 3:
          this.price = in.readDouble();
          break;

        case 4:
          this.time = in.readLong();
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}









