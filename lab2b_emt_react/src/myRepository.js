import axios from './custom-axios/axios';

const MyRepository = {
    fetchAccommodations: () => {
        return axios.get("/accommodations");
    },
    fetchCategories: () => {
        return axios.get("/accommodations/categories");
    },
    fetchCountries: () => {
        return axios.get("/countries");
    },
    fetchHosts: () => {
        return axios.get("/hosts");
    },
    deleteAccommodation: (id) => {
        return axios.delete(`/accommodations/delete/${id}`);
    },
    addAccommodation: (name, category, hostId, numRooms) => {
        return axios.post("/accommodations/add", {
            "name": name,
            "category": category,
            "hostId": hostId,
            "numRooms": numRooms
        });
    },
    editAccommodation: (id, name, category, hostId, numRooms) => {
        return axios.put(`/accommodations/edit/${id}`, {
            "name": name,
            "category": category,
            "hostId": hostId,
            "numRooms": numRooms
        });
    },
    getAccommodation: (id) => {
        return axios.get(`/accommodations/${id}`);
    },
    rentAccommodation: (id) => {
        return axios.post(`/accommodations/reserve/${id}`);
    }
}

export default MyRepository;
