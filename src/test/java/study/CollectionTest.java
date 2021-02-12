package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CollectionTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    // Test Case 구현

    @DisplayName("Set 크기 확인")
    @Test
    void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("1, 2, 3 존재 확인 중복 코드")
    @Test
    void containsDuplicated() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @DisplayName("1, 2, 3 존재 확인 중복 제거 코드")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains(int number) {
        assertTrue(numbers.contains(number));
    }

    @DisplayName("입력 값에 따라 결과 값이 다른 경우")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void containsValidate(String input, String expected) {
        assertEquals(expected, String.valueOf(numbers.contains(Integer.parseInt(input))));
    }

    @DisplayName("unmodifiableList -> stream 으로 변경하면 unmodifiable 조건 풀리는지")
    @Test
    void unmodifiableList() {
        List<String> names = new ArrayList<>();
        names.add("111");
        names.add("222");

        List<String> unmodifiableNames = Collections.unmodifiableList(names);

        Assertions.assertThatThrownBy(
            () -> unmodifiableNames.add("333")
        ).isInstanceOf(UnsupportedOperationException.class);

        List<String> unmodifiableNames1 = names.stream()
            .collect(Collectors.toList());
        List<String> unmodifiableNames2 = new ArrayList<>(names);
        List<String> unmodifiableNames3 = names.stream()
            .filter(name -> name.equals("222"))
            .collect(Collectors.toList());

        Assertions.assertThatCode(
            () -> unmodifiableNames1.add("333")
        ).doesNotThrowAnyException();

        Assertions.assertThatCode(
            () -> unmodifiableNames2.add("333")
        ).doesNotThrowAnyException();

        Assertions.assertThatCode(
            () -> unmodifiableNames3.add("333")
        ).doesNotThrowAnyException();

        List<String> unmodifiableNames4 = Collections.unmodifiableList(unmodifiableNames1);
        Assertions.assertThatThrownBy(
            () -> unmodifiableNames4.add("333")
        ).isInstanceOf(UnsupportedOperationException.class);
    }
}
