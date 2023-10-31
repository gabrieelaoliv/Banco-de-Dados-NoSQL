//Passos 1, 2 e 3	


db.createCollection("Task", {
   validator: {
      $jsonSchema: {
         bsonType: "object",
         required: ["title", "description", "start_date", "deadline_date", "priority", "status"],
         properties: {
            title: {
               bsonType: "varchar string",
               description: "Título da tarefa"
            },
            description: {
               bsonType: "varchar string",
               description: "Descrição da tarefa"
            },
            start_date: {
               bsonType: "date",
               description: "Data de início da tarefa"
            },
            deadline_date: {
               bsonType: "date",
               description: "Data de vencimento da tarefa"
            },
            priority: {
               bsonType: "integer",
               description: "Prioridade da tarefa"
            },
            status: {
               bsonType: "varchar string",
               description: "Status da tarefa"
            }
         }
      }
   }
})


db.createCollection("Project", {
   validator: {
      $jsonSchema: {
         bsonType: "object",
         required: ["name", "start_date", "end_date"],
         properties: {
            name: {
               bsonType: "varchar string",
               description: "Nome do projeto"
            },
            start_date: {
               bsonType: "date",
               description: "Data de início do projeto"
            },
            end_date: {
               bsonType: "date",
               description: "Data fim do projeto"
            }
         }
      }
   }
})


db.createCollection("User", {
   validator: {
      $jsonSchema: {
         bsonType: "object",
         required: ["first_name", "last_name", "email", "cell_phone"],
         properties: {
            first_name: {
               bsonType: "varchar string",
               description: "Primeiro nome do usuário"
            },
            last_name: {
               bsonType: "varchar string",
               description: "Sobrenome do usuário"
            },
            email: {
               bsonType: "varchar string",
               pattern: "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"
               description: "E-mail do usuário"
            },
            cell_phone: {
               bsonType: "varchar string",
	       pattern: "^[0-9]{3}-[0-9]{3}-[0-9]{4}$",
               description: "Número de celular do usuário"
            }
         }
      }
   }
})


db.Project.updateMany({}, { $set: { tasks: [] } })


db.Task.updateMany({}, { $set: { assigned_to: null } })

//Json

