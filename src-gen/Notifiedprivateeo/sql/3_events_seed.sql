-- ====================================================
-- Core EventCreation Seeding (ID: 99001)
-- ====================================================
INSERT INTO eventcreation_comp (eventid, capacity, startdate, enddate, name, location, objectname, modulesequence)
VALUES (99001, 120, '2026-06-15 00:00:00', '2026-06-20 00:00:00', 'Workshop SPLE Core (Seeded)', 'Aula Fasilkom UI', 'Event.eventcreation.core.model.EventCreationComponent', 'eventcreation_impl')
ON CONFLICT (eventid) DO NOTHING;

INSERT INTO eventcreation_impl (eventid)
VALUES (99001)
ON CONFLICT (eventid) DO NOTHING;


-- ====================================================
-- Delta TypeEventCreation Seeding (Base ID: 99002, Decorator ID: 99003)
-- ====================================================
-- Base component in eventcreation_comp
INSERT INTO eventcreation_comp (eventid, capacity, startdate, enddate, name, location, objectname, modulesequence)
VALUES (99002, 50, '2026-07-10 00:00:00', '2026-07-12 00:00:00', 'Seminar SPLE Delta (Seeded)', 'Online via Zoom', 'Event.eventcreation.core.model.EventCreationComponent', 'eventcreation_impl, eventcreation_typeeventcreation')
ON CONFLICT (eventid) DO NOTHING;

-- Base component in eventcreation_impl
INSERT INTO eventcreation_impl (eventid)
VALUES (99002)
ON CONFLICT (eventid) DO NOTHING;

-- Decorator component in eventcreation_comp
INSERT INTO eventcreation_comp (eventid, capacity, startdate, enddate, name, location, objectname, modulesequence)
VALUES (99003, 50, '2026-07-10 00:00:00', '2026-07-12 00:00:00', 'Seminar SPLE Delta (Seeded)', 'Online via Zoom', 'Event.eventcreation.typeeventcreation.model.EventCreationImpl', '')
ON CONFLICT (eventid) DO NOTHING;

-- Decorator component in eventcreation_typeeventcreation
INSERT INTO eventcreation_typeeventcreation (eventid, eventtype, record_eventid, recordname, base_component_id)
VALUES (99003, 'PUBLIC', 99002, 'Event.eventcreation.core.model.EventCreationImpl', 99002)
ON CONFLICT (eventid) DO NOTHING;
