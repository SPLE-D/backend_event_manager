-- SQL Migration script to fix checkin_timestampcheckin decorator relations
-- Product: Notifiedeo
-- Created: June 01, 2026

-- 1. Add missing support columns required by WinVMJ Framework if they do not exist
ALTER TABLE checkin_timestampcheckin ADD COLUMN IF NOT EXISTS recordname VARCHAR(256);
ALTER TABLE checkin_timestampcheckin ADD COLUMN IF NOT EXISTS base_component_id INTEGER;

-- 2. Add foreign key constraint to base_component_id if not present
DO $$
BEGIN
    IF NOT EXISTS (
        SELECT 1 FROM information_schema.table_constraints 
        WHERE constraint_name = 'fk_base_component' AND table_name = 'checkin_timestampcheckin'
    ) THEN
        ALTER TABLE checkin_timestampcheckin 
        ADD CONSTRAINT fk_base_component FOREIGN KEY (base_component_id) REFERENCES checkin_comp(checkinid) ON DELETE CASCADE;
    END IF;
END $$;

-- 3. Upgrade foreign key constraints to ON DELETE CASCADE to allow deletion of check-in records
ALTER TABLE checkin_timestampcheckin DROP CONSTRAINT IF EXISTS fkjbhrncl95a4ctdwd3fl6l4xx2;
ALTER TABLE checkin_timestampcheckin DROP CONSTRAINT IF EXISTS fklqdovhqh0kmkvmch73kxvsbd2;

ALTER TABLE checkin_timestampcheckin 
    ADD CONSTRAINT fkjbhrncl95a4ctdwd3fl6l4xx2 FOREIGN KEY (checkinid) REFERENCES checkin_comp(checkinid) ON DELETE CASCADE;

ALTER TABLE checkin_timestampcheckin 
    ADD CONSTRAINT fklqdovhqh0kmkvmch73kxvsbd2 FOREIGN KEY (record_checkinid) REFERENCES checkin_comp(checkinid) ON DELETE CASCADE;
