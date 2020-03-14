package analizadores;
import java_cup.runtime.*;

%%
%{
    //coidgo de usuario en sintaxis java
%}

    //directivas
%public 
%class AnalizadorLexico
%cupsym Simbolos
%cup
%char
%column
%full
//%ignorecase
%line
%unicode

    //expreciones regulares

Caracteres      = [-_$]
Letra           = [a-zA-Z]
Palabra         = {Letra} {Letra}*
Digito          = [0-9]
Numero          = {Digito} {Digito}*
Espacio         = [ \t\r\n]+
Texto           = ({Palabra}|{Numero}|{Caracteres})+
Nick            = {Letra} {Letra}? {Letra}?
%%


MAPA                    {System.out.println("MAPA"); return new Symbol(Simbolos.MAPA , yycolumn, yyline, yytext());}
PLANETAS                {System.out.println("PLANETAS"); return new Symbol(Simbolos.PLANETAS , yycolumn, yyline, yytext());}
PLANETAS_NEUTRALES      {System.out.println("PLANETAS_NEUTRALES"); return new Symbol(Simbolos.PLANETAS_NEUTRALES , yycolumn, yyline, yytext());}
JUGADORES               {System.out.println("JUGADORES"); return new Symbol(Simbolos.JUGADORES , yycolumn, yyline, yytext());}
id                      {System.out.println("ID"); return new Symbol(Simbolos.ID , yycolumn, yyline, yytext());}

filas                   {System.out.println("FILAS"); return new Symbol(Simbolos.FILAS , yycolumn, yyline, yytext());}
columnas                {System.out.println("COLUMNAS"); return new Symbol(Simbolos.COLUMNAS , yycolumn, yyline, yytext());}
alAzar                  {System.out.println("ALAZAR"); return new Symbol(Simbolos.ALAZAR , yycolumn, yyline, yytext());}
planetasNeutrales       {System.out.println("PLANET_NEU"); return new Symbol(Simbolos.PLANET_NEU , yycolumn, yyline, yytext());}
mapaCiego               {System.out.println("MAPA_CIEGO"); return new Symbol(Simbolos.MAPA_CIEGO , yycolumn, yyline, yytext());}
acumular                {System.out.println("ACUMULAR"); return new Symbol(Simbolos.ACUMULAR , yycolumn, yyline, yytext());}
NEUTRALES               {System.out.println("NEUTRALES"); return new Symbol(Simbolos.NEUTRALES , yycolumn, yyline, yytext());}
mostrarNaves            {System.out.println("MOSTRAR_NAVES"); return new Symbol(Simbolos.MOSTRAR_NAVES , yycolumn, yyline, yytext());}
mostrarEstadisticas     {System.out.println("MOSTRAR_ESTADISTICAS"); return new Symbol(Simbolos.MOSTRAR_ESTADISTICAS , yycolumn, yyline, yytext());}
produccion              {System.out.println("PRODUCCION"); return new Symbol(Simbolos.PRODUCCION , yycolumn, yyline, yytext());}
finalizacion            {System.out.println("FINALIZACION"); return new Symbol(Simbolos.FINALIZACION , yycolumn, yyline, yytext());}

nombre                  {System.out.println("NOMBRE"); return new Symbol(Simbolos.NOMBRE , yycolumn, yyline, yytext());}
naves                   {System.out.println("NAVES"); return new Symbol(Simbolos.NAVES , yycolumn, yyline, yytext());}
porcentajeMuertes       {System.out.println("PORCENTAJE_MUERTES"); return new Symbol(Simbolos.PORCENTAJE_MUERTES , yycolumn, yyline, yytext());}
planetas                {System.out.println("PLANETAS_JUGADOR"); return new Symbol(Simbolos.PLANETAS_JUGADOR , yycolumn, yyline, yytext());}
tipo                    {System.out.println("TIPO"); return new Symbol(Simbolos.TIPO , yycolumn, yyline, yytext());}
HUMANO                  {System.out.println("HUMANO"); return new Symbol(Simbolos.HUMANO , yycolumn, yyline, yytext());}
FACIL                   {System.out.println("FACIL"); return new Symbol(Simbolos.FACIL , yycolumn, yyline, yytext());}
DIFICIL                 {System.out.println("DIFICIL"); return new Symbol(Simbolos.DIFICIL , yycolumn, yyline, yytext());}
true                    {System.out.println("TRUE"); return new Symbol(Simbolos.TRUE , yycolumn, yyline, yytext());}
false                   {System.out.println("FALSE"); return new Symbol(Simbolos.FALSE , yycolumn, yyline, yytext());}



<YYINITIAL> {
    {Espacio}                       {/*Ignore*/}
    "\""                            {System.out.println("comillas"); return new Symbol(Simbolos.COMILLAS , yycolumn, yyline, yytext());}
    "tamano"                {System.out.println("TAMANO"); return new Symbol(Simbolos.TAMANO , yycolumn, yyline, yytext());}
    ("_"|"$"|{Letra})({Texto})*     {System.out.println("id: "+yytext()); return new Symbol(Simbolos.IDENTIFICADOR , yycolumn, yyline, yytext());}
    
    ({Numero}|{Numero}"."{Numero})  {System.out.println("NUMERO: "+yytext()); return new Symbol(Simbolos.NUMERO , yycolumn, yyline, yytext());}

    {Nick}                          {System.out.println("nick name: "+yytext()); return new Symbol(Simbolos.NICK_NAME , yycolumn, yyline, yytext());}

    {Texto}                         {System.out.println("texto: "+yytext()); return new Symbol(Simbolos.PALABRA , yycolumn, yyline, yytext());}
    ":"                             {System.out.println("dos puntos"); return new Symbol(Simbolos.DOS_PUNTOS , yycolumn, yyline, yytext());}
    "["                             {System.out.println("CHORCHETE ABRE"); return new Symbol(Simbolos.CORCHE_A , yycolumn, yyline, yytext());}
    "]"                             {System.out.println("CORCHE CIERRE"); return new Symbol(Simbolos.CORCHE_C , yycolumn, yyline, yytext());}
    "{"                             {System.out.println("LLAVES ABRE"); return new Symbol(Simbolos.LLAVES_A , yycolumn, yyline, yytext());}
    "}"                             {System.out.println("LLAVES CIEERRE"); return new Symbol(Simbolos.LLAVES_C , yycolumn, yyline, yytext());}
    ","                             {System.out.println("COMA"); return new Symbol(Simbolos.COMA , yycolumn, yyline, yytext());}
    .                               {System.out.println("error: "+"Columna: "+yycolumn+1+" linea: "+ yyline+1);}
    
}
