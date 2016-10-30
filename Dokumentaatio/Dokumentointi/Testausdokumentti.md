Testaaminen
-------

Ohjelman ratkaisualgoritmi toimii kaikilla peleillä samalla tavalla; pelitilanteesta konstruoidaan uudet pelitilanteet siirtämällä tyhjää pelilaattaa kaikkiin mahdollisiin suuntiin ja uudet tilanteet lisätään prioriteettijonoon. Prioriteettijonossa pelitilanteet järjestetään nousevaan järjestykseen pelitilanteelle lasketun prioriteettiarvon perusteella. Jonosta uudeksi tarkasteltavaksi pelitilanteeksi valikoituu prioriteettiarvon perusteella ratkeamisen kannalta optimaallisimmalta näyttävä pelitilanne. Koska jokainen pelitilanne ratkeaa samalla kaavalla, algoritmin tehokkuus perustuu sopivan prioriteettiarvon laskevan funktion valintaan. Prioriteettiarvon laskevasta funktiosta käytetään yleisesti myös nimitystä heuristiikkafunktio. Mitä tarkemman arvion heuristiikkafunktio antaa kyseisen pelitilanteen ratkeavuudesta, sitä paremmin pelitilanteet voidaan järjestää jonoon. 

Suoritin ratkaisualgoritmilleni kahdenlaisia testejä: algoritmin toimintaan liittyviä testejä sekä algoritmin suorituskykyyn liittyviä testejä. Algoritmin toimintaan liittyvän testauksen toteutin Javan JUnit-yksikkötestauksella. Kirjoitin testit kaikelle mielestäni algoritmin toiminnan kannalta oleelliselle sisällölle. JUnit testien tarkempaa sisältöä voi tarkastella projektikansioni Test-alikansiosta. Suorituskykytestausta suoritin läpi koko projektin pyrkiessäni löytämään erilaisille pelitilanteille mahdollisimman hyvän heuristiikkafunktion.

Suorituskykytestit
------

Algoritmin suorituskykyä testasin sekä 3x3 että 4x4 kokoisilla pelilaatikoilla. Loin metodin, joka konstruoi ja ratkaisee 10 000 erilaista pelitilannetta. 3x3 kokoinen pelilaatikko, eli 8-peli, osoittautui erittäin nopeaksi ratkaista mistä tahansa alkutilanteesta. 8-pelin keskimääräinen ratkaisuaika oli X millisekunttia, ratkaisun löytämiseen vaadittiin noin X siirtoa ja keskimääräinen prioriteettijonon koko oli X. Koska 8-peli on erittäin nopea ratkaista, ei sen suorituskyvyn tarkastelu ole kovin mielekästä. Sen sijaan 15-pelin (4x4 laatikko) ratkaisuaikojen vaihtelu oli riittävän suurta, jotta tuloksista olisi mielekästä tehdä jonkinlaisia johtopäätöksiä. Alla olevassa kuvassa on kuvattu 100 ensimmäisen 15-pelin ratkaisuajat, siirtojen lukumäärät sekä prioriteettijonon koot. Selkeyden vuoksi tilanteista, joissa ratkaisuajat ovat samat, on siirtojen lukumääräksi ja prioriteettijonon kooksi laskettu keskiarvo. Tälläisiä tilanteita syntyi lähinnä vain niiden pelitilanteiden kohdalla, jotka ratkesivat alle 10 millisekunnissa.  

![Diagnostiikka] (Diagnostiikka.png)
