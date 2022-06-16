package no.oslomet.cs.algdat.Oblig2;


////////////////// class DobbeltLenketListe //////////////////////////////

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;


public class DobbeltLenketListe<T> implements Liste<T> {

    /**
     * Node class
     *
     * @param <T>
     */
    private static final class Node<T> {
        private T verdi;                   // nodens verdi
        private Node<T> forrige;
        private Node<T> neste;    // pekere

        private Node(T verdi, Node<T> forrige, Node<T> neste) {
            this.verdi = verdi;
            this.forrige = forrige;
            this.neste = neste;
        }

        private Node(T verdi) {
            this(verdi, null, null);
        }
    }

    // instansvariabler
    private Node<T> hode;          // peker til den første i listen
    private Node<T> hale;          // peker til den siste i listen
    private int antall;            // antall noder i listen
    private int endringer;         // antall endringer i listen

    public DobbeltLenketListe() {
        this.hode = null;
        this.hale = null;
        this.antall = 0;
    }

    //Oppgave 1
    @Override
    public int antall() {
        return this.antall;
    }

    @Override
    public boolean tom() {
        return antall == 0;
    }

    public DobbeltLenketListe(T[] a) {//Konstruktør som lager en dobbeltlenket liste med verdiene fra tabell a
        if (a == null){//Dersom tabellen er tom gis det ut en NullPointerException
            throw new NullPointerException("Tabellen er null!");
        }
            Node<T> current;
            Node<T> q = null;

        for(T value : a){
            if(value == null){//dersom en verdi fra tabellen er tom skal den hoppes over
                continue;
            }

            current = new Node<>(value); //node current får ny verdi

            if(hode == null){//dersom hode == null skal current bli hode
                hode = current;
            }
            else{//dersom vi har en hode verdi fra før går vi inn hit
                q.neste = current; //node q peker fram på neste node current
                current.forrige = q;  //current peker bak på forrige node q
            }

            hale = current;//halen blir current verdi
            q = current;//q blir current verdi
            antall++;
        }
    }

    //Oppgave 2
    //2a
    @Override
    public String toString() {//Metode som gjør om en liste til en string, og returner stringen
        Node<T> current = hode;
        boolean shouldContinue = true;

        if(current == null){//dersom current == null (hode == null) er listen tom, og det skal ikke gås inn i while-løkken under.
            shouldContinue = false;
        }
        StringBuilder utskrift = new StringBuilder();//bruker StringBuilder for å bygge utskriften som skal returneres
        utskrift.append("[");


        while (shouldContinue){
            utskrift.append(current.verdi); //legger til current verdi i utskriften

            if(current.neste != null){ //dersom neste er noe annet enn null betyr det at det er flere verdier og vi er ikke ferdig i løkken
                utskrift.append(", ");
                current = current.neste;//bytter til neste node
            }else {//dersom neste == null går den inn hit og det er ingen verdier igjen i listen og går derfor ikke inn i løkken
                shouldContinue = false;
            }
        }

        utskrift.append("]");
        return String.valueOf(utskrift);//returner utskriften vi har bygget
    }

    public String omvendtString(){//Metode som gjør om en liste til en string, og returner stringen omvendt
        Node<T> current = hale;
        boolean shouldContinue = true;

        if(current == null){//dersom current == null (hale == null) er listen tom, og det skal ikke gås inn i while-løkken under.
            shouldContinue = false;
        }

        StringBuilder utskrift = new StringBuilder();//bruker StringBuilder for å bygge utskriften som skal returneres
        utskrift.append("[");


        while (shouldContinue){
            utskrift.append(current.verdi);//legger til current verdi i utskriften

            if(current.forrige != null){//dersom forrige er noe annet enn null betyr det at det er flere verdier og vi er ikke ferdig i løkken
                utskrift.append(", ");
                current = current.forrige;//bytter til noden foran
            }else {//dersom forrige == null går den inn hit og det er ingen verdier igjen i listen og går derfor ikke inn i løkken igjen
                shouldContinue = false;
            }
        }

        utskrift.append("]");
        return String.valueOf(utskrift);//returner utskriften vi har bygget
    }
    //2b
    @Override
    public boolean leggInn(T verdi) {//Metode for å legge inn en gitt verdi i en liste hvor verdien får første plass
        Objects.requireNonNull(verdi, "Ikke lov med null-verdier!");//Null-verdier er ikke tillatt, sjekker om verdien er null
        Node<T> nyNode = new Node<>(verdi);

        if (antall == 0) {//Dersom listen er tom, blir den nye noden både hode og hale
            hode = hale = nyNode;
        }
        else {//Dersom listen ikke er tom
            hale.neste = nyNode;//Den opprinnelige halen skal peke på nyNode
            nyNode.forrige = hale;//Ny node peker bak mot den opprinnelige halen
            hale = nyNode;//Den nye halen er nyNode
        }

        antall++; //plusser på antall fordi listen får ny verdi
        endringer++; //plusser på endringer fordi det har skjedd en endring, altså vi har lagt til en verdi
        return true;
    }
    //Oppgave 3
    //3a
    private Node<T> finnNode(int indeks) {
        Node<T> current;
        if (indeks < 0){
            throw new IndexOutOfBoundsException("Indeksen er ikke gyldig (mindre enn null)");
        }
        if (indeks > antall){
            throw new IndexOutOfBoundsException("Indeksen er ikke gyldig (større enn antall noder i lista)");
        }
        if (indeks < (antall / 2)) {//starter fra hode hvis antall/2 er større enn indeks
            current = hode;
            int i = 0; //current indeks
            while (current != null) {
                if (i == indeks){//kjører loopen og når current indeks er lik indeksen som er gitt inn returnerer vi current
                    return current;
                }
                i++;
                current = current.neste;
            }
        }
        else {//starter fra hale hvis antall/2 er mindre enn indeks
            current = hale;
            int i = antall - 1; //current indeks
            while (current != null) {
                if (i == indeks){//kjører loopen og når current indeks er lik indeksen som er gitt inn returnerer vi current
                    return current;
                }
                i--;
                current = current.forrige;
            }
        }
        throw new IndexOutOfBoundsException("Indeksen er ikke gyldig!");
    }
    @Override
    public T hent(int indeks) {
        indeksKontroll(indeks, false);
        return finnNode(indeks).verdi;
    }

