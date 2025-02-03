INSERT INTO tasks (title, description, created_at, status)
VALUES ('Configurar Banco de Dados', 'Configurar o banco de dados para o ambiente de desenvolvimento', GETDATE(),
        'PENDENTE'),
       ('Desenvolver API', 'Desenvolver a API de tarefas para o sistema', GETDATE(), 'EM_ANDAMENTO'),
       ('Testar Funcionalidades', 'Testar funcionalidades da aplicação antes do deploy', GETDATE(), 'CONCLUIDO');