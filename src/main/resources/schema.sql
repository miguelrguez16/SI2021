--Primero se deben borrar todas las tablas (de detalle a maestro) y lugo anyadirlas (de maestro a detalle)
--(en este caso en cada una de las aplicaciones (tkrun y descuento) se usa solo una tabla, por lo que no hace falta)

--Para giis.demo.tkrun:
drop table Carreras;
create table Carreras (id int primary key not null, inicio date not null, fin date not null, fecha date not null, descr varchar(32), check(inicio<=fin), check(fin<fecha));

drop table Colegiado;
drop table Inscripcion;
drop table Cursos;


CREATE TABLE "Colegiado" (
	"idcolegiado"	INTEGER NOT NULL UNIQUE,
	"nombre"	TEXT NOT NULL,
	"apellidos"	INTEGER NOT NULL,
	"direccion"	TEXT NOT NULL,
	"poblacion"	TEXT NOT NULL,
	"telefono"	TEXT NOT NULL,
	"datos bancarios"	TEXT NOT NULL,
	"fechaSolicitudColegiado"	TEXT NOT NULL,
	"titulacion"	TEXT NOT NULL DEFAULT 'informatica',
	"centro"	TEXT NOT NULL DEFAULT 'uniovi',
	"añotitulo"	INTEGER NOT NULL DEFAULT 2000,
	PRIMARY KEY("idcolegiado" AUTOINCREMENT)
);
CREATE TABLE "Cursos" (
	"idcurso"	INTEGER NOT NULL UNIQUE,
	"nombre"	TEXT NOT NULL,
	"precio"	REAL,
	"plazasTotales"	INTEGER DEFAULT 0,
	"fechaInicio"	TEXT,
	"fechaFin"	TEXT,
	"fechaInicioInscripcion"	TEXT,
	"fechaFinInscripción"	date,
	"estado"	TEXT NOT NULL DEFAULT 'planificado',
	PRIMARY KEY("idcurso" AUTOINCREMENT)
);
CREATE TABLE "Inscripcion" (
	"idInscripcion"	INTEGER NOT NULL UNIQUE,
	"idcolegiado"	INTEGER NOT NULL,
	"idcurso"	NUMERIC NOT NULL,
	"estado"	INTEGER NOT NULL,
	FOREIGN KEY("idcurso") REFERENCES "Inscripción"("idInscripcion"),
	FOREIGN KEY("idcolegiado") REFERENCES "Colegiado"("idcolegiado"),
	PRIMARY KEY("idInscripcion" AUTOINCREMENT)
);

