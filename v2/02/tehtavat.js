'use strict';

const Immutable = require('immutable');

//T.1
function laskija(kPiste, lisapisteet){
    return pituus => 60 + (pituus - kPiste) * lisapisteet;
}

//T.2
const Auto  = (function(){
    
    const suojatut = new WeakMap();  // yhteinen ilmentymille
    
    class Auto{
        
        constructor(){
            this.tankki = 0;
            suojatut.set(this, {matkamittari: 0});
        }
        
     
        tankkaa(maara) {this.tankki+=maara;}
        
        aja(maara){
            let auto = suojatut.get(this);
            auto.matkamittari+=maara;
            this.tankki-=maara;
        }
        
        getTankki() {return suojatut.get(this).tankki}
        
        getMittari() {return suojatut.get(this).matkamittari}
        
    }
    
    return Auto;
})();

const pieniMaki = laskija(80, 2.0);

//Pisteiden laskua
console.log(pieniMaki(90));
console.log(pieniMaki(70));

const auto1 = new Auto();
const auto2 = new Auto();
auto1.tankkaa(10);
auto1.aja(5);
auto1.aja(1);
auto1.tankki+=1;
console.log("Auto1, Tankki : " + auto1.tankki + " Mittari : " + auto1.getMittari());

auto2.tankki = 4;
auto2.aja(1);
auto2.aja(1);

console.log("Auto2, Tankki : " + auto2.tankki + " Mittari : " + auto2.getMittari());

//T.3

const set1 = Immutable.Set(['punainen', 'vihreä', 'keltainen']);

const set2 = set1.merge(Immutable.Set(['ruskea']));

console.log((set1 === set2));

const set3 = set2.merge(Immutable.Set(['ruskea']));

console.log(set2 === set3);

//T.4 löytyy toisesta tiedostosta nimellä tehtava4.js

//T.5


//dokumentaatio -> https://facebook.github.io/immutable-js/docs/#/Repeat
//Eka parametri on alkion arvo ja toka on alkioiden määrä. Luo Seq listan


const numeroLista = Immutable.Repeat(0,10)
                    .map((x,i)=>x+i)

console.log(numeroLista);



/*
const duplicateColors = Immutable.List.of("green", "blue","green","black", "blue")
const distinctColors = duplicateColors.groupBy(x => x).map(x => x.first()).toList();
console.log(distinctColors)
*/

