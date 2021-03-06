/* The following code was generated by JFlex 1.4.1 on 16-11-28 下午4:08 */

package tiger.parse;
import tiger.errormsg.ErrorMsg;

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.1
 * on 16-11-28 下午4:08 from the specification file
 * <tt>/Users/blue/Documents/F1403001/Compiler/tiger_runnable/tiger/parse/Tiger.flex</tt>
 */
public class Yylex implements Lexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int STRING = 2;
  public static final int STRINGIN = 3;
  public static final int YYINITIAL = 0;
  public static final int COMMENT = 1;

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = {
     0,  0,  0,  0,  0,  0,  0,  0,  0,  1,  1,  0,  1,  1,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     1,  0,  5,  0,  0,  0, 41,  0, 31, 32,  7, 42, 29, 25, 30,  6, 
     3,  3,  3,  3,  3,  3,  3,  3,  3,  3, 16, 33, 24, 22, 15,  0, 
     0,  2,  2,  2,  2,  2,  2,  2,  2,  2,  2,  2,  2,  2,  2,  2, 
     2,  2,  2,  2,  2,  2,  2,  2,  2,  2,  2, 36, 45, 37,  0,  4, 
     0, 26, 39, 11, 21, 17,  8, 46, 35, 13,  2, 40, 18,  2, 10, 14, 
    28,  2, 23, 19, 12,  9, 38, 34,  2, 27,  2, 43, 20, 44,  0,  0
  };

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\4\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7"+
    "\5\3\1\10\1\11\2\3\1\12\1\3\1\13\1\14"+
    "\1\15\1\3\1\16\1\17\1\20\1\21\1\22\1\3"+
    "\1\23\1\24\2\3\1\25\1\26\1\27\1\30\3\2"+
    "\1\31\1\32\1\33\1\34\1\35\1\36\1\37\3\3"+
    "\1\40\2\3\1\41\1\42\1\43\1\44\1\45\4\3"+
    "\1\46\1\47\1\50\4\3\1\51\1\52\1\53\1\54"+
    "\1\55\1\0\1\56\1\3\1\57\1\60\2\3\1\61"+
    "\2\3\1\62\2\3\1\63\1\3\1\0\1\3\1\64"+
    "\1\65\1\66\4\3\1\0\1\3\1\67\1\70\1\71"+
    "\1\72\1\0\1\3\1\0\1\3\1\0\1\73\1\74";

  private static int [] zzUnpackAction() {
    int [] result = new int[114];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\57\0\136\0\215\0\274\0\353\0\u011a\0\u0149"+
    "\0\274\0\u0178\0\u01a7\0\u01d6\0\u0205\0\u0234\0\u0263\0\u0292"+
    "\0\u02c1\0\u02f0\0\u031f\0\u034e\0\274\0\u037d\0\274\0\u03ac"+
    "\0\274\0\u03db\0\274\0\274\0\274\0\274\0\274\0\u040a"+
    "\0\274\0\274\0\u0439\0\u0468\0\274\0\274\0\274\0\274"+
    "\0\274\0\u0497\0\u04c6\0\274\0\274\0\u04f5\0\274\0\274"+
    "\0\274\0\274\0\u0524\0\u0553\0\u0582\0\u011a\0\u05b1\0\u05e0"+
    "\0\u011a\0\u011a\0\u011a\0\274\0\274\0\u060f\0\u063e\0\u066d"+
    "\0\u069c\0\u011a\0\274\0\274\0\u06cb\0\u06fa\0\u0729\0\u0758"+
    "\0\274\0\274\0\274\0\274\0\274\0\u0787\0\274\0\u07b6"+
    "\0\u011a\0\u011a\0\u07e5\0\u0814\0\u011a\0\u0843\0\u0872\0\u011a"+
    "\0\u08a1\0\u08d0\0\u011a\0\u08ff\0\u092e\0\u095d\0\u011a\0\u011a"+
    "\0\u011a\0\u098c\0\u09bb\0\u09ea\0\u0a19\0\u0a48\0\u0a77\0\u011a"+
    "\0\u011a\0\u011a\0\u011a\0\u0aa6\0\u0ad5\0\u0b04\0\u0b33\0\u0b62"+
    "\0\u011a\0\274";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[114];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\5\1\6\1\7\1\10\1\5\1\11\1\12\1\13"+
    "\1\14\1\7\1\15\1\7\1\16\1\17\1\20\1\21"+
    "\1\22\1\23\1\24\1\7\1\25\1\26\1\27\1\7"+
    "\1\30\1\31\1\32\2\7\1\33\1\34\1\35\1\36"+
    "\1\37\1\40\1\7\1\41\1\42\1\43\1\44\1\7"+
    "\1\45\1\46\1\47\1\50\1\5\1\7\6\51\1\52"+
    "\1\53\47\51\5\54\1\55\47\54\1\56\2\54\1\6"+
    "\3\54\1\57\47\54\1\60\1\54\60\0\1\6\57\0"+
    "\3\7\3\0\7\7\2\0\3\7\1\0\1\7\1\0"+
    "\1\7\2\0\3\7\5\0\2\7\2\0\3\7\5\0"+
    "\1\7\3\0\1\10\62\0\1\61\55\0\1\62\52\0"+
    "\3\7\3\0\1\7\1\63\4\7\1\64\2\0\3\7"+
    "\1\0\1\7\1\0\1\7\2\0\3\7\5\0\2\7"+
    "\2\0\3\7\5\0\1\7\2\0\3\7\3\0\5\7"+
    "\1\65\1\7\2\0\3\7\1\0\1\7\1\0\1\7"+
    "\2\0\3\7\5\0\2\7\2\0\3\7\5\0\1\7"+
    "\2\0\3\7\3\0\6\7\1\66\2\0\3\7\1\0"+
    "\1\7\1\0\1\7\2\0\1\7\1\67\1\7\5\0"+
    "\1\7\1\70\2\0\3\7\5\0\1\7\2\0\3\7"+
    "\3\0\1\71\1\7\1\72\4\7\2\0\3\7\1\0"+
    "\1\7\1\0\1\7\2\0\3\7\5\0\2\7\2\0"+
    "\3\7\5\0\1\7\2\0\3\7\3\0\1\73\6\7"+
    "\2\0\3\7\1\0\1\7\1\0\1\7\2\0\3\7"+
    "\5\0\2\7\2\0\3\7\5\0\1\7\26\0\1\74"+
    "\56\0\1\75\32\0\3\7\3\0\2\7\1\76\4\7"+
    "\2\0\1\7\1\77\1\7\1\0\1\7\1\0\1\100"+
    "\2\0\3\7\5\0\2\7\2\0\3\7\5\0\1\7"+
    "\2\0\3\7\3\0\7\7\2\0\1\101\2\7\1\0"+
    "\1\7\1\0\1\7\2\0\3\7\5\0\2\7\2\0"+
    "\3\7\5\0\1\7\2\0\3\7\3\0\6\7\1\102"+
    "\2\0\3\7\1\0\1\7\1\0\1\7\2\0\3\7"+
    "\5\0\2\7\2\0\3\7\5\0\1\7\17\0\1\103"+
    "\6\0\1\104\32\0\3\7\3\0\7\7\2\0\3\7"+
    "\1\0\1\7\1\0\1\105\2\0\3\7\5\0\2\7"+
    "\2\0\3\7\5\0\1\7\2\0\3\7\3\0\7\7"+
    "\2\0\3\7\1\0\1\7\1\0\1\7\2\0\3\7"+
    "\5\0\1\7\1\106\2\0\3\7\5\0\1\7\2\0"+
    "\3\7\3\0\7\7\2\0\3\7\1\0\1\7\1\0"+
    "\1\7\2\0\1\107\2\7\5\0\2\7\2\0\3\7"+
    "\5\0\1\7\2\0\3\7\3\0\7\7\2\0\3\7"+
    "\1\0\1\7\1\0\1\110\2\0\3\7\5\0\2\7"+
    "\2\0\3\7\5\0\1\7\7\0\1\111\55\0\1\112"+
    "\55\0\1\113\4\0\1\114\1\0\1\115\10\0\1\116"+
    "\27\0\1\117\3\0\3\7\3\0\2\7\1\120\4\7"+
    "\2\0\3\7\1\0\1\7\1\0\1\7\2\0\3\7"+
    "\5\0\2\7\2\0\3\7\5\0\1\7\2\0\3\7"+
    "\3\0\7\7\2\0\3\7\1\0\1\7\1\0\1\121"+
    "\2\0\3\7\5\0\2\7\2\0\3\7\5\0\1\7"+
    "\2\0\3\7\3\0\7\7\2\0\1\7\1\122\1\7"+
    "\1\0\1\7\1\0\1\7\2\0\3\7\5\0\2\7"+
    "\2\0\3\7\5\0\1\7\2\0\3\7\3\0\7\7"+
    "\2\0\3\7\1\0\1\7\1\0\1\7\2\0\2\7"+
    "\1\123\5\0\2\7\2\0\3\7\5\0\1\7\2\0"+
    "\3\7\3\0\7\7\2\0\1\124\2\7\1\0\1\7"+
    "\1\0\1\7\2\0\3\7\5\0\2\7\2\0\3\7"+
    "\5\0\1\7\2\0\3\7\3\0\7\7\2\0\3\7"+
    "\1\0\1\125\1\0\1\7\2\0\3\7\5\0\2\7"+
    "\2\0\3\7\5\0\1\7\2\0\3\7\3\0\7\7"+
    "\2\0\2\7\1\126\1\0\1\7\1\0\1\7\2\0"+
    "\3\7\5\0\2\7\2\0\3\7\5\0\1\7\2\0"+
    "\3\7\3\0\7\7\2\0\3\7\1\0\1\7\1\0"+
    "\1\127\2\0\3\7\5\0\2\7\2\0\3\7\5\0"+
    "\1\7\2\0\3\7\3\0\4\7\1\130\2\7\2\0"+
    "\3\7\1\0\1\7\1\0\1\7\2\0\3\7\5\0"+
    "\2\7\2\0\3\7\5\0\1\7\2\0\3\7\3\0"+
    "\7\7\2\0\3\7\1\0\1\7\1\0\1\131\2\0"+
    "\3\7\5\0\2\7\2\0\3\7\5\0\1\7\2\0"+
    "\3\7\3\0\5\7\1\132\1\7\2\0\3\7\1\0"+
    "\1\7\1\0\1\7\2\0\3\7\5\0\2\7\2\0"+
    "\3\7\5\0\1\7\2\0\3\7\3\0\7\7\2\0"+
    "\3\7\1\0\1\7\1\0\1\133\2\0\3\7\5\0"+
    "\2\7\2\0\3\7\5\0\1\7\2\0\3\7\3\0"+
    "\7\7\2\0\1\134\2\7\1\0\1\7\1\0\1\7"+
    "\2\0\3\7\5\0\2\7\2\0\3\7\5\0\1\7"+
    "\15\0\1\135\43\0\3\7\3\0\3\7\1\136\3\7"+
    "\2\0\3\7\1\0\1\7\1\0\1\7\2\0\3\7"+
    "\5\0\2\7\2\0\3\7\5\0\1\7\2\0\3\7"+
    "\3\0\7\7\2\0\1\137\2\7\1\0\1\7\1\0"+
    "\1\7\2\0\3\7\5\0\2\7\2\0\3\7\5\0"+
    "\1\7\2\0\3\7\3\0\2\7\1\140\4\7\2\0"+
    "\3\7\1\0\1\7\1\0\1\7\2\0\3\7\5\0"+
    "\2\7\2\0\3\7\5\0\1\7\2\0\3\7\3\0"+
    "\7\7\2\0\1\141\2\7\1\0\1\7\1\0\1\7"+
    "\2\0\3\7\5\0\2\7\2\0\3\7\5\0\1\7"+
    "\2\0\3\7\3\0\6\7\1\142\2\0\3\7\1\0"+
    "\1\7\1\0\1\7\2\0\3\7\5\0\2\7\2\0"+
    "\3\7\5\0\1\7\2\0\3\7\3\0\7\7\2\0"+
    "\3\7\1\0\1\7\1\0\1\7\2\0\1\143\2\7"+
    "\5\0\2\7\2\0\3\7\5\0\1\7\2\0\3\7"+
    "\3\0\7\7\2\0\1\7\1\144\1\7\1\0\1\7"+
    "\1\0\1\7\2\0\3\7\5\0\2\7\2\0\3\7"+
    "\5\0\1\7\2\0\3\7\3\0\7\7\2\0\3\7"+
    "\1\0\1\7\1\0\1\7\2\0\1\145\2\7\5\0"+
    "\2\7\2\0\3\7\5\0\1\7\56\0\1\146\2\0"+
    "\3\7\3\0\4\7\1\147\2\7\2\0\3\7\1\0"+
    "\1\7\1\0\1\7\2\0\3\7\5\0\2\7\2\0"+
    "\3\7\5\0\1\7\2\0\3\7\3\0\7\7\2\0"+
    "\3\7\1\0\1\7\1\0\1\150\2\0\3\7\5\0"+
    "\2\7\2\0\3\7\5\0\1\7\2\0\3\7\3\0"+
    "\7\7\2\0\3\7\1\0\1\7\1\0\1\7\2\0"+
    "\1\7\1\151\1\7\5\0\2\7\2\0\3\7\5\0"+
    "\1\7\2\0\3\7\3\0\7\7\2\0\1\152\2\7"+
    "\1\0\1\7\1\0\1\7\2\0\3\7\5\0\2\7"+
    "\2\0\3\7\5\0\1\7\2\0\3\7\3\0\7\7"+
    "\2\0\3\7\1\0\1\7\1\0\1\7\2\0\3\7"+
    "\5\0\2\7\2\0\2\7\1\153\5\0\1\7\15\0"+
    "\1\154\43\0\3\7\3\0\5\7\1\155\1\7\2\0"+
    "\3\7\1\0\1\7\1\0\1\7\2\0\3\7\5\0"+
    "\2\7\2\0\3\7\5\0\1\7\14\0\1\156\44\0"+
    "\3\7\3\0\6\7\1\157\2\0\3\7\1\0\1\7"+
    "\1\0\1\7\2\0\3\7\5\0\2\7\2\0\3\7"+
    "\5\0\1\7\14\0\1\160\44\0\3\7\3\0\2\7"+
    "\1\161\4\7\2\0\3\7\1\0\1\7\1\0\1\7"+
    "\2\0\3\7\5\0\2\7\2\0\3\7\5\0\1\7"+
    "\14\0\1\162\42\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[2961];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\4\0\1\11\3\1\1\11\13\1\1\11\1\1\1\11"+
    "\1\1\1\11\1\1\5\11\1\1\2\11\2\1\5\11"+
    "\2\1\2\11\1\1\4\11\11\1\2\11\5\1\2\11"+
    "\4\1\5\11\1\0\1\11\15\1\1\0\10\1\1\0"+
    "\5\1\1\0\1\1\1\0\1\1\1\0\1\1\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[114];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the textposition at the last state to be included in yytext */
  private int zzPushbackPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /* user code: */
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

public Yylex(java.io.InputStream s, ErrorMsg e) {
  this(s);
  errorMsg=e;
}



  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  Yylex(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  Yylex(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzPushbackPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead < 0) {
      return true;
    }
    else {
      zzEndRead+= numRead;
      return false;
    }
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = zzPushbackPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      yychar+= zzMarkedPosL-zzStartRead;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = zzLexicalState;


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 5: 
          { str.setLength(0); yybegin(STRING);
          }
        case 61: break;
        case 57: 
          { return tok(sym.WHILE, null);
          }
        case 62: break;
        case 16: 
          { return tok(sym.LPAREN, null);
          }
        case 63: break;
        case 14: 
          { return tok(sym.COMMA, null);
          }
        case 64: break;
        case 59: 
          { return tok(sym.FUNCTION, null);
          }
        case 65: break;
        case 24: 
          { return tok(sym.RBRACE, null);
          }
        case 66: break;
        case 51: 
          { return tok(sym.VAR, null);
          }
        case 67: break;
        case 33: 
          { return tok(sym.IF, null);
          }
        case 68: break;
        case 31: 
          { err("Comment Matching Error!");
          }
        case 69: break;
        case 27: 
          { yybegin(STRINGIN);
          }
        case 70: break;
        case 56: 
          { return tok(sym.ARRAY, null);
          }
        case 71: break;
        case 28: 
          { err("\\ in string matching error!");
          }
        case 72: break;
        case 58: 
          { return tok(sym.BREAK, null);
          }
        case 73: break;
        case 32: 
          { return tok(sym.TO, null);
          }
        case 74: break;
        case 19: 
          { return tok(sym.LBRACK, null);
          }
        case 75: break;
        case 37: 
          { return tok(sym.ASSIGN, null);
          }
        case 76: break;
        case 36: 
          { return tok(sym.GE, null);
          }
        case 77: break;
        case 40: 
          { return tok(sym.LE, null);
          }
        case 78: break;
        case 35: 
          { return tok(sym.OF, null);
          }
        case 79: break;
        case 54: 
          { return tok(sym.ELSE, null);
          }
        case 80: break;
        case 49: 
          { return tok(sym.END, null);
          }
        case 81: break;
        case 17: 
          { return tok(sym.RPAREN, null);
          }
        case 82: break;
        case 50: 
          { return tok(sym.LET, null);
          }
        case 83: break;
        case 45: 
          { str.append('\t');
          }
        case 84: break;
        case 10: 
          { return tok(sym.OR, null);
          }
        case 85: break;
        case 41: 
          { comNum++;
          }
        case 86: break;
        case 3: 
          { return tok(sym.ID, yytext());
          }
        case 87: break;
        case 52: 
          { return tok(sym.TYPE, null);
          }
        case 88: break;
        case 34: 
          { return tok(sym.IN, null);
          }
        case 89: break;
        case 9: 
          { return tok(sym.COLON, null);
          }
        case 90: break;
        case 18: 
          { return tok(sym.SEMICOLON, null);
          }
        case 91: break;
        case 13: 
          { return tok(sym.MINUS, null);
          }
        case 92: break;
        case 42: 
          { comNum--;
  if (comNum==0) {
    yybegin(YYINITIAL);
  }
          }
        case 93: break;
        case 46: 
          { str.append('\\');
          }
        case 94: break;
        case 6: 
          { return tok(sym.DIVIDE, null);
          }
        case 95: break;
        case 20: 
          { return tok(sym.RBRACK, null);
          }
        case 96: break;
        case 53: 
          { return tok(sym.THEN, null);
          }
        case 97: break;
        case 29: 
          { yybegin(STRING);
          }
        case 98: break;
        case 21: 
          { return tok(sym.AND, null);
          }
        case 99: break;
        case 22: 
          { return tok(sym.PLUS, null);
          }
        case 100: break;
        case 8: 
          { return tok(sym.GT, null);
          }
        case 101: break;
        case 48: 
          { return tok(sym.NIL, null);
          }
        case 102: break;
        case 23: 
          { return tok(sym.LBRACE, null);
          }
        case 103: break;
        case 12: 
          { return tok(sym.LT, null);
          }
        case 104: break;
        case 7: 
          { return tok(sym.TIMES, null);
          }
        case 105: break;
        case 1: 
          { err("Character error!");
          }
        case 106: break;
        case 43: 
          { str.append('\"');
          }
        case 107: break;
        case 4: 
          { return tok(sym.INT, new Integer(yytext()));
          }
        case 108: break;
        case 30: 
          { comNum=1; yybegin(COMMENT);
          }
        case 109: break;
        case 55: 
          { return tok(sym.error, null);
          }
        case 110: break;
        case 26: 
          { yybegin(YYINITIAL); 
  return tok(sym.STRING, str.toString());
          }
        case 111: break;
        case 25: 
          { str.append(yytext());
          }
        case 112: break;
        case 38: 
          { return tok(sym.DO, null);
          }
        case 113: break;
        case 11: 
          { return tok(sym.EQ, null);
          }
        case 114: break;
        case 60: 
          { int tmp=Integer.parseInt(yytext().substring(1, 4));
  if (tmp>255) err("exceed \\ddd");
  else str.append((char)tmp);
          }
        case 115: break;
        case 15: 
          { return tok(sym.DOT, null);
          }
        case 116: break;
        case 39: 
          { return tok(sym.NEQ, null);
          }
        case 117: break;
        case 47: 
          { return tok(sym.FOR, null);
          }
        case 118: break;
        case 44: 
          { str.append('\n');
          }
        case 119: break;
        case 2: 
          { 
          }
        case 120: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
              {   {
    if (yystate()==COMMENT) err("Comment Error!");
    if (yystate()==STRING) err("String Error!");
    if (yystate()==STRINGIN) err("String in Error!");
    return tok(sym.EOF, null);
  }
 }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
