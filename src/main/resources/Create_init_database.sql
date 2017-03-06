DROP SCHEMA PUBLIC CASCADE
;
create table projekt(
	idProjekt int primary key,
)
;


create table rollen(
idRolle int primary key,
Rolle_Desc Varchar(45),
)
;

create table Projektstatus(
idProjektstatus int primary key,
Projektstatus_DESC varchar(45) not null,
)
;

create table TerminArt(
idTerminArt int primary key,
Termin_Title varchar(45) not null,
Termin_DESC varchar(45),
)
;

create table Person(
idPerson int primary key,
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
	idStakeholder int primary key,
	idProjekt int not null,
	idPerson int not null,
	idRolle int not null,
	Foreign key (idProjekt) references projekt (idProjekt)
		on delete set null,
Foreign key(idPerson) references person (idPerson) on delete set null,
Foreign key(idRolle) references rollen (idRolle) on delete set null
)
;

create table projektteam(
idProjektteam int,
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
idProjektdetails int primary key,
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
idTermine int primary key,
idTerminArt int not null,
Termin_Start_TS int,
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
FROM
projekt pro

JOIN projektdetails det
ON pro.idprojekt = det.idprojekt

JOIN projektstatus stat
ON det.idprojektstatus = stat.idprojektstatus
;
CREATE VIEW projekt_team AS
SELECT
pro.idprojekt
,tm.idprojektteam
,pers.*
,rol.rolle_desc

FROM
projekt pro

JOIN projektteam tm
ON pro.idprojekt = tm.idprojekt

JOIN person pers
ON tm.idperson= pers.idperson

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