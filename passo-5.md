//Passo 5

//Alterar quem será o usuário responsável pela tarefa
let task = db.Projects.findOne({"tasks.title": "Tarefa 1-1"}, {"tasks.$": 1});

//Dilatar o prazo de entrega da tarefa
db.Task.updateOne(
  { _id: ObjectId("task_id_here") }, 
  { $set: { deadline_date: ISODate("nova_data_aqui") } } 
);

//Mudar o status de “In Progress” para “Complete”
db.Task.updateOne(
  { _id: ObjectId("task_id_here"), status: "In Progress" }, 
  { $set: { status: "Complete" } } 
)

//Adicionar uma nova descrição a uma tarefa
db.Task.updateOne(
  { _id: ObjectId("task_id_here") }, 
  { $set: { description: "Adicionar uma nova descriçãoo" } }
)

//Atualizar a data de início de uma tarefa
db.Task.updateOne(
  { _id: ObjectId("task_id_here") },
  { $set: { start_date: ISODate("new_start_date") } }
)


