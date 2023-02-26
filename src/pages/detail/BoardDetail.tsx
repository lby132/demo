import React, {useEffect} from "react";
import {MainApi} from "../../api/MainApi";
import {useParams} from "react-router-dom";

export default function Detail() {
    const param = useParams();
    let id = Number(param.id);

    useEffect(() => {
        MainApi.getContent(id).then((res: any) => {
            console.log(res);
        }).catch(error => {
            console.log(error);
        })
    })

    return (
        <div className="card-title">
            <div>
                <input/>
            </div>
        </div>
    );
};

