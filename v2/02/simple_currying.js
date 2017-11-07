function laske (x, y){
  return 2 * x + y;
}


// Currying:

function laskeCur(x){
  console.log("In x : " + x);
  return function(y){
    console.log(x + " " + y);
    return 2 * x + y;
  };
}

// Seuraavan sijaan:
console.log(laske(1,2));
// kirjoitetaankin:
console.log(laskeCur(1)(2));

// Jos ensimmäinen parametri kiinnitetään, sovelletaan partial application -nimistä tekniikkaa:
// osittainen soveltaminen, ks. seur.:

const laskeXon1 = laskeCur(1);
console.log(laskeXon1(2));


// currying ja partial application rinnastetaan/sotketaan jatkuvasti eri lähteissä