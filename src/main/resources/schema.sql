BEGIN TRANSACTION;
DROP TABLE IF EXISTS "Carreras";
CREATE TABLE IF NOT EXISTS "Carreras" (
	"id"	int NOT NULL,
	"inicio"	date NOT NULL,
	"fin"	date NOT NULL,
	"fecha"	date NOT NULL,
	"descr"	varchar(32),
	CHECK("inicio" <= "fin"),
	CHECK("fin" < "fecha"),
	PRIMARY KEY("id")
);
DROP TABLE IF EXISTS "Colegiado";
CREATE TABLE IF NOT EXISTS "Colegiado" (
	"idColegiado"	INTEGER NOT NULL UNIQUE,
	"nombre"	TEXT NOT NULL,
	"apellidos"	TEXT NOT NULL,
	"direccion"	TEXT NOT NULL,
	"poblacion"	TEXT NOT NULL,
	"telefono"	TEXT NOT NULL,
	"datosBancarios"	TEXT NOT NULL,
	"fechaSolicitudColegiado"	TEXT NOT NULL,
	"titulacion"	TEXT NOT NULL DEFAULT 'informatica',
	"centro"	TEXT NOT NULL DEFAULT 'uniovi',
	"anioTitulo"	INTEGER NOT NULL DEFAULT 2000,
	PRIMARY KEY("idColegiado" AUTOINCREMENT)
);
DROP TABLE IF EXISTS "SolicitudColegio";
CREATE TABLE IF NOT EXISTS "SolicitudColegio" (
	"idSolicitud"	INTEGER NOT NULL UNIQUE,
	"estado"	TEXT NOT NULL DEFAULT 'pendiente' CHECK("estado" = 'pendiente' OR "estado" = 'aprobado'),
	"idColegiado"	INTEGER NOT NULL,
	FOREIGN KEY("idColegiado") REFERENCES "Colegiado"("idColegiado"),
	PRIMARY KEY("idSolicitud" AUTOINCREMENT)
);
DROP TABLE IF EXISTS "Inscripcion";
CREATE TABLE IF NOT EXISTS "Inscripcion" (
	"idInscripcion"	INTEGER NOT NULL UNIQUE,
	"idColegiado"	INTEGER NOT NULL,
	"idCurso"	NUMERIC NOT NULL,
	"estado"	TEXT NOT NULL DEFAULT 'preinscrito' CHECK(("estado" = 'preinscrito' OR "estado" = 'aprobado')),
	FOREIGN KEY("idColegiado") REFERENCES "Colegiado"("idColegiado"),
	FOREIGN KEY("idCurso") REFERENCES "Curso"("idCurso"),
	PRIMARY KEY("idInscripcion" AUTOINCREMENT)
);
DROP TABLE IF EXISTS "Curso";
CREATE TABLE IF NOT EXISTS "Curso" (
	"idCurso"	INTEGER NOT NULL UNIQUE,
	"nombre"	TEXT NOT NULL,
	"precio"	REAL,
	"plazasTotales"	INTEGER DEFAULT 0,
	"fechaInicio"	TEXT,
	"fechaFin"	TEXT,
	"fechaInicioInscripcion"	TEXT,
	"fechaFinInscripción"	TEXT,
	"estado"	TEXT DEFAULT 'pendiente' CHECK(("estado" = 'pendiente' OR "estado" = 'finalizado' OR "estado" = 'abierto')),
	PRIMARY KEY("idCurso" AUTOINCREMENT)
);
COMMIT;
