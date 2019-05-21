-- Drop table if exists

drop table if exists expenses;

-- Create questions table

CREATE TABLE expenses (
	id INT AUTO_INCREMENT PRIMARY KEY,
 	month VARCHAR(7) NOT NULL,
    amount DOUBLE NOT NULL,
    tags VARCHAR(255) NOT NULL
);

-- Populate questions table

INSERT INTO expenses (month, amount, tags) VALUES ('4/2019', 127.40, 'Transportation, MetroLink Monthly Pass'),
												 ('5/2019', 17.15, 'Trader Joe, Groceries'),
												 ('5/2019', 31.31, 'Trader Joe, Gas');
