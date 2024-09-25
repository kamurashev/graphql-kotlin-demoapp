CREATE TABLE staff (
    id BIGSERIAL PRIMARY KEY,
    first_name VARCHAR NOT NULL,
    last_name VARCHAR NOT NULL,
    phone VARCHAR NOT NULL,
    title title NOT NULL,
    department department NOT NULL,
    grade INTEGER NOT NULL CHECK (grade BETWEEN 1 AND 7),
    status staff_status NOT NULL,
    facility_id BIGINT REFERENCES facility(id),
    guid UUID NOT NULL DEFAULT gen_random_uuid(),
    created_date TIMESTAMP NOT NULL,
    updated_date TIMESTAMP NOT NULL,
    created_by BIGINT,
    updated_by BIGINT
);