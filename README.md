## Patient Portal - Document Upload System

A full stack web application for uplaoding. listing, downloading, and deleting PDF documnets.

## Tech Stack

### **Frontend** 
- React (Vite)
- Axios (HTTP requests)
- React Toastify (notifications)
- Bootstrap (UI styling)

### **Backend** 
- Spring Boot (Java)
- Spring Web + Spring Data JPA
- MySQL database

### **Storage**
- Local disk storage (`E:/uploads`)
- Metadata stored in MySQL

## Features
- Upload PDF files  
- List all uploaded documents  
- Download documents  
- Delete documents  
- Toast notifications  
- Clean Bootstrap UI 

# How to run the project locally

## 1. Clone the repository
```bash
git clone https://github.com/VaibhavDongre/PatientPortal.git
```
---

## 2. Start the Backend (Springboot)

### Create MySQL Database 
```sql
CREATE DATABASE patientdata;
```
### Update application.properties : 
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/patientdata
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD

file.storage.location=E:/uploads
```
### Start Spring Boot

```bash
mvn spring-boot:run
```

Backend runs at:

```
http://localhost:8080
```

---
## 3. Start the Frontend
```bash
cd frontend
npm install
npm run dev
```

Frontend runs at:

```
http://localhost:5173
```
---

# 📡 API Endpoints

Base Route:
```
/v1.0/files
```

### Upload PDF
```
POST /v1.0/files/upload
```

### List All Files
```
GET /v1.0/files
```

### Download File
```
GET /v1.0/files/{id}/download
```

### Delete File
```
DELETE /v1.0/files/{id}
```

---

# 🧪 Example cURL Commands

### Upload
```bash
curl -X POST -F "file=@document.pdf" http://localhost:8080/v1.0/files/upload
```

### List Files
```bash
curl http://localhost:8080/v1.0/files
```

### Download File
```bash
curl -OJ http://localhost:8080/v1.0/files/1/download
```

### Delete File
```bash
curl -X DELETE http://localhost:8080/v1.0/files/1
```

---
