import React, {useEffect, useState} from "react";
import {Button} from "react-bootstrap";
import axios from "../api/axios";
import {MainApi} from "../api/MainApi";
import Board from "./model/board.model";

const Main = () => {
    const [data, setData] = useState<Board[]>([]);

    useEffect(() => {
        MainApi.getBoardList().then((res: any) => {
            setData(res.data);
        }).catch(error => {
            console.log(error)
        })
    }, []);

    function detail(id: any) {
        console.log(id)
    }

    return (
        <div className="App">
            {/*<Button as="input" type="button" value="input"/>*/}
            <table className="table">
                <thead>
                <tr>
                    <th scope="col">id</th>
                    <th scope="col">title</th>
                    <th scope="col">auth</th>
                    <th scope="col">category</th>
                    <th scope="col">content</th>
                    <th scope="col">cnt</th>
                </tr>
                </thead>
                <tbody>
                    {data && data.map((res: any) => {
                        return (
                            <tr key={res.id}>
                                <td>{res.id}</td>
                                <td>
                                    <a href="#" onClick={() => detail(res.id)}>{res.title}</a>
                                </td>
                                <td>{res.auth}</td>
                                <td>{res.category}</td>
                                <td>{res.content}</td>
                                <td>{res.cnt}</td>
                            </tr>
                        );
                    })}
                </tbody>
            </table>
        </div>
    );
}

export default Main