---DELETE TABLE---
DROP TABLE IF EXISTS "rl_user_role";
DROP TABLE IF EXISTS "rl_role";
DROP TABLE IF EXISTS "rl_user";

---CREATE TABLE---
CREATE TABLE "rl_user" (
	"pkid" serial NOT NULL,
	"name" varchar(50) NOT NULL,
	"surname" varchar(50) NOT NULL,
	"username" varchar(50) NOT NULL,
	"password" varchar(50) NOT NULL,
	CONSTRAINT "rl_user_pk" PRIMARY KEY ("pkid")
) WITH (
  OIDS=FALSE
);

CREATE TABLE "rl_user_role" (
    "pkid" serial NOT NULL,
	"fk_user_id" integer NOT NULL,
	"fk_role_id" integer NOT NULL,
	CONSTRAINT "rl_user_role_pk" PRIMARY KEY ("pkid")
) WITH (
  OIDS=FALSE
);

CREATE TABLE "rl_role" (
	"pkid" serial NOT NULL,
	"name" varchar(50) NOT NULL,
	"description" varchar(50) NOT NULL,
	CONSTRAINT "rl_role_pk" PRIMARY KEY ("pkid")
) WITH (
  OIDS=FALSE
);

ALTER TABLE "rl_user_role" ADD CONSTRAINT "rl_user_role_fk0" FOREIGN KEY ("fk_user_id") REFERENCES "rl_user"("pkid");
ALTER TABLE "rl_user_role" ADD CONSTRAINT "rl_user_role_fk1" FOREIGN KEY ("fk_role_id") REFERENCES "rl_role"("pkid");

---INSERT DATA---
INSERT INTO "rl_role" (pkid, name, description) VALUES (1, 'ROLE_A', 'Rol A Açıklama');
INSERT INTO "rl_role" (pkid, name, description) VALUES (2, 'ROLE_B', 'Rol B Açıklama');
INSERT INTO "rl_role" (pkid, name, description) VALUES (3, 'ROLE_C', 'Rol C Açıklama');
INSERT INTO "rl_role" (pkid, name, description) VALUES (4, 'ROLE_D', 'Rol D Açıklama');

INSERT INTO "rl_user" (pkid, name, surname, username, password) VALUES (1, 'Ahmet', 'Okay', 'ahmet', '123');
INSERT INTO "rl_user" (pkid, name, surname, username, password) VALUES (2, 'Hasan', 'Okay', 'hasan', '123');
INSERT INTO "rl_user" (pkid, name, surname, username, password) VALUES (3, 'Hüseyin', 'Okay', 'huseyin', '123');

INSERT INTO "rl_user_role" (pkid, fk_user_id, fk_role_id) VALUES (1, 1, 1);
INSERT INTO "rl_user_role" (pkid, fk_user_id, fk_role_id) VALUES (2, 2, 2);
INSERT INTO "rl_user_role" (pkid, fk_user_id, fk_role_id) VALUES (3, 3, 3);
INSERT INTO "rl_user_role" (pkid, fk_user_id, fk_role_id) VALUES (4, 1, 2);