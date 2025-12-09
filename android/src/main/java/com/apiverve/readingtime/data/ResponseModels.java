// Converter.java

// To use this code, add the following Maven dependency to your project:
//
//
//     com.fasterxml.jackson.core     : jackson-databind          : 2.9.0
//     com.fasterxml.jackson.datatype : jackson-datatype-jsr310   : 2.9.0
//
// Import this package:
//
//     import com.apiverve.data.Converter;
//
// Then you can deserialize a JSON string with
//
//     ReadingTimeCalculatorData data = Converter.fromJsonString(jsonString);

package com.apiverve.readingtime.data;

import java.io.IOException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Converter {
    // Date-time helpers

    private static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_INSTANT)
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetDateTime parseDateTimeString(String str) {
        return ZonedDateTime.from(Converter.DATE_TIME_FORMATTER.parse(str)).toOffsetDateTime();
    }

    private static final DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_TIME)
            .parseDefaulting(ChronoField.YEAR, 2020)
            .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
            .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetTime parseTimeString(String str) {
        return ZonedDateTime.from(Converter.TIME_FORMATTER.parse(str)).toOffsetDateTime().toOffsetTime();
    }
    // Serialize/deserialize helpers

    public static ReadingTimeCalculatorData fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(ReadingTimeCalculatorData obj) throws JsonProcessingException {
        return getObjectWriter().writeValueAsString(obj);
    }

    private static ObjectReader reader;
    private static ObjectWriter writer;

    private static void instantiateMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleModule module = new SimpleModule();
        module.addDeserializer(OffsetDateTime.class, new JsonDeserializer<OffsetDateTime>() {
            @Override
            public OffsetDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                String value = jsonParser.getText();
                return Converter.parseDateTimeString(value);
            }
        });
        mapper.registerModule(module);
        reader = mapper.readerFor(ReadingTimeCalculatorData.class);
        writer = mapper.writerFor(ReadingTimeCalculatorData.class);
    }

    private static ObjectReader getObjectReader() {
        if (reader == null) instantiateMapper();
        return reader;
    }

    private static ObjectWriter getObjectWriter() {
        if (writer == null) instantiateMapper();
        return writer;
    }
}

// ReadingTimeCalculatorData.java

package com.apiverve.readingtime.data;

import com.fasterxml.jackson.annotation.*;

public class ReadingTimeCalculatorData {
    private long textLength;
    private long wordCount;
    private long readingTimeMinutes;
    private long readingTimeSeconds;
    private String readingTimeText;
    private long wordsPerMinute;

    @JsonProperty("text_length")
    public long getTextLength() { return textLength; }
    @JsonProperty("text_length")
    public void setTextLength(long value) { this.textLength = value; }

    @JsonProperty("word_count")
    public long getWordCount() { return wordCount; }
    @JsonProperty("word_count")
    public void setWordCount(long value) { this.wordCount = value; }

    @JsonProperty("reading_time_minutes")
    public long getReadingTimeMinutes() { return readingTimeMinutes; }
    @JsonProperty("reading_time_minutes")
    public void setReadingTimeMinutes(long value) { this.readingTimeMinutes = value; }

    @JsonProperty("reading_time_seconds")
    public long getReadingTimeSeconds() { return readingTimeSeconds; }
    @JsonProperty("reading_time_seconds")
    public void setReadingTimeSeconds(long value) { this.readingTimeSeconds = value; }

    @JsonProperty("reading_time_text")
    public String getReadingTimeText() { return readingTimeText; }
    @JsonProperty("reading_time_text")
    public void setReadingTimeText(String value) { this.readingTimeText = value; }

    @JsonProperty("words_per_minute")
    public long getWordsPerMinute() { return wordsPerMinute; }
    @JsonProperty("words_per_minute")
    public void setWordsPerMinute(long value) { this.wordsPerMinute = value; }
}