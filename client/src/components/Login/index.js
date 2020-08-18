import React, { useState } from 'react'
import { useDispatch, useSelector } from 'react-redux'
import { Redirect } from 'react-router-dom'

import { AppDiv, LoginForm, Input } from './Styles'
import { SubmitButton } from '../StyledElements'

import {
  login,
  getLogin,
  setStateUsername,
  setStatePassword
} from '../../ducks/credentials.duck/'
import { HOME_PATH } from '../../utils'

const Login = () => {
  const [username, setUsername] = useState('')
  const [password, setPassword] = useState('')

  const loggedIn = useSelector(getLogin)
  const dispatch = useDispatch()

  const onUsernameChange = event => {
    const value = event.target.value
    setUsername(value)
  }

  const onPasswordChange = event => {
    const value = event.target.value
    setPassword(value)
  }

  const handleSubmitButton = e => {
    e.preventDefault()
    dispatch(setStatePassword(password))
    dispatch(setStateUsername(username))
    dispatch(login())
  }

  const redirectToLoginPage = loggedIn ? <Redirect push to={HOME_PATH} /> : null

  return (
    <AppDiv>
      {redirectToLoginPage}
      <img src='./pictures/Logo.svg' alt='Cook Systems Logo' />
      <LoginForm>
        <label>
          Username
          <br />
          <Input type='text' name='username' onChange={onUsernameChange} />
        </label>
        <label>
          Password
          <br />
          <Input type='password' name='password' onChange={onPasswordChange} />
        </label>
        <br />
        <SubmitButton onClick={handleSubmitButton}>Login</SubmitButton>
      </LoginForm>
    </AppDiv>
  )
}

export default Login
