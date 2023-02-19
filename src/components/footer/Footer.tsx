import React from "react";
// import "./Footer.css"
// @ts-ignore
import styled from "styled-components";
const Footer = () => {
    return (
        <Footers>
            <p>
                <span>저자 : cocoder</span><br/>
                <span>이메일 : cocoder16@gmail.com</span><br/>
                <span>Copyright 2020. cocoder. All Rights Reserved.</span>
            </p>
        </Footers>
    )
}
const Footers = styled.footer`
  width: 100%;
  height: 110px;
  bottom: 0px;
  position: absolute;
  font-size: x-small;
`
export default Footer

