drop table if exists candidates;
drop table if exists feedback;

CREATE TABLE feedback (
    parent_id INT NOT NULL,
    rating INT,
    comment VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    feedback_date DATETIME NOT NULL DEFAULT NOW()
);

CREATE TABLE candidates (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    specialities VARCHAR(255) NOT NULL,
    presentation VARCHAR(255) NOT NULL,
    rating DOUBLE DEFAULT(0.0)
);

INSERT INTO candidates (name, specialities, presentation)
VALUES ('John','Machine Learning','10am on 2/20 in ET A227'),
('Jack','Computer Vision','10am on 2/25 in ET A332'),
('Jane','Machine Learning','3pm on 2/27 in ET A126'),
('May','Computer Science Education','3:30pm on 3/11 in FA A216');

INSERT INTO feedback (rating, comment, name, feedback_date, parent_id)
VALUES ('5','I like his research. Seems to be a nice person.', 'Sue', '2019-03-10', '1'),
('3','The presentation was not very well organized. He may be a good researcher but I don''t think he''ll be a good teacher.', 'Tom', '2019-03-11', '1'),
('5','Amazing research. Totally deserves the job.', 'Robert', '2019-03-20', '2'),
('4','Jack''s reseach is incredible. However he wasn''t able to deliver his presentation preciselly.', 'Mike', '2019-03-21', '2');