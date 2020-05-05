CREATE TABLE players (
	id INTEGER GENERATED ALWAYS AS IDENTITY,
	first_name VARCHAR(32) NOT NULL,
	last_name VARCHAR(32) NOT NULL,
	position VARCHAR(32),
	eligibility VARCHAR(32),
	number INTEGER,
	PRIMARY KEY(id)
);

INSERT INTO players (first_name, last_name, position, eligibility, number)
VALUES
 ('Thomas', 'Edward', 'Midfield', 'Sophomore', 54)
,('Joe', 'Dirt', 'Attack', 'Freshman', 2)
,('John', 'Appleseeed', 'Defense', 'Senior', 11)
,('Carl', 'Junior', 'Midfield', 'Junior', 1);