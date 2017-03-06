insert into projekt(idprojekt) values (111);
insert into projektstatus (idprojektstatus, projektstatus_desc) values (0, 'Statusbeschrieb');
insert into projektdetails(idprojektdetails, projekt_title, projekt_desc, idprojektstatus, idprojekt) values (222, 'Testprojekt', 'Detailsbeschrieb', 0, 111);