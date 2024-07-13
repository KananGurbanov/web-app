package az.edu.turinghackaton.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Error {
    ERR_01("ERR_01", "Record was not found!"),
    ERR_02("ERR_02", "Email already exists!");

    private final String errorCode;
    private final String errorDescription;
}
