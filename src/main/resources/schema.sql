BEGIN TRANSACTION;
DROP TABLE IF EXISTS "Carreras";
CREATE TABLE IF NOT EXISTS "Carreras" (
	"id"	int NOT NULL,
	"inicio"	date NOT NULL,
	"fin"	date NOT NULL,
	"fecha"	date NOT NULL,
	"descr"	varchar(32),
	PRIMARY KEY("id"),
	CHECK("fin" < "fecha"),
	CHECK("inicio" <= "fin")
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
	"estado"	TEXT DEFAULT 'planificado' CHECK(("estado" = 'planificado' OR "estado" = 'finalizado' OR "estado" = 'abierto')),
	PRIMARY KEY("idCurso" AUTOINCREMENT)
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
	"dni"	TEXT NOT NULL DEFAULT 'ZZ',
	PRIMARY KEY("idColegiado" AUTOINCREMENT)
);
DROP TABLE IF EXISTS "Perito";
CREATE TABLE IF NOT EXISTS "Perito" (
	"idPerito"	INTEGER NOT NULL UNIQUE,
	"idColegiado"	INTEGER NOT NULL,
	PRIMARY KEY("idPerito")
);
DROP TABLE IF EXISTS "InformesPerito";
CREATE TABLE IF NOT EXISTS "InformesPerito" (
	"idInformePerito"	INTEGER NOT NULL,
	"idPerito"	INTEGER NOT NULL DEFAULT 0,
	"estado"	INTEGER NOT NULL DEFAULT 'pendiente',
	PRIMARY KEY("idInformePerito" AUTOINCREMENT)
);
DROP TABLE IF EXISTS "SolicitudColegio";
CREATE TABLE IF NOT EXISTS "SolicitudColegio" (
	"idSolicitud"	INTEGER UNIQUE,
	"estado"	TEXT NOT NULL DEFAULT 'pendiente' CHECK("estado" = 'pendiente' OR "estado" = 'aprobado'),
	"idColegiado"	INTEGER,
	"fecha"	TEXT,
	PRIMARY KEY("idSolicitud" AUTOINCREMENT),
	FOREIGN KEY("idColegiado") REFERENCES "Colegiado"("idColegiado")
);
DROP TABLE IF EXISTS "Inscripcion";
CREATE TABLE IF NOT EXISTS "Inscripcion" (
	"idInscripcion"	INTEGER NOT NULL UNIQUE,
	"idColegiado"	INTEGER,
	"idCurso"	NUMERIC,
	"estado"	TEXT NOT NULL DEFAULT 'preinscrito' CHECK(("estado" = 'preinscrito' OR "estado" = 'aprobado')),
	FOREIGN KEY("idCurso") REFERENCES "Curso"("idCurso"),
	PRIMARY KEY("idInscripcion" AUTOINCREMENT),
	FOREIGN KEY("idColegiado") REFERENCES "Colegiado"("idColegiado")
);
COMMIT;
