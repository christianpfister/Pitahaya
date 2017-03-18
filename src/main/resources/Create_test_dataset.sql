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



/**Datensatz für die View: Projekt-->Details-->Status*/
insert into projekt(idprojekt) values (1);
insert into projektstatus (idprojektstatus, projektstatus_desc) values (1, 'Eröffnet');
insert into projektdetails(idprojektdetails, projekt_title, projekt_desc, idprojektstatus, idprojekt) values (1, 'Testprojekt', 'Test des Projekts', 1, 1);

/**Datensatz für die View: Projekt-->Team-->Person--->Rolle*/
insert into rollen(idrolle, rolle_desc) values (1, 'Projektleiter');
insert into rollen(idrolle, rolle_desc) values (2, 'Projektmitarbeiter');
insert into projektteam(idprojektteam, idperson, idrolle, idprojekt) values (1, 1, 1, 1);
insert into projektteam(idprojektteam, idperson, idrolle, idprojekt) values (1, 2, 2, 1);
insert into person(idperson, name, vorname, strasse, strassen_nr, wohnort, wohnort_plz, idfunktion, idabteilung) values (1,'Köhli', 'Patrick', 'Westiweg', 69, 'Westihaus', 6666, 'Produktmanager', 'Produktmanagement');
insert into person(idperson, name, vorname, strasse, strassen_nr, wohnort, wohnort_plz, idfunktion, idabteilung) values (2,'Kilchhofer', 'Marino', 'Vechiweg', 13, 'Vechigen', 3333, 'Bieper', 'Biepmanagement');

/**Datensatz für die View: Projekt-->Stakeholder--->Person--->Rolle*/
insert into rollen (idrolle, rolle_desc) values (3, 'Auftraggeber');
insert into stakeholder(idstakeholder, idprojekt, idperson, idrolle) values (1, 1, 3, 3);
insert into person (idperson, name, vorname, strasse, strassen_nr, wohnort, wohnort_plz, idfunktion, idabteilung) values (3, 'Chief', 'Inspector', 'Überwacherweg', 10, 'Aufpass', 5555, 'Vizepräsident', 'Geschäftsleitung');


