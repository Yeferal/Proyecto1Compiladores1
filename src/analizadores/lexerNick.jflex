package analizadores;
import java_cup.runtime.*;

%%
%{
    //coidgo de usuario en sintaxis java
%}

    //directivas
%public 
%class AnalizadorLexicoNick
%cupsym SimbolosNick
%cup
%char
%column
%full
//%ignorecase
%line
%unicode

    //expreciones regulares
Letra           = [a-zA-Z]
Espacio         = [ \t\r\n]+
Nick            = {Letra} {Letra}? {Letra}?
%%

<YYINITIAL> {
    {Espacio}                       {/*Ignore*/}
    {Nick}                          {System.out.println("NickName: "+yytext()); return new Symbol(SimbolosNick.NICK , yycolumn, yyline, yytext());}
    .                               {System.out.println("error Lexico: "+"Columna: "+yycolumn+1+" linea: "+ yyline+1 + "Token: "+yytext());
                                        return new Symbol(SimbolosJugador.ERR , yycolumn, yyline, yytext());
                                    }
    
}

