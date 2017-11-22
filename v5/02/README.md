# viikko 5 02


# Clojuren kontrollirakenteet


1. Kirjoita ohjelma (funktio), joka kysyy sinulta yhden luvun (> 0) ja kertoo, onko luku parillinen. Jos luku on <= 0, ohjelma tulostaa virheilmoituksen. Merkkijonosyötteen (read-line) voi muuttaa kokonaisluvuksi operaattorilla <b>Integer.</b>, esim. (Integer. "2")

2. Lisää edelliseen funktioon toisto recur-operaattorilla: jos annettu luku on virheellinen, sitä pyydetäänn uudestaan (funktio kutsuu tässä tapauksessa itseään). 

3. Kirjoita funktio, joka tulostaa silmukassa kolmella jaolliset luvut väliltä 1 - yläraja, kun yläraja annetaan funktiolle parametrina.

4. Arvo lottorivi: 7 numeroa väliltä 1-39. Arvo luvut valitsemaasi tietorakenteeseen ja tulosta ne. Joukko (set) on tässä paras ratkaisu). Käytä Clojuren loop-silmukkarakennetta.

5.  Kahden luvun suurin yhteinen tekijä on suurin luku, jolla molemmat luvut ovat jaollisia.  Esimerkiksi lukujen 102 ja  68 suurin tekijä on 34.

```
syt(p, q) {
  Jos q on 0, palauta p.
  Muuten 
    selvitä rekursiivisella metodikutsulla, mikä on suurin yhteinen tekijä q:lle ja p%q:lle,
	ja
    palauta sama luku, jonka rekursiivinen kutsukin palautti.
}
```
Toteuta tämä funktio recur:in avulla.
