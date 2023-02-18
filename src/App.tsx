import React from 'react';
import {Routes, Route, BrowserRouter} from "react-router-dom";
import './App.css';
import Header from "./header/Header";

function App() {
    return (
        <div className="App">
            <BrowserRouter>
                <Header />
                <Routes>
                    <Route path="/">

                    </Route>
                </Routes>
            </BrowserRouter>
        </div>

    );
}

export default App;
