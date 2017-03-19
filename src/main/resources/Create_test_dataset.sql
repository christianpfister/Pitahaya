/** Standardwerte für die Tabelle Rollen*/
insert into rollen (rolle_desc) values ('Projektleiter');
insert into rollen (rolle_desc) values ('Projektmitarbeiter');
insert into rollen (rolle_desc) values ('Auftraggeber');
insert into rollen (rolle_desc) values ('Product Owner');
insert into rollen (rolle_desc) values ('Produktmanager');

/** Standardwerte für die Tabelle Projektstatus*/
insert into projektstatus (projektstatus_desc) values ('Eröffnet');
insert into projektstatus (projektstatus_desc) values ('In Freigabe');
insert into projektstatus (projektstatus_desc) values ('Freigegeben');
insert into projektstatus (projektstatus_desc) values ('In Bearbeitung');
insert into projektstatus (projektstatus_desc) values ('Abgeschlossen');
insert into projektstatus (projektstatus_desc) values ('Abgelehnt');
insert into projektstatus (projektstatus_desc) values ('Zurückgestellt');


/**Testdaten*/
/**Datensatz für die View: Projekt_Overview*/
/**Datensatz für die View: Projekt_Team*/
/**Datensatz für die View: Projekt_Stakeholder*/

insert into projekt(idprojekt) values (1);

insert into projektdetails(projekt_title, projekt_desc, idprojektstatus, idprojekt) values ('Testprojekt', 'Test des Projekts', 1, 1);

insert into person(name, vorname, strasse, strassen_nr, wohnort, wohnort_plz, idfunktion, idabteilung) values ('Köhli', 'Patrick', 'Westiweg', 69, 'Westihaus', 6666, 'Produktmanager', 'Produktmanagement');
insert into person(name, vorname, strasse, strassen_nr, wohnort, wohnort_plz, idfunktion, idabteilung) values ('Kilchhofer', 'Marino', 'Vechiweg', 13, 'Vechigen', 3333, 'Bieper', 'Biepmanagement');
insert into person (name, vorname, strasse, strassen_nr, wohnort, wohnort_plz, idfunktion, idabteilung) values ('Chief', 'Inspector', 'Überwacherweg', 10, 'Aufpass', 5555, 'Vizepräsident', 'Geschäftsleitung');
insert into person (name, vorname, strasse, strassen_nr, wohnort, wohnort_plz, idfunktion, idabteilung) values ('Der', 'Pate', 'Scheffweg', 1, 'Ganzoben', 1111, 'Präsident', 'Geschäftsleitung');

insert into projektteam(idperson, idrolle, idprojekt) values (1, 1, 1);
insert into projektteam(idprojektteam, idperson, idrolle, idprojekt) values (1, 2, 2, 1);

insert into stakeholder(idprojekt, idperson, idrolle) values (1, 3, 3);
insert into stakeholder(idprojekt, idperson, idrolle) values (1, 4, 3);






