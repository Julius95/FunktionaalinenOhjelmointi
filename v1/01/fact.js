function fact(n) {
// triviaalitapaus
  if (n === 0) {
    return 1;
  }
 // perussilmukka
  return n * fact(n - 1);
}
var tulos = fact(4);
console.log(tulos);


//T.1
function isPalindrome(string){
  if(string.length < 2)
    return true;
  else if(string.charAt(0) !== string.charAt(string.length-1)){
    return false;
  }else{
    return isPalindrome(string.substr(1).slice(0,-1));
  }
}

console.log(isPalindrome("saippuakauppias"))
console.log(isPalindrome("saippuakaappias"))
console.log(isPalindrome("nenonen"))


//T.2
function syt(p,q){
  if(q === 0)
    return p;
  return syt(q, p%q)
}

console.log(syt(102,68))//34
//console.log(syt(35,18))//34

//T.3
function kjl(p,q){
  if(q === 1)
    return true;
  else if(!q)
    return false;
  return kjl(q, p%q)
}

console.log(kjl(35,18))//34
console.log(kjl(9,3))//34

//T.4
function potenssiin(numero, potenssi){
  return helperKorotus(numero, potenssi, 1)
}

function helperKorotus(numero, potenssi, acc){
  if(potenssi === 0)
    return acc;
  return helperKorotus(numero, potenssi-1, acc*numero)
}

console.log("^ " + potenssiin(3,2))

//T.5
function kaanna(list, start, end){
  if(start === end || start - end === 1)
    return list
  let apu = list[start]
  list[start] = list[end]
  list[end] = apu
  //if(end - start === 1)//Etäisyys vain yhden alkion pituinen ja sitä koskevat operaatiot jo tehty
    //return list
  return kaanna(list, start+1, end-1)
}

console.log(kaanna([0,1,2,3,4,5,6,7,8,9],0,9))
console.log(kaanna([1,2,3,4,5,6,7,8,9],0,8))





