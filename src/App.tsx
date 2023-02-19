import React from 'react';
import {Routes, Route, BrowserRouter} from "react-router-dom";
import './App.css';
import Header from "./header/Header";
import Main from "./pages/MainPage";

function App() {
    return (
        <div className="App">
            <BrowserRouter>
                <Header />
                <Routes>
                    <Route path="/" element={<Main/>}/>

                </Routes>
            </BrowserRouter>
        </div>

    );
}

export default App;
