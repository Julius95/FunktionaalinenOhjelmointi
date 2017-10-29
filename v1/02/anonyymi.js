'use strict'

const f = function () {
    return function (x) {
		return x+1;
	 }
	}(); // Huomaa funktion kutsu!

let tulos = f(3);
console.log(tulos);

const vertaa = function(){
	return function(eka, toka){
		if(eka>toka)
			return 1;
		else if(eka<toka)
			return -1;
		return 0;
	}
}();

console.log(vertaa(4,4))

const kahdenTaulukonVertailu = function(vertaa1, eka,toka){
	let tulos=0;
	for(let i = 0; i<eka.length;i++){
		if(vertaa1(eka[i], toka[i]) === -1)//toka on lämpimämpi
			tulos++;
	}
	return tulos
}

console.log(kahdenTaulukonVertailu(vertaa, [2,3,55], [3,2,100]))