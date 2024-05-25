import React from 'react';
import {Link} from 'react-router-dom';

const header = (props) => {
    return (
        <header>
            <nav className="navbar navbar-expand-md navbar-dark navbar-fixed bg-dark">
                <div className="collapse navbar-collapse" id="navbarCollapse">
                    <ul className="navbar-nav mr-auto">
                        <li className="nav-item active">
                            <Link className="nav-link" to={"/accommodations"}>Accommodations</Link>
                        </li>
                        <li className="nav-item active">
                            <Link className="nav-link" to={"/categories"}>Categories</Link>
                        </li>
                        <li className="nav-item active">
                            <Link className={"nav-link"} to={"/hosts"}>Hosts</Link>
                        </li>
                        <li className="nav-item active">
                            <Link className="nav-link" to={"/countries"}>Countries</Link>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>
    )
}

export default header;