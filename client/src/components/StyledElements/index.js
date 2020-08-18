import styled from 'styled-components'

export const SubmitButton = styled.button`
  border-radius: 5px;
  width: 80%;
  margin-left: 10%;
  margin-top: 10pt;
  background: green;
  border: 2pt;
  padding: 2pt;

  &:hover {
    color: white;
    background: black;
  }
`

export const ExitButton = styled.button`
  margin-right: 5px;
  margin-top: 5px;
  float: right;
  box-shadow: inset 0px 1px 0px 0px #f29c93;
  background: linear-gradient(to bottom, #fe1a00 5%, #ce0100 100%);
  background-color: #fe1a00;
  border-radius: 6px;
  border: 1px solid #d83526;
  display: inline-block;
  cursor: pointer;
  color: #ffffff;
  font-family: Arial;
  font-size: 15px;
  font-weight: bold;
  padding: 6px 24px;
  text-decoration: none;
  text-shadow: 0px 1px 0px #b23e35;

  &:hover {
    background: linear-gradient(to bottom, #ce0100 5%, #fe1a00 100%);
    background-color: #ce0100;
  }
`

export const Button = styled.button`
  margin-top: 10px;
  background: green;
  color: white;
  border-radius: 10px;
  border: 2pt;
  font-size: 75%;

  &:hover {
    cursor: pointer;
  }
`

export const PageWrapper = styled.div`
  display: flex;
  justify-content: space-between;
  color: #000;
  height: 75vh;
`

export const TopContainer = styled.div`
  width: 100%;
  height: 75px;
`

export const InnerContainer = styled.div`
  width: 90%;
  margin-left: 5%;
  background: rgba(242, 242, 242, 0.8);
  height: 80%;
  overflow: scroll;
`

export const MainContentHeader = styled.div`
  width: 100%;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
`

export const EditorContainer = styled.div`
  text-align: left;
  color: black;
  line-height: 1;
  font-size: 17px;
`

export const SideSelectDiv = styled.div`
  display: flex;
  flex-direction: column;
  text-align: left;
  color: black;
`
