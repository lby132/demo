import React, {useEffect, useRef, useState} from "react";
import {MainApi} from "../../api/MainApi";
import {Link, useParams} from "react-router-dom";
import {BsCalendarDateFill, BsUniversalAccess, BsChatRightTextFill} from "react-icons/bs";
import { IoTrailSign } from "react-icons/io5";
import "./BoardDetail.css";
import DetailData from "./Detail.model";

export default function Detail() {
    const param = useParams();
    let idx = Number(param.id);
    const [data, setData] = useState<DetailType>();
    const [isEditing, setIsEditing] = useState(true);
    const contentRef = useRef<HTMLTextAreaElement>(null);


    const [inputs, setInputs] = useState({
        id: idx,
        title: "",
        content: "",
    });


    // @ts-ignore
    const setChange = (e: React.ChangeEvent<HTMLInputElement, HTMLTextAreaElement>, type: string) => {
        const value = e.target.value;
        setInputs({
            ...inputs,
            [type]: value,
        });
    };

    useEffect(() => {
        MainApi.getContent(idx).then((res: any) => {
            setData(res.data);
        }).catch(error => {
            console.log(error);
        })
    }, []);

    function update(update: boolean, dataYn: number) {
        setIsEditing(update);
        if (dataYn === 2) {
            let detailData = new DetailData(inputs.id, inputs.title, inputs.content);
            MainApi.postUpdate(detailData).then((res: any) => {
            }).catch(error => {
                console.log(error)
            });
        }
    }

    function boardDel(id: number | undefined) {
        MainApi.postDelete(id).then(() => {
            alert("삭제되었습니다.");
            window.location.href = "/";
        }).catch(error => {
            console.log(error);
        })
    }

    if(isEditing) {
        return (
            <div className="container col-md-6">
                <div className="card">
                    <div className="card-body">
                        <h4 className="card-title mb-3">{data?.title}</h4>
                        <h6 className="card-subtitle text-muted mb-4">
                            <BsUniversalAccess/>&nbsp;
                            <i className="bi bi-file-earmark-person-fill"></i>{"user"}<br/>
                            <BsCalendarDateFill/>&nbsp;
                            <i className="bi bi-calendar-day"></i>{data?.regDate}
                        </h6>
                        <BsChatRightTextFill/>
                        <p className="card-text">{data?.content}</p>
                    </div>
                    <div className="card-body">
                        <a href="#" className="btn btn-outline-secondary btn-sm" onClick={() => update(false, 1)}
                           role="button">수정</a>&nbsp;
                        <a href="#" className="btn btn-outline-secondary btn-sm" onClick={() => boardDel(data?.id)} role="button">삭제</a>
                    </div>
                    <div className="card-body">
                        <Link className="btn btn-dark" role="button" to="/">{"목록으로"}</Link>
                    </div>
                </div>
            </div>
        );
    } else {
        return (
            <div className="container col-md-6">
                <div className="card">
                    <div className="card-body">
                        <IoTrailSign/><br/>
                        <input className="card-title mb-3" name={"title"} defaultValue={data?.title} onChange={
                            (e) => setChange(e, "title")
                        }/>
                        <h6 className="card-subtitle text-muted mb-4">
                            <BsUniversalAccess/><br/>
                            <input defaultValue="user"/>
                        </h6>
                        <BsChatRightTextFill/>
                        <section>
                            <div className="input_box text_wrapper">
                            <textarea className="DiaryEditor textarea"
                                      name="content"
                                      ref={contentRef}
                                      defaultValue={data?.content}
                                      onChange={(e) => setChange(e, "content")}/>
                            </div>
                        </section>
                    </div>
                    <div className="card-body">
                        <a href="#" className="btn btn-outline-secondary btn-sm" onClick={() => update(true, 2)}
                           role="button">수정하기</a>&nbsp;
                    </div>
                    <div className="card-body">
                        <Link className="btn btn-dark" role="button" to="/">{"목록으로"}</Link>
                    </div>
                </div>
            </div>
        );
    }
};
