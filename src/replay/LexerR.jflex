package replay;
import java_cup.runtime.*;
import objetos.Error;
import java.util.ArrayList;

%%
%{
    //coidgo de usuario en sintaxis java
    ArrayList<Error> listaErrores = new  ArrayList<>();
    

    public ArrayList<Error> getListaErrores(){
        return listaErrores;
    }
%}

    //directivas
%public 
%class AnalizadorLexicoR
%cupsym SimbolosR
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


MAPA                    {/*System.out.println("MAPA");*/ return new Symbol(SimbolosR.MAPA , yycolumn, yyline, yytext());}
PLANETAS                {/*System.out.println("PLANETAS");*/ return new Symbol(SimbolosR.PLANETAS , yycolumn, yyline, yytext());}
PLANETAS_NEUTRALES      {/*System.out.println("PLANETAS_NEUTRALES");*/ return new Symbol(SimbolosR.PLANETAS_NEUTRALES , yycolumn, yyline, yytext());}
JUGADORES               {/*System.out.println("JUGADORES");*/ return new Symbol(SimbolosR.JUGADORES , yycolumn, yyline, yytext());}
id                      {/*System.out.println("ID");*/ return new Symbol(SimbolosR.ID , yycolumn, yyline, yytext());}

REPETICION                  {/*System.out.println("REPETICION");*/ return new Symbol(SimbolosR.REPETICION , yycolumn, yyline, yytext());}
MENSAJES                {/*System.out.println("MENSAJES");*/ return new Symbol(SimbolosR.MENSAJES , yycolumn, yyline, yytext());}

filas                   {/*System.out.println("FILAS");*/ return new Symbol(SimbolosR.FILAS , yycolumn, yyline, yytext());}
columnas                {/*System.out.println("COLUMNAS");*/ return new Symbol(SimbolosR.COLUMNAS , yycolumn, yyline, yytext());}
alAzar                  {/*System.out.println("ALAZAR");*/ return new Symbol(SimbolosR.ALAZAR , yycolumn, yyline, yytext());}
planetasNeutrales       {/*System.out.println("PLANET_NEU");*/ return new Symbol(SimbolosR.PLANET_NEU , yycolumn, yyline, yytext());}
mapaCiego               {/*System.out.println("MAPA_CIEGO");*/ return new Symbol(SimbolosR.MAPA_CIEGO , yycolumn, yyline, yytext());}
acumular                {/*System.out.println("ACUMULAR");*/ return new Symbol(SimbolosR.ACUMULAR , yycolumn, yyline, yytext());}
NEUTRALES               {/*System.out.println("NEUTRALES");*/ return new Symbol(SimbolosR.NEUTRALES , yycolumn, yyline, yytext());}
mostrarNaves            {/*System.out.println("MOSTRAR_NAVES");*/ return new Symbol(SimbolosR.MOSTRAR_NAVES , yycolumn, yyline, yytext());}
mostrarEstadisticas     {/*System.out.println("MOSTRAR_ESTADISTICAS");*/ return new Symbol(SimbolosR.MOSTRAR_ESTADISTICAS , yycolumn, yyline, yytext());}
produccion              {/*System.out.println("PRODUCCION");*/ return new Symbol(SimbolosR.PRODUCCION , yycolumn, yyline, yytext());}
finalizacion            {/*System.out.println("FINALIZACION");*/ return new Symbol(SimbolosR.FINALIZACION , yycolumn, yyline, yytext());}
navesEnviadas           {/*System.out.println("NAVES_ENVIADAS");*/ return new Symbol(SimbolosR.NAVES_ENVIADAS , yycolumn, yyline, yytext());}
jugadorPlaneta          {/*System.out.println("JUGADOR");*/ return new Symbol(SimbolosR.JUGADOR , yycolumn, yyline, yytext());}

tamaño                  {/*System.out.println("TAMAÑO");*/ return new Symbol(SimbolosR.TAMANO , yycolumn, yyline, yytext());}

nombre                  {/*System.out.println("NOMBRE");*/ return new Symbol(SimbolosR.NOMBRE , yycolumn, yyline, yytext());}
naves                   {/*System.out.println("NAVES");*/ return new Symbol(SimbolosR.NAVES , yycolumn, yyline, yytext());}
porcentajeMuertes       {/*System.out.println("PORCENTAJE_MUERTES");*/ return new Symbol(SimbolosR.PORCENTAJE_MUERTES , yycolumn, yyline, yytext());}
planetas                {/*System.out.println("PLANETAS_JUGADOR");*/ return new Symbol(SimbolosR.PLANETAS_JUGADOR , yycolumn, yyline, yytext());}
tipo                    {/*System.out.println("TIPO");*/ return new Symbol(SimbolosR.TIPO , yycolumn, yyline, yytext());}
coordenadaX             {/*System.out.println("COORDENADA_X");*/ return new Symbol(SimbolosR.COORDENADA_X , yycolumn, yyline, yytext());}
coordenadaY             {/*System.out.println("COORDENADA_Y");*/ return new Symbol(SimbolosR.COORDENADA_Y , yycolumn, yyline, yytext());}

