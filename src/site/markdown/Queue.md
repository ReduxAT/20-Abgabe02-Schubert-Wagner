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
