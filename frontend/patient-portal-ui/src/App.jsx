import './App.css'
import { ToastContainer } from "react-toastify";
import { useEffect, useState } from 'react';
import { listFiles } from './services/api';
import UploadedFiles from './components/UploadedFiles';
import FileUpload from "./components/FileUpload";


function App() {

  const [files, setFiles] = useState([]);

  const loadFiles = async() => {
    const response = await listFiles();
    setFiles(response.data);
  };

  useEffect(()=>{
    const fetchData = async() => {
      await loadFiles();
    };
    fetchData();
  }, [])

  return (
    <div style={{ padding: "20px"}}>
      <h2>Patient Portal</h2>

      <FileUpload onUploadSuccess={loadFiles}/>
      <UploadedFiles files={files} refreshList={loadFiles}/>
      <ToastContainer/>
    </div>
  )
}

export default App
