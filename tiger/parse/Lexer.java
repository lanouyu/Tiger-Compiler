package tiger.parse;

interface Lexer {
    public java_cup.runtime.Symbol next_token() throws java.io.IOException;
}
