'use strict';

const Immutable = require('immutable');

let parittomienNeliot = 
    Immutable.Seq([1,2,3,4,5,6,7,8])
    .filter(function(x){console.log(`filter ${x}`) ; return x % 2 })
    .map(function(x){console.log(`map ${x}`); return x * x});
    
//console.log(`0: ${parittomienNeliot.get(0)}`);        
//console.log(`1:  ${parittomienNeliot.get(1)}`);    
//console.log(`2: ${parittomienNeliot.get(2)}`);     
    
    
// Sama JavaScriptin taulukolle:

console.log ('Taulukko:');

/*let parittomienNeliotTaulukko = 
    [1,2,3,4,5,6,7,8]
    .filter(function(x){console.log(`filter ${x}`) ; return x % 2 })
    .map(function(x){console.log(`map ${x}`); return x * x});
  */  
console.log(`0: ${parittomienNeliot.get(0)}`);        
//console.log(`1:  ${parittomienNeliotTaulukko[1]}`);    
console.log(`2: ${parittomienNeliot}`);     


    