    @Override
    public T oppdater(int indeks, T nyverdi) {
        Objects.requireNonNull(nyverdi, "Ikke lov med null-verdier!");

        indeksKontroll(indeks, false);

        Node<T> p = finnNode(indeks);
        T gamleVerdi = p.verdi;

        p.verdi = nyverdi;
        endringer++;
        return gamleVerdi;
    }
    //3b
    public Liste<T> subliste(int fra, int til) {
        fraTilKontroll(antall, fra, til);//kontrollerer om intervallet fra og til er godkjent.
        Liste<T> utskriftListe = new DobbeltLenketListe<>();//lager ny liste som skal returneres

        if (fra == 0 && til == 0) {
            return utskriftListe;
        }
        Node<T> startVerdi = finnNode(fra);//starter fra første node med indeksen fra

        int i = fra;

        while (i < til) {//kjører loop til slutten av intervallet,
            utskriftListe.leggInn(startVerdi.verdi);//legger til hver verdi til den nye Lista
            startVerdi = startVerdi.neste;//går videre til neste node i løkka
            i++;
        }
        return utskriftListe;//returnerer
    }
    private void fraTilKontroll(int antall, int fra, int til) {
        if (fra < 0) {
            throw new IndexOutOfBoundsException("Fra må være 0 eller større");
        }
        if (til > antall) {
            throw new IndexOutOfBoundsException("Til må være mindre enn eller lik antall");
        }
    }

    //Oppgave 4
    @Override
    public int indeksTil(T verdi) {//metode for å finne indeksen til en gitt verdi. Returnerer -1 dersom den gitte verdien ikke finnes i listen.
        if (verdi == null) {//hvis verdien er null returnerer vi null
            return -1;
        }
        Node<T> current = hode;//starter fra hode
        boolean erFunnet = false;
        int erFunnetIndeks = 0;

        for (int i = 0; i < antall; i++) {//kjører løkke som looper gjennom nodene til listen.
            if (verdi.equals(current.verdi)) {//dersom verdien som er gitt == verdien til current node har vi funnet verdien vi leter etter
                erFunnet = true;
                erFunnetIndeks = i; //lagrer indeksen til verdien
                break;
            }
            else {//går inn i else hvis vi ikke har funnet verdien vi leter etter og den neste noden blir den nye current.
                current = current.neste;
            }
        }
        if (erFunnet){//etter å ha loopa gjennom lista (eller breaka ut), hvis erFunnet == true returnerer vi indeksen
            return erFunnetIndeks;
        }
        else{//hvis erFunnet == false returnerer vi -1
            return -1;
        }
    }

    @Override
    public boolean inneholder(T verdi) {
        return indeksTil(verdi) != -1;
    }

    //Oppgave 5
    @Override
    public void leggInn(int indeks, T verdi) {

        if (indeks < 0){
            throw new IndexOutOfBoundsException("Indeks er ikke gyldig! (index < 0)");
        }
        if (indeks > antall){
            throw new IndexOutOfBoundsException("Indeks er ikke gyldig! (index > antall)");
        }
        if (antall == 0){//hvis lista er tom bruker vi forrige metode for innlegging av node. Blir satt på første plass.
            leggInn(verdi);
        }
        else if (indeks == 0){//hvis noden skal bli lagt inn i første plass
            hode = hode.forrige = new Node<>(verdi, null, hode);
            antall++;
            endringer++;
        }
        else if (indeks == antall){//hvis noden skal bli lagt inn i siste plass
            hale = hale.neste = new Node<>(verdi, hale, null);
            antall++;
            endringer++;
        }
        else {//hvis noden skal bli satt inn mellom to verdier
            Node<T> current = finnNode(indeks);
            current.forrige = current.forrige.neste = new Node<>(verdi, current.forrige, current);
            antall++;
            endringer++;
        }
    }

