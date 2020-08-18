import styled from 'styled-components'
import { Link } from 'react-router-dom'

export const HeaderWrapper = styled.div`
    height: 10vh;
    font-size: 1em;
    display: flex;
    justify-content: space-between;
    width: 100%;
    margin-bottom: 50pt;
`

export const ButtonContainer = styled.div`
  justify-content: right;
  display: flex;
  padding: 15px;
`

export const ButtonWrapper = styled.div`
  justify-content: right;
  display: flex;
  margin-right: 10px;
`
export const HeaderButton = styled.button`
  background-color: transparent;
  border-radius: 20px;
  display: inline-block;
  cursor: pointer;
  color: #251ab8;
  font-family: Arial;
  font-size: 18px;
  padding: 6px 10px;
  text-decoration: none;
  background-repeat: no-repeat;
  border: none;
  cursor: pointer;
  overflow: hidden;
`

export const LogoContainer = styled.div`
  justify-content: left;
  float: left;
  padding: 5px;
  height: 10vh;
`

export const StyledLink = styled(Link)`
    padding-top: 15px;
    text-decoration: none;
`