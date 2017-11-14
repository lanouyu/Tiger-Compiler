package tiger.parse;
import tiger.errormsg.ErrorMsg;
%% 

%implements Lexer
%function next_token
%type java_cup.runtime.Symbol
%char

%{
StringBuffer str = new StringBuffer();
int comNum;
private void newline() {
  errorMsg.newline(yychar);
}

private void err(int pos, String s) {
  errorMsg.error(pos,s);
}

private void err(String s) {
  err(yychar,s);
}

private java_cup.runtime.Symbol tok(int kind, Object value) {
    return new java_cup.runtime.Symbol(kind, yychar, yychar+yylength(), value);
}

private ErrorMsg errorMsg;

Yylex(java.io.InputStream s, ErrorMsg e) {
  this(s);
  errorMsg=e;
}

%}

%eofval{
  {
    if (yystate()==COMMENT) err("Comment Error!");
    if (yystate()==STRING) err("String Error!");
    if (yystate()==STRINGIN) err("String in Error!");
    return tok(sym.EOF, null);
  }
%eofval}       

%state COMMENT
%state STRING
%state STRINGIN

delim=[ \t\n\f\r]
ws={delim}+
letter=[A-Za-z]
digit=[0-9]
id={letter}({letter}|{digit}|_)*
num={digit}+

%%
<YYINITIAL> \"      {str.setLength(0); yybegin(STRING);}
<YYINITIAL> "/*"    {comNum=1; yybegin(COMMENT);}
<YYINITIAL> "*/"    {err("Comment Matching Error!");}
<YYINITIAL> {ws}    {}
<YYINITIAL> "function"  {return tok(sym.FUNCTION, null);}
<YYINITIAL> ">"     {return tok(sym.GT, null);}
<YYINITIAL> "/"     {return tok(sym.DIVIDE, null);}
<YYINITIAL> ":"     {return tok(sym.COLON, null);}
<YYINITIAL> "else"  {return tok(sym.ELSE, null);}
<YYINITIAL> "|"     {return tok(sym.OR, null);}
<YYINITIAL> "nil"   {return tok(sym.NIL, null);}
<YYINITIAL> "do"    {return tok(sym.DO, null);}
<YYINITIAL> ">="    {return tok(sym.GE, null);}
<YYINITIAL> "error" {return tok(sym.error, null);}
<YYINITIAL> "<"     {return tok(sym.LT, null);}
<YYINITIAL> "of"    {return tok(sym.OF, null);}
<YYINITIAL> "-"     {return tok(sym.MINUS, null);}
<YYINITIAL> "array" {return tok(sym.ARRAY, null);}
<YYINITIAL> "type"  {return tok(sym.TYPE, null);}
<YYINITIAL> "for"   {return tok(sym.FOR, null);}
<YYINITIAL> "to"    {return tok(sym.TO, null);}
<YYINITIAL> "*"     {return tok(sym.TIMES, null);}
<YYINITIAL> ","     {return tok(sym.COMMA, null);}
<YYINITIAL> "<="    {return tok(sym.LE, null);}
<YYINITIAL> "in"    {return tok(sym.IN, null);}
<YYINITIAL> "end"   {return tok(sym.END, null);}
<YYINITIAL> ":="    {return tok(sym.ASSIGN, null);}
<YYINITIAL> "."     {return tok(sym.DOT, null);}
<YYINITIAL> "("     {return tok(sym.LPAREN, null);}
<YYINITIAL> ")"     {return tok(sym.RPAREN, null);}
<YYINITIAL> "if"    {return tok(sym.IF, null);}
<YYINITIAL> ";"     {return tok(sym.SEMICOLON, null);}
<YYINITIAL> "while" {return tok(sym.WHILE, null);}
<YYINITIAL> "["     {return tok(sym.LBRACK, null);}
<YYINITIAL> "]"     {return tok(sym.RBRACK, null);}
<YYINITIAL> "<>"    {return tok(sym.NEQ, null);}
<YYINITIAL> "var"   {return tok(sym.VAR, null);}
<YYINITIAL> "break" {return tok(sym.BREAK, null);}
<YYINITIAL> "&"     {return tok(sym.AND, null);}
<YYINITIAL> "+"     {return tok(sym.PLUS, null);}
<YYINITIAL> "{"     {return tok(sym.LBRACE, null);}
<YYINITIAL> "}"     {return tok(sym.RBRACE, null);}
<YYINITIAL> "let"   {return tok(sym.LET, null);}
<YYINITIAL> "then"  {return tok(sym.THEN, null);}
<YYINITIAL> "="     {return tok(sym.EQ, null);}
<YYINITIAL> {id}    {return tok(sym.ID, yytext());}
<YYINITIAL> {num}   {return tok(sym.INT, new Integer(yytext()));}
<YYINITIAL> [^]     {err("Character error!");}

<STRING>  \" {
  yybegin(YYINITIAL); 
  return tok(sym.STRING, str.toString());
}
<STRING>  \\digit{3} {
  int tmp=Integer.parseInt(yytext().substring(1, 4));
  if (tmp>255) err("exceed \\ddd");
  else str.append((char)tmp);
}
<STRING>  \\    {yybegin(STRINGIN);}
<STRING>  \\t   {str.append('\t');}
<STRING>  \\n   {str.append('\n');}
<STRING>  \\\"  {str.append('\"');}
<STRING>  \\\\  {str.append('\\');}
<STRING>  [^]   {str.append(yytext());}

<STRINGIN>  {ws}  {}
<STRINGIN>  \\  {yybegin(STRING);}
<STRINGIN>  \"  {err("\\ in string matching error!");}
<STRINGIN>  [^]  {str.append(yytext());}

<COMMENT> "/*"  {comNum++;}
<COMMENT> "*/"  {
  comNum--;
  if (comNum==0) {
    yybegin(YYINITIAL);
  }
}
<COMMENT> [^]  {}
