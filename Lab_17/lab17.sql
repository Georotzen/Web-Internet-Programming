-- 1. List the names of the top-level (i.e. parent_id is null) files and folders of user cysun. The results should list the folders first, and then the files.

SELECT f.name FROM files f
	INNER JOIN users u ON f.owner_id = u.id
	WHERE parent_id IS NULL AND u.name = 'cysun'
	ORDER BY f.is_folder DESC;

-- 2. List the names of the files and folders in the folder with id=8.

SELECT file.name FROM files file
	INNER JOIN files folder ON file.parent_id = folder.id
	WHERE folder.id = 8;

-- 3. Find the name of the parent folder of the file with id=14.

SELECT folder.name FROM files folder
	INNER JOIN files file ON file.parent_id = folder.id
	WHERE file.id = 14;

-- 4. List the names of all the empty folders.

SELECT folder.name FROM files folder
	LEFT JOIN files file ON folder.id = file.parent_id
	WHERE folder.is_folder = TRUE AND file.id IS NULL;

-- 5. Find the number of files (excluding folders) owned by user jdoe.

SELECT count(*) AS 'Files owned by jdoe' FROM files f
	INNER JOIN users u ON f.owner_id = u.id
	WHERE is_folder IS FALSE AND u.name = 'jdoe';

-- 6. Insert a new folder CS1222 owned by user with id=1 into the folder with id=2.

INSERT INTO files (name, is_folder, parent_id, owner_id)
	VALUES ('CS1222', true, 2, 1);

-- 7. Change the name of the folder Pictures to Images (assuming there is only one folder whose name is Pictures).

UPDATE files
	SET name = 'Images'
	WHERE name = 'Pictures';

-- 8. Delete all the files (i.e. not folders) under the folder with id=13.

DELETE FROM files
	WHERE parent_id = 13 AND is_folder = FALSE;

-- 9 (Extra Credit +10). List the names of the folder owned by user cysun, and for each folder, the number of files and folders in the folder (or 0 for empty folders).

SELECT f1.name, SUM(IF(f2.parent_id = f1.id,1,0)) AS 'files' FROM files f1
	LEFT JOIN files f2 ON f1.id = f2.parent_id
	INNER JOIN users u ON f1.owner_id = u.id
	WHERE u.name = 'cysun' AND f1.is_folder = TRUE
	GROUP BY f1.id ORDER BY f1.id ASC;