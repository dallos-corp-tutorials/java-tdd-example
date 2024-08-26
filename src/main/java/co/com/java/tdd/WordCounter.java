package co.com.java.tdd;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class WordCounter {
    public int count(String text) {
        if(StringUtils.isBlank(text)){
            return 0;
        }

        // Compile regex as predicate
        Predicate<String> alphaNumericPattern = Pattern
                .compile("^[a-zA-Z0-9ñÑ]+")
                .asPredicate();

        int count = 0;
        count = (int) Arrays.stream(text.split(" "))
                     .filter(alphaNumericPattern).count();

        return count;
    }
}
