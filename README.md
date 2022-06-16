[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-f059dc9a6f8d3a56e377f745f24479a46679e63a5d9fe6f495e02850cd0d8118.svg)](https://classroom.github.com/online_ide?assignment_repo_id=5849543&assignment_repo_type=AssignmentRepo)
# Obligatorisk oppgave 2 i Algoritmer og Datastrukturer

Denne oppgaven er en innlevering i Algoritmer og Datastrukturer. 
Oppgaven er levert av følgende studenter:
* Enes Ergin - s351880 - s351880@oslomet.no

# Oppgavebeskrivelse

I oppgave 1 så gikk jeg fram ved å først lage de simple metodene antall og tom. Antall skal returnere antall via hjelpevariabelene antall, og tom skal returnere true dersom listen er tom, og false dersom listen ikke er tom. Deretter lager vi konstruktøren. Første steg i konstruktøren er å sjekke om tabellen a er tom, hvis den er tom gis det en nullPointerException. Også looper vi gjennom tabellen med hjelp av en for-løkke og pekere, og legger til alle de gyldige verdiene til tabellen a inn i lista. Hopper altså over verdiene som er null "ikke gyldige"

I deloppgave 2a så lagde jeg to ganske like metoder. Formålet med metodene var å gjøre om en liste til en string, og forskjellen mellom dem var at den ene gjorde det på omvendt rekkefølge. Begge metodene looper gjennom lista, hvor den ene starter fra hode og går framover og den andre starter fra halen og går bakover, og legger til hver verdi til nodene de looper gjennom inn i en stringBuilder. Deretter blir den stringen som metodene har bygd returnert.

I deloppgave 2b derimot skulle jeg lage en metode som la til en verdi på slutten av lista. Metoden har først en sjekk for verdien som blir gitt inn for å sjekke om den er gyldig (ikke null). Deretter har vi to cases: 1. listen er tom og den nye verdien blir hale og hode 2.listen er ikke tom og den nye verdien blir kun hale

I deloppgave 3a lager jeg først en privat hjelpemetode finnNode som skal finne en node fra en liste med en gitt indeks. Metoden starter først med en sjekk om indeksen som er gitt er gyldig. Deretter har vi to cases: 1- Hvis indeks er før midten av lista skal metoden starte fra hodet og gå oppover for å finne node med gitt indeks. 2- Hvis indeks er etter midten av lista skal metoden starte fra halen og gå nedover for å finne noden med gitt indeks. Så lager jeg to andre metoder hent og oppdater. Metoden hent bruker hjelpemetoden finnNode for å returnere verdien på en gitt indeks, og metoden oppdater bruker hjelpemetoden finnNode for å oppdatere en node med en gitt verdi med en nyverdi, og deretter returnere den gamle verdien.

I deloppgave 3b lager jeg en metode som skal returnere en liste som består av nodene fra et gitt intervall av en annen liste. Metoden subliste starter med en sjekk om intervallet fra og til er godkjent (altså at listen vi skal hente nodene fra har indeksene fra og til tilgjengelig). Deretter lager metoden en ny liste som skal returneres på slutten. Metoden bruker hjelpemetoden finnNode for å finne noden som den skal starte fra, og looper gjennom lista helt til den indeksen den skal slutte på. Også returneres den nye lista som har blitt bygd.

I oppgave 4 lager jeg metode indeksTil som skal returnere indeksen til en gitt verdi dersom den finnes i listen, og returnere -1 hvis den ikke finnes. Hvis verdien som er gitt ikke er gyldig (null), returner vi -1 fordi den ikke finnes uansett. Deretter looper vi gjennom lista og hvis vi finner den gitte verdien breaker vi ut av loopen og returnerer indeksen til noden hvor verdien er lik den gitte verdien. På denne måten returneres den første noden dersom det er flere noder som har samme verdi som den gitte verdien. Jeg lager også metoden inneholder som skal returnere true dersom en liste inneholder en gitt verdi, og false hvis den ikke inneholder den gitte verdien. Metoden inneholder blir lagd ved bruk av metoden indeksTil.

I oppgave 5 lager jeg metoden leggInn hvor man skal kunne legge inn en node med gitt indeks og verdi inn i en liste. Starter metoden med en sjekk om indeksen som er gitt er gyldig. Noden kan ikke legges inn i en negativ indeks, eller en indeks som er større enn antall noder i lista. Etter sjekken har metoden 4 forskjellige cases: 1- lista er tom og noden skal bli både hode og hale i lista. 2- indeks == 0, altså den nye noden skal legges inn som hode i lista. 3- indeks == antall, altså den nye noden skal bli lagt inn som halen i lista. 4- Den nye noden skal bli lagt inn mellom to andre noder, altså ikke hode eller hale

I oppgave 6 lager to metoder som skal fjerne en node fra en liste. Den første metoden T fjern skal fjerne en node med gitt indeks og returnere verdien som blir fjernet, og den andre metoden boolean fjern skal fjerne en node med gitt verdi og returnere true hvis det skjer. 

Metoden T fjern starter med en indeksKontroll for å sjekke om det har blitt gitt en gyldig indeks. Deretter har vi 4 forskjellige cases: 1- Noden inneholder en verdi, altså både hodet og halen skal fjernes. 2- indeks==0, altså hodet skal fjernes. 3- indeks==antall-1, altså halen skal fjernes. 4- en verdi som ikke er hode eller hale skal fjernes. Etter å ha fjernet riktig node basert på de 4 casene returneres verdien som ble fjernet. 

Metoden boolean fjern derimot starter med en sjekk om den gitte verdien er gyldig eller ikke. Deretter loopes gjennom lista for å finne den gitte verdien slik at den kan fjernes. Hvis den gitte verdien blir funnet i loopen, breakes det ut av loopen og vi har 4 forskjellige cases hvor alle fjerner en node og returnerer true: 1- antall==1, som betyr at noden som skal fjernes er både hale og hode. 2- noden som skal fjernes er hode. 3- noden som skal fjernes er hale. 4- noden som skal fjernes er ikke node eller hale.  Hvis den gitte verdien ikke blir funnet gjennom hele loopen derimot returnerer vi false.

Oppgave 7 var jeg ikke ment til å gjøre, men siden testen til oppgave 8 bruker nullstill metoden fra oppgave 7, kopierte jeg nullstill metoden fra en medelev som kopierte fra kompendiet slik at testen til 8 ikke får failed. Kunne også ha fjernet testene som bruker nullstill (det var de 2-3 siste), men metoden nullstill var ganske simpel uansett :)

I oppgave 8 derimot var det ikke så mye tenking involvert ettersom at oppgaveteksten forklarte akkurat steg for steg hva man skulle gjøre. 

I deloppgave 8A lager jeg metoden T next. Metoden sjekker først om iteratorendringer er lik endringer. Hvis ikke, kastes en ConcurrentModificationException. Så en NoSuchElementException hvis det ikke er flere igjen i listen (dvs.hvis hasNext() ikke er sann/true). Deretter settes fjernOK til sann/true, verdien til denne returneres og denne flyttes til den neste node.

I deloppgave 8B lager jeg metoden iterator. Metoden skal returnere en instans av iteratorklassen.

I deloppgave 8C lager jeg konstruktøren DobbeltLenketListeIterator. Den skal sette pekeren denne til den noden som hører til den oppgitte indeksen. Resten skal være lik den konstruktøren som er ferdigkodet.

I deloppgave 8D lager jeg metoden iterator(indeks). Metoden sjekker først om indeksen som er gitt er lovlig ved hjelp av metoden indeksKontroll. Deretter skal metoden ved hjelp av konstruktøren i deloppgave c returnere en instans av iteratorklassen.
