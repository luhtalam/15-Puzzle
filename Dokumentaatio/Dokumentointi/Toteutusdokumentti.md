Rakenne 
-------

Aika- ja tilavaativuudet
-------

Analysoin projektin määrittelydokumentissa ratkaisualgoritmin pahimman tapauksen aika- ja tilavaativuuksiksi O(2^n), jossa n on optimaallisimman ratkaisun siirtojen lukumäärä. Teoriassa ratkaisualgoritmi on edelleen aika- ja tilavaativuuksiltaan samaa luokkaa. Prioriteettijonosta nostetaan tarkasteluun aina, sillä hetkellä optimaallisin pelitilanne. Jotta aika- ja tilavaativuudet olisivat täsmälleen luokkaa 2^n, täytyisi käytännössä jokaisen uuden pelitilanteen olla yhtä optimaallinen kuin edeltäjänsä. Todellisuudessa pahimpaan aika- ja tilavaativuuteen ei törmätä, sillä uusien konstruoitujen pelitilanteiden prioriteetti eroaa valitsemani heuristiikkafunktion takia edeltäjästään. 

Optimaallisimmassa tapauksessa ratkaisualgoritmi käy läpi vain ratkaisuun vaadittavat n kappaletta siirtoja. Tällöin algortimi konstruoi keskimäärin 2n uutta pelitilannetta, joten tilavaativuus on 2nM, jossa n on siirtojen lukumäärä ja M on pelitaulukon tilavaatimus. Aikavaativuudeltaa tälläinen tilanne on myös 2nM, jos oletetaan, että uudet pelitilanteet voidaan konstruoida ajassa M, joka on verrannollinen pelitilanteen kokoon M. Näin olleen ratkaisualgoritmin parhaan tapauksen aika- ja tilavaativuus on luokkaa O(n).
