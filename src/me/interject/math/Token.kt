package me.interject.math

/**
 * Created by michaelshaulskiy on 14.09.16.
 */
enum class Type {
    NUMBER,
    OPERATOR_ADD,
    OPERATOR_SUB,
    OPERATOR_MUL,
    OPERATOR_DIV,
    OPERATOR_MOD,
    OPERATOR_FAK,
    OPENING_BRACE,
    CLOSING_BRACE
}

class Token {

    private enum class OperatorType {
        UNARY,
        BINARY,
        TERNARY,
        VARIADIC
    }

    constructor() {

    }

    constructor(t: Type) {
        when(t) {
            Type.NUMBER -> {

            }
        }
    }

}