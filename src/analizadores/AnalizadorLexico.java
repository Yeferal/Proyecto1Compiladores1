/* The following code was generated by JFlex 1.4.3 on 26/03/20 06:10 PM */

package analizadores;
import java_cup.runtime.*;
import objetos.Error;
import java.util.ArrayList;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 26/03/20 06:10 PM from the specification file
 * <tt>Lexer.jflex</tt>
 */
public class AnalizadorLexico implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\4\1\57\2\0\1\4\22\0\1\4\1\0\1\56\1\0"+
    "\1\2\7\0\1\66\1\1\1\60\1\0\12\3\1\61\6\0\1\6"+
    "\1\2\1\44\1\22\1\12\1\54\1\21\1\53\1\55\1\20\1\2"+
    "\1\10\1\5\1\11\1\23\1\7\1\2\1\17\1\14\1\13\1\16"+
    "\5\2\1\62\1\0\1\63\1\0\1\15\1\0\1\30\1\51\1\32"+
    "\1\25\1\42\1\26\1\45\1\2\1\24\1\52\1\2\1\27\1\35"+
    "\1\36\1\33\1\41\1\2\1\40\1\31\1\43\1\34\1\46\3\2"+
    "\1\37\1\64\1\0\1\65\63\0\1\50\21\0\1\47\uff3c\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\4\1\5\17\3\1\6"+
    "\1\7\1\10\1\11\1\12\1\13\1\14\1\0\5\3"+
    "\1\15\21\3\1\4\27\3\1\16\21\3\1\17\1\3"+
    "\1\20\6\3\1\21\1\3\1\22\5\3\1\23\4\3"+
    "\1\0\1\3\1\0\1\3\1\24\5\3\1\25\4\3"+
    "\1\26\3\3\2\27\1\0\1\30\3\3\1\31\10\3"+
    "\1\32\1\33\3\3\1\34\1\35\3\3\1\36\3\3"+
    "\1\37\1\40\1\3\1\41\13\3\1\42\7\3\1\43"+
    "\1\44\25\3\1\45\1\46\1\47\1\3\1\50";

  private static int [] zzUnpackAction() {
    int [] result = new int[216];
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
    "\0\0\0\67\0\156\0\245\0\334\0\u0113\0\u014a\0\u0181"+
    "\0\u01b8\0\u01ef\0\u0226\0\u025d\0\u0294\0\u02cb\0\u0302\0\u0339"+
    "\0\u0370\0\u03a7\0\u03de\0\u0415\0\u044c\0\67\0\67\0\67"+
    "\0\67\0\67\0\67\0\67\0\u0483\0\u04ba\0\u04f1\0\u0528"+
    "\0\u055f\0\u0596\0\245\0\u05cd\0\u0604\0\u063b\0\u0672\0\u06a9"+
    "\0\u06e0\0\u0717\0\u074e\0\u0785\0\u07bc\0\u07f3\0\u082a\0\u0861"+
    "\0\u0898\0\u08cf\0\u0906\0\u093d\0\u0483\0\u0974\0\u09ab\0\u09e2"+
    "\0\u0a19\0\u0a50\0\u0a87\0\u0abe\0\u0af5\0\u0b2c\0\u0b63\0\u0b9a"+
    "\0\u0bd1\0\u0c08\0\u0c3f\0\u0c76\0\u0cad\0\u0ce4\0\u0d1b\0\u0d52"+
    "\0\u0d89\0\u0dc0\0\u0df7\0\u0e2e\0\245\0\u0e65\0\u0e9c\0\u0ed3"+
    "\0\u0f0a\0\u0f41\0\u0f78\0\u0faf\0\u0fe6\0\u101d\0\u1054\0\u108b"+
    "\0\u10c2\0\u10f9\0\u1130\0\u1167\0\u119e\0\u11d5\0\245\0\u120c"+
    "\0\245\0\u1243\0\u127a\0\u12b1\0\u12e8\0\u131f\0\u1356\0\245"+
    "\0\u138d\0\245\0\u13c4\0\u13fb\0\u1432\0\u1469\0\u14a0\0\245"+
    "\0\u14d7\0\u150e\0\u1545\0\u157c\0\u15b3\0\u15ea\0\u1621\0\u1658"+
    "\0\245\0\u168f\0\u16c6\0\u16fd\0\u1734\0\u176b\0\245\0\u17a2"+
    "\0\u17d9\0\u1810\0\u1847\0\245\0\u187e\0\u18b5\0\u18ec\0\67"+
    "\0\245\0\u1923\0\245\0\u195a\0\u1991\0\u19c8\0\245\0\u19ff"+
    "\0\u1a36\0\u1a6d\0\u1aa4\0\u1adb\0\u1b12\0\u1b49\0\u1b80\0\67"+
    "\0\u1bb7\0\u1bee\0\u1c25\0\u1c5c\0\245\0\245\0\u1c93\0\u1cca"+
    "\0\u1d01\0\u1d38\0\u1d6f\0\u1da6\0\u1ddd\0\245\0\245\0\u1e14"+
    "\0\245\0\u1e4b\0\u1e82\0\u1eb9\0\u1ef0\0\u1f27\0\u1f5e\0\u1f95"+
    "\0\u1fcc\0\u2003\0\u203a\0\u2071\0\245\0\u20a8\0\u20df\0\u2116"+
    "\0\u214d\0\u2184\0\u21bb\0\u21f2\0\245\0\245\0\u2229\0\u2260"+
    "\0\u2297\0\u22ce\0\u2305\0\u233c\0\u2373\0\u23aa\0\u23e1\0\u2418"+
    "\0\u244f\0\u2486\0\u24bd\0\u24f4\0\u252b\0\u2562\0\u2599\0\u25d0"+
    "\0\u2607\0\u263e\0\u2675\0\245\0\245\0\245\0\u26ac\0\245";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[216];
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
    "\1\2\1\3\1\4\1\5\1\6\1\7\1\4\1\10"+
    "\1\4\1\11\6\4\1\12\1\4\1\13\1\4\1\14"+
    "\1\4\1\15\1\4\1\16\1\4\1\17\2\4\1\20"+
    "\1\21\2\4\1\22\1\4\1\23\3\4\2\2\2\4"+
    "\1\24\1\25\1\4\1\26\1\6\1\2\1\27\1\30"+
    "\1\31\1\32\1\33\1\34\70\0\3\3\1\0\42\3"+
    "\2\0\5\3\12\0\3\4\1\0\42\4\2\0\5\4"+
    "\12\0\2\3\1\5\1\0\42\3\2\0\5\3\2\0"+
    "\1\35\12\0\1\6\52\0\1\6\10\0\3\4\1\0"+
    "\1\4\1\36\40\4\2\0\5\4\12\0\3\4\1\0"+
    "\3\4\1\37\36\4\2\0\5\4\12\0\3\4\1\0"+
    "\5\4\1\40\34\4\2\0\5\4\12\0\3\4\1\0"+
    "\11\4\1\41\30\4\2\0\5\4\12\0\3\4\1\0"+
    "\42\4\2\0\4\4\1\42\12\0\3\4\1\0\20\4"+
    "\1\43\21\4\2\0\5\4\12\0\3\4\1\0\17\4"+
    "\1\44\3\4\1\45\16\4\2\0\5\4\12\0\3\4"+
    "\1\0\22\4\1\46\2\4\1\47\14\4\2\0\5\4"+
    "\12\0\3\4\1\0\26\4\1\50\13\4\2\0\5\4"+
    "\12\0\3\4\1\0\23\4\1\51\2\4\1\52\13\4"+
    "\2\0\5\4\12\0\3\4\1\0\23\4\1\53\2\4"+
    "\1\54\13\4\2\0\5\4\12\0\3\4\1\0\22\4"+
    "\1\55\3\4\1\56\4\4\1\57\6\4\2\0\5\4"+
    "\12\0\3\4\1\0\17\4\1\60\3\4\1\61\7\4"+
    "\1\62\6\4\2\0\5\4\12\0\3\4\1\0\11\4"+
    "\1\63\30\4\2\0\5\4\12\0\3\4\1\0\1\4"+
    "\1\64\40\4\2\0\5\4\14\0\1\65\64\0\3\4"+
    "\1\0\2\4\1\66\37\4\2\0\5\4\12\0\3\4"+
    "\1\0\1\4\1\67\40\4\2\0\5\4\12\0\3\4"+
    "\1\0\11\4\1\70\30\4\2\0\5\4\12\0\3\4"+
    "\1\0\14\4\1\71\25\4\2\0\5\4\12\0\3\4"+
    "\1\0\42\4\2\0\3\4\1\72\1\4\12\0\3\4"+
    "\1\0\22\4\1\73\6\4\1\74\10\4\2\0\5\4"+
    "\12\0\3\4\1\0\22\4\1\75\17\4\2\0\5\4"+
    "\12\0\3\4\1\0\1\4\1\76\40\4\2\0\5\4"+
    "\12\0\3\4\1\0\27\4\1\77\12\4\2\0\5\4"+
    "\12\0\3\4\1\0\22\4\1\100\17\4\2\0\5\4"+
    "\12\0\3\4\1\0\34\4\1\101\5\4\2\0\5\4"+
    "\12\0\3\4\1\0\24\4\1\102\15\4\2\0\5\4"+
    "\12\0\3\4\1\0\41\4\1\103\2\0\5\4\12\0"+
    "\3\4\1\0\30\4\1\104\11\4\2\0\5\4\12\0"+
    "\3\4\1\0\23\4\1\105\16\4\2\0\5\4\12\0"+
    "\3\4\1\0\33\4\1\106\6\4\2\0\5\4\12\0"+
    "\3\4\1\0\26\4\1\107\13\4\2\0\5\4\12\0"+
    "\3\4\1\0\34\4\1\110\5\4\2\0\5\4\12\0"+
    "\3\4\1\0\30\4\1\111\11\4\2\0\5\4\12\0"+
    "\3\4\1\0\27\4\1\112\12\4\2\0\5\4\12\0"+
    "\3\4\1\0\1\113\41\4\2\0\5\4\12\0\3\4"+
    "\1\0\37\4\1\114\2\4\2\0\5\4\12\0\3\4"+
    "\1\0\1\4\1\115\40\4\2\0\5\4\12\0\3\4"+
    "\1\0\4\4\1\116\35\4\2\0\5\4\12\0\3\4"+
    "\1\0\6\4\1\117\33\4\2\0\5\4\12\0\3\4"+
    "\1\0\1\4\1\120\40\4\2\0\5\4\12\0\3\4"+
    "\1\0\42\4\2\0\4\4\1\121\12\0\3\4\1\0"+
    "\23\4\1\122\16\4\2\0\5\4\12\0\3\4\1\0"+
    "\23\4\1\123\16\4\2\0\5\4\12\0\3\4\1\0"+
    "\24\4\1\124\15\4\2\0\5\4\12\0\3\4\1\0"+
    "\32\4\1\125\7\4\2\0\5\4\12\0\3\4\1\0"+
    "\30\4\1\126\11\4\2\0\5\4\12\0\3\4\1\0"+
    "\27\4\1\127\12\4\2\0\5\4\12\0\3\4\1\0"+
    "\23\4\1\130\16\4\2\0\5\4\12\0\3\4\1\0"+
    "\36\4\1\131\3\4\2\0\5\4\12\0\3\4\1\0"+
    "\35\4\1\132\4\4\2\0\5\4\12\0\3\4\1\0"+
    "\42\4\2\0\1\133\4\4\12\0\3\4\1\0\31\4"+
    "\1\134\10\4\2\0\5\4\12\0\3\4\1\0\25\4"+
    "\1\135\14\4\2\0\5\4\12\0\3\4\1\0\20\4"+
    "\1\136\21\4\2\0\5\4\12\0\3\4\1\0\26\4"+
    "\1\137\13\4\2\0\5\4\12\0\3\4\1\0\23\4"+
    "\1\140\16\4\2\0\5\4\12\0\3\4\1\0\35\4"+
    "\1\141\4\4\2\0\5\4\12\0\3\4\1\0\1\4"+
    "\1\142\40\4\2\0\5\4\12\0\3\4\1\0\42\4"+
    "\2\0\4\4\1\143\12\0\3\4\1\0\5\4\1\144"+
    "\34\4\2\0\5\4\12\0\3\4\1\0\12\4\1\145"+
    "\27\4\2\0\5\4\12\0\3\4\1\0\15\4\1\146"+
    "\24\4\2\0\5\4\12\0\3\4\1\0\37\4\1\147"+
    "\2\4\2\0\5\4\12\0\3\4\1\0\24\4\1\150"+
    "\15\4\2\0\5\4\12\0\3\4\1\0\22\4\1\151"+
    "\17\4\2\0\5\4\12\0\3\4\1\0\35\4\1\152"+
    "\4\4\2\0\5\4\12\0\3\4\1\0\23\4\1\153"+
    "\16\4\2\0\5\4\12\0\3\4\1\0\27\4\1\154"+
    "\12\4\2\0\5\4\12\0\3\4\1\0\30\4\1\155"+
    "\11\4\2\0\5\4\12\0\3\4\1\0\37\4\1\156"+
    "\2\4\2\0\5\4\12\0\3\4\1\0\33\4\1\157"+
    "\6\4\2\0\5\4\12\0\3\4\1\0\24\4\1\160"+
    "\15\4\2\0\5\4\12\0\3\4\1\0\33\4\1\161"+
    "\6\4\2\0\5\4\12\0\3\4\1\0\35\4\1\162"+
    "\4\4\2\0\5\4\12\0\3\4\1\0\35\4\1\163"+
    "\4\4\2\0\5\4\12\0\3\4\1\0\27\4\1\164"+
    "\12\4\2\0\5\4\11\0\1\165\3\166\1\165\42\166"+
    "\1\167\1\165\5\166\1\165\1\0\7\165\1\0\3\4"+
    "\1\0\4\4\1\170\35\4\2\0\5\4\12\0\3\4"+
    "\1\0\3\4\1\171\36\4\2\0\5\4\12\0\3\4"+
    "\1\0\6\4\1\172\33\4\2\0\5\4\12\0\3\4"+
    "\1\0\1\4\1\173\40\4\2\0\5\4\12\0\3\4"+
    "\1\0\16\4\1\174\23\4\2\0\5\4\12\0\3\4"+
    "\1\0\42\4\2\0\4\4\1\175\12\0\3\4\1\0"+
    "\17\4\1\176\22\4\2\0\5\4\12\0\3\4\1\0"+
    "\33\4\1\177\6\4\2\0\5\4\12\0\3\4\1\0"+
    "\22\4\1\200\17\4\2\0\5\4\12\0\3\4\1\0"+
    "\31\4\1\201\10\4\2\0\5\4\12\0\3\4\1\0"+
    "\17\4\1\202\22\4\2\0\5\4\12\0\3\4\1\0"+
    "\23\4\1\203\16\4\2\0\5\4\12\0\3\4\1\0"+
    "\35\4\1\204\4\4\2\0\5\4\12\0\3\4\1\0"+
    "\36\4\1\205\3\4\2\0\5\4\12\0\3\4\1\0"+
    "\31\4\1\206\10\4\2\0\5\4\12\0\3\4\1\0"+
    "\25\4\1\207\14\4\2\0\5\4\44\0\1\210\34\0"+
    "\3\4\1\0\26\4\1\211\13\4\2\0\5\4\44\0"+
    "\1\210\14\0\1\212\17\0\3\4\1\0\16\4\1\213"+
    "\23\4\2\0\5\4\12\0\3\4\1\0\1\4\1\214"+
    "\40\4\2\0\5\4\12\0\3\4\1\0\3\4\1\215"+
    "\36\4\2\0\5\4\12\0\3\4\1\0\12\4\1\216"+
    "\27\4\2\0\5\4\12\0\3\4\1\0\3\4\1\217"+
    "\36\4\2\0\5\4\12\0\3\4\1\0\32\4\1\220"+
    "\7\4\2\0\5\4\12\0\3\4\1\0\23\4\1\221"+
    "\16\4\2\0\5\4\12\0\3\4\1\0\23\4\1\222"+
    "\16\4\2\0\5\4\12\0\3\4\1\0\35\4\1\223"+
    "\4\4\2\0\5\4\12\0\3\4\1\0\33\4\1\224"+
    "\6\4\2\0\5\4\12\0\3\4\1\0\23\4\1\225"+
    "\16\4\2\0\5\4\12\0\3\4\1\0\36\4\1\226"+
    "\3\4\2\0\5\4\12\0\3\4\1\0\25\4\1\227"+
    "\14\4\2\0\5\4\44\0\1\230\34\0\3\4\1\0"+
    "\7\4\1\231\32\4\2\0\5\4\12\0\3\4\1\0"+
    "\5\4\1\232\34\4\2\0\5\4\12\0\3\4\1\0"+
    "\5\4\1\233\34\4\2\0\5\4\12\0\3\4\1\0"+
    "\23\4\1\234\16\4\2\0\5\4\12\0\3\4\1\0"+
    "\33\4\1\235\6\4\2\0\5\4\12\0\3\4\1\0"+
    "\24\4\1\236\15\4\2\0\5\4\12\0\3\4\1\0"+
    "\40\4\1\237\1\4\2\0\5\4\12\0\3\4\1\0"+
    "\4\4\1\240\1\241\34\4\2\0\5\4\12\0\3\4"+
    "\1\0\24\4\1\242\15\4\2\0\5\4\12\0\3\4"+
    "\1\0\23\4\1\243\16\4\2\0\5\4\12\0\3\4"+
    "\1\0\17\4\1\244\22\4\2\0\5\4\12\0\3\4"+
    "\1\0\10\4\1\245\31\4\2\0\5\4\12\0\3\4"+
    "\1\0\7\4\1\246\32\4\2\0\5\4\12\0\3\4"+
    "\1\0\7\4\1\247\32\4\2\0\5\4\12\0\3\4"+
    "\1\0\25\4\1\250\14\4\2\0\5\4\12\0\3\4"+
    "\1\0\26\4\1\251\13\4\2\0\5\4\12\0\3\4"+
    "\1\0\23\4\1\252\16\4\2\0\5\4\12\0\3\4"+
    "\1\0\24\4\1\253\15\4\2\0\5\4\12\0\3\4"+
    "\1\0\4\4\1\254\35\4\2\0\5\4\12\0\3\4"+
    "\1\0\42\4\2\0\1\4\1\255\3\4\12\0\3\4"+
    "\1\0\26\4\1\256\13\4\2\0\5\4\12\0\3\4"+
    "\1\0\4\4\1\257\35\4\2\0\5\4\12\0\3\4"+
    "\1\0\17\4\1\260\22\4\2\0\5\4\12\0\3\4"+
    "\1\0\41\4\1\261\2\0\5\4\12\0\3\4\1\0"+
    "\36\4\1\262\3\4\2\0\5\4\12\0\3\4\1\0"+
    "\35\4\1\263\4\4\2\0\5\4\12\0\3\4\1\0"+
    "\35\4\1\264\4\4\2\0\5\4\12\0\3\4\1\0"+
    "\31\4\1\265\10\4\2\0\5\4\12\0\3\4\1\0"+
    "\5\4\1\266\34\4\2\0\5\4\12\0\3\4\1\0"+
    "\26\4\1\267\13\4\2\0\5\4\12\0\3\4\1\0"+
    "\35\4\1\270\4\4\2\0\5\4\12\0\3\4\1\0"+
    "\23\4\1\271\16\4\2\0\5\4\12\0\3\4\1\0"+
    "\27\4\1\272\12\4\2\0\5\4\12\0\3\4\1\0"+
    "\1\273\41\4\2\0\5\4\12\0\3\4\1\0\11\4"+
    "\1\274\30\4\2\0\5\4\12\0\3\4\1\0\31\4"+
    "\1\275\10\4\2\0\5\4\12\0\3\4\1\0\24\4"+
    "\1\276\15\4\2\0\5\4\12\0\3\4\1\0\20\4"+
    "\1\277\21\4\2\0\5\4\12\0\3\4\1\0\36\4"+
    "\1\300\3\4\2\0\5\4\12\0\3\4\1\0\27\4"+
    "\1\301\12\4\2\0\5\4\12\0\3\4\1\0\6\4"+
    "\1\302\33\4\2\0\5\4\12\0\3\4\1\0\17\4"+
    "\1\303\22\4\2\0\5\4\12\0\3\4\1\0\33\4"+
    "\1\304\6\4\2\0\5\4\12\0\3\4\1\0\35\4"+
    "\1\305\4\4\2\0\5\4\12\0\3\4\1\0\12\4"+
    "\1\306\27\4\2\0\5\4\12\0\3\4\1\0\24\4"+
    "\1\307\15\4\2\0\5\4\12\0\3\4\1\0\23\4"+
    "\1\310\16\4\2\0\5\4\12\0\3\4\1\0\33\4"+
    "\1\311\6\4\2\0\5\4\12\0\3\4\1\0\1\4"+
    "\1\312\40\4\2\0\5\4\12\0\3\4\1\0\36\4"+
    "\1\313\3\4\2\0\5\4\12\0\3\4\1\0\22\4"+
    "\1\314\17\4\2\0\5\4\12\0\3\4\1\0\36\4"+
    "\1\315\3\4\2\0\5\4\12\0\3\4\1\0\3\4"+
    "\1\316\36\4\2\0\5\4\12\0\3\4\1\0\17\4"+
    "\1\317\22\4\2\0\5\4\12\0\3\4\1\0\35\4"+
    "\1\320\4\4\2\0\5\4\12\0\3\4\1\0\35\4"+
    "\1\321\4\4\2\0\5\4\12\0\3\4\1\0\5\4"+
    "\1\322\34\4\2\0\5\4\12\0\3\4\1\0\25\4"+
    "\1\323\14\4\2\0\5\4\12\0\3\4\1\0\24\4"+
    "\1\324\15\4\2\0\5\4\12\0\3\4\1\0\24\4"+
    "\1\325\15\4\2\0\5\4\12\0\3\4\1\0\7\4"+
    "\1\326\32\4\2\0\5\4\12\0\3\4\1\0\23\4"+
    "\1\327\16\4\2\0\5\4\12\0\3\4\1\0\24\4"+
    "\1\330\15\4\2\0\5\4\11\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[9955];
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
    "\1\0\1\11\23\1\7\11\1\0\127\1\1\0\1\1"+
    "\1\0\20\1\1\11\1\1\1\0\15\1\1\11\100\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[216];
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

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
    //coidgo de usuario en sintaxis java
    ArrayList<Error> listaErrores = new  ArrayList<>();
    

public ArrayList<Error> getListaErrores(){
        return listaErrores;
    }



  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public AnalizadorLexico(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public AnalizadorLexico(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 158) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
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

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
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
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
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

    //throw new Error(message);
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
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
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

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn++;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


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
        case 34: 
          { System.out.println("PRODUCCION"); return new Symbol(Simbolos.PRODUCCION , yycolumn, yyline, yytext());
          }
        case 41: break;
        case 1: 
          { System.out.println("error Lexico: "+"Columna: "+yycolumn+1+" linea: "+ yyline+1 + "Token: "+yytext());
                                    Error error = new Error(yytext(), "Sintactico", "Error Sintaxis token: " + yyline+1 + " " + yycolumn+1 + " " + yytext(), yyline+1, yycolumn+1);
                                    listaErrores.add(error);
          }
        case 42: break;
        case 30: 
          { System.out.println("PLANETAS_JUGADOR"); return new Symbol(Simbolos.PLANETAS_JUGADOR , yycolumn, yyline, yytext());
          }
        case 43: break;
        case 29: 
          { System.out.println("COLUMNAS"); return new Symbol(Simbolos.COLUMNAS , yycolumn, yyline, yytext());
          }
        case 44: break;
        case 32: 
          { System.out.println("JUGADORES"); return new Symbol(Simbolos.JUGADORES , yycolumn, yyline, yytext());
          }
        case 45: break;
        case 28: 
          { System.out.println("ACUMULAR"); return new Symbol(Simbolos.ACUMULAR , yycolumn, yyline, yytext());
          }
        case 46: break;
        case 31: 
          { System.out.println("NEUTRALES"); return new Symbol(Simbolos.NEUTRALES , yycolumn, yyline, yytext());
          }
        case 47: break;
        case 14: 
          { System.out.println("MAPA"); return new Symbol(Simbolos.MAPA , yycolumn, yyline, yytext());
          }
        case 48: break;
        case 21: 
          { System.out.println("ALAZAR"); return new Symbol(Simbolos.ALAZAR , yycolumn, yyline, yytext());
          }
        case 49: break;
        case 26: 
          { System.out.println("TAMAÑO"); return new Symbol(Simbolos.TAMANO , yycolumn, yyline, yytext());
          }
        case 50: break;
        case 37: 
          { System.out.println("PLANET_NEU"); return new Symbol(Simbolos.PLANET_NEU , yycolumn, yyline, yytext());
          }
        case 51: break;
        case 2: 
          { System.out.println("texto: "+yytext()); return new Symbol(Simbolos.PALABRA , yycolumn, yyline, yytext());
          }
        case 52: break;
        case 6: 
          { System.out.println("comillas"); return new Symbol(Simbolos.COMILLAS , yycolumn, yyline, yytext());
          }
        case 53: break;
        case 25: 
          { System.out.println("DIFICIL"); return new Symbol(Simbolos.DIFICIL , yycolumn, yyline, yytext());
          }
        case 54: break;
        case 12: 
          { System.out.println("COMA"); return new Symbol(Simbolos.COMA , yycolumn, yyline, yytext());
          }
        case 55: break;
        case 39: 
          { System.out.println("PLANETAS_NEUTRALES"); return new Symbol(Simbolos.PLANETAS_NEUTRALES , yycolumn, yyline, yytext());
          }
        case 56: break;
        case 18: 
          { System.out.println("FALSE"); return new Symbol(Simbolos.FALSE , yycolumn, yyline, yytext());
          }
        case 57: break;
        case 40: 
          { System.out.println("MOSTRAR_ESTADISTICAS"); return new Symbol(Simbolos.MOSTRAR_ESTADISTICAS , yycolumn, yyline, yytext());
          }
        case 58: break;
        case 24: 
          { System.out.println("HUMANO"); return new Symbol(Simbolos.HUMANO , yycolumn, yyline, yytext());
          }
        case 59: break;
        case 20: 
          { System.out.println("FACIL"); return new Symbol(Simbolos.FACIL , yycolumn, yyline, yytext());
          }
        case 60: break;
        case 17: 
          { System.out.println("FILAS"); return new Symbol(Simbolos.FILAS , yycolumn, yyline, yytext());
          }
        case 61: break;
        case 13: 
          { System.out.println("ID"); return new Symbol(Simbolos.ID , yycolumn, yyline, yytext());
          }
        case 62: break;
        case 7: 
          { System.out.println("dos puntos"); return new Symbol(Simbolos.DOS_PUNTOS , yycolumn, yyline, yytext());
          }
        case 63: break;
        case 23: 
          { System.out.println("TAMANO"); return new Symbol(Simbolos.TAMANO , yycolumn, yyline, yytext());
          }
        case 64: break;
        case 3: 
          { System.out.println("id: "+yytext()); return new Symbol(Simbolos.IDENTIFICADOR , yycolumn, yyline, yytext());
          }
        case 65: break;
        case 10: 
          { System.out.println("LLAVES ABRE"); return new Symbol(Simbolos.LLAVES_A , yycolumn, yyline, yytext());
          }
        case 66: break;
        case 15: 
          { System.out.println("TIPO"); return new Symbol(Simbolos.TIPO , yycolumn, yyline, yytext());
          }
        case 67: break;
        case 9: 
          { System.out.println("CORCHE CIERRE"); return new Symbol(Simbolos.CORCHE_C , yycolumn, yyline, yytext());
          }
        case 68: break;
        case 36: 
          { System.out.println("MOSTRAR_NAVES"); return new Symbol(Simbolos.MOSTRAR_NAVES , yycolumn, yyline, yytext());
          }
        case 69: break;
        case 38: 
          { System.out.println("PORCENTAJE_MUERTES"); return new Symbol(Simbolos.PORCENTAJE_MUERTES , yycolumn, yyline, yytext());
          }
        case 70: break;
        case 16: 
          { System.out.println("TRUE"); return new Symbol(Simbolos.TRUE , yycolumn, yyline, yytext());
          }
        case 71: break;
        case 4: 
          { System.out.println("NUMERO: "+yytext()); return new Symbol(Simbolos.NUMERO , yycolumn, yyline, yytext());
          }
        case 72: break;
        case 8: 
          { System.out.println("CHORCHETE ABRE"); return new Symbol(Simbolos.CORCHE_A , yycolumn, yyline, yytext());
          }
        case 73: break;
        case 11: 
          { System.out.println("LLAVES CIEERRE"); return new Symbol(Simbolos.LLAVES_C , yycolumn, yyline, yytext());
          }
        case 74: break;
        case 22: 
          { System.out.println("NOMBRE"); return new Symbol(Simbolos.NOMBRE , yycolumn, yyline, yytext());
          }
        case 75: break;
        case 35: 
          { System.out.println("FINALIZACION"); return new Symbol(Simbolos.FINALIZACION , yycolumn, yyline, yytext());
          }
        case 76: break;
        case 5: 
          { /*Ignore*/
          }
        case 77: break;
        case 27: 
          { System.out.println("PLANETAS"); return new Symbol(Simbolos.PLANETAS , yycolumn, yyline, yytext());
          }
        case 78: break;
        case 19: 
          { System.out.println("NAVES"); return new Symbol(Simbolos.NAVES , yycolumn, yyline, yytext());
          }
        case 79: break;
        case 33: 
          { System.out.println("MAPA_CIEGO"); return new Symbol(Simbolos.MAPA_CIEGO , yycolumn, yyline, yytext());
          }
        case 80: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              { return new java_cup.runtime.Symbol(Simbolos.EOF); }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
