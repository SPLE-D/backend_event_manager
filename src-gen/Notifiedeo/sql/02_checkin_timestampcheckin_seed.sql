-- SQL Seed script for Attendees, CheckIn, and TimeStampCheckIn data
-- Product: Notifiedeo
-- Created: June 01, 2026

DO $$
BEGIN
    -- ==========================================
    -- 1. SEED ATTENDEE DATA (WITH EMAILS & PHONES)
    -- ==========================================

    -- Seeding Attendee 1: fadhlurohmandzaki@gmail.com (ID: 87896770)
    IF NOT EXISTS (SELECT 1 FROM attendeemanagement_comp WHERE attendeeid = 87896770) THEN
        INSERT INTO attendeemanagement_comp (attendeeid, email, objectname, phonenumber, modulesequence)
        VALUES (
            87896770, 
            'fadhlurohmandzaki@gmail.com', 
            'Event.attendeemanagement.core.model.AttendeeManagementComponent', 
            '12', 
            'attendeemanagement_impl'
        );

        INSERT INTO attendeemanagement_impl (attendeeid)
        VALUES (87896770);
    END IF;

    -- Seeding Attendee 2: jaki@mail.com (ID: 1330204588)
    IF NOT EXISTS (SELECT 1 FROM attendeemanagement_comp WHERE attendeeid = 1330204588) THEN
        INSERT INTO attendeemanagement_comp (attendeeid, email, objectname, phonenumber, modulesequence)
        VALUES (
            1330204588, 
            'jaki@mail.com', 
            'Event.attendeemanagement.core.model.AttendeeManagementComponent', 
            '83167848177', 
            'attendeemanagement_impl'
        );

        INSERT INTO attendeemanagement_impl (attendeeid)
        VALUES (1330204588);
    END IF;

    -- Seeding Attendee 3: admin@admin.com (ID: 2007864969)
    IF NOT EXISTS (SELECT 1 FROM attendeemanagement_comp WHERE attendeeid = 2007864969) THEN
        INSERT INTO attendeemanagement_comp (attendeeid, email, objectname, phonenumber, modulesequence)
        VALUES (
            2007864969, 
            'admin@admin.com', 
            'Event.attendeemanagement.core.model.AttendeeManagementComponent', 
            '2131231212', 
            'attendeemanagement_impl'
        );

        INSERT INTO attendeemanagement_impl (attendeeid)
        VALUES (2007864969);
    END IF;


    -- ==========================================
    -- 2. SEED CHECK-IN & TIMESTAMPCHECKIN DATA
    -- ==========================================

    -- Seeding Check-In 1 (Attendee: fadhlurohmandzaki@gmail.com)
    IF NOT EXISTS (SELECT 1 FROM checkin_comp WHERE checkinid = 800100) THEN
        -- Core checkin component
        INSERT INTO checkin_comp (checkinid, attended, objectname, modulesequence, attendeeid)
        VALUES (800100, true, 'Event.checkin.core.model.CheckInComponent', 'checkin_impl', 87896770);

        INSERT INTO checkin_impl (checkinid)
        VALUES (800100);

        -- Decorator (timestampcheckin) component
        INSERT INTO checkin_comp (checkinid, attended, objectname, modulesequence, attendeeid)
        VALUES (900100, true, 'Event.checkin.timestampcheckin.model.CheckInImpl', '', 87896770);

        INSERT INTO checkin_timestampcheckin (timestamp, checkinid, record_checkinid, recordname, base_component_id)
        VALUES ('2026-06-01 10:00:00.000', 900100, 800100, 'Event.checkin.core.model.CheckInImpl', 800100);
    END IF;

    -- Seeding Check-In 2 (Attendee: jaki@mail.com)
    IF NOT EXISTS (SELECT 1 FROM checkin_comp WHERE checkinid = 800200) THEN
        -- Core checkin component
        INSERT INTO checkin_comp (checkinid, attended, objectname, modulesequence, attendeeid)
        VALUES (800200, false, 'Event.checkin.core.model.CheckInComponent', 'checkin_impl', 1330204588);

        INSERT INTO checkin_impl (checkinid)
        VALUES (800200);

        -- Decorator (timestampcheckin) component
        INSERT INTO checkin_comp (checkinid, attended, objectname, modulesequence, attendeeid)
        VALUES (900200, false, 'Event.checkin.timestampcheckin.model.CheckInImpl', '', 1330204588);

        INSERT INTO checkin_timestampcheckin (timestamp, checkinid, record_checkinid, recordname, base_component_id)
        VALUES ('2026-06-01 11:15:30.000', 900200, 800200, 'Event.checkin.core.model.CheckInImpl', 800200);
    END IF;

    -- Seeding Check-In 3 (Attendee: admin@admin.com)
    IF NOT EXISTS (SELECT 1 FROM checkin_comp WHERE checkinid = 800300) THEN
        -- Core checkin component
        INSERT INTO checkin_comp (checkinid, attended, objectname, modulesequence, attendeeid)
        VALUES (800300, true, 'Event.checkin.core.model.CheckInComponent', 'checkin_impl', 2007864969);

        INSERT INTO checkin_impl (checkinid)
        VALUES (800300);

        -- Decorator (timestampcheckin) component
        INSERT INTO checkin_comp (checkinid, attended, objectname, modulesequence, attendeeid)
        VALUES (900300, true, 'Event.checkin.timestampcheckin.model.CheckInImpl', '', 2007864969);

        INSERT INTO checkin_timestampcheckin (timestamp, checkinid, record_checkinid, recordname, base_component_id)
        VALUES ('2026-06-01 12:30:45.000', 900300, 800300, 'Event.checkin.core.model.CheckInImpl', 800300);
    END IF;

END $$;
