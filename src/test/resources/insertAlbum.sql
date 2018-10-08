insert into albums(artiestid, naam) values
((select id from artiesten where naam='testartiest'), 'testalbum');
insert into tracks(albumid, naam, tijd) values
((select id from albums where naam='testalbum'), 'testtrack', 10);