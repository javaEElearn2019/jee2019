CREATE TABLE PHONEBOOK(
  RECGUID VARCHAR(50) NOT NULL,
  LOGIN VARCHAR(255) NOT NULL,
  PASSWORD VARCHAR(511) NOT NULL,
  FIRSTNAME VARCHAR(255) NULL,
  LASTNAME VARCHAR(255) NULL,
  MIDDLENAME VARCHAR(255) NULL,
  BIRTHDATE DATE NULL,
  EMAIL VARCHAR(255) NULL,
  PHONE VARCHAR(255) NULL
);
CREATE UNIQUE INDEX PK_PHONEBOOK ON PHONEBOOK(RECGUID);
CREATE UNIQUE INDEX IDX01_PHONEBOOK ON PHONEBOOK(LOGIN);

INSERT INTO PHONEBOOK (RECGUID, LOGIN, PASSWORD)
VALUES ('0000', 'admin', 'EFAECC0E8F3165F5D727203A99966BC2436D993C8F3C5D0A46CC5EAC40968AF7');