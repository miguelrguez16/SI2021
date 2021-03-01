--Datos para carga inicial de la base de datos
delete from carreras;
insert into carreras(id,inicio,fin,fecha,descr) values 
	(100,'2016-10-05','2016-10-25','2016-11-09','finalizada'),
	(101,'2016-10-05','2016-10-25','2016-11-10','en fase 3'),
	(102,'2016-11-05','2016-11-09','2016-11-20','en fase 2'),
	(103,'2016-11-10','2016-11-15','2016-11-21','en fase 1'),
	(104,'2016-11-11','2016-11-15','2016-11-22','antes inscripcion'),
	(105,'2016-11-12','2016-11-16','2016-11-23','en fase 1');

delete from Cursos;
	INSERT INTO "Cursos" ("idcurso","nombre","precio","plazasTotales","fechaInicio","fechaFin","fechaInicioInscripcion","fechaFinInscripción","estado") VALUES (1,'data mining',34.0,45,'2020-11-20','2020-11-30','2020-10-20','2020-10-30','finalizado'),
 (2,'redes',22.0,32,'2021-05-20','2021-06-30','2021-02-20','2021-02-28','abierto'),
 (3,'java',10.0,23,NULL,NULL,NULL,NULL,'planificado');