import React from "react";
import {IoTrailSign} from "react-icons/io5";
import {BsChatRightTextFill, BsUniversalAccess} from "react-icons/bs";
import {Link} from "react-router-dom";
export {}

const BoardWrite = () => {

    return (
        <div className="container col-md-6">
            <div className="card">
                <div className="card-body">
                    <IoTrailSign/><br/>
                    <input className="card-title mb-3" name={"title"} />
                    <h6 className="card-subtitle text-muted mb-4">
                        <BsUniversalAccess/><br/>
                        <input defaultValue="user"/>
                    </h6>
                    <BsChatRightTextFill/>
                    <section>
                        <div className="input_box text_wrapper">
                            <textarea className="DiaryEditor textarea"
                                      name="content"></textarea>
                        </div>
                    </section>
                </div>
                <div className="card-body">
                    <a href="#" className="btn btn-outline-secondary btn-sm"
                       role="button">글등록</a>&nbsp;
                </div>
            </div>
        </div>
    );
}

export default BoardWrite;