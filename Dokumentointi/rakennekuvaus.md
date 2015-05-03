Ohjelman logiikka on luokka MineField jossa meillä on BaseTable, eli taulukko missä on kaikki miinat merkitetty -1:ksi,
tyhjät ruudut 0 ja ruudut joissa on arvoja numeroilla 1-8. MineFieldilla on myös kenttä GameTable jossa kaikki avatut ruudut ovat näkyvillä. 

Peli käynnistyy luokasta Main, siellä luodaan yks GUI. GUIssa luodaan yksi MineField kentta. Johon aina vertaillaan 
nykyinen tilanne. GUI luo myös yksi TimerDisplay, jossa tapahtuu ajanlaskua. Luokka GUI luo jokaiselle 
JButtonille MouseListener. Eli luodaan NxN JButtonia. Kun painetaan nappiin "Change difficulty" niin suljetaan 
kenttä GUI ja avataan uusi kenttä Config eli toisen sanottu GUI luokasta kutsutaan Config luokka ja suljetaan pelin pääkenttä. 
Jos halutaan tarkistaa ennätykset klikataan “Check records” niin avautuu kenttä RecordTable.