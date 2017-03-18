/** Standardwerte für die Tabelle Rollen*/
insert into rollen (rolle_desc) values ("Projektleiter");
insert into rollen (rolle_desc) values ("Projektmitarbeiter");
insert into rollen (rolle_desc) values ("Auftraggeber");
insert into rollen (rolle_desc) values ("Product Owner");
insert into rollen (rolle_desc) values ("Produktmanager");

/** Standardwerte für die Tabelle Projektstatus*/
insert into projektstatus (projektstatus_desc) values ("Eröffnet");
insert into projektstatus (projektstatus_desc) values ("In Freigabe");
insert into projektstatus (projektstatus_desc) values ("Freigegeben");
insert into projektstatus (projektstatus_desc) values ("In Bearbeitung");
insert into projektstatus (projektstatus_desc) values ("Abgeschlossen");
insert into projektstatus (projektstatus_desc) values ("Abgelehnt");
insert into projektstatus (projektstatus_desc) values ("Zurückgestellt");


/**ZU ÜBERARBEITEN!! */
/**Datensatz für die View: Projekt-->Details-->Status*/
insert into projekt(idprojekt) values (111);
insert into projektstatus (idprojektstatus, projektstatus_desc) values (0, 'Statusbeschrieb');
insert into projektdetails(idprojektdetails, projekt_title, projekt_desc, idprojektstatus, idprojekt) values (222, 'Testprojekt', 'Detailsbeschrieb', 0, 111);

/**Datensatz für die View: Projekt-->Team-->Person--->Rolle*/
insert into projekt(idprojekt) values (111);
insert into projektteam(idprojektteam, idperson, idrolle, idprojekt) values (1212, 19, 2, 111);
insert into person(idperson, name, vorname, strasse, strassen_nr, wohnort, wohnort_plz, idfunktion, idabteilung) values (19,'Köhli', 'Mamma', 'Plauschweg', 69, 'Köhlhausen', 1313, 'Funktion1', 'Abteilung1');
insert into rollen(idrolle, rolle_desc) values (2, 'Mami');

/**Datensatz für die View: Projekt-->Stakeholder--->Person--->Rolle*/
insert into projekt(idprojekt) values (111);
insert into rollen (idrolle, rolle_desc) values (1, 'Scheff');
insert into stakeholder(idstakeholder, idprojekt, idperson, idrolle) values (12, 111, 20, 1);
insert into person (idperson, name, vorname, strasse, strassen_nr, wohnort, wohnort_plz, idfunktion, idabteilung) values (20, 'Muster', 'Max', 'Musterstrasse', 10, 'Musterhausen', 1000, 'Funktion2', 'Abteilung2');


