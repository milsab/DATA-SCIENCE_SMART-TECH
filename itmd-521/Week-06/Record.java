// ORM class for table 'records'
// WARNING: This class is AUTO-GENERATED. Modify at your own risk.
//
// Debug information:
// Generated date: Tue Feb 27 16:18:55 CST 2018
// For connector: org.apache.sqoop.manager.MySQLManager
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.lib.db.DBWritable;
import com.cloudera.sqoop.lib.JdbcWritableBridge;
import com.cloudera.sqoop.lib.DelimiterSet;
import com.cloudera.sqoop.lib.FieldFormatter;
import com.cloudera.sqoop.lib.RecordParser;
import com.cloudera.sqoop.lib.BooleanParser;
import com.cloudera.sqoop.lib.BlobRef;
import com.cloudera.sqoop.lib.ClobRef;
import com.cloudera.sqoop.lib.LargeObjectLoader;
import com.cloudera.sqoop.lib.SqoopRecord;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Record extends SqoopRecord  implements DBWritable, Writable {
  private final int PROTOCOL_VERSION = 3;
  public int getClassFormatVersion() { return PROTOCOL_VERSION; }
  public static interface FieldSetterCommand {    void setField(Object value);  }  protected ResultSet __cur_result_set;
  private Map<String, FieldSetterCommand> setters = new HashMap<String, FieldSetterCommand>();
  private void init0() {
    setters.put("id", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        Record.this.id = (Integer)value;
      }
    });
    setters.put("us_station", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        Record.this.us_station = (String)value;
      }
    });
    setters.put("wb_station", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        Record.this.wb_station = (String)value;
      }
    });
    setters.put("date", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        Record.this.date = (String)value;
      }
    });
    setters.put("hour", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        Record.this.hour = (String)value;
      }
    });
    setters.put("latitude", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        Record.this.latitude = (String)value;
      }
    });
    setters.put("longitude", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        Record.this.longitude = (String)value;
      }
    });
    setters.put("kind", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        Record.this.kind = (String)value;
      }
    });
    setters.put("elevation", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        Record.this.elevation = (String)value;
      }
    });
    setters.put("wind", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        Record.this.wind = (String)value;
      }
    });
    setters.put("quality", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        Record.this.quality = (String)value;
      }
    });
    setters.put("visibility", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        Record.this.visibility = (String)value;
      }
    });
    setters.put("temperature", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        Record.this.temperature = (Integer)value;
      }
    });
    setters.put("dew", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        Record.this.dew = (String)value;
      }
    });
    setters.put("pressure", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        Record.this.pressure = (String)value;
      }
    });
  }
  public Record() {
    init0();
  }
  private Integer id;
  public Integer get_id() {
    return id;
  }
  public void set_id(Integer id) {
    this.id = id;
  }
  public Record with_id(Integer id) {
    this.id = id;
    return this;
  }
  private String us_station;
  public String get_us_station() {
    return us_station;
  }
  public void set_us_station(String us_station) {
    this.us_station = us_station;
  }
  public Record with_us_station(String us_station) {
    this.us_station = us_station;
    return this;
  }
  private String wb_station;
  public String get_wb_station() {
    return wb_station;
  }
  public void set_wb_station(String wb_station) {
    this.wb_station = wb_station;
  }
  public Record with_wb_station(String wb_station) {
    this.wb_station = wb_station;
    return this;
  }
  private String date;
  public String get_date() {
    return date;
  }
  public void set_date(String date) {
    this.date = date;
  }
  public Record with_date(String date) {
    this.date = date;
    return this;
  }
  private String hour;
  public String get_hour() {
    return hour;
  }
  public void set_hour(String hour) {
    this.hour = hour;
  }
  public Record with_hour(String hour) {
    this.hour = hour;
    return this;
  }
  private String latitude;
  public String get_latitude() {
    return latitude;
  }
  public void set_latitude(String latitude) {
    this.latitude = latitude;
  }
  public Record with_latitude(String latitude) {
    this.latitude = latitude;
    return this;
  }
  private String longitude;
  public String get_longitude() {
    return longitude;
  }
  public void set_longitude(String longitude) {
    this.longitude = longitude;
  }
  public Record with_longitude(String longitude) {
    this.longitude = longitude;
    return this;
  }
  private String kind;
  public String get_kind() {
    return kind;
  }
  public void set_kind(String kind) {
    this.kind = kind;
  }
  public Record with_kind(String kind) {
    this.kind = kind;
    return this;
  }
  private String elevation;
  public String get_elevation() {
    return elevation;
  }
  public void set_elevation(String elevation) {
    this.elevation = elevation;
  }
  public Record with_elevation(String elevation) {
    this.elevation = elevation;
    return this;
  }
  private String wind;
  public String get_wind() {
    return wind;
  }
  public void set_wind(String wind) {
    this.wind = wind;
  }
  public Record with_wind(String wind) {
    this.wind = wind;
    return this;
  }
  private String quality;
  public String get_quality() {
    return quality;
  }
  public void set_quality(String quality) {
    this.quality = quality;
  }
  public Record with_quality(String quality) {
    this.quality = quality;
    return this;
  }
  private String visibility;
  public String get_visibility() {
    return visibility;
  }
  public void set_visibility(String visibility) {
    this.visibility = visibility;
  }
  public Record with_visibility(String visibility) {
    this.visibility = visibility;
    return this;
  }
  private Integer temperature;
  public Integer get_temperature() {
    return temperature;
  }
  public void set_temperature(Integer temperature) {
    this.temperature = temperature;
  }
  public Record with_temperature(Integer temperature) {
    this.temperature = temperature;
    return this;
  }
  private String dew;
  public String get_dew() {
    return dew;
  }
  public void set_dew(String dew) {
    this.dew = dew;
  }
  public Record with_dew(String dew) {
    this.dew = dew;
    return this;
  }
  private String pressure;
  public String get_pressure() {
    return pressure;
  }
  public void set_pressure(String pressure) {
    this.pressure = pressure;
  }
  public Record with_pressure(String pressure) {
    this.pressure = pressure;
    return this;
  }
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Record)) {
      return false;
    }
    Record that = (Record) o;
    boolean equal = true;
    equal = equal && (this.id == null ? that.id == null : this.id.equals(that.id));
    equal = equal && (this.us_station == null ? that.us_station == null : this.us_station.equals(that.us_station));
    equal = equal && (this.wb_station == null ? that.wb_station == null : this.wb_station.equals(that.wb_station));
    equal = equal && (this.date == null ? that.date == null : this.date.equals(that.date));
    equal = equal && (this.hour == null ? that.hour == null : this.hour.equals(that.hour));
    equal = equal && (this.latitude == null ? that.latitude == null : this.latitude.equals(that.latitude));
    equal = equal && (this.longitude == null ? that.longitude == null : this.longitude.equals(that.longitude));
    equal = equal && (this.kind == null ? that.kind == null : this.kind.equals(that.kind));
    equal = equal && (this.elevation == null ? that.elevation == null : this.elevation.equals(that.elevation));
    equal = equal && (this.wind == null ? that.wind == null : this.wind.equals(that.wind));
    equal = equal && (this.quality == null ? that.quality == null : this.quality.equals(that.quality));
    equal = equal && (this.visibility == null ? that.visibility == null : this.visibility.equals(that.visibility));
    equal = equal && (this.temperature == null ? that.temperature == null : this.temperature.equals(that.temperature));
    equal = equal && (this.dew == null ? that.dew == null : this.dew.equals(that.dew));
    equal = equal && (this.pressure == null ? that.pressure == null : this.pressure.equals(that.pressure));
    return equal;
  }
  public boolean equals0(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Record)) {
      return false;
    }
    Record that = (Record) o;
    boolean equal = true;
    equal = equal && (this.id == null ? that.id == null : this.id.equals(that.id));
    equal = equal && (this.us_station == null ? that.us_station == null : this.us_station.equals(that.us_station));
    equal = equal && (this.wb_station == null ? that.wb_station == null : this.wb_station.equals(that.wb_station));
    equal = equal && (this.date == null ? that.date == null : this.date.equals(that.date));
    equal = equal && (this.hour == null ? that.hour == null : this.hour.equals(that.hour));
    equal = equal && (this.latitude == null ? that.latitude == null : this.latitude.equals(that.latitude));
    equal = equal && (this.longitude == null ? that.longitude == null : this.longitude.equals(that.longitude));
    equal = equal && (this.kind == null ? that.kind == null : this.kind.equals(that.kind));
    equal = equal && (this.elevation == null ? that.elevation == null : this.elevation.equals(that.elevation));
    equal = equal && (this.wind == null ? that.wind == null : this.wind.equals(that.wind));
    equal = equal && (this.quality == null ? that.quality == null : this.quality.equals(that.quality));
    equal = equal && (this.visibility == null ? that.visibility == null : this.visibility.equals(that.visibility));
    equal = equal && (this.temperature == null ? that.temperature == null : this.temperature.equals(that.temperature));
    equal = equal && (this.dew == null ? that.dew == null : this.dew.equals(that.dew));
    equal = equal && (this.pressure == null ? that.pressure == null : this.pressure.equals(that.pressure));
    return equal;
  }
  public void readFields(ResultSet __dbResults) throws SQLException {
    this.__cur_result_set = __dbResults;
    this.id = JdbcWritableBridge.readInteger(1, __dbResults);
    this.us_station = JdbcWritableBridge.readString(2, __dbResults);
    this.wb_station = JdbcWritableBridge.readString(3, __dbResults);
    this.date = JdbcWritableBridge.readString(4, __dbResults);
    this.hour = JdbcWritableBridge.readString(5, __dbResults);
    this.latitude = JdbcWritableBridge.readString(6, __dbResults);
    this.longitude = JdbcWritableBridge.readString(7, __dbResults);
    this.kind = JdbcWritableBridge.readString(8, __dbResults);
    this.elevation = JdbcWritableBridge.readString(9, __dbResults);
    this.wind = JdbcWritableBridge.readString(10, __dbResults);
    this.quality = JdbcWritableBridge.readString(11, __dbResults);
    this.visibility = JdbcWritableBridge.readString(12, __dbResults);
    this.temperature = JdbcWritableBridge.readInteger(13, __dbResults);
    this.dew = JdbcWritableBridge.readString(14, __dbResults);
    this.pressure = JdbcWritableBridge.readString(15, __dbResults);
  }
  public void readFields0(ResultSet __dbResults) throws SQLException {
    this.id = JdbcWritableBridge.readInteger(1, __dbResults);
    this.us_station = JdbcWritableBridge.readString(2, __dbResults);
    this.wb_station = JdbcWritableBridge.readString(3, __dbResults);
    this.date = JdbcWritableBridge.readString(4, __dbResults);
    this.hour = JdbcWritableBridge.readString(5, __dbResults);
    this.latitude = JdbcWritableBridge.readString(6, __dbResults);
    this.longitude = JdbcWritableBridge.readString(7, __dbResults);
    this.kind = JdbcWritableBridge.readString(8, __dbResults);
    this.elevation = JdbcWritableBridge.readString(9, __dbResults);
    this.wind = JdbcWritableBridge.readString(10, __dbResults);
    this.quality = JdbcWritableBridge.readString(11, __dbResults);
    this.visibility = JdbcWritableBridge.readString(12, __dbResults);
    this.temperature = JdbcWritableBridge.readInteger(13, __dbResults);
    this.dew = JdbcWritableBridge.readString(14, __dbResults);
    this.pressure = JdbcWritableBridge.readString(15, __dbResults);
  }
  public void loadLargeObjects(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void loadLargeObjects0(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void write(PreparedStatement __dbStmt) throws SQLException {
    write(__dbStmt, 0);
  }

  public int write(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeInteger(id, 1 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(us_station, 2 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(wb_station, 3 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(date, 4 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(hour, 5 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(latitude, 6 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(longitude, 7 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(kind, 8 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(elevation, 9 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(wind, 10 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(quality, 11 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(visibility, 12 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(temperature, 13 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(dew, 14 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(pressure, 15 + __off, 12, __dbStmt);
    return 15;
  }
  public void write0(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeInteger(id, 1 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(us_station, 2 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(wb_station, 3 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(date, 4 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(hour, 5 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(latitude, 6 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(longitude, 7 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(kind, 8 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(elevation, 9 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(wind, 10 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(quality, 11 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(visibility, 12 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeInteger(temperature, 13 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeString(dew, 14 + __off, 12, __dbStmt);
    JdbcWritableBridge.writeString(pressure, 15 + __off, 12, __dbStmt);
  }
  public void readFields(DataInput __dataIn) throws IOException {
this.readFields0(__dataIn);  }
  public void readFields0(DataInput __dataIn) throws IOException {
    if (__dataIn.readBoolean()) { 
        this.id = null;
    } else {
    this.id = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.us_station = null;
    } else {
    this.us_station = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.wb_station = null;
    } else {
    this.wb_station = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.date = null;
    } else {
    this.date = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.hour = null;
    } else {
    this.hour = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.latitude = null;
    } else {
    this.latitude = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.longitude = null;
    } else {
    this.longitude = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.kind = null;
    } else {
    this.kind = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.elevation = null;
    } else {
    this.elevation = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.wind = null;
    } else {
    this.wind = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.quality = null;
    } else {
    this.quality = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.visibility = null;
    } else {
    this.visibility = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.temperature = null;
    } else {
    this.temperature = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.dew = null;
    } else {
    this.dew = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.pressure = null;
    } else {
    this.pressure = Text.readString(__dataIn);
    }
  }
  public void write(DataOutput __dataOut) throws IOException {
    if (null == this.id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.id);
    }
    if (null == this.us_station) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, us_station);
    }
    if (null == this.wb_station) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, wb_station);
    }
    if (null == this.date) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, date);
    }
    if (null == this.hour) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, hour);
    }
    if (null == this.latitude) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, latitude);
    }
    if (null == this.longitude) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, longitude);
    }
    if (null == this.kind) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, kind);
    }
    if (null == this.elevation) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, elevation);
    }
    if (null == this.wind) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, wind);
    }
    if (null == this.quality) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, quality);
    }
    if (null == this.visibility) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, visibility);
    }
    if (null == this.temperature) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.temperature);
    }
    if (null == this.dew) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, dew);
    }
    if (null == this.pressure) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, pressure);
    }
  }
  public void write0(DataOutput __dataOut) throws IOException {
    if (null == this.id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.id);
    }
    if (null == this.us_station) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, us_station);
    }
    if (null == this.wb_station) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, wb_station);
    }
    if (null == this.date) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, date);
    }
    if (null == this.hour) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, hour);
    }
    if (null == this.latitude) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, latitude);
    }
    if (null == this.longitude) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, longitude);
    }
    if (null == this.kind) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, kind);
    }
    if (null == this.elevation) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, elevation);
    }
    if (null == this.wind) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, wind);
    }
    if (null == this.quality) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, quality);
    }
    if (null == this.visibility) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, visibility);
    }
    if (null == this.temperature) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.temperature);
    }
    if (null == this.dew) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, dew);
    }
    if (null == this.pressure) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, pressure);
    }
  }
  private static final DelimiterSet __outputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  public String toString() {
    return toString(__outputDelimiters, true);
  }
  public String toString(DelimiterSet delimiters) {
    return toString(delimiters, true);
  }
  public String toString(boolean useRecordDelim) {
    return toString(__outputDelimiters, useRecordDelim);
  }
  public String toString(DelimiterSet delimiters, boolean useRecordDelim) {
    StringBuilder __sb = new StringBuilder();
    char fieldDelim = delimiters.getFieldsTerminatedBy();
    __sb.append(FieldFormatter.escapeAndEnclose(id==null?"null":"" + id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(us_station==null?"null":us_station, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(wb_station==null?"null":wb_station, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(date==null?"null":date, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(hour==null?"null":hour, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(latitude==null?"null":latitude, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(longitude==null?"null":longitude, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(kind==null?"null":kind, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(elevation==null?"null":elevation, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(wind==null?"null":wind, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(quality==null?"null":quality, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(visibility==null?"null":visibility, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(temperature==null?"null":"" + temperature, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(dew==null?"null":dew, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(pressure==null?"null":pressure, delimiters));
    if (useRecordDelim) {
      __sb.append(delimiters.getLinesTerminatedBy());
    }
    return __sb.toString();
  }
  public void toString0(DelimiterSet delimiters, StringBuilder __sb, char fieldDelim) {
    __sb.append(FieldFormatter.escapeAndEnclose(id==null?"null":"" + id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(us_station==null?"null":us_station, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(wb_station==null?"null":wb_station, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(date==null?"null":date, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(hour==null?"null":hour, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(latitude==null?"null":latitude, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(longitude==null?"null":longitude, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(kind==null?"null":kind, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(elevation==null?"null":elevation, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(wind==null?"null":wind, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(quality==null?"null":quality, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(visibility==null?"null":visibility, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(temperature==null?"null":"" + temperature, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(dew==null?"null":dew, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(pressure==null?"null":pressure, delimiters));
  }
  private static final DelimiterSet __inputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  private RecordParser __parser;
  public void parse(Text __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharSequence __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(byte [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(char [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(ByteBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  private void __loadFromFields(List<String> fields) {
    Iterator<String> __it = fields.listIterator();
    String __cur_str = null;
    try {
    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.id = null; } else {
      this.id = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.us_station = null; } else {
      this.us_station = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.wb_station = null; } else {
      this.wb_station = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.date = null; } else {
      this.date = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.hour = null; } else {
      this.hour = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.latitude = null; } else {
      this.latitude = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.longitude = null; } else {
      this.longitude = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.kind = null; } else {
      this.kind = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.elevation = null; } else {
      this.elevation = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.wind = null; } else {
      this.wind = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.quality = null; } else {
      this.quality = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.visibility = null; } else {
      this.visibility = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.temperature = null; } else {
      this.temperature = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.dew = null; } else {
      this.dew = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.pressure = null; } else {
      this.pressure = __cur_str;
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  private void __loadFromFields0(Iterator<String> __it) {
    String __cur_str = null;
    try {
    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.id = null; } else {
      this.id = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.us_station = null; } else {
      this.us_station = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.wb_station = null; } else {
      this.wb_station = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.date = null; } else {
      this.date = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.hour = null; } else {
      this.hour = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.latitude = null; } else {
      this.latitude = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.longitude = null; } else {
      this.longitude = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.kind = null; } else {
      this.kind = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.elevation = null; } else {
      this.elevation = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.wind = null; } else {
      this.wind = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.quality = null; } else {
      this.quality = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.visibility = null; } else {
      this.visibility = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.temperature = null; } else {
      this.temperature = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.dew = null; } else {
      this.dew = __cur_str;
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null")) { this.pressure = null; } else {
      this.pressure = __cur_str;
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  public Object clone() throws CloneNotSupportedException {
    Record o = (Record) super.clone();
    return o;
  }

  public void clone0(Record o) throws CloneNotSupportedException {
  }

  public Map<String, Object> getFieldMap() {
    Map<String, Object> __sqoop$field_map = new HashMap<String, Object>();
    __sqoop$field_map.put("id", this.id);
    __sqoop$field_map.put("us_station", this.us_station);
    __sqoop$field_map.put("wb_station", this.wb_station);
    __sqoop$field_map.put("date", this.date);
    __sqoop$field_map.put("hour", this.hour);
    __sqoop$field_map.put("latitude", this.latitude);
    __sqoop$field_map.put("longitude", this.longitude);
    __sqoop$field_map.put("kind", this.kind);
    __sqoop$field_map.put("elevation", this.elevation);
    __sqoop$field_map.put("wind", this.wind);
    __sqoop$field_map.put("quality", this.quality);
    __sqoop$field_map.put("visibility", this.visibility);
    __sqoop$field_map.put("temperature", this.temperature);
    __sqoop$field_map.put("dew", this.dew);
    __sqoop$field_map.put("pressure", this.pressure);
    return __sqoop$field_map;
  }

  public void getFieldMap0(Map<String, Object> __sqoop$field_map) {
    __sqoop$field_map.put("id", this.id);
    __sqoop$field_map.put("us_station", this.us_station);
    __sqoop$field_map.put("wb_station", this.wb_station);
    __sqoop$field_map.put("date", this.date);
    __sqoop$field_map.put("hour", this.hour);
    __sqoop$field_map.put("latitude", this.latitude);
    __sqoop$field_map.put("longitude", this.longitude);
    __sqoop$field_map.put("kind", this.kind);
    __sqoop$field_map.put("elevation", this.elevation);
    __sqoop$field_map.put("wind", this.wind);
    __sqoop$field_map.put("quality", this.quality);
    __sqoop$field_map.put("visibility", this.visibility);
    __sqoop$field_map.put("temperature", this.temperature);
    __sqoop$field_map.put("dew", this.dew);
    __sqoop$field_map.put("pressure", this.pressure);
  }

  public void setField(String __fieldName, Object __fieldVal) {
    if (!setters.containsKey(__fieldName)) {
      throw new RuntimeException("No such field:"+__fieldName);
    }
    setters.get(__fieldName).setField(__fieldVal);
  }

}
