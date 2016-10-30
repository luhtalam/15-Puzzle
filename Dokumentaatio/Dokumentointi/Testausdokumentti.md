Testaaminen
-------

Ohjelman ratkaisualgoritmi toimii kaikilla peleillä samalla tavalla; pelitilanteesta konstruoidaan uudet pelitilanteet siirtämällä tyhjää pelilaattaa kaikkiin mahdollisiin suuntiin ja uudet tilanteet lisätään prioriteettijonoon. Prioriteettijonossa pelitilanteet järjestetään nousevaan järjestykseen pelitilanteelle lasketun prioriteettiarvon perusteella. Jonosta uudeksi tarkasteltavaksi pelitilanteeksi valikoituu prioriteettiarvon perusteella ratkeamisen kannalta optimaallisimmalta näyttävä pelitilanne. Koska jokainen pelitilanne ratkeaa samalla kaavalla, algoritmin tehokkuus perustuu sopivan prioriteettiarvon laskevan funktion valintaan. Prioriteettiarvon laskevasta funktiosta käytetään yleisesti myös nimitystä heuristiikkafunktio. Mitä tarkemman arvion heuristiikkafunktio antaa kyseisen pelitilanteen ratkeavuudesta, sitä paremmin pelitilanteet voidaan järjestää jonoon. 

Suoritin ratkaisualgoritmilleni kahdenlaisia testejä: algoritmin toimintaan liittyviä testejä sekä algoritmin suorituskykyyn liittyviä testejä. Algoritmin toimintaan liittyvän testauksen toteutin Javan JUnit-yksikkötestauksella. Kirjoitin testit kaikelle mielestäni algoritmin toiminnan kannalta oleelliselle sisällölle. JUnit testien tarkempaa sisältöä voi tarkastella projektikansioni Test-alikansiosta. Suorituskykytestausta suoritin läpi koko projektin pyrkiessäni löytämään erilaisille pelitilanteille mahdollisimman hyvän heuristiikkafunktion.

Suorituskykytestit
------

![Diagnostiikka] (Diagnostiikka.png)
