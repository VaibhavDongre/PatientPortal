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

## How to run the project locally

### 1.Clone the repository
- ```bashgit clone https://github.com/VaibhavDongre/PatientPortal.git ```

### 2. Start the Backend (Springboot)
- Configure MySQL:
- Create database : ```bash CREATE DATABASE patientdata ```
- Update application.properties : 
- ```bash spring.datasource.url=jdbc:mysql://localhost:3306/patientdata ```
- ```bash spring.datasource.username=YOUR_USERNAME ```
- ```bash spring.datasource.password=YOUR_PASSWORD ```
- ```bash file.storage.location=E:/uploads or OTHER DIRECTORY ```

- Run Backend: ```bashmvn spring-boot:run```
- Backend runs at: (`http://localhost:8080`)

### 3. Start the Frontend
```bash
- cd frontend
- npm install
- npm run dev ```

###Front end runs at: (`http://localhost:5173`)
