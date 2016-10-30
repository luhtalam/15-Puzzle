Käyttöohjeet
=======

Pelin idea
-------

15-peli (engl. 15-puzzle tai Boss puzzle) on ongelman ratkaisupeli, jossa 15 numeroitua laattaa on sijoitettuna tavallisimmin
4 kertaa 4 kokoiseen laatikkoon. Näin laatikkoon jää yksi tyhjä kolo pelilaattojen siirtämistä varten. Pelin alussa pelilaatat on sijoitettu pelilaatikkoon
epäjärjestykseen. Pelaajan tehtävänä on saada pelilaatat siirrettyä takaisin numerojärjestykseen liu'uttamalla palikoita yksi
kerrallaan viereisestä ruudusta kulloinkin tyhjänä olevaan ruutuun niin, että lopussa tyhjä ruutu on laatikon oikeassa 
alakulmassa. 

![ratkaistu peli](15-puzzle.png)

Ohjelman toiminta
-------

15-pelin ratkaisu -algoritmi käynnistetään avaamalla 15-Puzzle kansion juuressa oleva jar-tiedosto 15-puzzle.jar. Tällöin käyttäjälle avautuu tekstikäyttöliittymä, josta ensimmäiseksi valitaan halutaanko ratkaista 8-peli (3x3-ruudukko) vai 15-peli (4x4-ruudukko). Kun valinta on tehty ohjelma konstruoi käyttäjälle satunnaisen pelin alkutilanteen. Tässä vaiheessa käyttäjä voi valita konstruoidaanko uusi pelitilanne vai ratkaistaanko nykyinen. Mikäli alkutilanne kelpaa käyttäjälle, algoritmi löytää ratkaisun hetkessä ja ilmoittaa ratkaisun löytymisestä käyttäjälle. Tässä vaiheessa ratkaistun pelin ratkaisuun johtaneet siirrot voi  halutessaan tulostaa näytölle. Ohjelman voi sulkea missä tahansa vaiheessa antamalla tekstikäyttöliittymälle komennon x.
