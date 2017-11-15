# viikko 4 02

# Omia collectoreja ja suunnittelumalleja

Näistä annetaan vain osa tehtäviksi (ks. tehtäväksianto työtilasta)

1. a) Kirjoita oma Collector-rajapinnan toteuttaja, joka toimii kuten Collector.joining()-tehdasmetodin palauttama Collector-toteutus.
Tuota koodaamasi kollektorin avulla merkkijono ArrayList-tietorakenteen sisältämistä Omena-olioista. 
Kirjoita myös oma joining()-metodia vastaava staattinen tehdasmetodi omaan OmatKollektorit-luokkaan ja käytä sitä.
* Vinkki: käytä StringBufferia Supplierin paluuarvona.
<br><br>
b) Pystyykö edellisen toteuttamaan yhdellä usean säikeen yhteisellä StringBufferilla, jos hyödynnetään rinnakkaisuutta?
Testaa sopivalla, riittävän isolla aineistolla.
* Testaa siis CONCURRENT -optimoinnin käyttö. Järjestyksellä ei ole väliä tuloslistaa muodostettaessa.

2. Kirjoita oma Collector-rajapinnan toteuttaja vuossa olevien elementtien lukumäärän laskemiseksi. 
* Käytä Stream.generate -generaattoria vuon generoimiseksi.
* Mittaa aikoja sekä sarjalliselle että rinnakkaiselle laskennalle.
* Pystytkö tässä käyttämään yhtä tulosoliota rinnakkaislaskennassa ilman combinerin käyttöä?

3. Tutki välitulostuksin, kuinka fork/join -kehys pilkkoo virran ja kokoaa tulokset gitissä V4/02/ olevaa 
OmaListaCollectoria käytettäessä, kun laskenta suoritetaan rinnakkaisesti.

4. Selvitä testaamalla ja esim.APIa tutkimalla, mitä tarkoittaa seuraava:
```
List<Omena> omenaLista = omenaStream.collect(
    ArrrayList::new,
    List::add,
    List::addAll);
```

5. Määrittele Abstrakti tehdas (Abstract Factory) Meijeri, josta saadaan kolmenlaisia tuotteita: maitoa, juustoa, jugurttia.
Toteuta kaksi erilaista konkreettista tehdasta: laktoositon ja vähälaktoosinen.
Kirjoita testiohjelma, jossa käytät joko laktoosittomia tai vähälaktoosisia tuotteita.
Tehdas voidaan vaihtaa muuttamatta soivelluskoodia muulla tavalla kuin tehtaan vaihdolla.

* Tuotteille pitää määritellä omat rajapinnat: interface Maito jne.
* Katso mallia gitistä v4/02/AbstractFactory.


6. Määrittele vastuuketju (Chain of Responsibility), jossa käsitellään merkkijonona välitettävä dokumentti.
Ensimmäinen käsittelijä poistaa dokumentista kaikki ylimääräiset välilyönnit. Toinen korvaa skandit seuraavasti: ä,å -> a; ö -> o; Ä,Å -> A; Ö -> O. 
Kolmas tarkistaa oikeinkirjoituksen: kaikki sturct-sanat korvataan struct-sanoilla.
* Katso mallia gitistä v4/02/ChainOfResponsibility.

7. Edellisessä tehtävässä tehdyt toiminnallisuudet voidaan nähdä merkkijonon käsittelyyn liittyvinä erilaisina editointistrategioina. 
Tarkastele asiaa tästä näkökulmasta ja toteuta merkkijonon käsittely Strategy-mallin mukaisesti. 
* Katso mallia gitistä v4/02/Strategy.

8. Uutistoimisto tuottaa uutisia, joita se välittää eri medioille (Helsingin Sanomat, Ilta-Sanomat jne.) Kirjoita ja testaa Observer-mallin mukainen ratkaisu, 
jossa Helsingin Sanomat välittää lukijoilleen (tulostaa ruudulle) kaikki uutiset, joista löytyy avainsana "politiikka" ja Ilta-Sanomat jokaisen, josta löytyy avainsana "julkkis".
* Katso mallia gitistä v4/02/Observer.

9. Vuoropohjaisen pelin (shakki, pokeri jne. ) logiikka voidaan esittää seuraavalla algoritmilla (= Template Method):

```
 abstract class Game {
 
    protected int playersCount;
    abstract void initializeGame();
    abstract void makePlay(int player);
    abstract boolean endOfGame();
    abstract void printWinner();

    public final void playOneGame(int playersCount) {
        this.playersCount = playersCount;
        initializeGame();
        int j = 0;
        while (!endOfGame()){
            makePlay(j);
            j = (j + 1) % playersCount;
        }
        printWinner();
    }
```
* Pystytkö esittämään tälle funktionaalisen version ja jonkin pelin toteutuksen? 
* Katso mallia gitistä v4/02/TemplateMethod.