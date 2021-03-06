
//----------------------------------------------------
// The following code was generated by CUP v0.11a beta 20060608
// Sat Mar 28 23:01:38 CST 2020
//----------------------------------------------------

package analizadores;

import java_cup.runtime.Symbol;

/** CUP v0.11a beta 20060608 generated parser.
  * @version Sat Mar 28 23:01:38 CST 2020
  */
public class AnalizadorSintacticoJugador extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public AnalizadorSintacticoJugador() {super();}

  /** Constructor which sets the default scanner. */
  public AnalizadorSintacticoJugador(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public AnalizadorSintacticoJugador(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\003\000\002\002\004\000\002\002\003\000\002\002" +
    "\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\005\000\006\003\004\004\005\001\002\000\004\002" +
    "\uffff\001\002\000\004\002\000\001\002\000\004\002\007" +
    "\001\002\000\004\002\001\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\005\000\004\002\005\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$AnalizadorSintacticoJugador$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$AnalizadorSintacticoJugador$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$AnalizadorSintacticoJugador$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



    private boolean completo;

    public void setCompleto(boolean completo){
        this.completo = completo;
    }

    public boolean getCompleto(){
        return completo;
    }
    
    private Symbol s;
    public void syntaxError(Symbol s){
        this.s = s;
    }
    public Symbol getS(Symbol s){
        return this.s = s;
    }

    public void setAccion(String tipo,String mensaje,String accion){
            System.out.println(tipo+"         "+mensaje);
        }

    public void syntax_error(Symbol s){
            if(s!=null){
                //Error e = new Error((String) s.value, "Sintactico", "Error Sintaxis token: " + s.right + " " + s.left + " " + s.value, s.right, s.left);
            
                //escribirErrores(e);
                setAccion("ERROR","Error Sintaxis token: " + (s.right+1) + " " + (s.left+1) + " " + s.value, "");
            }
    }


}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$AnalizadorSintacticoJugador$actions {


    private boolean completo;

  private final AnalizadorSintacticoJugador parser;

  /** Constructor */
  CUP$AnalizadorSintacticoJugador$actions(AnalizadorSintacticoJugador parser) {
    this.parser = parser;
  }

  /** Method with the actual generated action code. */
  public final java_cup.runtime.Symbol CUP$AnalizadorSintacticoJugador$do_action(
    int                        CUP$AnalizadorSintacticoJugador$act_num,
    java_cup.runtime.lr_parser CUP$AnalizadorSintacticoJugador$parser,
    java.util.Stack            CUP$AnalizadorSintacticoJugador$stack,
    int                        CUP$AnalizadorSintacticoJugador$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$AnalizadorSintacticoJugador$result;

      /* select the action based on the action number */
      switch (CUP$AnalizadorSintacticoJugador$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // INICIO ::= error 
            {
              Object RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoJugador$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoJugador$stack.peek()).right;
		Object e = (Object)((java_cup.runtime.Symbol) CUP$AnalizadorSintacticoJugador$stack.peek()).value;
		parser.syntax_error((Symbol)e); completo = false; parser.setCompleto(completo);
              CUP$AnalizadorSintacticoJugador$result = parser.getSymbolFactory().newSymbol("INICIO",0, ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoJugador$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoJugador$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintacticoJugador$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // INICIO ::= NOMBRE 
            {
              Object RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoJugador$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoJugador$stack.peek()).right;
		Object a = (Object)((java_cup.runtime.Symbol) CUP$AnalizadorSintacticoJugador$stack.peek()).value;
		 System.out.println((String) a); completo = true; parser.setCompleto(completo);
              CUP$AnalizadorSintacticoJugador$result = parser.getSymbolFactory().newSymbol("INICIO",0, ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoJugador$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoJugador$stack.peek()), RESULT);
            }
          return CUP$AnalizadorSintacticoJugador$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= INICIO EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoJugador$stack.elementAt(CUP$AnalizadorSintacticoJugador$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoJugador$stack.elementAt(CUP$AnalizadorSintacticoJugador$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$AnalizadorSintacticoJugador$stack.elementAt(CUP$AnalizadorSintacticoJugador$top-1)).value;
		RESULT = start_val;
              CUP$AnalizadorSintacticoJugador$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoJugador$stack.elementAt(CUP$AnalizadorSintacticoJugador$top-1)), ((java_cup.runtime.Symbol)CUP$AnalizadorSintacticoJugador$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$AnalizadorSintacticoJugador$parser.done_parsing();
          return CUP$AnalizadorSintacticoJugador$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
}

