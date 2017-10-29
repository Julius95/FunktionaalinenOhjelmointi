'use strict';

let f, g;

function foo() {
  let x;
  f = function() { return ++x; };//liitetään sulkeuma muuttujaan f, joka korottaa lokaalia muuttujaa x
  g = function() { return --x; };//liitetään sulkeuma muuttujaan g, joka pienentää lokaalia muuttujaa x
  x = 1;
  console.log('inside foo, call to f(): ' + f());
}
foo();//Funktion suoritus loppuu ja foo tuhoutuu suorituspinosta. foo-Funktion lokaali muuttuja kopioidaan f:lle ja g:lle yhteiskäyttöön.  
console.log('call to g(): ' + g());//Kutsutaan g, joka näkee x:än kopion
console.log('call to f(): ' + f());//Kutsutaan f, joka näkee x:än kopion
