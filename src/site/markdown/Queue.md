# Was ist eine Queue

Eine Queue (Warteschlange) ist eine dynamische Datenstruktur, die eine beliebige
Menge von Elementen speichern kann, jedoch können die gespeicherten
Elemente nur in der gleichen Reihenfolge wieder gelesen werden, wie sie
gespeichert wurden.

# Wie kann eine Queue getestet werden

Eine Queue testet man, indem man zuerst eine Queue mit beliebiger Länge erstellt.
Anschließend können biliebig viele Elemente in die Queue gespeichert werden. (ACHTUNG: Wenn die Anzahl der gespeicherten
Elemente die maximale Größe der Queue überschreitet, wird eine Exception geworfen.)
Anschließend können die Elemente wieder aus der Queue genommen werden. Dabei ist darauf zu achten, dass immer nur das
Element zurückgegeben wird, welches zuerst in die Queue gespeichert wurde (First in first out). (ACHTUNG: Wenn sich
dabei kein Element mehr die der Queue befindet, wird eine Exception geworfen.)

```
@Override
    public T remove() {
        T element = poll();
        if (element == null)
            throw new NoSuchElementException("there's no element any more");
        return element;
    }
```

# Mögliche Einsatzgebiete einer Queue
Typische Anwendungsbereiche sind:

 * Druckerschlange
 * Tastatureingabe
 * Multitask-Systeme
 * Breitensuche

, da eine Queue über das FiFo (First in First out) Verfahren funktioniert -> also das was zuerst kommt, wird zuerst behandelt.

# Was sind Generics?
Generics sind generische Klassen. Das heißt, die Klassen erlauben es einem ein oder mehrere Datentypen,
 welche intern verarbeitet werden, variabel zu halten. In diesem Beispiele gibt es eine generische Queue, 
 das bedeutet also das egal was für ein Datentyp die Queue beinhalten muss, es funktioniert, da sie Datentypen unabhängig implementiert wurde. 
 
# Was ist eine Code Coverage bei Source Code Tests?

Die Code Coverage oder auf Deutsch "Code Abdeckung" gibt an wie viel prozent des Codes durch die Tests Abgedeckt wurde,
 also wie viel Prozent des Codes durch den Test ausgeführt wurden und gibt somit einen guten Überblick ob 
 und was die Tests abdecken.  