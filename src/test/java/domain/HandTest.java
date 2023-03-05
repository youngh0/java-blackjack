package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class HandTest {

    private Hand hand;

    private static Stream<Arguments> cardProvider() {
        return Stream.of(
            Arguments.of(new Card("A클로버", 11), 13),
            Arguments.of(new Card("9하트", 9), 21)
        );
    }

    private static Stream<Arguments> isAceProvider() {
        return Stream.of(
                Arguments.of(new Card("A클로버", 11), true),
                Arguments.of(new Card("9하트", 9), false)
        );
    }

    @BeforeEach
    void setUp() {
        hand = new Hand(new ArrayList<>(
            List.of(
                new Card("2하트", 2),
                new Card("K다이아", 10)
            ))
        );
    }

    @Test
    void addCard() {
        hand.addCard(new Card("5클로버", 5));
        assertThat(hand.getCardNames().size()).isEqualTo(3);
    }

    @ParameterizedTest
    @MethodSource("isAceProvider")
    @DisplayName("현재 카드가 ace인지에 따라 boolean값을 반환한다.")
    void isAceTest(Card card, boolean isAce) {
        assertThat(card.isAce()).isEqualTo(isAce);
    }

    @ParameterizedTest
    @MethodSource("cardProvider")
    void calculateValue(Card card, int handValue) {
        hand.addCard(card);
        assertThat(hand.calculateValue()).isEqualTo(handValue);
    }
}
