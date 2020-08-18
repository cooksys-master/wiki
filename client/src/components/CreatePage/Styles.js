import styled from 'styled-components'

export const PopupDiv = styled.div`
  position: fixed;
  width: 100%;
  height: 100%;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  margin: auto;
  background-color: rgba(0, 0, 0, 0.5);
`

export const PopupInner = styled.div`
  position: absolute;
  left: 35%;
  right: 25%;
  top: 35%;
  bottom: 25%;
  margin: auto;
  background: #f79d28;
`

export const LoginForm = styled.form`
  margin-top: 15%;
  margin-left: 25%;
  width: 50%;
  min-width: 200pt;
  background: #f79d28;
  display: flex;
  flex-direction: column;
  color: white;
`

export const Input = styled.input`
  width: 80%;
  border-radius: 5px;
  margin-top: 5pt;
  margin-bottom: 5pt;
`
