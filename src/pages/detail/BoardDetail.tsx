import React, {useEffect, useState} from "react";
import {MainApi} from "../../api/MainApi";
import {useParams} from "react-router-dom";
import DetailType from "./Detail";

export default function Detail() {
    const param = useParams();
    let id = Number(param.id);
    const [data, setData] = useState<DetailType>();

    useEffect(() => {
        MainApi.getContent(id).then((res: any) => {
            console.log(res);
            setData(res.data);
        }).catch(error => {
            console.log(error);
        })
    }, []);

    return (
        <div className="container col-md-6">
            <div className="card">
                <div className="card-body">
                    <h4 className="card-title mb-3">{data?.title}</h4>
                    <h6 className="card-subtitle text-muted mb-4">
                        <i className="bi bi-file-earmark-person-fill"></i>{"user"}<br/>
                        ·
                        <i className="far fa-clock"></i>{data?.regDate}
                        ·
                        <i className="fas fa-align-justify">11</i>
                    </h6>
                    <p className="card-text">{data?.content}</p>
                </div>
                <div className="card-body">
                    <a href="#" className="btn btn-outline-secondary btn-sm" role="button">수정</a>
                    <a href="#" className="btn btn-outline-secondary btn-sm " role="button">삭제</a>
                </div>
                <div className="card-body">
                    {/*<a className="btn btn-info" role="button">목록으로</a>*/}
                </div>
            </div>
        </div>
    );
};

