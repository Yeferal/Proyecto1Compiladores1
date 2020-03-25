package analizador.guardar;
import java_cup.runtime.*;

%%
%{
    //coidgo de usuario en sintaxis java
%}

    //directivas
%public 
%class AnalizadorLexicoG
%cupsym SimbolosG
%cup
%char
%line
%column
%full
//%ignorecase

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


MAPA                    {System.out.println("MAPA"); return new Symbol(SimbolosG.MAPA , yycolumn, yyline, yytext());}
PLANETAS                {System.out.println("PLANETAS"); return new Symbol(SimbolosG.PLANETAS , yycolumn, yyline, yytext());}
PLANETAS_NEUTRALES      {System.out.println("PLANETAS_NEUTRALES"); return new Symbol(SimbolosG.PLANETAS_NEUTRALES , yycolumn, yyline, yytext());}
JUGADORES               {System.out.println("JUGADORES"); return new Symbol(SimbolosG.JUGADORES , yycolumn, yyline, yytext());}
id                      {System.out.println("ID"); return new Symbol(SimbolosG.ID , yycolumn, yyline, yytext());}

FLOTAS                  {System.out.println("FLOTAS"); return new Symbol(SimbolosG.FLOTAS , yycolumn, yyline, yytext());}
MENSAJES                {System.out.println("MENSAJES"); return new Symbol(SimbolosG.MENSAJES , yycolumn, yyline, yytext());}

filas                   {System.out.println("FILAS"); return new Symbol(SimbolosG.FILAS , yycolumn, yyline, yytext());}
columnas                {System.out.println("COLUMNAS"); return new Symbol(SimbolosG.COLUMNAS , yycolumn, yyline, yytext());}
alAzar                  {System.out.println("ALAZAR"); return new Symbol(SimbolosG.ALAZAR , yycolumn, yyline, yytext());}
planetasNeutrales       {System.out.println("PLANET_NEU"); return new Symbol(SimbolosG.PLANET_NEU , yycolumn, yyline, yytext());}
mapaCiego               {System.out.println("MAPA_CIEGO"); return new Symbol(SimbolosG.MAPA_CIEGO , yycolumn, yyline, yytext());}
acumular                {System.out.println("ACUMULAR"); return new Symbol(SimbolosG.ACUMULAR , yycolumn, yyline, yytext());}
NEUTRALES               {System.out.println("NEUTRALES"); return new Symbol(SimbolosG.NEUTRALES , yycolumn, yyline, yytext());}
mostrarNaves            {System.out.println("MOSTRAR_NAVES"); return new Symbol(SimbolosG.MOSTRAR_NAVES , yycolumn, yyline, yytext());}
mostrarEstadisticas     {System.out.println("MOSTRAR_ESTADISTICAS"); return new Symbol(SimbolosG.MOSTRAR_ESTADISTICAS , yycolumn, yyline, yytext());}
produccion              {System.out.println("PRODUCCION"); return new Symbol(SimbolosG.PRODUCCION , yycolumn, yyline, yytext());}
finalizacion            {System.out.println("FINALIZACION"); return new Symbol(SimbolosG.FINALIZACION , yycolumn, yyline, yytext());}
navesEnviadas           {System.out.println("NAVES_ENVIADAS"); return new Symbol(SimbolosG.NAVES_ENVIADAS , yycolumn, yyline, yytext());}
jugadorPlaneta          {System.out.println("JUGADOR"); return new Symbol(SimbolosG.JUGADOR , yycolumn, yyline, yytext());}

tamaño                  {System.out.println("TAMAÑO"); return new Symbol(SimbolosG.TAMANO , yycolumn, yyline, yytext());}

nombre                  {System.out.println("NOMBRE"); return new Symbol(SimbolosG.NOMBRE , yycolumn, yyline, yytext());}
naves                   {System.out.println("NAVES"); return new Symbol(SimbolosG.NAVES , yycolumn, yyline, yytext());}
porcentajeMuertes       {System.out.println("PORCENTAJE_MUERTES"); return new Symbol(SimbolosG.PORCENTAJE_MUERTES , yycolumn, yyline, yytext());}
planetas                {System.out.println("PLANETAS_JUGADOR"); return new Symbol(SimbolosG.PLANETAS_JUGADOR , yycolumn, yyline, yytext());}
tipo                    {System.out.println("TIPO"); return new Symbol(SimbolosG.TIPO , yycolumn, yyline, yytext());}
coordenadaX             {System.out.println("COORDENADA_X"); return new Symbol(SimbolosG.COORDENADA_X , yycolumn, yyline, yytext());}
coordenadaY             {System.out.println("COORDENADA_Y"); return new Symbol(SimbolosG.COORDENADA_Y , yycolumn, yyline, yytext());}

