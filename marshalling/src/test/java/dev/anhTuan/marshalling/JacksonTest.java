package dev.anhTuan.marshalling;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.anhTuan.marshalling.domain.Book;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class JacksonTest {
    @Test
    public void testThatObjectMapperCanCreateJsonFromJavaObject() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Book book = Book.builder()
                .isbn("987-0-13-478627-5")
                .title("The Enigma of Eternity")
                .author("Aria Montgomery")
                .yearPublished("2005")
                .build();
        String result = objectMapper.writeValueAsString(book);
        Assertions.assertThat(result).isEqualTo("{\"isbn\":\"987-0-13-478627-5\",\"title\":\"The Enigma of Eternity\",\"author\":\"Aria Montgomery\",\"year\":\"2005\"}");
    }
    @Test
    public void testThatObjectMapperCanCreateJavaObjectFromJsonObject() throws JsonProcessingException {
        String json = "{\"foo\":\"bar\",\"isbn\":\"987-0-13-478627-5\",\"title\":\"The Enigma of Eternity\",\"author\":\"Aria Montgomery\",\"year\":\"2005\"}";
        Book book = Book.builder()
                .isbn("987-0-13-478627-5")
                .title("The Enigma of Eternity")
                .author("Aria Montgomery")
                .yearPublished("2005")
                .build();
        final ObjectMapper objectMapper  = new ObjectMapper();
        Book result = objectMapper.readValue(json,Book.class);
        Assertions.assertThat(result).isEqualTo(book);
    }

}
