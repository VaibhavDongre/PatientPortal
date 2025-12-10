import axios from "axios";

const API = "http://localhost:8080/v1.0/files";

export const uploadFile = (file) => {
    const formData = new FormData();
    formData.append("file", file);

    return axios.post(`${API}/upload`, formData, {
        headers: {
            "Content-Type" : "multipart/form-data"
        }
    });
};

export const listFiles = () => {
    return axios.get(API);
};

export const downloadFiles = (id) => {
    return axios.get(`${API}/${id}/download`, {
        responseType: "blob"
    });
};

export const deleteFile = (id) => {
    return axios.delete(`${API}/${id}`);
};