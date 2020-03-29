package analizadores;
import java_cup.runtime.*;

%%
%{
    //coidgo de usuario en sintaxis java
%}

    //directivas
%public 
%class AnalizadorLexicoJugador
%cupsym SimbolosJugador
%cup
%char
%column
%full
%line
%unicode

    //expreciones regulares
Letra           = [a-zA-Z]
Digito          = [0-9]
Numero          = {Digito}
Espacio         = [ \t\r\n]+
Nombre          = {Letra} ({Numero}|{Letra})? ({Numero}|{Letra})? ({Numero}|{Letra})? ({Numero}|{Letra})? ({Numero}|{Letra})? ({Numero}|{Letra})? ({Numero}|{Letra})? ({Numero}|{Letra})? ({Numero}|{Letra})?
%%

<YYINITIAL> {
    {Espacio}                       {/*Ignore*/}
    {Nombre}                        {System.out.println("NickName: "+yytext()); return new Symbol(SimbolosJugador.NOMBRE , yycolumn, yyline, yytext());}
    .                               {System.out.println("error Lexico: "+"Columna: "+yycolumn+1+" linea: "+ yyline+1 + "Token: "+yytext()); 
                                     return new Symbol(SimbolosJugador.ERR , yycolumn, yyline, yytext());
                                    }
    
}
