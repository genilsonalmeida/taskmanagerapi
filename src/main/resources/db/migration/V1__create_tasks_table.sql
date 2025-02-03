CREATE TABLE tasks
(
    id          INT IDENTITY(1,1) PRIMARY KEY,
    title       VARCHAR(255) NOT NULL,
    description TEXT,
    status      VARCHAR(50)  NOT NULL DEFAULT 'PENDING',
    created_at  DATETIME              DEFAULT GETDATE()
);
