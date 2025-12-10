import { useState } from "react"
import { toast } from "react-toastify";
import { uploadFile } from "../services/api";

export default function FileUpload( {onUploadSuccess}) {
    const [file, setFile] = useState(null);

        const handleFileChange = (e) => {
            if (!e.target.files || e.target.files.length === 0) {
                toast.error("No file selected");
                return;
            }

            setFile(e.target.files[0]);
        }

        const handleUpload = async() => {
            if (!file) {
                toast.error("Please select a file");
                return;
            }

            try {
                await uploadFile(file);
                toast.success("File uploaded successfully");
                setFile(null);
                onUploadSuccess();
            } catch (error) {
                console.log(error);
                toast.error("Upload failed");
            }
        }
    return (
        <div style={{marginBottom: "20px"}}>
            <input 
                type="file" 
                accept="application/pdf"
                onChange={handleFileChange}
                />
            <button onClick={handleUpload} style={{ marginLeft: "10px"}}>
                Uplaod
            </button>
        </div>
    )
}