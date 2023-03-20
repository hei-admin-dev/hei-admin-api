CREATE TABLE if not exists "course" (
                        id SERIAL PRIMARY KEY,
                        code VARCHAR,
                        name VARCHAR,
                        credits INTEGER,
                        totalHours INTEGER,
                        teacher_id INTEGER,
                        CONSTRAINT fk_teacher
                            FOREIGN KEY(teacher_id)
                                REFERENCES teacher(id)
);