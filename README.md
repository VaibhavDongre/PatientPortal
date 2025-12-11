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
# Postman 

### Upload file

- In Postman create a POST method with url (`http://localhost:8080/v1.0/files/upload`)
- Go to Body
- Select form-data
- Add a key named file(exact spelling)
- Select "Type" = file
- In the value section, select your PDF 

### List all files

- In Postman create a GET method with url (`http://localhost:8080/v1.0/files`)
- In return you will get JSON content with all the details

### Download file

- In Postman create a GET method with url (`http://localhost:8080/v1.0/files/?/downloads`)
- When you list all the files note the id of the file which you want to download
- Replace the ? with the id number of the file which you want to download
- Use the URL in browser, file will be downloaded automatically

### Delete file

- In Postman create a DELETE method with URL (`http://localhost:8080/v1.0/files/?`)
- Replace the ? with the id no of the file which you want to delete.

---


# 🧪 Example cURL Commands

### Upload
- Provide correct file location like (`C:\Users\ASUS\Downloads\Prescription.pdf`), here we have used document.pdf
```bash
curl -X POST -F "file=@document.pdf" http://localhost:8080/v1.0/files/upload
```

### List Files
```bash
curl http://localhost:8080/v1.0/files
```

### Download File
- Provide correct id number of the file which you want to download, here we have used 1
```bash
curl -OJ http://localhost:8080/v1.0/files/1/download
```

### Delete File
- Provide correct id number of the file which you want to delete, here we have used 1
```bash
curl -X DELETE http://localhost:8080/v1.0/files/1
```

---
