
var fs = require('fs');
//T.1
let toCelsius = fahrenheit => (5/9) * (fahrenheit-32);

let area = radius => Math.PI * radius * radius;

console.log()

//T.2

fs.readFile('movies.js', 'utf8', function (err, data) {
    let list
    if (err) throw err;
    list = JSON.parse(data);
    list = list.map((element) => ({title : element.title, release : element.release}))
    list.map((x) => console.log(x))
});




//T.3
fs.readFile('movies.js', 'utf8', function (err, data) {
    console.log("-------------------------------------")
    let list
    if (err) throw err;
    list = JSON.parse(data);
    list = list.filter(x => x.release > 2011)
    list.map((x) => console.log(x))
});

//T.4

let lampo15 = [-5,-6,-1,2,8,14,18,16,13,7,2,-3];
let lampo16 = [-4,-5,-3,1,9,15,19,17,12,8,2,-3];

let ka = lampo16.map((x,i) => (x + lampo15[i])/2)
        .filter(x => x>0)
        .reduce((prev,curr,index,arr) => {
            prev+=curr
            if(index === (arr.length-1)){
                prev /= arr.length
            }
            return prev
        },0)

console.log("#######= " + ka)

//T.5
fs.readFile('kalevala.txt', 'utf8', function (err, data) {
    console.log("-------------------------------------")
    let list = []//Tähän lajitellaan kaikki tekstin sanat match metodin avulla
    let res = []//Lopputuloksena saatu lista, joka koostuu olioista joiden attribuutteina varsinainen sana ja määrä
    let found = []//apu lista johon lisätään sanoja, jotka valmiiksi lisätty res listaan
    if (err) throw err;
    list = data.match(/[^, :.!\r\n;][\wåäöÅÄÖ']*/g)
    list.map(x=>{
        if(found.indexOf(x)<0){
            res.push(({sana : x, maara : 
                list.reduce((acc,current,index)=>{
                    if(current === x)
                        acc++
                    return acc
                },0)
            }))
            found.push(x)
        }
    })
    
    //Lajitellaan sanat
    res.sort(function(a, b){
        let sanaA=a.sana.toLowerCase(), sanaB=b.sana.toLowerCase();
        if (sanaA < sanaB)
            return -1;
        if (sanaA > sanaB)
            return 1;
        return 0;
    });
    
    res.map(x=>{
      console.log(x)  
    })
});