# Zadatak 1

Napraviti javnu klasu **PrijemniException** u paketu **prijemni.izuzeci** kao neproveravani izuzetak i koja ima:
- Javni **konstruktor** koji kao parametar prima poruku greške i poziva odgovarajući konstruktor nadklase prosleđujući mu parametar.

Napraviti javnu klasu **PrijemniIspit** u paketu **prijemni** koja može da bude serijalizovana i ima:
- Privatni atribut **nazivUstanove**.
- Privatni atribut **godinaUpisa** koji predstavlja godinu upisa na koju se odnose podaci (npr. 2018).
- privatni atribut **brojMesta** koji predstvlja broj mesta za upis na fakultet.
- Privatni atribut **brojPrijavljenih** koji predstavlja broj prijavljenih kandidata za prijemni ispit.
- Odgovarajuće javne **get i set metode** za ove atribute. Nedozvoljene vrednosti za naziv su null i svaki String kraći od pet znakova, a svi ostali atributi moraju biti nula ili veći od nule. U slučaju unosa nedozvoljenih vrednosti, baciti izuzetak klase **PrijemniException** sa odgovarajućom porukom.
- Redefinisanu metodu **toString** klase Object koja vraća String sa svim podacima o prijemnom ispitu ali je potrebno izračunati i u taj String ubaciti i podatak o relativnom odnosu broja prijavljenih i broja mesta (podeliti ta dva).
- Redefinisanu **equals** metodu klase Object. Metoda prvo proverava da li je uneti objekat klase PrijemniIspit, pa ako nije vraca false. Metoda vraća true ako su vrednosti svih atributa jednaki vrednostima odgovarajućih atributa unetog prijemnog ispita, a inače false.

Napraviti javnu klasu **OrganizacijaPrijemnogIspita** u paketu **prijemni** koja ima:
- Privatni atribut **ustanove** koji predstavlja listu objekata klase **PrijemniIspit**. Odmah inicijalizovati listu.
- Javnu metodu **ucitajIzFajlaUListu** koja ne vraća ništa, a kao parametar dobija naziv fajla iz kojeg je potrebno deserijalizovati podatke o prijemnom ispitu i uneti ih u listu. Unos u listu se vrši samo za one ustanove (iz fajla) kod kojih je broj prijavljenih veći od nule. Ukoliko dodje do greške, baciti izuzetak klase **PrijemniException** sa odgovarajućom porukom.
- Javnu metodu **vratiUspesnePrijemneIspite** koja vraca listu naziva ustanova koje su 2018. godine imale veći broj prijavljenih nego 2017. godine.

Napraviti vizuelnu klasu **PrijemniGUI**u paketu **prijemni.gui** koja izgleda kao na slici. Naslov prozora bi trebalo da bude "Prijemni ispit", a centralni deo ekrana bi trebalo da sadrži editor za tekst. Kada se promeni dimenzija forme, trebalo bi da se ovaj centralni deo poveća/smanji a da ostale komponente ostanu na istom mestu.
- Klasa **PrijemniGUI** bi trebalo da sadrži privatni atribut **organizacijaPrijemnog** koji predstavlja objekat klase **OrganizacijaPrijemnogIspita**. Odmah inicijalizovati objekat.
- Kada se pritisne dugme "Izadji", prekida se izvršavanje programa.
- Kada se pritisne dugme "Ucitaj", iz editora se preuzima tekst koji sadrži naziv fajla i poziva se odgovarajuća metoda atributa **organizacijaPrijemnog** kojom se deserijalizuju podaci o prijemnim ispitima.
- Kada se pritisne dugme "Ispisi", ispisuje se izveštaj u editoru koji sadrži samo nazive ustanova koje su 2018. godine imali veći broj prijavljenih nego 2017. godine (poziva se odgovarajuća metoda atributa **organizacijaPrijemnog**).