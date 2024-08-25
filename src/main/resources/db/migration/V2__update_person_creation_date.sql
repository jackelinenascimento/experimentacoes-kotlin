UPDATE person
SET creation_date = CURRENT_TIMESTAMP
WHERE creation_date IS NULL;
