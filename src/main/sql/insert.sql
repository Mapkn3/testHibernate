INSERT INTO race VALUES (
    1,
    'Elf',
    'M',
    30,
    '+2 modDexterity, +2 modIntellegence, -2 modConstitution, have two language'
);
INSERT INTO race VALUES (
    2,
    'Dwarf',
    'M',
    20,
    '+2 modConstitution, +2 modWisdom, -2 modCharisma, have dark-vision 60f'
);
INSERT INTO race VALUES (
    3,
    'Halfling',
    'S',
    20,
    '+2 modDexterity, +2 modCharisma, -2 modStrenght, have lucky +1 to check'
);
INSERT INTO race VALUES (
    4,
    'Ork','L',
    40,
    '+2 modStrenght, +2 modConstitution, -2 modCharisma, have dark-vision 60f, have hatred of people'
);

INSERT INTO personageClass VALUES (
    1,
    'Barbarian',
    'Rage! Speed +10 without armor',
    12,
    'y',
    'n',
    'y',
    'n',
    'n',
    1
);
INSERT INTO personageClass VALUES (
    2,
    'Bard',
    'Inspire Competence, magic(valCharisma > 10)',
    8,
    'y',
    'n',
    'n',
    'y',
    'n',
    0
);
INSERT INTO personageClass VALUES (
    3,
    'Cleric',
    'Channel Energy (domains), magic (valWisdom>10)',
    8,
    'n',
    'n',
    'n',
    'y',
    'y',
    0
);
INSERT INTO personageClass VALUES (
    4,
    'Rogue',
    'Rogue Talents, Evasion,Sneak Attack',
    10,
    'y',
    'y',
    'n',
    'y',
    'n',
    0
);

INSERT INTO weapon VALUES (
    1,
    'Brass knife',
    0,
    2,
    'cutting',
    5,
    '1d4'
);
INSERT INTO weapon VALUES (
    2,
    'Magic short sword',
    1,
    3,
    'stabbing',
    5,
    '1d6'
);
INSERT INTO weapon VALUES (
    3,
    'Heavy crossbow',
    0,
    2,
    'stabbing',
    120,
    '1d10'
);
INSERT INTO weapon VALUES (
    4,
    'Light mace',
    0,
    2,
    'crashing',
    5,
    '1d6'
);

INSERT INTO spell VALUES (
    1,
    'Holy shield',
    'check 16,
    +3 modFortitude 2m',
    3
);
INSERT INTO spell VALUES (
    2,
    'Treatment',
    'check 15, +1d6 hp',
    3
);
INSERT INTO spell VALUES (
    3,
    'Protection(intimidation)',
    'check 12, +2 modWill',
    2
);
INSERT INTO spell VALUES (
    4,
    'Attack(rollsOfThunder)',
    'check 16, attack 2d4',
    2
);

INSERT INTO player VALUES (
    1,
    'admin',
    'admin',
    'admin'
);
INSERT INTO player VALUES (
    2,
    'master',
    'master',
    'master'
);
INSERT INTO player VALUES (
    3,
    'player',
    'player',
    'player'
);

INSERT INTO personage VALUES (
    1,
    'test',
    100,
    1,
    'LG',
    6,
    50,
    5,
    2,
    3,
    5,
    1,
    12,
    11,
    15,
    9,
    16,
    11,
    4,
    5 ,
    5,
    2,
    1,
    3
);

INSERT INTO weaponOfPersonage VALUES (
    1,
    1,
    2
);
INSERT INTO weaponOfPersonage VALUES (
    2,
    1,
    4
);