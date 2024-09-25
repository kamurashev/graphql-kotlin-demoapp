-- Generate random facilities
DO $$
    DECLARE
        facility_name_prefixes TEXT[] := ARRAY['Central', 'South', 'East', 'West', 'North', 'Midtown'];
        facility_name_suffixes TEXT[] := ARRAY['Plant', 'Facility', 'Operations', 'Station', 'Works'];
    BEGIN
        FOR i IN 1..6 LOOP
                INSERT INTO facility (name, address, department, guid, created_date, updated_date)
                VALUES (
                           facility_name_prefixes[floor(random() * array_length(facility_name_prefixes, 1) + 1)::INT] || ' ' ||
                           facility_name_suffixes[floor(random() * array_length(facility_name_suffixes, 1) + 1)::INT],
                           (floor(random() * 999 + 1))::INT || ' ' ||
                           (ARRAY['Main St', 'First Ave', 'Second St', 'Third Blvd', 'Maple St', 'Oak St'])[floor(random() * 6 + 1)::INT] || ', ' ||
                           (ARRAY['Metropolis', 'Gotham', 'Springfield', 'Riverside', 'Franklin', 'Greenville'])[floor(random() * 6 + 1)::INT] || ', ' ||
                           (ARRAY['CA', 'TX', 'NY', 'FL', 'PA', 'IL'])[floor(random() * 6 + 1)::INT] || ' ' || (floor(random() * 8999 + 1000))::INT,
                           (SELECT unnest(enum_range(NULL::department)) ORDER BY random() LIMIT 1),  -- Select and unnest a single value
                           gen_random_uuid(),
                           NOW(),
                           NOW()
                       );
            END LOOP;
    END $$;

-- Generate random staff members
DO $$
    DECLARE
        facility_id BIGINT;
        first_names TEXT[] := ARRAY['John', 'Jane', 'Alex', 'Emily', 'Michael', 'Sarah', 'David', 'Laura', 'Robert', 'Linda', 'Chris', 'Patricia', 'Mark', 'Sophia', 'Paul', 'Diana', 'James', 'Theresa', 'Peter', 'Nancy'];
        last_names TEXT[] := ARRAY['Smith', 'Johnson', 'Williams', 'Jones', 'Brown', 'Davis', 'Miller', 'Wilson', 'Moore', 'Taylor', 'Anderson', 'Thomas', 'Jackson', 'White', 'Harris', 'Martin', 'Thompson', 'Garcia', 'Martinez', 'Clark'];
    BEGIN
        FOR facility_id IN (SELECT id FROM facility) LOOP
                FOR i IN 1..15 LOOP
                        INSERT INTO staff (
                            first_name,
                            last_name,
                            phone,
                            title,
                            department,
                            grade,
                            status,
                            facility_id,
                            guid,
                            created_date,
                            updated_date
                        ) VALUES (
                                     first_names[floor(random() * array_length(first_names, 1) + 1)::INT],
                                     last_names[floor(random() * array_length(last_names, 1) + 1)::INT],
                                     '555-' || (floor(random() * 900 + 100))::INT || '-' || (floor(random() * 9000 + 1000))::INT,
                                     (SELECT unnest(enum_range(NULL::title)) ORDER BY random() LIMIT 1),  -- Select and unnest a single value
                                     (SELECT department FROM facility WHERE id = facility_id),  -- Retrieve department value directly
                                     (floor(random() * 7 + 1))::INT,
                                     (SELECT unnest(enum_range(NULL::staff_status)) ORDER BY random() LIMIT 1),  -- Select and unnest a single value
                                     facility_id,
                                     gen_random_uuid(),
                                     NOW(),
                                     NOW()
                                 );
                    END LOOP;
            END LOOP;
    END $$;

-- Generate random equipment
DO $$
    DECLARE
        facility_id BIGINT;
        equipment_types TEXT[] := ARRAY['Generator', 'Turbine', 'Pump', 'Boiler', 'Compressor', 'Conveyor', 'Crane', 'Drill'];
    BEGIN
        FOR facility_id IN (SELECT id FROM facility) LOOP
                FOR i IN 1..15 LOOP
                        INSERT INTO equipment (
                            name,
                            type,
                            facility_id,
                            guid,
                            created_date,
                            updated_date
                        ) VALUES (
                                     'Equipment ' || i,
                                     equipment_types[floor(random() * array_length(equipment_types, 1) + 1)::INT],
                                     facility_id,
                                     gen_random_uuid(),
                                     NOW(),
                                     NOW()
                                 );
                    END LOOP;
            END LOOP;
    END $$;

-- Generate random overhauls
DO $$
    DECLARE
        equipment_id BIGINT;
    BEGIN
        FOR equipment_id IN (SELECT id FROM equipment) LOOP
                FOR i IN 0..3 LOOP
                        INSERT INTO overhaul (
                            description,
                            date,
                            status,
                            equipment_id,
                            guid,
                            created_date,
                            updated_date
                        ) VALUES (
                                     'Overhaul Description ' || i,
                                     NOW() - INTERVAL '1 MONTH' * (floor(random() * 12))::INT,
                                     (SELECT unnest(enum_range(NULL::overhaul_status)) ORDER BY random() LIMIT 1),  -- Select and unnest a single value
                                     equipment_id,
                                     gen_random_uuid(),
                                     NOW(),
                                     NOW()
                                 );
                    END LOOP;
            END LOOP;
    END $$;