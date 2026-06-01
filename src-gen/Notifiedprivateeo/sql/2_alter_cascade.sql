-- ====================================================
-- 1. Core Module: eventcreation_impl
-- ====================================================
ALTER TABLE eventcreation_impl 
  DROP CONSTRAINT IF EXISTS fkp90v5bjfmt6l6g8grjbhsdcd4;

ALTER TABLE eventcreation_impl 
  ADD CONSTRAINT fkp90v5bjfmt6l6g8grjbhsdcd4 
  FOREIGN KEY (eventid) REFERENCES eventcreation_comp(eventid) ON DELETE CASCADE;


-- ====================================================
-- 2. Delta Module: eventcreation_typeeventcreation
-- ====================================================
-- Constraint untuk inheritance ke superclass
ALTER TABLE eventcreation_typeeventcreation 
  DROP CONSTRAINT IF EXISTS fktg0s8s64w27omu2kc1adyesi6;

ALTER TABLE eventcreation_typeeventcreation 
  ADD CONSTRAINT fktg0s8s64w27omu2kc1adyesi6 
  FOREIGN KEY (eventid) REFERENCES eventcreation_comp(eventid) ON DELETE CASCADE;

-- Constraint untuk reference 'record' decorator
ALTER TABLE eventcreation_typeeventcreation 
  DROP CONSTRAINT IF EXISTS fkjxqxkpmuf5a0h9w0vvbwpr6os;

ALTER TABLE eventcreation_typeeventcreation 
  ADD CONSTRAINT fkjxqxkpmuf5a0h9w0vvbwpr6os 
  FOREIGN KEY (record_eventid) REFERENCES eventcreation_comp(eventid) ON DELETE CASCADE;

-- Constraint untuk 'base_component'
ALTER TABLE eventcreation_typeeventcreation 
  DROP CONSTRAINT IF EXISTS fk_base_component;

ALTER TABLE eventcreation_typeeventcreation 
  ADD CONSTRAINT fk_base_component 
  FOREIGN KEY (base_component_id) REFERENCES eventcreation_comp(eventid) ON DELETE CASCADE;