{
   "_id":"ObjectId(""project_id_here"")",
   "name":"Projeto MongoDB",
   "start_date":"ISODate(""2023-10-06T00:00:00Z"")",
   "end_date":"ISODate(""2023-12-30T23:59:59Z"")",
   "tasks":[
      {
         "_id":"ObjectId("task_id_1")",
         "title":"Realizar reunião",
         "description":"Reunião semanal de equipe para discutir andamento dos projetos 1",
         "start_date":"ISODate(""2023-11-01T09:00:00Z"")",
         "deadline_date":"ISODate(""2023-11-01T10:00:00Z"")",
         "priority":"Alta",
         "status":"Pendente",
         "assigned_to":{
            "_id":"ObjectId(""user_id_1"")",
            "first_name":"João",
            "last_name":"Silva",
            "email":"joao.silva1@email.com",
            "cell_phone":"+55 11 9999-9999"
         }
      },
      {
         "_id":"ObjectId(""task_id_2"")",
         "title":"Realizar reunião de equipe 2",
         "description":"Reunião semanal de equipe para discutir andamento dos projetos 2",
         "start_date":"ISODate(""2023-11-01T09:00:00Z"")",
         "deadline_date":"ISODate(""2023-11-01T10:00:00Z"")",
         "priority":"Média",
         "status":"Em andamento",
         "assigned_to":{
            "_id":"ObjectId(""user_id_2"")",
            "first_name":"Maria",
            "last_name":"Ferreira",
            "email":"maria.ferreira2@email.com",
            "cell_phone":"+55 11 8888-8888"
         }
      },
      {
         "_id":"ObjectId(""task_id_6"")",
         "title":"Preparar apresentação de vendas",
         "description":"Preparar uma apresentação para a reunião de vendas",
         "start_date":"ISODate(""2023-11-05T10:00:00Z"")",
         "deadline_date":"ISODate(""2023-11-05T12:00:00Z"")",
         "priority":"Média",
         "status":"Em andamento",
         "assigned_to":{
            "_id":"ObjectId(""user_id_6"")",
            "first_name":"Lucas",
            "last_name":"Pereira",
            "email":"lucas.pereira@email.com",
            "cell_phone":"+55 11 4444-4444"
         }
      },
      {
         "_id":"ObjectId(""task_id_7"")",
         "title":"Testar aplicativo em dispositivos móveis",
         "description":"Realizar testes em diversos dispositivos móveis",
         "start_date":"ISODate(""2023-11-06T14:00:00Z"")",
         "deadline_date":"ISODate(""2023-11-06T16:00:00Z"")",
         "priority":"Alta",
         "status":"Pendente",
         "assigned_to":{
            "_id":"ObjectId(""user_id_7"")",
            "first_name":"Mariana",
            "last_name":"Ribeiro",
            "email":"mariana.ribeiro@email.com",
            "cell_phone":"+55 11 3333-3333"
         }
      },
      {
         "_id":"ObjectId(""task_id_8"")",
         "title":"Revisar conteúdo do blog",
         "description":"Revisar e publicar novos artigos no blog da empresa",
         "start_date":"ISODate(""2023-11-07T10:00:00Z"")",
         "deadline_date":"ISODate(""2023-11-07T12:00:00Z"")",
         "priority":"Baixa",
         "status":"Concluída",
         "assigned_to":{
            "_id":"ObjectId(""user_id_8"")",
            "first_name":"Rafael",
            "last_name":"Lima",
            "email":"rafael.lima@email.com",
            "cell_phone":"+55 11 2222-2222"
         }
      },
      {
         "_id":"ObjectId(""task_id_9"")",
         "title":"Entrevistar candidatos para a equipe",
         "description":"Realizar entrevistas para preencher vagas na equipe de desenvolvimento",
         "start_date":"ISODate(""2023-11-08T09:00:00Z"")",
         "deadline_date":"ISODate(""2023-11-08T17:00:00Z"")",
         "priority":"Alta",
         "status":"Pendente",
         "assigned_to":{
            "_id":"ObjectId(""user_id_9"")",
            "first_name":"Paula",
            "last_name":"Gonçalves",
            "email":"paula.goncalves@email.com",
            "cell_phone":"+55 11 1111-1111"
         }
      },      
      {
         "_id":"ObjectId(""task_id_20"")",
         "title":"Realizar testes de segurança",
         "description":"Conduzir testes de segurança em sistemas da empresa",
         "start_date":"ISODate(""2023-11-19T11:00:00Z"")",
         "deadline_date":"ISODate(""2023-11-19T13:00:00Z"")",
         "priority":"Baixa",
         "status":"Concluída",
         "assigned_to":{
            "_id":"ObjectId(""user_id_20"")",
            "first_name":"Cláudia",
            "last_name":"Ferreira",
            "email":"claudia.ferreira@email.com",
            "cell_phone":"+55 11 6666-7777"
         }
      },
      {
         "_id":"ObjectId(""task_id_21"")",
         "title":"Realizar pesquisa de mercado",
         "description":"Conduzir uma pesquisa de mercado para avaliar a concorrência",
         "start_date":"ISODate(""2023-11-20T10:00:00Z"")",
         "deadline_date":"ISODate(""2023-11-20T13:00:00Z"")",
         "priority":"Alta",
         "status":"Em andamento",
         "assigned_to":{
            "_id":"ObjectId(""user_id_21"")",
            "first_name":"Isabela",
            "last_name":"Pereira",
            "email":"isabela.pereira@email.com",
            "cell_phone":"+55 11 1111-2222"
         }
      },
      {
         "_id":"ObjectId(""task_id_22"")",
         "title":"Atualizar manual do usuário",
         "description":"Revisar e atualizar o manual do usuário para o novo software",
         "start_date":"ISODate(""2023-11-21T14:00:00Z"")",
         "deadline_date":"ISODate(""2023-11-21T17:00:00Z"")",
         "priority":"Média",
         "status":"Pendente",
         "assigned_to":{
            "_id":"ObjectId(""user_id_22"")",
            "first_name":"Carlos",
            "last_name":"Sousa",
            "email":"carlos.sousa@email.com",
            "cell_phone":"+55 11 5555-7777"
         }
      },
    
   ]
}
