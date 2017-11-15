# viikko 3 02


# Javan funktionaalisia rajapintoja


1. Koodaa tunnilla esitetty Generaattori-esimerkki (Gitin v3/02/java2_OmaFIF-kansiossa) uudestaan
käyttäen sopivaa Java-API:n tarjoamaa funktionaalista rajapintaa.


2. Alla on esitetty runkoa ohjelmalle, jossa hyödynnetään currying-tekniikkaa ja osittain soveltamista (vrt. vastaava aiempi JavaScript-tehtävä). 
Ideana on, että makePistelaskuri()-metodi palauttaa funktionaalisen rajapinnan toteuttajan, johon "leivotaan sisään" mäen speksit
ja joka tässä esimerkissä on DoubleUnaryOperator-rajapinnan toteuttaja (deskriptori: double -> double).
Määrittele metodin paluuarvoksi rajapinnan toteuttajan koodi lambdana ja paluta se metodista.
K-pisteen hyppy tuottaa 60 pistettä ja lisäpisteet/vähennys ylittävistä/alittavista metreistä on normaalimäessä 2.0 pistettä.
Näytä,kuinka saat tulostetuksi pituspisteet 100-metrin hypystä Lahden normaalimäessä.


```
import java.util.function.DoubleUnaryOperator;

public class Makihyppy {
lein repl
    static DoubleUnaryOperator makePistelaskuri(double kPiste, double lisapisteet){
            return // puuttuva koodi
    };
        
    public static void main(String[] args) {

       
       DoubleUnaryOperator normaaliLahti = makePistelaskuri(90, 2.0);
       
       System.out.println(/* pituuspisteet 100 metrin hypystä */); 
          
    }
    
}

```
* Vinkki: APIsta selviää, että DoubleUnaryOperator esittelee yksiparamerisen metodin <code>double applyAsDouble(double x)</code>.
Pituus annetaan parametrina juuri tälle metodille.¨
* Koodipohja gitissä: v3/02/Tehtavapohjat/Makihyppy.java

3. Esitä koodi, jolla tuotat kokonaislukuvuon (IntStream), joka sisältää "oikean lottorivin". 
Esitä kaksi eri tapaa: 1) arvonta lambdalla ja 2) arvonta anonyymin sisäluokan ilmentymällä.
Tulosta oikea rivi.

4. Anonyymin sisäluokan avulla luotuun olioon voidaan sisällyttää instanssimuuttujia. 
Hyödynnä tätä toteuttaessasi anonyymi IntSupplier:n ilmentymä, jota voidaan käyttää tuotettaessa kokonaislukuvirta Fibonaccin lukuja:

```
IntStream.generate(fibo).limit(10).forEach((n) -> System.out.println(n));

```
* Vinkki: käytä instanssimuuttujia edellinen ja nykyinen. Paluuarvona on edellistä edellinen.
* Fibonaccin luvut: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34,...

5. Yhdistetty funktio. Alla on ohjelma, jossa tehdään usemmalle pisteelle sama muunnos 2-ulotteisessa koordinaatistossa (vrt. aikaisempi JavaScript-tehtävä).
Kirjoita Piste-luokka, jonka avulla saat ohjelman toimimaan. Alla olevassa ohjelmassa on yksi kommentotu kohta. Koodaa siihen yhdistetyn funktion muodostaminen.

```
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Function;

public class PisteenTransformaatiot {
          
    public static void main(String[] args) {
               
       Function siirto = Piste.makeSiirto(1, 2);
       Function skaalaus = Piste.makeSkaalaus(2);
       Function kierto = Piste.makeKierto(Math.PI);
       Function muunnos = // muodosta tässä yhdistetty funktio
       
       Piste[] pisteet = {new Piste(1,1), new Piste(2,2), new Piste(3,3)};
       List<Piste> uudetPisteet = new CopyOnWriteArrayList();
       
       for (Piste p: pisteet){
           uudetPisteet.add((Piste)muunnos.apply(p));
       } 
  
       uudetPisteet.forEach(p -> System.out.println(p));
    }
}
```

* Koodipohja gitissä: v3/02/Tehtavapohjat/PisteenTransformaatiot.java


