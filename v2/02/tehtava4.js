'use strict';

const Immutable = require('immutable');


const AnimatedObject  = (function(){
    
    const suojatut = new WeakMap();
    
    class AnimatedObject{
        
        constructor(p_id,p_ruudulla){
            suojatut.set(this, {id: p_id, ruudulla: p_ruudulla});
        }
        
        animoi() {
            console.log("Suoritetaan olion " + suojatut.get(this).id + " laskennallisesti vaativa animaatio");
        }
        
        isAnimatable() { 
            return suojatut.get(this).ruudulla
        }
        
    }
    
    return AnimatedObject;
})();

const setti = Immutable.Seq([
    new AnimatedObject(1,false),
    new AnimatedObject(2,true),
    new AnimatedObject(3,false),
    new AnimatedObject(4,true)
    ])
    .filter(x => x.isAnimatable())
    .map(x=> x.animoi())

setti.get(1);




