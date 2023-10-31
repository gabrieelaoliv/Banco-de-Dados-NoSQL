//Passo 4

// Buscar todos os projetos
db.Project.findAll({})

// Buscar um projeto específico por nome
db.Project.find({ name: "Nome do Projeto" })

// Buscar todas as tarefas
db.Task.findAll({})

// Buscar uma tarefa específica por título
db.Task.find({ title: "Título da Tarefa" })

// Buscar todos os usuários
db.User.findAll({})

// Buscar um usuário específico por email
db.User.find({ email: "exemplo@gmail.com" })

//Todos os projetos que já terminaram
//  db.Projects.find({end_date: {$lt: new Date()}});

// Todas as tarefas de um projeto específico
db.Task.find({ project_id: ObjectId("project_id_here") })

// Todas as tarefas de um usuário específico
db.Task.find({ "assigned_to._id": ObjectId("user_id_here") })

// Todas as tarefas com status "To-Do" de um projeto específico
db.Task.find({ project_id: ObjectId("project_id_here"), status: "To-Do" })

// Todas as tarefas com status "To-Do" de um usuário específico
db.Task.find({ "assigned_to._id": ObjectId("user_id_here"), status: "To-Do" })

// Todas as tarefas com prazo de entrega vencido
db.Task.find({ deadline_date: { $lt: new Date() } })

// Buscar todos os projetos em andamento
db.Project.find({ end_date: { $gte: new Date() } })

// Buscar todas as tarefas atribuídas a um usuário específico com status "Concluída"
db.Task.find({ "assigned_to._id": ObjectId("user_id_here"), status: "Concluída" })

// Buscar todos os projetos que têm tarefas atribuídas a mais de um usuário diferente
db.Projects.find({"tasks.user_id": {$exists: true}});