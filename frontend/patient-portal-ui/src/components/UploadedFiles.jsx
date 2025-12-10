import { toast } from "react-toastify";
import { deleteFile, downloadFiles } from "../services/api";

export default function UploadedFiles({files, refreshList}) {
    const handleDownload = async(id, filename) => {
        try {
            const response = await downloadFiles(id);

            const url = window.URL.createObjectURL(new Blob([response.data]));
            const link = document.createElement("a");

            link.href = url;
            link.setAttribute("download", filename);
            document.body.appendChild(link);
            link.click();

            toast.success("Download started");
        } catch (error) {
            console.log(error);
            toast.error("Download failed");
        }
    }

    const handleDelete = async(id) => {
        try {
            await deleteFile(id);
            toast.success("File deleted");
            refreshList();
        } catch (error) {
            console.log(error);
            toast.error("Delete failed");
        }
    }

    return (
        <table border="1" width="100%" cellPadding="10">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Filename</th>
                    <th>Size (bytes)</th>
                    <th>Data</th>
                    <th>Download</th>
                    <th>Delete</th>
                </tr>
            </thead>

            <tbody>
                {files.map((f) => {
                    return (
                        <tr key={f.id}>
                        <td>{f.id}</td>
                        <td>{f.originalFilename}</td>
                        <td>{f.size}</td>
                        <td>{f.createdAt}</td>

                        <td>
                            <button 
                                onClick={()=>handleDownload(f.id, f.originalFilename)}
                            > 
                                Download
                            </button>
                        </td>

                        <td>
                            <button 
                                onClick={()=>handleDelete(f.id)}
                                style={{color:"red"}}
                            >
                                Delete
                            </button>
                        </td>
                    </tr>
                    )
                })}
            </tbody>
        </table>
    )
}