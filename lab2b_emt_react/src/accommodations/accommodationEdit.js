import React from 'react';
import { useNavigate } from 'react-router-dom';

const AccommodationEdit = (props) => {

    const navigate = useNavigate();
    const [formData, updateFormData] = React.useState({
        name: "",
        category: 1,
        hostId: 0,
        numRooms: 1
    });

    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        });
    };

    const onFormSubmit = (e) => {
        e.preventDefault();
        const name = formData.name !== "" ? formData.name : props.accommodation.name;
        const category = formData.category !== 0 ? formData.category : props.accommodation.category;
        const hostId = formData.hostId !== 0 ? formData.hostId : props.accommodation.host.id;
        const numRooms = formData.numRooms !== "" ? formData.numRooms : props.accommodation.numRooms;

        props.onEditAccommodation(props.accommodation.id, name, category, hostId, numRooms);
        navigate("/accommodations");
    };

    return(
        <div className="row mt-5">
            <div className="col-md-5">
                <form onSubmit={onFormSubmit}>
                    <div className="form-group">
                        <label htmlFor="name">Accommodation name</label>
                        <input type="text"
                               className="form-control"
                               id="name"
                               name="name"
                               placeholder={props.accommodation.name}
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label>Category</label>
                        <select name="category" className="form-control" onChange={handleChange} value={formData.category}>
                            {props.categories.map((term) => (
                                <option key={term} value={term}>{term}</option>
                            ))}
                        </select>
                    </div>
                    <div className="form-group">
                        <label>Host</label>
                        <select name="hostId" className="form-control" onChange={handleChange} value={formData.hostId}>
                            {props.hosts.map((term) => (
                                <option key={term.id} value={term.id}>{term.name}</option>
                            ))}
                        </select>
                    </div>
                    <div className="form-group">
                        <label htmlFor="name">Number of rooms</label>
                        <input type="number"
                               className="form-control"
                               id="numRooms"
                               name="numRooms"
                               placeholder={props.accommodation.numRooms}
                               onChange={handleChange}
                        />
                    </div>
                    <button id="submit" type="submit" className="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    );
};

export default AccommodationEdit;
