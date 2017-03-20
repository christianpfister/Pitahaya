create table if not exists items (id long identity, name varchar(200), quantity decimal);


DROP ALL OBJECTS
;
create table projekt(
	idProjekt int primary key auto_increment,
	projekt_active boolean default true not null,
	create_TS timestamp default now(),
)
;


create table rollen(
idRolle int primary key auto_increment,
Rolle_Desc Varchar(45) not null,
)
;

create table Projektstatus(
idProjektstatus int primary key auto_increment,
Projektstatus_DESC varchar(45) not null,
)
;

create table TerminArt(
idTerminArt int primary key auto_increment,
Termin_Title varchar(45) not null,
Termin_DESC varchar(45),
)
;

create table Person(
idPerson int primary key auto_increment,
Name varchar(45) not null,
Vorname varchar(45) not null,
Strasse varchar(45) not null,
Strassen_Nr int not null,
Wohnort varchar(45) not null,
Wohnort_PLZ int not null,
idFunktion varchar(45) not null,
idAbteilung varchar(45),
)
;

create table stakeholder(
	idStakeholder int primary key auto_increment,
	idProjekt int not null,
	idPerson int not null,
	idRolle int not null,
	Foreign key (idProjekt) references projekt (idProjekt) on delete set null,
	Foreign key(idPerson) references person (idPerson) on delete set null,
	Foreign key(idRolle) references rollen (idRolle) on delete set null
)
;

create table projektteam(
idProjektteam int not null auto_increment,
idPerson int not null,
idRolle int not null,
idProjekt int not null,
Foreign key (idProjekt) references projekt (idProjekt)
on delete set null,
Foreign key (idRolle) references rollen (idRolle)
on delete set null
)
;
create table projektdetails(
idProjektdetails int primary key auto_increment,
Projekt_title varchar(45) not null,
Projekt_desc varchar(45),
idProjektstatus int,
idProjekt int not null,
Foreign key (idProjekt) references projekt (idProjekt)
on delete set null,
Foreign key (idProjektstatus) references projektstatus (idProjektstatus)
on delete set null,
)
;
create table termine(
idTermine int primary key auto_increment,
idTerminArt int not null,
Termin_Start_TS int not null,
Termin_End_TS int,
idProjekt int not null,
Foreign key (idProjekt) references projekt (idProjekt)
on delete set null,
Foreign key (idTerminArt) references terminart (idTerminArt)
on delete set null,
)
;
CREATE VIEW projekt_overview AS
SELECT
pro.idprojekt
,det.idprojektdetails
,det.projekt_title
,det.projekt_desc
,det.idprojektstatus
,stat.projektstatus_desc
,tm.idperson
,tm.idrolle
,pers.name
,pers.vorname
FROM
projekt pro

JOIN projektdetails det
ON pro.idprojekt = det.idprojekt

JOIN projektstatus stat
ON det.idprojektstatus = stat.idprojektstatus

JOIN projektteam tm
ON pro.idprojekt = tm.idprojekt

JOIN person pers
ON tm.idperson = pers.idperson

JOIN rollen rol
ON tm.idRolle = rol.idRolle
AND rol.Rolle_Desc = 'Projektleiter'

WHERE
	pro.projekt_active = true
;
CREATE VIEW projekt_team AS
SELECT
pro.idprojekt
,tm.idprojektteam
,tm.idPerson
,pers.Vorname
,pers.Name
,rol.rolle_desc

FROM
projekt pro

JOIN projektteam tm
ON pro.idprojekt = tm.idprojekt

JOIN person pers
ON tm.idperson = pers.idperson

JOIN rollen rol
ON tm.idrolle = rol.idrolle
;

CREATE VIEW projekt_stakeholder AS
SELECT
pro.idprojekt
,stak.idstakeholder
,pers.*
,rol.rolle_desc

FROM
projekt pro

JOIN stakeholder stak
ON pro.idprojekt = stak.idprojekt

JOIN rollen rol
ON stak.idrolle = rol.idrolle

JOIN person pers
ON stak.idperson = pers.idperson
;

/** Fügt die Default Status hinzu */

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

