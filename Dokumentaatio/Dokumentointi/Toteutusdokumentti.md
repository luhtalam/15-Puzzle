Rakenne 
-------

Aika- ja tilavaativuudet
-------

Analysoin projektin määrittelydokumentissa ratkaisualgoritmin pahimman tapauksen aika- ja tilavaativuuksiksi O(2^n), jossa n on optimaallisimman ratkaisun siirtojen lukumäärä. Teoriassa ratkaisualgoritmi on edelleen aika- ja tilavaativuuksiltaan samaa luokkaa. Prioriteettijonosta nostetaan tarkasteluun aina, sillä hetkellä optimaallisin pelitilanne. Jotta aika- ja tilavaativuudet olisivat täsmälleen luokkaa 2^n, täytyisi käytännössä jokaisen uuden pelitilanteen olla yhtä optimaallinen kuin edeltäjänsä. Todellisuudessa pahimpaan aika- ja tilavaativuuteen ei törmätä, sillä uusien konstruoitujen pelitilanteiden prioriteetti eroaa valitsemani heuristiikkafunktion takia edeltäjästään. 

Optimaallisimmassa tapauksessa ratkaisualgoritmi käy läpi vain ratkaisuun vaadittavat n kappaletta siirtoja. Tällöin algortimi konstruoi keskimäärin 2*n uutta pelitilannetta, joten tilavaativuus on luokkaa 2nM, jossa n on siirtojen luokumäärä ja M on pelitaulukon tilavaatimus. Aikavaativuudeltaan tälläinen tilanne on luokkaa nN, jos oletetaan, että uudet pelitilanteet voidaan konstruoida ajassa N, joka on verrannollinen pelitilanteen kokoon N.
