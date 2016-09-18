Viikkoraportti 2
=======

Toisella viikolla tavoitteena oli aloittaa varsinaisen 15-pelin ratkaisu algoritmin koodaaminen. Kävin torstaina kysymässä
muutamia vinkkejä käytännön toteutuksesta. Näistä suurin osa oli sellaisia asioita joita olin jo pohtinut valmiiksi, mutta
halusin niille vielä varmistuksen. Perehdyin ratkaisualgoritmiin torstai-iltai illasta eteenpäin ja sainkin varsin nopeasti
koodattua tehokkaan ratkaisu algoritmin 3x3 -matriisin eli 8-pelin ratkaisemiseen.  Illan päätteeksi kokeilin toimisiko kyseinen algoritmi jo sellaisenaan 4x4 -matriisiin, muttei toiminut. 

Itse algoritmin toiminta on hyvin yksinkertainen: konstruoidaan alkutilanne, josta algoritmi lähtee rakentamaan seuraavia pelitilanteita ja tallentaa niitä kekoon, josta nostetaan seuraavaksi tarkasteltavaksi pelitilanteeksi aina sillä hetkellä optimaallisin. Ongelmaksi muodostui toimivan heuristiikka funktion löytäminen, eli funktion jonka tehtävänä on arvottaa eri pelitilanteet niiden sopivuuden mukaan. Lähdin liikkeelle perinteisellä Manhattan distancella, MD, jossa pelin arvo määritellään sen mukaan kuinka monen "askeleen" päässä kukin pelilaatta on oikeasta paikastaan. Tällä tavoin sain 3x3 matriisit ratkeamaan varsin nopeasti, mutta joidenkin pelitilanteiden kohdalla algoritmi näytti jäävän luuppiin saavutettuaan jonkin MD-arvon. Tämä johtuu todennäköisesti siitä, että pelin konstruoimat uudet pelitilanteet ovat arvoltaan (MD) lähes yhtä arvokkaita kuin edelliset, jonka takia keosta nostetaan uudelleen ja uudelleen lähes identtisiä pelitilanteita.
