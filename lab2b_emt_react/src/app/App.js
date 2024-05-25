    import './App.css';
    import React, {Component} from "react";
    import {BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';
    import Header from '../header';
    import Categories from '../categories/categories';
    import Hosts from '../hosts/hosts';
    import AccommodationList from '../accommodations/accommodationList';
    import AccommodationAdd from '../accommodations/accommodationAdd';
    import AccommodationEdit from '../accommodations/accommodationEdit';
    import MyRepository from "../myRepository";
    import Countries from "../countries/countries";

    class App extends Component {

        constructor(props) {
            super(props);
            this.state = {
                accommodations: [],
                categories: [],
                countries: [],
                hosts: [],
                selectedAccommodation: {}
            }
        }

        render() {
            return (
                <Router>
                    <Header/>
                    <main>
                        <div className="container">
                            <Routes>
                                <Route path={"/"} element={
                                    <AccommodationList accommodations={this.state.accommodations}
                                                       onDelete={this.deleteAccommodation}
                                                       onRent={this.rentAccommodation}
                                                       onEdit={this.getAccommodation}/>}/>
                                <Route path={"/accommodations"} element={
                                    <AccommodationList accommodations={this.state.accommodations}
                                                       onDelete={this.deleteAccommodation}
                                                       onRent={this.rentAccommodation}
                                                       onEdit={this.getAccommodation}/>}/>
                                <Route path={"/accommodations/add"} element={
                                    <AccommodationAdd categories={this.state.categories}
                                                      hosts={this.state.hosts}
                                                      onAddAccommodation={this.addAccommodation}/>}/>
                                <Route path={"/accommodations/edit/:id"} element={
                                    <AccommodationEdit categories={this.state.categories}
                                                       hosts={this.state.hosts}
                                                       onEditAccommodation={this.editAccommodation}
                                                       accommodation={this.state.selectedAccommodation}/>}/>
                                <Route path={"/categories"} element={
                                    <Categories categories={this.state.categories}/>}/>
                                <Route path={"/countries"} element={
                                    <Countries countries={this.state.countries}/>}/>
                                <Route path={"/hosts"} element={
                                    <Hosts hosts={this.state.hosts}/>}/>
                                <Route path={"/*"} element={<Navigate replace to="/accommodations" />} />
                            </Routes>
                        </div>
                    </main>
                </Router>

            );
        }

        componentDidMount() {
            this.fetchData();
        }

        fetchData = () => {
            this.loadHosts();
            this.loadCategories();
            this.loadCountries();
            this.loadAccommodations();
        }

        loadHosts = () => {
            MyRepository.fetchHosts()
                .then((data) => {
                    this.setState({
                        hosts: data.data
                    })
                });
        }

        loadAccommodations = () => {
            MyRepository.fetchAccommodations()
                .then((data) => {
                    this.setState({
                        accommodations: data.data
                    })
                });
        }

        loadCategories = () => {
            MyRepository.fetchCategories()
                .then((data) => {
                    this.setState({
                        categories: data.data
                    })
                });
        }

        loadCountries = () => {
            MyRepository.fetchCountries()
                .then((data) => {
                    this.setState({
                        countries: data.data
                    })
                });
        }

        deleteAccommodation = (id) => {
            MyRepository.deleteAccommodation(id)
                .then(() => {
                    this.loadAccommodations();
                });
        }

        rentAccommodation = (id) => {
            MyRepository.rentAccommodation(id)
                .then(() => {
                    this.loadAccommodations();
                });
        }

        addAccommodation = (name, category, hostId, numRooms) => {
            MyRepository.addAccommodation(name, category, hostId, numRooms)
            .then(() => {
                this.loadAccommodations();
            });
    }

    getAccommodation = (id) => {
        MyRepository.getAccommodation(id)
            .then((data) => {
                this.setState({
                    selectedAccommodation: data.data
                })
            })
    }

    editAccommodation = (id, name, category, hostId, numRooms) => {
        MyRepository.editAccommodation(id, name, category, hostId, numRooms)
            .then(() => {
                this.loadAccommodations();
            });
    }
}

export default App;
