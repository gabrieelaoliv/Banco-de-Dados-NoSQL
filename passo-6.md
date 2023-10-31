//Passo 6

db.Projects.createIndex({ "tasks.status": 1 });
db.Projects.createIndex({ "start_date": 1 });
db.Projects.createIndex({ "tasks.start_date": 1 });

db.Projects.find({ "tasks.status": "To-Do" }).explain("executionStats");