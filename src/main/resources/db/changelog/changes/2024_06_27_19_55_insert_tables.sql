INSERT INTO items (created_at, description, name,
                   price, updated_at)
VALUES ('2024-06-22 14:22:12.374154', 'Mobile Phone',
        'Iphone 16', 700000, '2024-06-22 14:43:45.115041'),
       ('2024-06-22 14:32:12.374154', 'Mobile Phone',
        'Iphone 17', 800000, '2024-06-22 14:53:45.115041'),
       ('2024-06-22 14:42:12.374154', 'Mobile Phone',
        'Iphone 18', 900000, '2024-06-22 15:03:45.115041');

INSERT INTO permissions (role)
VALUES ('ROLE_STUDENT'),
       ('ROLE_TEACHER'),
       ('ROLE_ADMIN');

INSERT INTO users (email, fullname, password)
VALUES ('berik.berikov@gmail.com', 'Berik Berikov', '$2a$12$ZGFqHmztKDU79dhs.YvaXuI/XeyVD6K8B471xiR3ef.rOmXeVJsdu'),
       ('baken.bakenov@gmail.com', 'Baken Bakenov', '$2a$10$2IQyf.S3HWO6yddLCewd0ejcFEEjOBfdLUC0I62cZP9z3QWIPI/B2'),
       ('serik.serikov@gmail.com', 'Serik Serikov', '$2a$10$HRLLSTtEL8NNUhmPC50w3O/V9b2fjECf2w5gAA1nHNKp8mWCyRzfy');

INSERT INTO users_permissions (user_id, permissions_id)
VALUES (1, 1),
       (1,2),
       (1,3),
       (2,1),
       (3,1);

