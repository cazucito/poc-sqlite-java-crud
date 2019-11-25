/**
 * Author:  cazucito
 * Created: Nov 24, 2019
 */
CREATE TABLE "book" (
	"idBook"	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
	"title"	TEXT NOT NULL,
	"author"	TEXT NOT NULL DEFAULT 'Anónimo'
);
INSERT INTO "main"."book" ("idBook", "title", "author") VALUES ('1', 'Romeo y Julieta', 'William Shakespeare');
INSERT INTO "main"."book" ("idBook", "title", "author") VALUES ('2', 'Neuromancer', 'William Gibson');
