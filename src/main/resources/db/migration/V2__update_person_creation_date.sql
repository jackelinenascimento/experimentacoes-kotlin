-- Ensure the person table exists
DO $$
BEGIN
    IF NOT EXISTS (SELECT 1 FROM information_schema.tables WHERE table_name = 'person') THEN
        RAISE EXCEPTION 'Table "person" does not exist';
END IF;
END $$;

-- Update the creation_date for existing records
UPDATE person
SET creation_date = CURRENT_TIMESTAMP
WHERE creation_date IS NULL;
