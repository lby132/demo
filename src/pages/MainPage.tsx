import React, {useEffect, useState} from "react";
import {MainApi} from "../api/MainApi";
import Board from "./model/board.model";
import {Link} from "react-router-dom";

const Main = () => {
    const [data, setData] = useState<Board[]>([]);

    useEffect(() => {
        MainApi.getBoardList().then((res: any) => {
            console.log(res.data)
            setData(res.data);
        }).catch(error => {
            console.log(error)
        })
    }, []);

    return (
        <div className="App">
            <table className="table">
                <thead>
                <tr>
                    <th scope="col">id</th>
                    <th scope="col">title</th>
                    <th scope="col">auth</th>
                    <th scope="col">category</th>
                    <th scope="col">content</th>
                    <th scope="col">cnt</th>
                    <th scope="col">date</th>
                </tr>
                </thead>
                <tbody>
                    {data && data.map((res: any) => {
                        return (
                            <tr key={res.id}>
                                <td>{res.id}</td>
                                <td>
                                    <Link to={`detail/${res.id}`}>{res.title}</Link>
                                </td>
                                <td>{res.auth}</td>
                                <td>{res.category}</td>
                                <td>{res.content}</td>
                                <td>{res.cnt}</td>
                                <td>{res.regDt}</td>
                            </tr>
                        );
                    })}
                </tbody>
            </table>
        </div>
    );
}

export default Main