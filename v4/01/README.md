# viikko 4 01

1. Debugging.java-tiedostossa on Point-luokan toteutus. Luennolla esitettiin moveAllPointsRightBy-metodi, 
jolla saadaan siirrettyä kaikki listan pisteet oikealle. 
Toteuta tämä loppuun asti niin, että myös testit menevät läpi. 

Vinkki. AssertArrayEquals() käyttää equals()-metodia. Miten varmistetaan pisteiden yhtäsuuruus?


2. Seuraava ratkaisu on melko hidas, vaikka käytetäänkin rinnakkaista vuota. 
Tee samanlainen vertailu kuin ParallelStreamsHarness.java-ohjelmassa erilaisista toteutustavoista. Tee erilaisia ratkaisuja, joissa
- käytetään linkitettyä listaa
- taulukkolistaa
- suoraan IntStreamia

Alusta listat ja vuot riittävän isolla alkioiden määrällä niin, että ajoissa saat eroja.

```
taulukkoLista = new ArrayList<>();
linkitettyLista = new LinkedList<>();

public int hidasNelioSumma() {
        return linkitettyLista.parallelStream()
                                  .map(x -> x * x)
                                  .reduce(0, (acc, x) -> acc + x);
}
```
3. Pystyisitkö rinnakkaistamaan viime viikon ratkaisuasi, joka tekee esiintymälistan kalevala.txt-tiedossa
esiintyvistä sanoista? Vertaa suoritusaikoja eri ratkaisuilla.