HUMANO                  {/*System.out.println("HUMANO");*/ return new Symbol(SimbolosR.HUMANO , yycolumn, yyline, yytext());}
FACIL                   {/*System.out.println("FACIL");*/ return new Symbol(SimbolosR.FACIL , yycolumn, yyline, yytext());}
DIFICIL                 {/*System.out.println("DIFICIL");*/ return new Symbol(SimbolosR.DIFICIL , yycolumn, yyline, yytext());}
true                    {/*System.out.println("TRUE");*/ return new Symbol(SimbolosR.TRUE , yycolumn, yyline, yytext());}
false                   {/*System.out.println("FALSE");*/ return new Symbol(SimbolosR.FALSE , yycolumn, yyline, yytext());}

origen                  {/*System.out.println("ORIGEN");*/ return new Symbol(SimbolosR.ORIGEN , yycolumn, yyline, yytext());}
destino                 {/*System.out.println("DESTINO");*/ return new Symbol(SimbolosR.DESTINO , yycolumn, yyline, yytext());}
tipoPlaneta             {/*System.out.println("TIPOPLANETA");*/ return new Symbol(SimbolosR.TIPOPLANETA , yycolumn, yyline, yytext());}
turnoJugador            {/*System.out.println("TURNO_JUGADOR");*/ return new Symbol(SimbolosR.TURNO_JUGADOR  , yycolumn, yyline, yytext());}
turnoLlegada            {/*System.out.println("TURNO_LLEGADA");*/ return new Symbol(SimbolosR.TURNO_LLEGADA , yycolumn, yyline, yytext());}
nombreJugador           {/*System.out.println("NOMBRE_JUG");*/ return new Symbol(SimbolosR.NOMBRE_JUG , yycolumn, yyline, yytext());}
resultado               {/*System.out.println("RESULTADO");*/ return new Symbol(SimbolosR.RESULTADO , yycolumn, yyline, yytext());}
turno                   {/*System.out.println("TURNO");*/ return new Symbol(SimbolosR.TURNO , yycolumn, yyline, yytext());}
turnoNumero             {/*System.out.println("TURNO_NUMERO");*/ return new Symbol(SimbolosR.TURNO_NUMERO , yycolumn, yyline, yytext());}

<YYINITIAL> {
    {Espacio}                       {/*Ignore*/}
    "\""                            {/*System.out.println("comillas");*/ return new Symbol(SimbolosR.COMILLAS , yycolumn, yyline, yytext());}
    "tama"."o"                      {/*System.out.println("TAMANO");*/ return new Symbol(SimbolosR.TAMANO , yycolumn, yyline, yytext());}
    ("_"|"$"|{Letra})({Texto})*     {System.out.println("id: "+yytext()); return new Symbol(SimbolosR.IDENTIFICADOR , yycolumn, yyline, yytext());}
    
    ({Numero}|{Numero}"."{Numero})  {System.out.println("NUMERO: "+yytext()); return new Symbol(SimbolosR.NUMERO , yycolumn, yyline, yytext());}

    {Texto}                         {System.out.println("texto: "+yytext()); return new Symbol(SimbolosR.PALABRA , yycolumn, yyline, yytext());}
    ":"                             {/*System.out.println("dos puntos");*/ return new Symbol(SimbolosR.DOS_PUNTOS , yycolumn, yyline, yytext());}
    "["                             {/*System.out.println("CHORCHETE ABRE");*/ return new Symbol(SimbolosR.CORCHE_A , yycolumn, yyline, yytext());}
    "]"                             {/*System.out.println("CORCHE CIERRE");*/ return new Symbol(SimbolosR.CORCHE_C , yycolumn, yyline, yytext());}
    "{"                             {/*System.out.println("LLAVES ABRE");*/ return new Symbol(SimbolosR.LLAVES_A , yycolumn, yyline, yytext());}
    "}"                             {/*System.out.println("LLAVES CIEERRE");*/ return new Symbol(SimbolosR.LLAVES_C , yycolumn, yyline, yytext());}
    ","                             {/*System.out.println("COMA");*/ return new Symbol(SimbolosR.COMA , yycolumn, yyline, yytext());}
    .                               {System.out.println("error Lexico: "+"Columna: "+yycolumn+1+" linea: "+ yyline+1 + "Token: "+yytext());
                                    Error error = new Error(yytext(), "Sintactico", "Error Sintaxis token: " + yyline+1 + " " + yycolumn+1 + " " + yytext(), yyline+1, yycolumn+1);
                                    listaErrores.add(error);
                                    }
    
}
