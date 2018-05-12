CREATE TABLE player (
    playerId NUMBER NOT NULL,
    nickname VARCHAR2(30),
    PRIMARY KEY (playerId)
);

CREATE TABLE personageClass (
    personageClassId NUMBER NOT NULL,
    personageClassName VARCHAR(10),
    personageClassFeatures VARCHAR2(200),
    PRIMARY KEY (personageClassId)
);

CREATE TABLE spell (
    spellId NUMBER NOT NULL,
    spellName VARCHAR(20),
    spellDescription VARCHAR2(200),
    forClassId NUMBER NOT NULL,
    PRIMARY KEY (spellId),
    FOREIGN KEY (forClassId) REFERENCES personageClass(personageClassId)
);

CREATE TABLE race (
    raceId NUMBER NOT NULL,
    raceName VARCHAR2(10) NOT NULL,
    raceSize VARCHAR2(1),
    raceSpeed NUMBER,
    raceFeatures VARCHAR2(200),
    PRIMARY KEY (raceId)
);

CREATE TABLE weapon (
    weaponId NUMBER NOT NULL,
    nameOfWeapon VARCHAR2(20),
    attackBonus NUMBER,
    criticalBonus NUMBER,
    typeOfWeapon VARCHAR2(3),
    rangeOfWeapon NUMBER,
    ammunition NUMBER,
    damage VARCHAR2(4),
    PRIMARY KEY (weaponId)
);

CREATE TABLE personage (
    personageId NUMBER NOT NULL,
    personageName VARCHAR2(30),
    personageLevel NUMBER,
    personageAlignment VARCHAR2(3),
    personageCharacteristics VARCHAR2(200),
    personageClass NUMBER NOT NULL,
    personageRace NUMBER NOT NULL,
    personageOwnerId NUMBER,
    PRIMARY KEY (personageId),
    FOREIGN KEY (personageOwnerId) REFERENCES player(playerId),
    FOREIGN KEY (personageClass) REFERENCES personageClass(personageClassId),
    FOREIGN KEY (personageRace) REFERENCES race(raceId)
);

CREATE TABLE weaponOfPersonage (
    id NUMBER NOT NULL,
    personageId NUMBER NOT NULL,
    weaponId NUMBER NOT NULL,
	PRIMARY KEY (id),
    FOREIGN KEY (personageId) REFERENCES personage(personageId),
    FOREIGN KEY (weaponId) REFERENCES weapon(weaponId)
);