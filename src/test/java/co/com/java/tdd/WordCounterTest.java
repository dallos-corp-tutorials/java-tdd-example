package co.com.java.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterTest {

    private WordCounter wordCounter;

    @BeforeEach
    public void setUp() {
        wordCounter = new WordCounter();
    }

    @ParameterizedTest
    @NullAndEmptySource
    void shouldCountZeroWords_NullAndEmptyText(String text) {
        //Given

        //When
        int count = wordCounter.count(text);

        //Then
        assertEquals(0, count, "Must be zero words");
    }

    @ParameterizedTest
    @CsvSource({"'My name is Cristian Dallos Bustos.', 6",
    "'   ', 0",
    "' ... ', 0",
    "' .$%# ', 0,",
    "' 2 ', 1",
    "' a. B.... ñÑ ', 3"})
    void shouldCountWords(String text, int numWords) {
        //Given

        //When
        int count = wordCounter.count(text);

        //Then
        assertEquals(numWords, count, "Must be six words");
    }

}
