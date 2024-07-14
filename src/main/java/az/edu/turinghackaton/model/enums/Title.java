package az.edu.turinghackaton.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Title {
    KONULLU("konullu"),
    TECRUBE_PROQRAMI("tecrube proqrami"),
    VAKANSIYA("vakansiya"),
    KURS("kurs");

    private final String description;
}
