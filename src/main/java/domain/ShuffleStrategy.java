package domain;

import java.util.Stack;

public interface ShuffleStrategy {
    Stack<Card> shuffle(Stack<Card> deck);
}
