BEGIN TRANSACTION;
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
DROP TABLE IF EXISTS "SolicitudColegio";
CREATE TABLE IF NOT EXISTS "SolicitudColegio" (
	"idSolicitud"	INTEGER UNIQUE,
	"estado"	TEXT NOT NULL DEFAULT 'pendiente' CHECK("estado" = 'pendiente' OR "estado" = 'aprobado'),
	"idColegiado"	INTEGER,
	"fecha"	TEXT,
	FOREIGN KEY("idColegiado") REFERENCES "Colegiado"("idColegiado"),
	PRIMARY KEY("idSolicitud" AUTOINCREMENT)
);
DROP TABLE IF EXISTS "InformesPerito";
CREATE TABLE IF NOT EXISTS "InformesPerito" (
	"idInformePerito"	INTEGER NOT NULL,
	"idPerito"	INTEGER NOT NULL DEFAULT 0,
	"estado"	TEXT NOT NULL DEFAULT 'pendiente',
	"fecha"	TEXT,
	PRIMARY KEY("idInformePerito" AUTOINCREMENT)
);
DROP TABLE IF EXISTS "Inscripcion";
CREATE TABLE IF NOT EXISTS "Inscripcion" (
	"idInscripcion"	INTEGER NOT NULL UNIQUE,
	"idColegiado"	INTEGER,
	"idCurso"	INTEGER,
	"estado"	TEXT NOT NULL DEFAULT 'preinscrito' CHECK(("estado" = 'preinscrito' OR "estado" = 'inscrito')),
	"fecha"	TEXT,
	FOREIGN KEY("idCurso") REFERENCES "Curso"("idCurso"),
	FOREIGN KEY("idColegiado") REFERENCES "Colegiado"("idColegiado"),
	PRIMARY KEY("idInscripcion" AUTOINCREMENT)
);
DROP TABLE IF EXISTS "Colectivo";
CREATE TABLE IF NOT EXISTS "Colectivo" (
	"idColectivo"	INTEGER NOT NULL UNIQUE,
	"nombre"	TEXT NOT NULL,
	"apellidos"	TEXT NOT NULL,
	"dni" TEXT NOT NULL,
	"direccion"	TEXT NOT NULL,
	"poblacion"	TEXT NOT NULL,
	"telefono"	TEXT NOT NULL,
	"datosBancarios" TEXT NOT NULL,
	PRIMARY KEY("idColectivo" AUTOINCREMENT)
);
DROP TABLE IF EXISTS "Precolegiado";
CREATE TABLE IF NOT EXISTS "Precolegiado" (
	"id"	INTEGER NOT NULL UNIQUE,
	"nombre"	TEXT,
	"apellidos"	TEXT,
	"dni"	INTEGER,
	"direccion"	TEXT,
	"datosCuenta"	TEXT,
	"fechaSolicitudPrecolegiado"	TEXT,
	"titulacion"	TEXT,
	"Poblacion"	TEXT,
	PRIMARY KEY("id" AUTOINCREMENT)
);
DROP TABLE IF EXISTS "InscripcionColectivo";
CREATE TABLE IF NOT EXISTS "InscripcionColectivo" (
	"idInscripcionColectivo"	INTEGER NOT NULL UNIQUE,
	"idColectivo"	INTEGER,
	"idCurso"	INTEGER,
	"estado"	TEXT NOT NULL DEFAULT 'preinscrito' CHECK(("estado" = 'preinscrito' OR "estado" = 'inscrito')),
	"fecha"	TEXT,
	FOREIGN KEY("idCurso") REFERENCES "Curso"("idCurso"),
	FOREIGN KEY("idColectivo") REFERENCES "Colectivo"("idColectivo"),
	PRIMARY KEY("idInscripcionColectivo" AUTOINCREMENT)
);
DROP TABLE IF EXISTS "InscripcionPrecolegiado";
CREATE TABLE IF NOT EXISTS "InscripcionPrecolegiado" (
	"id"	INTEGER NOT NULL UNIQUE,
	"idCurso"	INTEGER,
	"idPrecolegiado"	INTEGER,
	"estado"	TEXT,
	"fecha"	TEXT,
	FOREIGN KEY("idCurso") REFERENCES "Curso"("idCurso"),
	PRIMARY KEY("id" AUTOINCREMENT)
);
DROP TABLE IF EXISTS "Perito";
CREATE TABLE IF NOT EXISTS "Perito" (
	"idPerito"	INTEGER NOT NULL UNIQUE,
	"idColegiado"	INTEGER NOT NULL,
	"fecha"	TEXT,
	"turno"	INTEGER,
	FOREIGN KEY("idColegiado") REFERENCES "Colegiado"("idColegiado"),
	PRIMARY KEY("idPerito")
);
COMMIT;