HUMANO                  {System.out.println("HUMANO"); return new Symbol(SimbolosG.HUMANO , yycolumn, yyline, yytext());}
FACIL                   {System.out.println("FACIL"); return new Symbol(SimbolosG.FACIL , yycolumn, yyline, yytext());}
DIFICIL                 {System.out.println("DIFICIL"); return new Symbol(SimbolosG.DIFICIL , yycolumn, yyline, yytext());}
true                    {System.out.println("TRUE"); return new Symbol(SimbolosG.TRUE , yycolumn, yyline, yytext());}
false                   {System.out.println("FALSE"); return new Symbol(SimbolosG.FALSE , yycolumn, yyline, yytext());}

origen                  {System.out.println("ORIGEN"); return new Symbol(SimbolosG.ORIGEN , yycolumn, yyline, yytext());}
destino                 {System.out.println("DESTINO"); return new Symbol(SimbolosG.DESTINO , yycolumn, yyline, yytext());}
tipoPlaneta             {System.out.println("TIPOPLANETA"); return new Symbol(SimbolosG.TIPOPLANETA , yycolumn, yyline, yytext());}
turnoDistancia          {System.out.println("TURNO_DISTANCIA"); return new Symbol(SimbolosG.TURNO_DISTANCIA , yycolumn, yyline, yytext());}
turnoLlegada            {System.out.println("TURNO_LLEGADA"); return new Symbol(SimbolosG.TURNO_LLEGADA , yycolumn, yyline, yytext());}
nombreJugador           {System.out.println("NOMBRE_JUG"); return new Symbol(SimbolosG.NOMBRE_JUG , yycolumn, yyline, yytext());}
resultado               {System.out.println("RESULTADO"); return new Symbol(SimbolosG.RESULTADO , yycolumn, yyline, yytext());}
turno                   {System.out.println("TURNO"); return new Symbol(SimbolosG.TURNO , yycolumn, yyline, yytext());}

<YYINITIAL> {
    {Espacio}                       {/*Ignore*/}
    "\""                            {System.out.println("comillas"); return new Symbol(SimbolosG.COMILLAS , yycolumn, yyline, yytext());}
    "tama"."o"                      {System.out.println("TAMANO"); return new Symbol(SimbolosG.TAMANO , yycolumn, yyline, yytext());}
    ("_"|"$"|{Letra})({Texto})*     {System.out.println("id: "+yytext()); return new Symbol(SimbolosG.IDENTIFICADOR , yycolumn, yyline, yytext());}
    
    ({Numero}|{Numero}"."{Numero})  {System.out.println("NUMERO: "+yytext()); return new Symbol(SimbolosG.NUMERO , yycolumn, yyline, yytext());}

    {Texto}                         {System.out.println("texto: "+yytext()); return new Symbol(SimbolosG.PALABRA , yycolumn, yyline, yytext());}
    ":"                             {System.out.println("dos puntos"); return new Symbol(SimbolosG.DOS_PUNTOS , yycolumn, yyline, yytext());}
    "["                             {System.out.println("CHORCHETE ABRE"); return new Symbol(SimbolosG.CORCHE_A , yycolumn, yyline, yytext());}
    "]"                             {System.out.println("CORCHE CIERRE"); return new Symbol(SimbolosG.CORCHE_C , yycolumn, yyline, yytext());}
    "{"                             {System.out.println("LLAVES ABRE"); return new Symbol(SimbolosG.LLAVES_A , yycolumn, yyline, yytext());}
    "}"                             {System.out.println("LLAVES CIEERRE"); return new Symbol(SimbolosG.LLAVES_C , yycolumn, yyline, yytext());}
    ","                             {System.out.println("COMA"); return new Symbol(SimbolosG.COMA , yycolumn, yyline, yytext());}
    .                               {System.out.println("error Lexico: "+"Columna: "+yycolumn+1+" linea: "+ yyline+1 + "Token: "+yytext());}
    
}
