import React from 'react';
import { useNavigate } from 'react-router-dom';

const AccommodationAdd = (props) => {
    const navigate = useNavigate();

    const [formData, updateFormData] = React.useState({
        name: "",
        category: "ROOM",
        hostId: 1,
        numRooms: 1
    });

    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        })
    }

    const onFormSubmit = (e) => {
        e.preventDefault();
        const name = formData.name;
        const category = formData.category;
        const hostId = formData.hostId;
        const numRooms = formData.numRooms;

        props.onAddAccommodation(name, category, hostId, numRooms);
        navigate("/accommodations");
    }

    return (
        <div className="container mt-5">
            <div className="row">
                <div className="col-md-5">
                    <form onSubmit={onFormSubmit}>
                        <div className="form-group">
                            <label htmlFor="name">Accommodation name</label>
                            <input
                                type="text"
                                className="form-control"
                                id="name"
                                name="name"
                                required
                                placeholder="Enter name"
                                onChange={handleChange}
                            />
                        </div>
                        <div className="form-group">
                            <label>Category</label>
                            <select name="category" className="form-control" onChange={handleChange}>
                                {props.categories.map((term) =>
                                    <option value={term}>{term}</option>
                                )}
                            </select>
                        </div>
                        <div className="form-group">
                            <label>Host</label>
                            <select name="hostId" className="form-control" onChange={handleChange}>
                                {props.hosts.map((term) =>
                                    <option value={term.id}>{term.name}</option>
                                )}
                            </select>
                        </div>
                        <div className="form-group">
                            <label htmlFor="numRooms">Number of rooms</label>
                            <input
                                type="number"
                                className="form-control"
                                id="numRooms"
                                name="numRooms"
                                required
                                placeholder="Enter numRooms"
                                onChange={handleChange}
                            />
                        </div>
                        <button type="submit" className="btn btn-primary">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    )
}

export default AccommodationAdd;
