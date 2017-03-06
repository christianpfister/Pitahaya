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
,det.idprojektteam
,det.idperson
,det.idrolle
,det.name
,det.vorname
,det.strasse
,det.strassen_nr
,det.wohnort
,det.wohnort_plz
,det.idfunktion
,det.idabteilung
FROM
projekt pro

JOIN projektteam tm
ON pro.idprojekt = tm.idprojekt

JOIN person pers
ON tm.idprojektteam = pers.idprojektteam

JOIN rollen rol
ON tm.idprojektteam = rol.idprojektteam
;
CREATE VIEW stakeholder AS
SELECT
pro.idprojekt
,det.idstakeholder
,det.idperson
,det.idrolle
,det.name
,det.vorname
,det.strasse
,det.strassen_nr
,det.wohnort
,det.wohnort_plz
,det.idfunktion
,det.idabteilung
,det.rolle_desc
FROM
projekt pro

JOIN stakeholder stak
ON pro.idprojekt = stak.idprojekt

JOIN rollen rol
ON stak.idstakeholder = rol.idstakeholder

JOIN person pers
ON stak.idstakeholder = pers.idstakeholder
;