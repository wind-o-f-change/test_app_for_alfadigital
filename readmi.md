Тестовое задание

Пример передачи пути к XML файлу:   
POST запрос на адрес: http://localhost:8080/    
body: 
{
"path": "/opt/input.xml"
}

Для получения тестового результата согласно заданию  
POST запрос на адрес: http://localhost:8080/test    
body:
{
"box": 1,
"color": "red"
}