Rakenne 
-------

Aika- ja tilavaativuudet
-------

Analysoin projektin määrittelydokumentissa ratkaisualgoritmin pahimman tapauksen aika- ja tilavaativuuksiksi O(b^n)[1][2], jossa n on optimaallisimman ratkaisun siirtojen lukumäärä ja b on pelipuun keskimääräinen haarautumiskerroin. Teoriassa ratkaisualgoritmi on edelleen aika- ja tilavaativuuksiltaan samaa luokkaa. Prioriteettijonosta nostetaan tarkasteluun aina, sillä hetkellä optimaallisin pelitilanne. Jotta aika- ja tilavaativuudet olisivat täsmälleen luokkaa b^n, täytyisi käytännössä jokaisen uuden pelitilanteen olla yhtä optimaallinen kuin edeltäjänsä. Todellisuudessa pahimpaan aika- ja tilavaativuuteen ei törmätä, sillä uusien konstruoitujen pelitilanteiden prioriteetti eroaa valitsemani heuristiikkafunktion takia edeltäjästään. 


Parannusehdotuksia ja pohdintoja
-------

Algoritmin todellinen ratkaisunopeus riippuu pitkälälti sopivan heuristiikkafunktion valinnasta. Mitä paremmin heuristiikkafunktio arvioi silloisenkin pelitilanteen "arvoa" sitä nopeammin ratkaisu löytyy. Päädyin työssäni lopulta heuristiikkafunktioon, joka laskee pelitilanteen Manhattan distancen[3] arvon, kertoo sen neljällä ja painottaa sitä tehtyjen siirtojen lukumäärällä. Kerroin neljä osoittautui sopivaksi kompromissiksi optimaallisen ratkaisun ja sen löytämiseen käytetyn ajan suhteen. Kertoimella neljä päästään noin kertoimen 1,2 päähän optimaallisimmasta ratkaisusta, mutta algoritmin laskenta-aika on satoja, joissain tapauksissa jopa tuhansia, kertoja nopeampi kuin optimaallisen/lähes optimaallisen ratkaisun löytäminen. 

Mikäli algoritmia haluaisi kehittää eteenpäin, pitäisi heuristiikkafunktion rakennetta muuttaa merkittävästi. Perinteisillä heuristiikkafunktiolla, mm. Manhattan distance, joudutaan lähestulkoon aina tekemään kompromisseja optimaallisen tuloksen ja käytetyn ajan suhteen. Mikäli algoritmia haluaisi tehostaa voisi heuristiikkassa käyttää erilaisia tietokantoja, joihin erilaisia tilanteita olisi laskettu valmiiksi. Tälläisiä tietokantoja ovat mm. Walking distance[4] ja erilaiset kuvio tietokannat(pattern databases)[5]. 

Lähteet
-------

[1] https://en.wikipedia.org/wiki/A*_search_algorithm#Complexity

[2] https://en.wikipedia.org/wiki/Branching_factor

[3] https://en.wikipedia.org/wiki/Taxicab_geometry

[4] http://www.ic-net.or.jp/home/takaken/e/15pz/index.html

[5]https://heuristicswiki.wikispaces.com/file/view/Searching+with+pattern+database+%28Culberson+%26+Schaeffer+1996%29.pdf/92790472/Searching%20with%20pattern%20database%20%28Culberson%20%26%20Schaeffer%201996%29.pdf
