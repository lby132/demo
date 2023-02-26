import React from "react";
import styled from "styled-components";

const Header = () => {
    return (
        <Headers>
            <h1>BoardList</h1>
        </Headers>
    )
}

const Headers = styled.header`
  margin-top: 30px;
  margin-bottom: 2.5rem;
  font-weight: 500;
  line-height: 10px;
`
export default Header