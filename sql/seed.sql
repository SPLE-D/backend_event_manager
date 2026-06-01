-- ============================================================
-- Seed data untuk produk Withclass (eventmanager_product_withclass)
-- Mengikuti pola JOINED inheritance WinVMJ:
--   *_comp  -> menyimpan kolom data + objectname + modulesequence
--   *_impl  -> hanya menyimpan id (subclass core)
--   attendeemanagement_classattendeemanagement -> tabel delta (decorator)
--
-- Aman dijalankan berulang: pakai ON CONFLICT DO NOTHING.
-- Urutan insert mengikuti dependensi FK (comp dulu, baru impl/delta).
-- ============================================================

-- ========== EVENT CREATION ==========
INSERT INTO eventcreation_comp (eventid, name, location, startdate, enddate, capacity, objectname, modulesequence) VALUES
  (1, 'Tech Conference 2026', 'Jakarta Convention Center', 20260610, 20260612, 500, 'Event.eventcreation.core.model.EventCreationComponent', 'eventcreation_impl'),
  (2, 'Campus Hackathon',      'Fasilkom UI',              20260701, 20260702, 200, 'Event.eventcreation.core.model.EventCreationComponent', 'eventcreation_impl'),
  (3, 'Design Workshop',       'Bandung Creative Hub',     20260815, 20260815, 80,  'Event.eventcreation.core.model.EventCreationComponent', 'eventcreation_impl')
ON CONFLICT DO NOTHING;

INSERT INTO eventcreation_impl (eventid) VALUES (1), (2), (3) ON CONFLICT DO NOTHING;

-- ========== ATTENDEE MANAGEMENT (core / tanpa kelas) ==========
INSERT INTO attendeemanagement_comp (attendeeid, phonenumber, email, eventid, objectname, modulesequence) VALUES
  (101, '081234567001', 'budi@example.com',  1, 'Event.attendeemanagement.core.model.AttendeeManagementComponent', 'attendeemanagement_impl'),
  (102, '081234567002', 'sari@example.com',  2, 'Event.attendeemanagement.core.model.AttendeeManagementComponent', 'attendeemanagement_impl')
ON CONFLICT DO NOTHING;

INSERT INTO attendeemanagement_impl (attendeeid) VALUES (101), (102) ON CONFLICT DO NOTHING;

-- ========== CLASS ATTENDEE MANAGEMENT (delta / decorator) ==========
-- Tiap entri = 1 base core (211/212) yang dibungkus 1 decorator (201/202).
-- 1) Base core record (comp + impl), modulesequence berisi rantai modul.
INSERT INTO attendeemanagement_comp (attendeeid, phonenumber, email, eventid, objectname, modulesequence) VALUES
  (211, '081299900001', 'andi@example.com', 1, 'Event.attendeemanagement.core.model.AttendeeManagementComponent', 'attendeemanagement_impl, attendeemanagement_classattendeemanagement'),
  (212, '081299900002', 'dina@example.com', 2, 'Event.attendeemanagement.core.model.AttendeeManagementComponent', 'attendeemanagement_impl, attendeemanagement_classattendeemanagement')
ON CONFLICT DO NOTHING;

INSERT INTO attendeemanagement_impl (attendeeid) VALUES (211), (212) ON CONFLICT DO NOTHING;

-- 2) Decorator record (comp), objectname = kelas delta, field mirror dari base.
INSERT INTO attendeemanagement_comp (attendeeid, phonenumber, email, eventid, objectname, modulesequence) VALUES
  (201, '081299900001', 'andi@example.com', 1, 'Event.attendeemanagement.classattendeemanagement.model.AttendeeManagementImpl', NULL),
  (202, '081299900002', 'dina@example.com', 2, 'Event.attendeemanagement.classattendeemanagement.model.AttendeeManagementImpl', NULL)
ON CONFLICT DO NOTHING;

-- 3) Baris tabel delta yang menautkan decorator -> base record.
INSERT INTO attendeemanagement_classattendeemanagement (attendeeid, attendeeclass, record_attendeeid, recordname, base_component_id) VALUES
  (201, 'XII-RPL-1', 211, 'Event.attendeemanagement.core.model.AttendeeManagementImpl', 211),
  (202, 'XII-RPL-2', 212, 'Event.attendeemanagement.core.model.AttendeeManagementImpl', 212)
ON CONFLICT DO NOTHING;

-- ========== CHECK IN ==========
INSERT INTO checkin_comp (checkinid, attended, objectname, modulesequence) VALUES
  (301, TRUE,  'Event.checkin.core.model.CheckInComponent', 'checkin_impl'),
  (302, FALSE, 'Event.checkin.core.model.CheckInComponent', 'checkin_impl')
ON CONFLICT DO NOTHING;

INSERT INTO checkin_impl (checkinid) VALUES (301), (302) ON CONFLICT DO NOTHING;

-- ========== REPORT ==========
INSERT INTO report_comp (reportid, eventid, totalattendee, totalrevenue, summary, objectname, modulesequence) VALUES
  (401, 1, 320, 48000000, 'Acara berjalan lancar, kapasitas hampir penuh.', 'Event.report.core.model.ReportComponent', 'report_impl'),
  (402, 2, 150, 0,        'Hackathon kampus, gratis untuk mahasiswa.',      'Event.report.core.model.ReportComponent', 'report_impl')
ON CONFLICT DO NOTHING;

INSERT INTO report_impl (reportid) VALUES (401), (402) ON CONFLICT DO NOTHING;

-- ========== REVIEW ==========
INSERT INTO review_comp (reviewid, eventid, attendeeid, rating, comment, objectname, modulesequence) VALUES
  (501, 1, 101, 5, 'Materi sangat bermanfaat!',        'Event.review.core.model.ReviewComponent', 'review_impl'),
  (502, 2, 102, 4, 'Seru, tapi waktunya terlalu mepet.', 'Event.review.core.model.ReviewComponent', 'review_impl')
ON CONFLICT DO NOTHING;

INSERT INTO review_impl (reviewid) VALUES (501), (502) ON CONFLICT DO NOTHING;

-- ========== NOTIFICATION ==========
INSERT INTO notification_comp (notifiationid, content, objectname, modulesequence) VALUES
  (601, 'Pendaftaran Tech Conference 2026 telah dibuka.', 'Event.notification.core.model.NotificationComponent', 'notification_impl'),
  (602, 'Reminder: Campus Hackathon mulai besok pagi.',   'Event.notification.core.model.NotificationComponent', 'notification_impl')
ON CONFLICT DO NOTHING;

INSERT INTO notification_impl (notifiationid) VALUES (601), (602) ON CONFLICT DO NOTHING;
