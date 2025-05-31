# semsteraufgabe
Verleih-System\n
Es soll ein Verleihsystem f¨ur eine Studierendenvertretung erstellt werden. In dem System sollen verschiedene
Daten (bei Gegenst¨anden Inventarnummer, Bezeichnung, Anzahl, Zustand auf einer Skala
von 1-5, Verleihbarkeit, Serien-/Modellnummer, Kommentar; bei Schl¨usseln Schl¨usselnummer, wof¨ur der
Schl¨ussel schließt, Kommentar) erfasst und verwaltet werden. Bei der Leihe soll erfasst werden, wer den
Gegenstand ausgeliehen hat (Vorname, Nachname, Adresse, Handynummer, E-Mail), ob ein Pfand entrichtet
wurde und wie viel, wann ausgeliehen wurde, wann die geplante R¨uckgabe ist, wann die R¨uckgabe
tats¨achlich erfolgt ist und es soll die M¨oglichkeit geben, einen Kommentar hinzuzuf¨ugen.
Das System soll die Liste der Gegenst¨ande und Schl¨ussel als (auch von Menschen) lesbare CSV-Datei
speichern.4 Zus¨atzlich soll das System in der Lage sein, gefilterte Listen als CSV-Datei zu exportieren.
Hierbei soll man ausw¨ahlen k¨onnen, ob alle verliehenen Gegenst¨ande enthalten sind oder nur jene, deren
Leihfrist bereits abgelaufen ist.
Freiwillige Zusatzaufgaben
1. Implementierung einer Suchfunktion zur Suche nach Gegenst¨anden/Schl¨usseln oder leihenden Personen.
2. Anzeige und Verwaltung in verschiedenen Kategorien, die vom Benutzer festgelegt werden k¨onnen.
3. Benutzermanagement: Man muss sich mit einer Benutzerkennung anmelden. Bei jedem Gegenstand
wird automatisch vermerkt, wer und wann zuletzt eine ¨Anderung eingetragen hat.
Technische Anforderungen
Das System soll modular aufgebaut und leicht erweiterbar sein.
