CREATE TABLE widgets (
	id INTEGER GENERATED ALWAYS AS IDENTITY,
	first_name VARCHAR(32) NOT NULL,
	middle_name VARCHAR(32) NOT NULL,
	last_name VARCHAR(32) NOT NULL,
	age INTEGER NOT NULL,
	PRIMARY KEY(id)
);

INSERT INTO widgets (first_name, middle_name, last_name, age)
VALUES
 ('Thomas', 'Edward', 'Stanton', 54)
,('Nathan', 'Michael', 'Sutton', 67)
,('Alex', 'Jarrod', 'Templeton', 45);