    //Oppgave6
    @Override
    public T fjern(int indeks) {//Metode for å fjerne en node med en gitt indeks fra en liste.
        indeksKontroll(indeks, false);//Kontroll om indeksen som er gitt er gyldig
        Node<T> current = hode;//starter fra hode

        if (antall == 1){//hvis listen inneholder en node
            hode = hale = null;
        }
        else if (indeks == 0) {//hvis hode skal fjernes
            hode = hode.neste;
            hode.forrige = null;
        }
        else if (indeks == antall - 1) {//hvis hale skal fjernes
            current = hale;
            hale = hale.forrige;
            hale.neste = null;
        }
        else {//hvis verdien som skal fjernes ikke er node eller hale
            current = finnNode(indeks);
            current.forrige.neste = current.neste;
            current.neste.forrige = current.forrige;
        }

        T fjernetVerdi = current.verdi;//lagrer den fjernet verdien
        current.verdi = null;
        current.neste = null;
        current.forrige = null;

        antall--;//reduserer antall siden en verdi fjernes
        endringer++;
        return fjernetVerdi;//returnerer fjernetVerdi
    }
    @Override
    public boolean fjern(T verdi) {//Metode for å fjerne en gitt verdi fra en liste.
        if (verdi == null) {//hvis det gis inn en ugyldig verdi (null), returneres det automatisk false
            return false;
        }
        Node<T> current = hode; //starter fra hode

        while (current != null) {
            if (current.verdi.equals(verdi)) {//dersom den gitte verdien finnes i listen, breaker vi ut av loopen.
                break;
            }
            current = current.neste;
        }
        if (current == null) {
            return false;
        }
        if (antall == 1) {
            hode = hale = null;
        }
        else if (current == hode) {//dersom verdien som er gitt er lik hodet
            hode = hode.neste;
            hode.forrige = null;
        }
        else if (current == hale) {//dersom verdien som er gitt er lik halen
            hale = hale.forrige;
            hale.neste = null;
        }
        else {//dersom verdien som er gitt er mellom to verdier
            current.forrige.neste = current.neste;
            current.neste.forrige = current.forrige;
        }

        current.verdi = null;
        current.neste = null;
        current.forrige = null;

        antall--;//reduserer antall siden en verdi fjernes
        endringer++;
        return true;
    }

    @Override
    public void nullstill() {//kopiert direkte fra en medelev som kopierte fra kompendiet. Jeg jobber individuelt så jeg skulle egentlig ikke gjøre oppgave 7, men nullstill brukes på testen til oppgave 8
        Node<T> p = hode;

        while (p != null)
        {
            Node<T> q = p.neste;

            p.neste = null;     // for resirkulering
            p.forrige = null;   // for resirkulering
            p.verdi = null;     // for resirkulering

            p = q;
        }
        antall = 0;
        endringer = 0;
        hode = hale = null;
    }

    //Oppgave 8
    //8B
    @Override
    public Iterator<T> iterator() {
        return new DobbeltLenketListeIterator();
    }

    //8D
    public Iterator<T> iterator(int indeks) {
        indeksKontroll(indeks, false);
        return new DobbeltLenketListeIterator(indeks);
    }

    private class DobbeltLenketListeIterator implements Iterator<T> {
        private Node<T> denne;
        private boolean fjernOK;
        private int iteratorendringer;

        private DobbeltLenketListeIterator() {
            denne = hode;     // p starter på den første i listen
            fjernOK = false;  // blir sann når next() kalles
            iteratorendringer = endringer;  // teller endringer
        }

        @Override
        public boolean hasNext() {
            return denne != null;
        }

        //8A
        @Override
        public T next() {
            if (iteratorendringer != endringer) {
                throw new ConcurrentModificationException("Iteratorendringer er ikke lik endringer!");
            }
            if (!hasNext()){
                throw new NoSuchElementException("Det er ikke fler elementer i listen!");
            }

            fjernOK = true;
            Node<T> temp = denne;
            denne = denne.neste;
            return temp.verdi;
        }
        //8C
        private DobbeltLenketListeIterator(int indeks) {
            denne = finnNode(indeks);
            fjernOK = false;
            iteratorendringer = endringer;
        }


    } // class DobbeltLenketListeIterator


} // class DobbeltLenketListe


