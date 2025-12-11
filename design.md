# 1.Tech Stack Choices
--------------------------------------------------------------------------------------------------------------------
## Q1. What frontend framework did you use and why? 
- Frontend : React (vite)
- I have used React in this project as I have been practising React and I can work on it for Frontend development.
- It provides easy integration with Axios and Toastify
- It provides simple state management using hooks (useState, useEffect) 
--------------------------------------------------------------------------------------------------------------------

## Q2. What backend framework did you choose and why?
- Backend: Spring Boot (Java)
- For backend I have used Spring Boot as I have been practising Springboot for backend development.
- It provides easy integration with MySQL using Spring Data JPA
- Springboot is widely used in enterprices
-------------------------------------------------------------------------------------------------------------------

## Q3.What database did you choose and why?
- Database: MySql
- I have used MySql for this project as it is simple and easy to use
- It can be easily configured with Spring Boot
-------------------------------------------------------------------------------------------------------------------

## Q4. If you were to support 1000+ users, what changes would you consider?
- To scale 1000+ users we can do following steps
- Move file storage to cloud like AWS S3, where we can store data and operations will be faster
- We also have to shift database to cloud (AWS RDS) to store our file metadata
- Use pagination for listing
-------------------------------------------------------------------------------------------------------------------

# 2.Architecture Overview

React frontend --> Axios --> Spring Boot Backend(Rest api) --> JPA/Hibernate --> MySql Database --> LocalStorage

- From frontend user can upload files, downlaod files, delete files and see list of files which they have uploaded
- Then Backend will receive files and manage meta data
- Database will store the file metadata
- File STorage directory, here actual PDFs will be saved
--------------------------------------------------------------------------------------------------------------------

# 3.API Specifications
--------------------------------------------------------------------------------------------------------------------

# 4.Data Flow Description
- User selects a PDF in React
- React sends a form-data POST request to: http://localhost:8080/v1.0/files/upload
- Backend receives file as MultipartFile
- Backend generates a UUID sotred filename
- File is saved on disk under E:/uploads
- Metadata is saved in MySql
- Backend returns JSON Metadata
- Frontend shows success toast popup
- FIle list is refreshed
-------------------------------------------------------------------------------------------------------------------------

## Q5. Describe the step-by-step process of what happens when a file is uploaded and when it is downloaded. 
- React calls : /v1.0/files/{id}/download
- Backend retrieves metadata from MySQL
- Backend loads file from disk
- Backend sends file stream with headers: Content-Disposition: attachment
- Browser downloads the PDF(go to http://localhost:8080/v1.0/files/{1}/download this url on browser)
-------------------------------------------------------------------------------------------------------------------------

# 5.Assumptions

## Q6. What assumptions did you make while building this? (e.g., file size limits, authentication, concurrency) 
- User will upload PDF file
- Maximum file size: 200 MB
- Only single user is using this platform
- No pagination is required